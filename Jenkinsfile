pipeline {
    agent any
       tools {
            maven 'M2_HOME'
        }
    stages {
        stage('GIT') {
            steps {
                checkout scm
            }
        }

        stage('MVN CLEAN') {
            steps {
                sh 'mvn clean compile'
            }
        }

//stage('SonarQube') {
  //              steps {
    //                   sh 'mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=sonar'
      //                }

        // }
             stage('JUNIT/MOCKITO') {
                                              steps {
                                                      sh 'mvn test'
                                                    }
                                                }
         stage('NEXUS') {
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

                                                         sh "docker login -u azzouz99 -p azzouz1999"
                                                         sh "docker tag kaddemimage:v${BUILD_NUMBER} azzouz99/azzouz99-5infini2-g5-kaddem:kaddemimage"
                                                         sh "docker push  azzouz99/azzouz99-5infini2-g5-kaddem:kaddemimage"
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