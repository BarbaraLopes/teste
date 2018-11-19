#!/bin/sh
echo "sdasdasd"
while ! nc -z configserver 9090 ; do
    echo "Waiting for upcoming Config Server"
    sleep 2
done
java -jar /opt/spring-cloud/lib/config-client.jar