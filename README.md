# Wallet Balance

# Run
1. Build project by maven:
   mvn clean package
   Note that one integration test is run at the end. Database starts by mysql container.
2. Copy openjdk17, version 17.0.5 with exact name as jdk-17.0.5_linux-x64_bin.tar.gz in jars diretory of project wallet-balance:
   Path: wallet-balance/jars
3. Open docker-compose file and change mysql->volumes accroding to path of your system. (change home/atousa part) 
4. Go to the root of the project in an open terminal and run command:
   Docker compose up

 The project will start successfully. 
 Swagger URL: http://localhost:8080/api/swagger-ui/index.html

 One User with ID: 1 added to system

 At the start of project it is stored in DB using Liquibase.

