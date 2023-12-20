# InventorySystem

### Description ###

This is an Inventory System which is developed using simple Rest APIs. This application performs all CRUD operations.

### Installation ###
For installing this application firstly i opened spring.io then here give all details of project which are needed.
Then i added all dependencies like h2 database, Spring web, springDataJPA etc.
Then after downloading the zip folder extract this folder and import into STS.

### Accessing the application: ###
 
 For Getting all items use
 
 GET: localhost:8080/items
 
 Post:localhost:8080/items (if the data is not proper then it will also show validation messages like name not null, if price or quantity is less than 0 it will show price or quantity should not be negative.)
 
 Update:localhost:8080/items/1 (if id does not found then it will return exception like Item not found with ID)
 And it will also show validation messages like name not null, if price or quantity is less than 0 it will show price or quantity should not be negative.
 
 GetbyId:localhost:8080/items/1 (if id does not found then it will return exception like Item not found with ID)
 
 Delete:localhost:8080/items/1 (if id does not found then it will return exception like Item not found with ID)
 
 
 For documentation I used swagger and below is documentation link
 
 http://localhost:8080/swagger-ui/index.html


 ### Technology Stack ###

- Spring Boot 
- Spring Data JPA
- Database – H2Database
- JDK 11
