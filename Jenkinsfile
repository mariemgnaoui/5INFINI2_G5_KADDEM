pipeline {
    agent any
    stages {
        stage('stage 1 github') {
            steps {
                checkout scm
            }
        }

        stage('stage 2 compiler') {
            steps {
                sh 'mvn clean compile'
            }
        }

//stage('stage 3 sonarqube') {
  //              steps {
    //                   sh 'mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=chtiba'
      //                }

        // }
         stage('stage 4 nexus') {
                                 steps {
                                        sh 'mvn deploy -DskipTests=true'
                                             }
                                      }
                                      }
    post {
        success {
            echo 'Build successfully'
        }
        failure {
            echo 'failed '
        }
    }
 }
