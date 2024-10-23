#### Software version recommendation(which I'm using)
CentOS Linux release 7.9.2009 (Core)

Docker version 18.06.3-ce

maven 3.6.0

mysql:8.0.26(docker image)

openjdk:8(docker image)

#### Operation Guide
1. Run 'mvn package' to package jar file from the source code.
   ```
   mvn package
   ```
2. Log on Linux server, create a new directory(mkdir /superHero), and change directory to it(cd /superHero)
   ```
   mkdir /superHero
   cd /superHero

3. Upload the file "Dockerfile" here, and upload the jar file packaged in step 2 here
4. (optional) docker pull openjdk:8, docker run -d -it --name jdk8 openjdk:8
   ```
   docker pull openjdk:8 
   docker run -d -it --name jdk8 openjdk:8

5. (optional) docker pull mysql:8.0.26, docker run -di --name=mysql -p 3306:3306 -e MYSQL_ROOT_PASSWORD=123456 mysql8
   ```
   docker pull mysql:8.0.26
   docker run -di --name=mysql -p 3306:3306 -e MYSQL_ROOT_PASSWORD=123456 mysql8

6. Run /sql/init.sql in mysql client to init the database, tables and data rows.
7. Docker build the app image(docker  build  -t app:latest  .)
   ```
   docker  build  -t app:latest  .

8. According to the below command, modify the environment variables(DB_HOST, DB_PORT, DB_USER, DB_PWD) as your actual situation, then excute it to start the App
   ```
   docker run -d -e DB_HOST=192.168.116.134 -e DB_PORT=3306 -e DB_USER=root -e DB_PWD=123456 --name=superHeroApp -p 8080:8080 app:latest
   
9. Testing: excute below command to call the API(need to modify the 'host' as your actual situation)
```
   1. query all
   curl --location 'host:8080/superHero?pageNum=1&pageSize=10'
  
   2. save 
   curl --location 'host:8080/superHero' \
   --header 'Content-Type: application/json' \
   --data '{
    "alias":"alias1",
    "name":"name1",
    "origin":"origin1",
    "powers":["power1", "power2"],
    "weapons":["weapon1", "weapon2"],
    "associations":["association1", "association2"]
}'

```