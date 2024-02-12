pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                echo 'Le code source a été récupéré.'
            }
        }
      stage('SonarQube Analysis') {

steps{
    sh "mvn sonar:sonar -Dsonar.projectKey=test -Dsonar.projectName='test'"
    
  }}
        stage('Build avec Maven') {
            steps {
                sh 'mvn clean compile'
            }
        }

    
    }
}
