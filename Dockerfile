## 이 프로젝트 이미지 정보
FROM openjdk:17

LABEL maintainer="sarah2316@g.skku.edu"

VOLUME /tmp

EXPOSE 8080

ARG JAR_FILE=build/libs/portfolio-0.0.1-SNAPSHOT.jar

ADD ${JAR_FILE} portfolio-hyeran.jar

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom", "-jar", "/portfolio-hyeran.jar"]