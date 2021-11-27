# Jumia Test Application

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management
* [JDK](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) - Java™ Platform, Standard Edition Development Kit
* [Spring Boot](https://spring.io/projects/spring-boot) - Framework to ease the bootstrapping and development of new Spring Applications
* [git](https://git-scm.com/) - Free and Open-Source distributed version control system

## Running the application locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `com.jumia.test.TestApplication` class from your IDE.

- Download the zip or clone the Git repository.
- Unzip the zip file (if you downloaded one)
- Open Command Prompt and Change directory (cd) to folder containing pom.xml
- Open Eclipse
    - File -> Import -> Existing Maven Project -> Navigate to the folder where you unzipped the zip
    - Select the project
- Choose the Spring Boot Application file (search for @SpringBootApplication)
- Right Click on the file and Run as Java Application

Another way is to use the docker by 

first build the project
```shell
mvn clean install
```
then build the docker image :
```shell
  docker build -t jumia/test
```
after that , you can run the image by :
```shell
docker run -p 8080:8080 jumia/test
```
Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
mvn spring-boot:run
```

## packages

- `entity` — to hold our entities;
- `dao` — to communicate with the database;
- `service` — to hold our business logic;
- `controller` — to listen to the client;
- `dto` - Data transfer object between the client and the backend
- `config` - Configuration related to the project
- `resources/` - Contains all the static resources, templates and property files.
- `resources/static` - contains static resources such as css, js and images.
- `resources/templates` - contains server-side templates which are rendered by Spring.
- `resources/application.properties` - It contains application-wide properties.

- `test/` - contains unit and integration tests
- `pom.xml` - contains all the project dependencies
- `Dockerfile` - file responsible for dockerizing the build
