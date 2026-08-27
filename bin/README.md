## 1. Technologies used
- Spring Boot 3.3.7
- Spring Data JPA
- MySQL 8
- Swagger for API testing
## 2. Run application (in dev)
- Build application with mvn clean install
- Run application with mvn spring-boot:run -Dspring-boot.run.profiles=dev
- Access h2-database using: http://ip-address:8080/h2-console, enter JDBC URL: jdbc:h2:mem:easyfly_db, enter username: sa, enter password: sa
## 3. Run application (in prod)
- Go to MySQL and create database with name easyfly_db
- Build application with mvn clean install
- Run application with mvn  spring-boot:run -Dspring-boot.run.profiles=prod