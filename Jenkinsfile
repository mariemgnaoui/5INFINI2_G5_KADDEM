pipeline {
    agent any
    stages {
        stage('GIT') {
            steps {
                echo 'pulling ..'
                git branch :'abderrahmen_benazzouz',
                url : 'https://github.com/mariemgnaoui/5INFINI2_G5_KADDEM.git'
            }
        }

        stage('MVN CLEAN') {
            steps {
                sh 'mvn clean install'
            }
        }

         stage('MVN COMPILE') {
            steps {
                sh 'mvn compile'
            }
        }

          stage('MVN SONARQUBE') {
            steps {
                sh 'mvn sonar:sonar -Dsonar.login:admin -Dsonar.password:sonar '
            }
        }
    }
}

 

