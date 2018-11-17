#!/bin/bash


echo "docker repository name $1"


if [ -z $1]
then
      echo "$1 is not empty"    
else
      echo "$1 is empty"
      $1 = "test"
fi
echo "docker repository name $1"
echo "BUILD USER SERVICE DOCKER IMAGE"

cd user-service 
docker build -t $1/user-service .

echo "BUILD USER SERVICE  DOCKER IMAGE SUCCESSFUL"

cd ../

echo "BUILD BANK SERVICE DOCKER IMAGE"

cd bank-service 
docker build -t $1/bank-service .

echo "BUILD BANK SERVICE DOCKER IMAGE SUCCESSFUL"

cd ../

echo "BUILD API GATEWAY DOCKER IMAGE"

cd api-gateway 
docker build -t $1/fork-join-api-gateway .

echo "BUILD API GATEWAY DOCKER IMAGE SUCCESSFUL"

cd ../

echo "BUILD Angular app DOCKER IMAGE"

cd fork-join-demo
docker build -t $1/fork-join-demo-ui .

echo "BUILD Angular app DOCKER IMAGE SUCCESSFUL"