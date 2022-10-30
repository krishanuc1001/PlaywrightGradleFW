def jenkinsHelper = new JenkinsHelper()

pipeline
        {
            agent any

            tools {
                maven 'maven'
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

                        stage("Checkout Test f/w repo") {
                            steps {
                                git branch: 'main', url: 'https://github.com/krishanuc1001/PlaywrightGradleFW.git'
                            }
                        }

                        stage('Test') {
                            steps {
                                sh "docker-compose -f docker-compose.yml down || true"
                                sh "docker stop selenium-hub-pw || true"
                                sh "docker rm -f selenium-hub-pw || true"
                                sh "docker-compose up -d"
//                                git branch: 'main', url: 'https://github.com/krishanuc1001/PlaywrightGradleFW.git'
                                sh "./gradlew clean test --info"
                            }

                            post {
                                always {
                                    script {
                                        jenkinsHelper.publishHTMLUIReports()
                                    }
                                }
                            }

                        }

                        stage('Publish Extent Report') {
                            echo "Success !!! Extent report published..."
//                            steps {
//                                jenkinsHelper.publishHTMLUIReports()
//                            }
                        }

                    }
        }


class JenkinsHelper {

    def steps

    def publishHTMLUIReports() {
        steps.publishHTML([allowMissing         : true,
                           alwaysLinkToLastBuild: true,
                           keepAll              : true,
                           reportDir            : 'ExtentReport-output',
                           reportFiles          : '**/*.html',
                           reportName           : 'Extent Report',
                           reportTitles         : 'Extent Report'])
    }
}