pipeline {
    agent any
    stages {
        stage('GIT') {
            steps {
                checkout scm
            }
        }

        stage('COMPILING') {
            steps {
                sh 'mvn clean compile'
            }
        }
        stage('SONARQUBE') {
                             steps {
                                    sh 'mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=ahmed2000'
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
