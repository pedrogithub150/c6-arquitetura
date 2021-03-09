pipeline
{
	agent any

	parameters
	{
		string(name: 'DOCKER_IMAGE', defaultValue: 'default_name', description: 'Docker image')

	}

    stages
       {
        stage('Docker build'){
            steps
                {
		        sh "docker rmi -f ${DOCKER_IMAGE}"
		        sh "docker build -t ${DOCKER_IMAGE} ."
            }
        }

        stage('Envia o artefacto para o Nexus'){
            steps
                {
                sh "docker login -u admin -p vD5tQ3fcTrF8dud localhost:8082 "
		        sh "docker tag ${DOCKER_IMAGE} localhost:8082/${DOCKER_IMAGE}"
		        sh "docker push localhost:8082/${DOCKER_IMAGE}"
                sh "javac *.java"
                sh "jar cfe tarefaCalculadora.jar tarefaCalculadora ./*.class"
                sh "curl -v -u 'admin:vD5tQ3fcTrF8dud' --upload tarefaCalculadora.jar http://nexus:8081/repository/raw-repository/"
            }
        }
		
        stage("faz a análise sonarqube") {
            environment { scannerHome = tool 'sonarqube' }
            steps {
                withSonarQubeEnv('sonarqube') {
                    sh "${scannerHome}/bin/sonar-scanner \
                    -D sonar.login=0231446ae87e96b06e70e7468fdf430ab2dfc49f \
                    -D sonar.projectKey=sonarqube \
                    -D sonar.java.binaries=/var/jenkins_home/workspace/c6-arquitetura \
                    -D sonar.java.source=11 \
                    -D sonar.host.url=http://sonarqube:9000/"
                    }
                }
            }
        }
    }