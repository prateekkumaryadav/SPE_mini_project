pipeline {
  agent any
  
  environment {
    DOCKER_IMAGE_NAME = 'prateekkumaryadav/scientific-calculator'
    DOCKER_IMAGE_TAG = "${BUILD_NUMBER}"
    DOCKER_HUB_CREDS = credentials('dockerhub-credentials')
    PATH = "/usr/local/bin:${env.PATH}"
  }
  
  tools {
    maven 'Maven'
  }
  
  stages {
    stage('Github Initialization') {
      steps {
        git(url: 'https://github.com/prateekkumaryadav/SPE_mini_project', branch: 'main')
      }
    }
    
    stage('Building Calculator Program') {
      steps {
        // Build with Maven
        sh 'mvn clean package'
      }
    }

    stage('Maven Testing(JUnit)') {
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
    
    stage('Building Docker Image') {
      steps {
        // Build Docker image for linux/amd64 platform (cross-platform compatibility)
        sh "docker build --platform linux/amd64 -t ${DOCKER_IMAGE_NAME}:${DOCKER_IMAGE_TAG} ."
        sh "docker tag ${DOCKER_IMAGE_NAME}:${DOCKER_IMAGE_TAG} ${DOCKER_IMAGE_NAME}:latest"
      }
    }
    
    stage('Pushing Image to Docker Hub') {
      steps {
        // Log in to Docker Hub and push the image
        sh "echo ${DOCKER_HUB_CREDS_PSW} | docker login -u ${DOCKER_HUB_CREDS_USR} --password-stdin"
        sh "docker push ${DOCKER_IMAGE_NAME}:${DOCKER_IMAGE_TAG}"
        // sh "docker push ${DOCKER_IMAGE_NAME}:latest"
      }
    }
  }
}
