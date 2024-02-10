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

       // stage('SONARQUBE') {
       //              steps {
       //                     sh 'mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=mariem2000'
       //                     }
       //  }

     stage('JUNIT/MOCKITO') {
                                      steps {
                                              sh 'mvn test'
                                            }
                                        }
    stage('Nexus') {
                        steps {
                               sh 'mvn deploy -DskipTests=true'
                                    }
                             }
 stage('Docker images')
                 {
                      steps {
                         sh 'docker build -t kaddemimage:v${BUILD_NUMBER} -f Dockerfile ./'
                               }

                 }
  stage('dockerhub') {
                                             steps {

                                        sh "docker login -u mariemgnaoui -p mariem2000"
                                        sh "docker tag kaddemimage:v${BUILD_NUMBER} mariemgnaoui/mariemgnaoui-5infini2-g5-kaddem:kaddemimage"
                                        sh "docker push  mariemgnaoui/mariemgnaoui-5infini2-g5-kaddem:kaddemimage"
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
