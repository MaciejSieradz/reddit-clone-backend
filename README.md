# reddit-clong-backend

This is my personal Java with Spring back-end project for learning full-stack application development
using Spring and Angular. This is **not** a production ready projects. It lacks of many features and has some simplifiers.
For example, a private key for generating JWT token should be store in safe place, like vault. Moreover, I didin't create a separate Authorization server for simplicity, although I plan to do it in near future as and external repository. Also I didin't implement refresh token in the correct way. Refresh token **should be** a one-time use token, so it would be a better idea to store it in memory probably.

# Running

To run this application simply use maven command: _mvn spring-boot:run_ or run it and IDE. you can also dockerize it with 
_mvn spring-boot:build-image_ if you want. 
