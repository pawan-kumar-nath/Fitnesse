#!/bin/sh
# ***********************************************************************
# Command line script to run Fitnesse Demo app 
#
# This tool requires JAVA_HOME/bin directory to be present in PATH
# environment variable.
# 
# All the environment variables mentioned below are required and tool 
# will fail without setting them.
# ***********************************************************************

host_url=http://localhost:9000
export host_url
db_host={host}:{port}:{sid}
export db_host
dbUser={user}
export dbUser
dbPassword={password}
export dbPassword

java -jar target/demo-Fitnesse-0.0.1-SNAPSHOT.jar -p 8888 -d . -r wiki/FitNesseRoot/