pipeline
        {
            agent any

            tools {
                gradle 'gradle'
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
                                catchError(buildResult: 'SUCCESS', stageResult: 'FAILURE') {
                                    git 'https://github.com/krishanuc1001/PlaywrightGradleFW'
                                    sh "./gradlew clean test --info"
                                }
                            }
                        }

                        stage('Publish Extent Report') {
                            steps {
                                publishHTML([allowMissing         : false,
                                             alwaysLinkToLastBuild: false,
                                             keepAll              : true,
                                             reportDir            : 'ExtentReport-output',
                                             reportFiles          : '**/*.html',
                                             reportName           : 'Extent Report',
                                             reportTitles         : 'Extent Report'])
                            }
                        }

                    }
        }