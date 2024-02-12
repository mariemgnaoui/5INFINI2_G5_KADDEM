pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                echo 'Le code source a été récupéré.'
            }
        }
           stage('Tests Mockito/Junit') {
                                              steps {
                                                      sh 'mvn test'
                                                    }
                                                }
        stage('Build avec Maven') {
            steps {
                sh 'mvn clean compile'
            }
        }

    
    }
}
