pipeline {
    agent any
//    agent {
//        docker {
//            image 'mcr.microsoft.com/playwright:v1.27.1-focal'
//        }
//    }

    tools {
        maven 'maven'
    }

    environment {
        PATH = "$PATH:/usr/local/bin"
    }

    stages
            {
                stage('Build') {
                    steps
                            {
                                git 'https://github.com/jglick/simple-maven-project-with-tests.git'
                                sh "mvn -Dmaven.test.failure.ignore=true clean package"
                            }
                    post
                            {
                                success
                                        {
                                            junit '**/target/surefire-reports/TEST-*.xml'
                                            archiveArtifacts 'target/*.jar'
                                        }
                            }
                }

                stage("Deploy to QA") {
                    steps {
                        echo "Deploying to QA"
                        echo "Success"
                    }
                }

//                stage('Install playwright') {
//                    steps {
//                        sh '''
//                              npm i -D @playwright/test
//                              npx playwright install
//                            '''
//                    }
//                }

                stage("Checkout Test f/w repo") {
                    steps {
                        git branch: 'main', url: 'https://github.com/krishanuc1001/PlaywrightGradleFW.git'
                    }
                }

                stage('Test') {
                    steps {
                        sh "docker-compose down || true"
                        sh "docker-compose up -d"
                        sh "./gradlew clean test --info"
                    }

                    post {
                        always {
                            script {
                                publishHTML([allowMissing         : true,
                                             alwaysLinkToLastBuild: true,
                                             keepAll              : true,
                                             reportDir            : 'ExtentReport-output',
                                             reportFiles          : '**/*.html',
                                             reportName           : 'Extent Report',
                                             reportTitles         : 'Extent Report'])
                                echo "Success !!! Extent report published..."
                            }
                        }
                    }

                }

                stage('Tear Down') {
                    steps {
                        sh "docker-compose down || true"
                    }
                }

            }
}