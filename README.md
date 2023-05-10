# reddit-clone-backend

This is my personal Java with Spring back-end project for learning full-stack application development
using Spring and Angular. This is **not** a production ready projects. It lacks of many features and has some simplifiers.
For example, a private key for generating JWT token should be store in safe place, like vault. Moreover, I didin't create a separate Authorization server for simplicity, although I plan to do it in near future as an external repository. Also I didin't implement refresh token in the correct way. Refresh token **should be** a one-time use token, so it would be a better idea to store it in memory probably.

## Development server

Run `mvn spring-boot:run` for a dev server. Default port for rest API is 8080.

## Build

Run `mvn spring-boot:build-image` to build a docker image of this application.

## Database

For a proper work of application, you need to create and connect SQL database and email in `application.properties` file.  
