pipeline{
        agent any
        stages{
                stage('---setup---'){
                        steps{
                                sh "sudo rm -rf /var/lib/wildfly-10.1.0.Final/standalone/deployments/*"
                        }
                }
                stage('--Package--'){
                        steps{
                                sh "mvn package"
                        }
                }
                stage('--Deploy To Wildfly--'){
                        steps{
                                sh "cd /"
				sh "pwd"
                                sh "sudo cp /var/lib/jenkins/workspace/${JOB_NAME}/target/MotoGPManager.war /var/lib/wildfly-10.1.0.Final/standalone/deployments/"
                        }
                }
                stage('--Jacoco--'){
                        steps{
                                sh "mvn install"
                        }
                }
		        stage('--Surefire Report--'){
                        steps{
                                sh "mvn surefire-report:report"
				sh "mvn site"
                        }
                }
                stage('--Email--'){
                        steps{
                                emailext attachLog: true, attachmentsPattern: 'target/site/jacoco/index.html, target/site/surefire-report.html', body: '$BUILD_STATUS!', subject: '$BUILD_STATUS! - $PROJECT_NAME - Build # $BUILD_NUMBER ', to: 'jack.flanagan93@outlook.com cc:jenkinsvirtualmachine@gmail.com'
                        }
                }
        }
}
