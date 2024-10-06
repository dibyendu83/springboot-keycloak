# Spring Boot with Swagger and Keycloak Integration
This project showcases the integration of Spring Boot with Keycloak, a powerful open-source identity and access management solution. It demonstrates how to set up user authentication and authorization using Keycloak's robust features, allowing for secure access to your Spring Boot applications. The project includes sample configurations and endpoints to help developers implement secure authentication mechanisms, manage user roles, and protect resources effortlessly. Ideal for those looking to enhance their applications with secure identity management.

# Getting Started
Clone the repository from github for development.

## Requirements

For building and running the application you need:

- [JDK 21](https://www.oracle.com/java/technologies/javase/jdk21-archive-downloads.html)
- [Maven](https://maven.apache.org/download.cgi)
- [Docker](https://www.docker.com/products/docker-desktop/)
- [Docker Compose](https://docs.docker.com/compose/install/)

## Prerequisites
The provided ```docker-compose.yml``` file will create containers for:

- PostgreSQL: A database used by Keycloak for storing user and authentication data.
- Keycloak: An open-source Identity and Access Management tool

#### Run the containers
To spin up the containers, run ``` docker-compose up ``` command in the project root where ```docker-compose.yml``` is located:

##### 3rd party

## Set Up Keycloak
* Login the url ```http://localhost:8181/``` with ``username as admin and password as admin``
* Create a realm named as test.
* Create a client named as demo-client
* Create two users. One is Admin role and another one is User role.
* Get the access_token from ``http://localhost:8181/realms/test/protocol/openid-connect/token`` 
* For more endpoints checkout ``http://localhost:8181/realms/test/.well-known/openid-configuration``

## Build and Run the application
To build and run the project locally
* Clone the project from github and go to locally cloned folder
* Command to run the application ```mvn spring-boot:run```

## Built With
* Maven - Build tool
* Junit - Testing framework