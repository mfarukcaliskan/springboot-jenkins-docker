pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
                checkout([
                    $class: 'GitSCM',
                    branches: [[name: '*/main']],
                    extensions: [],
                    userRemoteConfigs: scm.userRemoteConfigs
                ])
            }
        }
        stage('Maven Build') {
            steps {
                bat 'mvn clean package -DskipTests'
            }
        }
        stage('Docker Build') {
            steps {
                bat 'docker build -t cicdapp:latest .'
            }
        }
        stage('Stop Old Container') {
            steps {
                bat(returnStatus: true, script: 'docker stop cicdapp-container')
            }
        }
        stage('Remove Old Container') {
            steps {
                bat(returnStatus: true, script: 'docker rm cicdapp-container')
            }
        }
        stage('Run Container') {
            steps {
                bat 'docker run -d -p 8082:8080 --name cicdapp-container cicdapp:latest'
            }
        }
    }
}
