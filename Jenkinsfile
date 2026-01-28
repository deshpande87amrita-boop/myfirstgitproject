pipeline {
    agent any

    tools {
        jdk 'JDK11'
        maven 'Maven3'
    }

    stages {

        stage('Build') {
            steps {
                echo 'Building the project using Maven'
                bat 'mvn clean compile'
            }
        }

        stage('Run Tests') {
            steps {
                echo 'Running Selenium TestNG tests'
                bat 'mvn test'
            }
            post {
                always {
                    echo 'Collecting Test Results'
                    junit '**/target/surefire-reports/*.xml'
                }
            }
        }

        stage('Post-Build') {
            steps {
                echo 'Build and Tests Completed'
            }
        }
    }

    post {
        success {
            echo 'Pipeline completed successfully!'
        }
        failure {
            echo 'Pipeline failed. Please check logs.'
        }
        always {
            echo 'Cleaning workspace'
            cleanWs()
        }
    }
}
