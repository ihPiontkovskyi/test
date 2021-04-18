FROM java:8-jre
MAINTAINER Ihor Piontkovskyi <ih.piontkovskyi@gmail.com>

ADD ./target/registry.jar /app/
CMD ["java", "-Xmx240m", "-jar", "/app/registry.jar"]

EXPOSE 8761