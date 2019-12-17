pipeline {
    agent any

    stages {
        stage('Test') {
            steps {
                sh 'mvn clean test'
                sh 'mvn sonar:sonar \
                      -Dsonar.projectKey=BakaBoing_itb5-culture-tickets \
                      -Dsonar.organization=bakaboing \
                      -Dsonar.host.url=https://sonarcloud.io \
                      -Dsonar.login=93377b01b5a9f1e92609418d47e376d5c6a2f1d5 \
                      -Dsonar.jacoco.reportPaths=**/target/jacoco.exec'
                junit '**/target/surefire-reports/*.xml'
            }
        }
        stage('Build') {
            when {
                branch 'master'
            }
            steps {
                sh 'mvn clean -DskipTests -U package'
            }
        }
    }
}
