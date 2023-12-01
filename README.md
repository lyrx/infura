# JSON RPC Client Demo Project

![](./jsonrpc/images/scalajavademo.png)



## Overview
This project demonstrates proficiency in both Java and Scala programming, specifically in the context of JSON-RPC client development. It includes a simple JSON-RPC client (`JsonRpcClient`) written in Scala and its corresponding unit tests (`JsonRpcClientTest`).

## Structure
- `JsonRpcClient`: Scala implementation of a JSON-RPC client.
- `JsonRpcClientTest`: Unit tests for `JsonRpcClient` using ScalaTest and Mockito.

## Technologies Used
- **Scala**: For implementing the JSON-RPC client.
- **Java**: Utilized in the underlying HTTP client logic.
- **ScalaTest**: For unit testing the application.
- **Mockito**: For mocking dependencies in tests.

## Setup and Running
To run this project, you need to have Scala and SBT installed on your machine. Follow these steps:

1. Clone the repository to your local machine.
2. Navigate to the project directory.
3. Run the Scala application or tests using SBT:
   ```
   sbt run // To run the application
   sbt test // To run the tests
   ```
