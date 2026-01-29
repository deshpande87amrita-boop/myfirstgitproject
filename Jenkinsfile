pipeline {
    agent any

    tools {
        jdk 'JDK11'
        maven 'Maven3'
    }

    stages {
        stage('Build') {
            steps {
                bat 'mvn clean compile'
            }
        }

        stage('Run Tests') {
            steps {
                bat 'mvn test'
            }
            post {
                always {
                    junit '**/target/surefire-reports/*.xml'
                }
            }
        }
    }

    post {
        always {
            cleanWs()
        }
    }
}
pipeline {
    agent any  // Run on any available Jenkins node

    tools {
        jdk 'JDK11'      // Name of JDK installed in Jenkins
        maven 'Maven3'   // Name of Maven installed in Jenkins
    }

    environment {
        GITHUB_TOKEN = 'github-token'  // Optional, if your repo is private
    }

    stages {

        stage('Checkout') {
            steps {
                echo 'Checking out the code from GitHub'
                git branch: 'main',
                    url: 'ht

