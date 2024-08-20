pipeline {
    agent {
        label 'inbound-agent' //agente docker     
    }
    environment {
        JAVA_HOME = '/opt/jdk-22'
        PATH = "${JAVA_HOME}/bin:${env.PATH}"
    }
     stages {
        stage('Prepare Workspace') {
            steps {
                sh 'mkdir -p src/main/resources'
            }
        }        
        stage('Checkout') {
            steps {
                git 'https://github.com/fidonoso/test-junit-java-maven.git'
            }
        }
        stage('Build & Test') {
            steps {
                // Ejecutar las pruebas unitarias con Maven
                sh 'mvn clean test'
            }
        }
    }
    post {
        success {
            echo 'Build and Tests completed successfully.'
        }
        failure {
            echo 'Build or Tests failed.'
        }
    }
}