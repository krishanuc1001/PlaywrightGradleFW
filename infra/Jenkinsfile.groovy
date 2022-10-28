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

                        stage('Test') {
                            steps {
                                git branch: 'main', url: 'https://github.com/krishanuc1001/PlaywrightGradleFW.git'
                                sh "./gradlew clean test --info"
                            }
                        }

                        stage('Publish Extent Report') {
                            steps {
                                publishHTML([allowMissing         : true,
                                             alwaysLinkToLastBuild: true,
                                             keepAll              : true,
                                             reportDir            : 'ExtentReport-output',
                                             reportFiles          : '**/*.html',
                                             reportName           : 'ExtentReport',
                                             reportTitles         : 'Extent Report'])
                            }
                        }

                    }
        }