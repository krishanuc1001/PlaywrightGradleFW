pipeline
        {
            agent any

//            tools {
//                maven 'maven'
//            }

            stages
                    {
//                        stage('Build') {
//                            steps
//                                    {
//                                        git 'https://github.com/jglick/simple-maven-project-with-tests.git'
//                                        sh "mvn -Dmaven.test.failure.ignore=true clean package"
//                                    }
//                            post
//                                    {
//                                        success
//                                                {
//                                                    junit '**/target/surefire-reports/TEST-*.xml'
//                                                    archiveArtifacts 'target/*.jar'
//                                                }
//                                    }
//                        }

                        stage("Deploy to QA") {
                            steps {
                                echo "Deploying to QA"
                                echo "Success"
                            }
                        }

                        stage('Test') {
                            steps {
                                git 'https://github.com/krishanuc1001/PlaywrightGradleFW.git'
                                sh "./gradlew clean test --info"

//                                catchError(buildResult: 'SUCCESS', stageResult: 'FAILURE') {
                                // Checkout git repo
//                                    git 'https://github.com/krishanuc1001/PlaywrightGradleFW.git'
//                                    sh "git checkout main"

                                // Removing existing docker containers
//                                    sh "docker-compose down || true"
//                                    sh "docker rm -f selenium-hub-pw || true"

                                // Run test
//                                    sh "docker-compose run --name=playwright-gradle-framework clean test --info"
//                                    sh "./gradlew clean test --info"
//                                }
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