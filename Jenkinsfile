pipeline {
    agent any

    tools {
        jdk 'JDK11'
        maven 'Maven3'
    }

    stages {
        stage('Build') {
            steps {
                echo 'Building Maven project'
                bat 'mvn clean compile'
            }
        }

        stage('Run Tests') {
            steps {
                echo 'Running tests'
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
            echo 'Cleaning workspace'
            cleanWs()
        }
    }
}
