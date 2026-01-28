pipeline {
    agent any  // run on the same Jenkins machine

    tools {
        jdk 'JDK11'  // Name of JDK installed in Jenkins
        maven 'Maven3'  // Name of Maven configured in Jenkins
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/username/MySeleniumProject.git'
            }
        }

        stage('Build') {
            steps {
                echo 'Building project with Maven'
                sh 'mvn clean compile'
            }
        }

        stage('Run Tests') {
            steps {
                echo 'Running Selenium TestNG tests'
                sh 'mvn test'
            }
            post {
                always {
                    junit '**/target/surefire-reports/*.xml'  // Collect TestNG results
                }
            }
        }

        stage('Post-Build') {
            steps {
                echo 'Tests Completed'
            }
        }
    }
}
