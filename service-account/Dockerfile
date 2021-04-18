FROM java:8-jre
MAINTAINER Ihor Piontkovskyi <ih.piontkovskyi@gmail.com>

ADD ./target/service-account.jar /app/
CMD ["java", "-Xmx240m", "-jar", "/app/service-account.jar"]

EXPOSE 6000