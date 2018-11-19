FROM openjdk:8-jdk-alpine
RUN apk --no-cache add netcat-openbsd
COPY target/delivery-eureka-server.jar /opt/spring-cloud/lib/
COPY config-client-entrypoint.sh /opt/spring-cloud/bin/
RUN chmod 755 /opt/spring-cloud/bin/config-client-entrypoint.sh