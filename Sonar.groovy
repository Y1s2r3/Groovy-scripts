 node {
  stage('Clone') {
  git "https://github.com/Y1s2r3/Maven-demo.git"
  }
  stage('Build') {
    bat "mvn -Dmaven.test.failure.ignore=true clean package"
    archiveArtifacts artifacts: 'target/*.jar', onlyIfSuccessful: true
  }
  stage ('analysis') {
    //bat "mvn verify org.sonarsource.scanner.maven:sonar-maven-plugin:sonar"
    //junit 'target/surefire-reports/*.xml'
    bat "mvn org.sonarsource.scanner.maven:sonar-maven-plugin:3.8.6:sonar \
    -Dsonar.projectKey=gs-maven1 \
    -Dsonar.host.url=http://localhost:9000 \
    -Dsonar.user=admin \
    -Dsonar.login=sqp_e19f2b234afa50cc33d48e0436d19b3c134e3783"
  } 
 }
