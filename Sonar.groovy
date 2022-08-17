node {
  stage('Clone') {
    git branch: "main" , url: ""
  }
  stage('Build') {
    bat "cd initial && mvn clean install"
  }
  stage('SonarCloud Analysis') {
    withSonarQubeEnv('SonarCloud')
    bat "mvn sonar:sonar"
  }
  
