FROM openjdk:8
ADD target/delivery-auth-server.jar delivery-auth-server.jar
EXPOSE 8761
ENTRYPOINT ["java", "-jar", "delivery-auth-server.jar"]