package com.example.apolloissue.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.example.apolloissue.demo")
public class DemoApplication {

  public static void main(String[] args) {
    SpringApplication.run(DemoApplication.class, args);

    String graphqlServerUrl = ""; // FILL ME
    String apiToken = ""; // FILL ME

    GraphQLApolloClient client = new GraphQLApolloClient(graphqlServerUrl,
        apiToken);
    GraphQLResponse response = client.mutation();
  }
}
