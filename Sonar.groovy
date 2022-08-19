 node {
  stage('Clone') {
  git branch: 'main', url: 'https://github.com/Y1s2r3/Maven-demo.git'
  }
  stage('Build') {
    bat "cd initial && mvn clean install"
  }
  stage ('analysis') {
   bat "mvn org.sonarsource.scanner.maven:sonar-maven-plugin:3.7.0.1746:sonar \
  -Dsonar.projectKey=wertfg \
  -Dsonar.host.url=http://localhost:9000 \
   -Dsonar.user=admin \
  -Dsonar.login=eb57ec8810b20a8b7ed1d9eebb39f80840e33009"
  } 
 }
