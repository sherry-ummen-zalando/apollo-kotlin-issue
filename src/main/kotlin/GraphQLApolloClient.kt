package com.example.apolloissue.demo;

import com.apollographql.apollo3.ApolloClient
import com.example.apollokotlinclient.submission.UpdateExampleMutation
import com.example.apollokotlinclient.submission.type.ExampleInput
import kotlinx.coroutines.runBlocking
import mu.KotlinLogging
import org.springframework.beans.factory.annotation.Value

class GraphQLApolloClient(
  private val graphqlServerUrl: String,
  private val apiToken: String,
) {

  private val logger = KotlinLogging.logger {}

  private val apolloClient: ApolloClient = ApolloClient.Builder()
    .serverUrl(graphqlServerUrl)
    .addHttpHeader("Authorization", "Bearer $apiToken")
    .build()

  fun mutation(): GraphQLResponse {
    try {
      val response = runBlocking {
        apolloClient.mutation(
          UpdateExampleMutation(
            input = ExampleInput(entityId = "Sherry Testing"),
          )
        ).execute()
      }
      logger.info("############### Response $response #################")
      return GraphQLResponse(
        status = !response.hasErrors(),
        data = response.data
      )
    } catch (ex: Exception) {
      return GraphQLResponse(
        status = false,
        error = ex.message
      )
    }
  }
}

  data class GraphQLResponse(
    @JvmField val status: Boolean,
    @JvmField val error: String? = "",
    @JvmField val data: Any? = null
  )