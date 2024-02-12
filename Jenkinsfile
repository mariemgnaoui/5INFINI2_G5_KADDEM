pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                echo 'Le code source a été récupéré.'
            }
        }

        stage('Build avec Maven') {
            steps {
                sh 'mvn clean compile'
            }
        }
        stage('SonarQube Analysis') {


    sh 'mvn sonar:sonar -Dsonar.projectKey=test -Dsonar.projectName='test'"
    
  }
    }
}
