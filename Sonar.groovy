node {
  stage('Clone') {
    git branch: "main" , url: "https://github.com/Y1s2r3/Maven-demo.git"
  }
  stage('Build') {
    bat "cd initial && mvn clean install"
  }
  stage('SonarCloud Analysis') {
      withSonarQubeEnv(credentialsId: '4352577ae45e2fd0dafd6d24633ff7c77405f0bc', installationName: 'My SonarQube Server') {
      sh 'mvn org.sonarsource.scanner.maven:sonar-maven-plugin:3.8.6:sonar'
  }
}
  
