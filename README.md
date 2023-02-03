# RIG (Reading Is Good)
ReadingIsGood is an online books retail firm which operates only on the internet.

"RIG" is the microservice of the ReadingIsGood project.

# Used Technologies

- Java 11
- Spring Boot
- PostgreSQL
- Docker
- Postman

# General Information About RIG
The RIG microservice has three entities named "Book", "Order" and "Customer". 
These entities contain information about the book, order and customer, respectively.

Three controllers named "BookController", "OrderController" and "CustomerController" 
have been defined for CRUD operations on these entities. 
A "StatisticController" is also defined, which provides customer statistics.

# Project Creation Process
First of all, Spring Boot web application was created. The dependencies to be used 
in the project (for example: lombok, postgresql, mapstruct etc) have been added 
to pom.xml.

After adding the necessary dependencies, the specified entities for the project 
were created under the "entity" folder and their definitions were made, and then 
the necessary definitions for postgresql were made in the "application.yml" file.
Then dto and response objects were defined for these entities. After the entity 
definitions were made, a schema named "rig" was created in the postgresql database.

Afterwards, controllers were created, the APIs for the operations to be performed 
were written, and the services for the logic operations were defined.

While creating the services, services such as repository and mapper to be used 
in these services were created.

Then, open API (swagger) was configured for more comfortable API usage.

Finally, the created microservice is containerized with Docker.
In order to containerize, the init.sql file, which creates the general structure 
of the database, is added to the project directory. Since the project will be 
started with docker-compose, the docker-compose.yaml file is also created in this 
directory and the information of the "rig" service and the "posgresql" service is 
added.

# How to start the project

- Pull the project locally
  To create the .jar package required to create the image;
- mvn clean package
  to create an image;
- docker build --tag=rig-application.jar:latest .
  run the created image;
- docker run rig-application.jar

You can access the project at http://localhost:8787/rig/swagger-ui.html.

You can also test the project by importing the Postman collection named 
"rig-postman_collection" in the project directory.