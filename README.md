# fibonacci-spring-boot

Fibonacci sequence with spring-boot is a project that contains a REST API to request a determinate size of the sequence, 
i.e., if you ask for a sequence of 4 elements you will receive a result like this:

`[ 0, 1, 1, 2 ]` 

If you ask for a sequence of 7 elements you will receive this one:

`[ 0, 1, 1, 2, 3, 5, 8]`

For the specifications of the API REST you could access to `http://localhost:8081/swagger-ui.html`.

This application could executed in two ways:

1 - As a spring boot application in console:

    - Download the application from https://github.com/rplaza/fibonacci-spring-boot.git
    - Compile the code: `mvn clean install`
    - Run the application: `mvn spring-boot:run`
    
2 - This application create a docker container when it is compiling, so you can execute it as a docker application:
    
    - Download the application from https://github.com/rplaza/fibonacci-spring-boot.git
    - Compile the code: `mvn clean install`
    - Run the application: `docker run -p 8081:8081 rplaza/fibonacci-spring-boot:1.0.0-SNAPSHOT`   
    
NOTE
----
This application works under some environment needs:
 - Maven 2 or upper
 - Java 8
 - Docker installed locally
     
