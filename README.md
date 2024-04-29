# Car Marketplace

Microservices App for Car Marketplace

## Status

[![build](https://github.com/geekymon2/carmarketplace-user-svc/actions/workflows/build.yml/badge.svg)](https://github.com/geekymon2/carmarketplace-user-svc/actions/workflows/build.yml) &nbsp;&nbsp; [![codecov](https://codecov.io/gh/geekymon2/carmarketplace-user-svc/branch/main/graph/badge.svg?token=LH7ATDIHTB)](https://codecov.io/gh/geekymon2/carmarketplace-user-svc) &nbsp;&nbsp; ![Docker Image Version (latest by date)](https://img.shields.io/docker/v/geekymon2/cm-user-svc) &nbsp;&nbsp; ![Docker Image Size (latest by date)](https://img.shields.io/docker/image-size/geekymon2/cm-user-svc)

## About this Service

**User Service**

This service provides user authentication and registration api endpoints

## Documentation

For more details refer to the swagger documentation.

## Development Environment Setup

#### Step 1: Install the following tools to get local environment up and running.
* IntelliJ
* MySql
* Docker
* Maven
* Zulu JDK

#### Step 2: Ensure the local DB schema is created
* See schema-mysql.sql script in resources folder

#### Step 3: Ensure Config Server is running
All configuration is loaded from the config server directly

#### Step 4: Ensure Discovery Server is running

#### Local swagger url: http://localhost:8080/api/user-service/swagger-ui/index.html