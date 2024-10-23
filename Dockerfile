FROM openjdk:8
EXPOSE 8080

VOLUME /superHero
ADD superHeroApp.jar  superHeroApp.jar
ENTRYPOINT ["java","-jar","/superHeroApp.jar"]
