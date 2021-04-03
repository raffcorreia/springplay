# SpringPlay



## Build FE and BE
In the root folder run:
```shell
mvn clean package
```

## Run FE and BE
* Run using **Maven**:
```shell
mvn spring-boot:run
```
  
* Run the **jar** file as as any other spring boot app:
```shell
java -jar backend/target/backend-springplay-0.0.1-SNAPSHOT.jar
```

## Authentication
This project uses authentication for test purposes the type of authentications are;
### Spring login form with **Session**
* Username: `admin`
* Password: `admin`
### Basic auth
`Authorization:Basic YWRtaW46YWRtaW4=`
### JWT
Call the endpoint `POST /authenticate` with the previous username and password to generate a JWT or create one using the following signature;

`ThisIsAJWTSignatureSample`

This is a sample JWT the expires in the year 2999;

JWT |
------------ |
eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsImF1dGhvcml0aWVzIjoiUk9MRV9BRE1JTiIsImlhdCI6MTYxNzQxOTA4MiwiZXhwIjozMjUwMzY3OTk5OX0.tMWTHmBUYIPA06H5TJMaYadF3xbHRTeGAfjb1OGcsds|
