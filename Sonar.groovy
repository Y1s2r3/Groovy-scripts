 node {
  stage('Clone') {
  git branch: 'main', url: 'https://github.com/Y1s2r3/Maven-demo.git'
  }
  stage('Build') {
    bat "cd initial && mvn clean install"
  }
  stage ('analysis') {
   bat "mvn org.sonarsource.scanner.maven:sonar-maven-plugin:3.7.0.1746:sonar \
  -Dsonar.host.url=http://localhost:9000 \
  -Dsonar.login=d9d9baef117586a3303d6c203bcfebf6d2bd1e79"
  } 
 }
