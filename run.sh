#!/bin/sh
echo "********************************************************"
echo "Starting market-news-service "
echo "********************************************************"
java -jar -Dspring.profiles.active=dev market-news-service.jar
