#!/bin/bash

echo "BUILD USER SERVICE"

cd user-service 
mvn clean install -DskipTests

echo "BUILD USER SERVICE SUCCESSFUL"

cd ../

echo "BUILD BANK SERVICE"

cd bank-service 
mvn clean install -DskipTests

echo "BUILD BANK SERVICE SUCCESSFUL"

cd ../

echo "BUILD API GATEWAY"

cd api-gateway 
mvn clean install -DskipTests

echo "BUILD API GATEWAY SUCCESSFUL"

cd ../

echo "BUILD Angular app"

cd fork-join-demo
npm install
npm run build

echo "BUILD Angular app SUCCESSFUL"