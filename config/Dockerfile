FROM java:8-jre
MAINTAINER Ihor Piontkovskyi <ih.piontkovskyi@gmail.com>

ADD ./target/config.jar /app/
CMD ["java", "-Xmx240m", "-jar", "/app/config.jar"]

EXPOSE 8888