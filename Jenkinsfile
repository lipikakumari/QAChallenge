pipeline {
  agent any
  stages {
    stage('Build') {
      agent any
      steps {
        sh '''brew install maven
'''
        sh '''mvn test
'''
      }
    }
  }
}
