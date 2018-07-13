# boptum
## Backend

### Prerequisite
1. Download Java JDK 1.8
2. Install maven from brew using `brew install maven`
3. Set up sdk man 'curl -s `https://get.sdkman.io" | bash`
4. Get spring boot by using sdk man `sdk install springboot`
5. Download mySQL Community from [here](https://dev.mysql.com/downloads/mysql/) (Make sure to remeber the password-)
6. Also download mySQL from brew using `brew install mysql`
7. Start up mysql using `sudo mysql --password`
8. Create a new database
```shell
create database boptum_mysql;
create user 'boptum'@'localhost' identified by 'password';
grant all on boptum_mysql.* to 'boptum'@'localhost';
```

### Usage
1. Navigate to `boptum/boptum_backend`
2. Run commmand `mvn clean install` to install dependencies
3. Run command `mvn spring-boot:run` to start up server

## Frontend
1. Navigate to `boptum/boptum_frontend`
2. Install dependencies using `npm install`
3. Start program with command `npm start`
4. You will be redirected to `localhost:8080`
