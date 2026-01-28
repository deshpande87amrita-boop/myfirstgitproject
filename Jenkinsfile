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
