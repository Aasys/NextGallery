# Next Gallery

## tools
java 1.8

Google Web Toolkit 

gwtmaterialdesign

maven


## How to Build
Requires java and maven. use maven command to compile

    mvn clean install
    
## host
Find the '.war' file in the target directory after compilation. Use a web server to host this file.

## tomcat
I used tomcat for hosting. Using tomcat, place the war file in the tomcat webapps directory.
name it NextGallery.war and now you can access it at localhost:8080/NextGallery