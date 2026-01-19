pipeline {
  agent any
  stages {
    stage('initialization') {
      steps {
        git(url: 'https://github.com/prateekkumaryadav/SPE_mini_project', branch: 'main')
      }
    }

    stage('listing all the files') {
      steps {
        sh 'ls -la'
      }
    }

  }
}