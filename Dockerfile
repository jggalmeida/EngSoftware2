FROM openjdk:8-jre-slim
WORKDIR /praticandoAPI
COPY target/*.war /praticandoAPI/praticandoAPI-0.0.1-SNAPSHOT.war
EXPOSE 8080
CMD java -XX:+UseContainerSupport -Xmx512m -Dserver.port=9090 -jar praticandoAPI-0.0.1-SNAPSHOT.war 



