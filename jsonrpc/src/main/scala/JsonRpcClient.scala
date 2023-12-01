// Import necessary classes from the Java standard library and external libraries

import com.typesafe.config.ConfigFactory
import java.net.URI
import java.net.http.{HttpClient, HttpRequest, HttpResponse}
import java.net.http.HttpRequest.BodyPublishers
import java.net.http.HttpResponse.BodyHandlers
import org.json.JSONObject

// Define the JsonRpcClient object
object JsonRpcClient {

  // Define a method to call a JSON-RPC service
  // 'method': JSON-RPC method to be called
  // 'params': Sequence of parameters for the JSON-RPC method
  // 'endpoint': The endpoint URL of the JSON-RPC service
  def call(method: String, params: Seq[String] = Seq.empty, endpoint: String): HttpResponse[String] = {
    // Prepare JSON payload for the JSON-RPC request
    val json =
      s"""
    {
      "jsonrpc": "2.0",
      "method": "$method",
      "params": [${params.mkString(",")}],
      "id": 1
    }
    """

    // Create an HTTP client
    val client = HttpClient.newHttpClient()

    // Build the HTTP request with necessary headers and body
    val request = HttpRequest.newBuilder()
      .uri(URI.create(endpoint))
      .header("Content-Type", "application/json")
      .POST(BodyPublishers.ofString(json))
      .build()

    // Send the request and return the response
    client.send(request, BodyHandlers.ofString())
  }

  // Define a method to get the current block number from an Ethereum node
  // This method reads the endpoint URL from the application's configuration file
  def blockNumber(): String = new JSONObject(
    call("eth_blockNumber", Seq(), ConfigFactory.load().getString("infura.url")).body()
  ).getString("result")
}
