pipeline {
  agent any
  stages {
    stage("verify tooling") {
      steps {
        bat '''
          docker version
          docker info
          docker compose version 
          curl --version
          jq --version
          '''
      }
    }
    stage('Prune Docker data') {
      steps {
        bat 'docker system prune -a --volumes -f'
      }
    }
    stage('Start container') {
      steps {
        bat 'docker compose up -d --no-color --wait'
        bat 'docker compose ps'
      }
    }
    stage('Run tests against the container') {
      steps {
        //bat 'curl http://localhost:9090'
        bat 'curl http://localhost:9090/param?query=demo | jq'
      }
    }
  }

  post {
    always {
    bat 'docker compose down --remove-orphans -v'
    bat 'docker compose ps'
    }
  }
}