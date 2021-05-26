#!/bin/sh
echo "********************************************************"
echo "Starting fundamental-service "
echo "********************************************************"
java -jar -Dspring.profiles.active=dev fundamental.jar
