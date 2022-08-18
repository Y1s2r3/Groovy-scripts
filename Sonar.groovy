node {
  stage('Clone') {
    git branch: "main" , url: "https://github.com/Y1s2r3/Maven-demo.git"
  }
  stage('SonarCloud Analysis') {
    withSonarQubeEnv('SonarCloud')
    bat "mvn sonar:sonar"
  }
}
  
