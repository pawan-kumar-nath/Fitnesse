# Fitnesse

Primary objective of this project is to demonstrate setup and operation of an Enterprise Fitnesse project

Technology stack used:
1) Fitnesse along with FitLibrary for Fixtures
2) Spring IOC
3) JDBI Library for database interaction
4) Feign REST Client
5) Maven

In order to run this project, please do following steps:
1) Update Database Host and Credentials in file \Fitnesse\run.sh
2) Build using MAVEN (command:  mvn install)
3) Run application by command:  ./run.sh

Ports:
Application run on port: 8888
Debugging Port: 8889

New Fitnesse Test pages, respective fixtures and supporting classes can be created in this project for Fitnesse practice but in case if you want to run existing Fitnesse tests then please setup and run following parallel project:
https://github.com/pawan-kumar-nath/AccountProjectFitnesseDemo

 
