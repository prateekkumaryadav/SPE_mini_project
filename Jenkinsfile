pipeline {
  agent any
  stages {
    stage('initialization') {
      steps {
        git(url: 'https://github.com/prateekkumaryadav/SPE_mini_project', branch: 'main')
      }
    }
    
    stage('Build') {
      steps {
        // Build with Maven
        sh 'mvn clean package'
      }
    }

    stage('Test') {
      steps {
        // Run tests using Maven
        sh 'mvn test'
      }
      // post build
      post {
        always {
          // Publishing the JUnit test results
          junit '**/target/surefire-reports/*.xml'
        }
      }
    }
  }
}