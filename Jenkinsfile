pipeline {
  agent any
  stages {
    stage('initialization') {
      steps {
        git 'https://github.com/prateekkumaryadav/SPE_mini_project'
      }
    }

    stage('listing all files') {
      steps {
        sh 'ls -la'
      }
    }

  }
}