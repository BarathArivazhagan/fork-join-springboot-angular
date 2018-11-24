# fork-join-springboot-angular5

In parallel computing, fork–join is a way of setting up and executing parallel programs, such that execution branches off in parallel at designated points in the program, to "join" (merge) at a subsequent point and resume sequential execution. Parallel sections may fork recursively until a certain task granularity is reached. Fork–join can be considered a parallel design pattern.

# fork-join flow


![fork join](images/forkjoin.png)

<table>
 <tr>
    <th style="text-align:left">Name</th>
    <th style="text-align:left">Port</th> 
    <th style="text-align:left">Description</th>
  </tr>
  <tr>
    <td><a href="https://github.com/BarathArivazhagan/fork-join-springboot-angular5/tree/master/bank-service"> bank-service</a></td>
    <td>9001</td>
    <td>Spring Boot Microservice</td>
  </tr>
  <tr>
    <td><a href="https://github.com/BarathArivazhagan/fork-join-springboot-angular5/tree/master/user-service">user-service</a></td>
    <td>9000</td>
    <td>Spring Boot Microservice</td>
  </tr>
  <tr>
    <td><a href="https://github.com/BarathArivazhagan/fork-join-springboot-angular5/tree/master/fork-join-demo">fork-join-demo</a></td>
    <td>4200</td>
    <td>Angular App</td>
  </tr>
  <tr>
    <td><a href="https://github.com/BarathArivazhagan/fork-join-springboot-angular5/tree/master/api-gateway">api-gateway</a></td>
    <td>9500</td>
    <td>Zuul API Gateway</td>
  </tr>
  
</table>

## How to run the application ?

* Clone the repository

```
git clone https://github.com/BarathArivazhagan/fork-join-springboot-angular5.git
```

* Execute below script to build all the applications

```
cd fork-join-springboot-angular5
./build.sh

```
* On windows, navigate to each applications and perform maven/webpack build

```
cd fork-join-springboot-angular5
cd api-gateway 
./mvnw clean package

cd bank-service
./mvnw clean package

cd user-service
./mvnw clean package

cd fork-join-demo

npm install
npm run build

```

* Start the applications

```
cd fork-join-springboot-angular5
cd api-gateway 
./mvnw spring-boot:run

cd bank-service
./mvnw spring-boot:run

cd user-service
./mvnw spring-boot:run

cd fork-join-demo

npm run start

```

### Docker support

Take advantage of docker compose to quickly build and run applications as containers.

* Build docker images

```
docker-compose build
```

* Run the applications

```
docker-compose up
```

### Kubernetes Support

To deploy the applications as docker containers inside kubernetes cluster

```
$ git clone https://github.com/BarathArivazhagan/fork-join-springboot-angular5.git && cd fork-join-springboot-angular5
$ kubectl create -f k8s/fork-join-deployment-k8s.yaml

configmap/spring-config-map created
configmap/api-gateway-config-map created
deployment.apps/user-app created
deployment.apps/bank-app created
deployment.apps/fork-join-api-gateway created
deployment.apps/fork-join-demo-app created
service/fork-join-api-gateway created
service/bank-service created
service/user-service createdservice/fork-join-ui created
```
