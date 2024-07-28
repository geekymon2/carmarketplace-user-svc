# Car Marketplace

Microservices App for Car Marketplace

## Status

[![build](https://github.com/geekymon2/carmarketplace-user-svc/actions/workflows/build.yml/badge.svg)](https://github.com/geekymon2/carmarketplace-user-svc/actions/workflows/build.yml) &nbsp;&nbsp; [![codecov](https://codecov.io/gh/geekymon2/carmarketplace-user-svc/branch/main/graph/badge.svg?token=LH7ATDIHTB)](https://codecov.io/gh/geekymon2/carmarketplace-user-svc) &nbsp;&nbsp; ![Docker Image Version (latest by date)](https://img.shields.io/docker/v/geekymon2/cm-user-svc) &nbsp;&nbsp; ![Docker Image Size (latest by date)](https://img.shields.io/docker/image-size/geekymon2/cm-user-svc)

## About this Service

__User Service__

This service provides user authentication and registration api endpoints

## Local Environment Setup
* To run locally set the SPRING profile to "local".
    * You can do this by setting environment variable SPRING_PROFILES_ACTIVE=local
    * you can also set profile within the Intellij IDE
* Ensure that the root **carmarketplace** and **carmarketplace-core** modules are installed.
    * Check the local build instructions with that root project README.md
* Set the following environment variables.
    * USER_DB_NAME = userdbdev
    * USER_DB_PASSWORD = [PASSWORD]
* Direct API Swagger URL: http://localhost:8082/api/user-service/swagger-ui/index.html
* API Gateway: http://localhost:8008/api/swagger-ui/index.html

## Documentation

For more details refer to the swagger documentation.