Instalar Jenkins  

1- Criar dockerfile :
------------------------------
FROM jenkins/jenkins

USER root
RUN apt-get -y update && \
    apt-get -y install apt-transport-https ca-certificates curl gnupg-agent software-properties-common && \
    curl -fsSL https://download.docker.com/linux/ubuntu/gpg | apt-key add - && \
    add-apt-repository "deb [arch=amd64] https://download.docker.com/linux/$(. /etc/os-release; echo "$ID") $(lsb_release -cs) stable" && \
    apt-get update && \
    apt-get -y install docker-ce docker-ce-cli containerd.io
RUN curl -L "https://github.com/docker/compose/releases/download/1.26.2/docker-compose-$(uname -s)-$(uname -m)" -o /usr/local/bin/docker-compose && \
    chmod +x /usr/local/bin/docker-compose && \
    ln -s /usr/local/bin/docker-compose /usr/bin/docker-compose

USER jenkins
---------------------------------------------------

2- Correr comando :

docker run -d -u root -p 8080:8080 -p 50000:50000 -v /var/run/docker.sock:/var/run/docker.sock -v jenkins_home:/var/jenkins_home --name jenkins_docker jenkins-docker

--------------------------------------------------

Instalar nexus

docker run -d -p 8081:8081 --name nexus sonatype/nexus3

-------------------------------------------------

Instalar Sonar

docker run -d --name sonarqube sonarqube:latest

-------------------------------------------------

Network 

docker network create jenkins 

docker network connect jenkins sonarqube
docker network connect jenkins nexus
docker network connect jenkins jenkins_docker

.








