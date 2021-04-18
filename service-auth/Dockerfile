FROM java:8-jre
MAINTAINER Ihor Piontkovskyi <ih.piontkovskyi@gmail.com>

ADD ./target/service-auth.jar /app/
CMD ["java", "-Xmx240m", "-jar", "/app/service-auth.jar"]

EXPOSE 5000