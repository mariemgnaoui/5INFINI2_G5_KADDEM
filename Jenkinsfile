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
           stage('Tests Mockito/Junit') {
                                              steps {
                                                      sh 'mvn test'
                                                    }
                                                }
   

          stage('Nexus') {
                                 steps{
                                        sh 'mvn deploy -DskipTests=true'
                                             }
                                      }

    
    }
}
