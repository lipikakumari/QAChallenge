pipeline {
  agent any
  stages {
    stage('Build') {
      agent any
      steps {
        sh ''' mkdir homebrew && curl -L https://github.com/Homebrew/brew/tarball/master | tar xz --strip 1 -C homebrew
'''
        sh '''brew install maven
'''
        sh '''mvn test
'''
      }
    }
  }
}
