FROM java:8-jre
MAINTAINER Ihor Piontkovskyi <ih.piontkovskyi@gmail.com>

ADD ./target/gateway.jar /app/
CMD ["java", "-Xmx240m", "-jar", "/app/gateway.jar"]

EXPOSE 4000