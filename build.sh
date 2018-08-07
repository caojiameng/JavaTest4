#!/usr/bin/env bash

mvn clean package
mv target/Java*.jar docker/java/

docker-compose build
docker-compose up