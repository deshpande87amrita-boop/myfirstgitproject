pipeline {
    agent any

    stages {

        stage('Compile') {
            steps {
                echo 'Compiling Java files...'
                // Create bin folder if it doesn't exist
                bat 'if not exist bin mkdir bin'
                // Compile all Java files in src folder into bin
                bat 'javac -d bin src\\**\\*.java'
            }
        }

        stage('Run') {
            steps {
                echo 'Running Java program...'
                // Run your main class (replace MainClass with your class name)
                bat 'java -cp bin MainClass'
            }
        }
    }

    post {
        always {
            echo 'Cleaning workspace...'
            cleanWs()
        }
    }
}
