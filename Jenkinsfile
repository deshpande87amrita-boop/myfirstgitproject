pipeline {
    agent any  // Run on any available Jenkins node

    tools {
        jdk 'JDK11'      // Must match the name of JDK installed in Jenkins
        maven 'Maven3'   // Must match the name of Maven installed in Jenkins
    }

    environment {
        // GitHub token stored in Jenkins credentials
        GITHUB_TOKEN = 'github-token'
    }

    stages {

        stage('Checkout') {
            steps {
                echo 'Checking out the code from GitHub'
                git branch: 'main',
                    url: 'https://github.com/deshpande87amrita-boop/myfirstgitproject.git',
                    credentialsId: credentials('github-token')
            }
        }

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
                echo 'You can add notifications here (email/Slack) if needed'
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
            cleanWs()  // Optional: clean workspace after build
        }
    }
}


