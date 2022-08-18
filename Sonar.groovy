node {
  stage('Clone') {
    git branch: "main" , url: "https://github.com/Y1s2r3/Maven-demo.git"
  }
  stage('Build') {
    bat "cd initial && mvn clean install"
  }
  stage('Upload War file to nexus') {
    bat "cd initial && mvn clean package"
  }
  stage('SonarQube analysis') {
    withSonarQubeEnv(credentialsId: 'a1893900d468b89894e5c7c0755b5a93574ac54d', installationName: 'Sonar-cloud') {
      sh 'mvn org.sonarsource.scanner.maven:sonar-maven-plugin:3.8.6:sonar'
    }
  }
}
  
