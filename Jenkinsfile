pipeline {
    agent any
    triggers {
        pollSCM('* * * * *') // Checks for changes every minute; adjust as necessary
    }

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
            steps {
                sh 'mvn deploy -DskipTests=true'
            }
        }
        stage('Docker')
                 {
                      steps {
                script {
                    // Build the Docker image with Jenkins BUILD_NUMBER as the version
                    sh 'docker build -t kaddemimage:v${BUILD_NUMBER} -f Dockerfile ./'
                    

                    
                    // Run Docker Compose
                    sh "IMAGE_VERSION=v${BUILD_NUMBER} docker compose up -d"
                }
            }
                 }
    }
}


