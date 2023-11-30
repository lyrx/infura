import java.net.URI
import java.net.http.{HttpClient, HttpRequest, HttpResponse}
import java.net.http.HttpRequest.BodyPublishers
import java.net.http.HttpResponse.BodyHandlers

val json = """
{
  "jsonrpc": "2.0",
  "method": "eth_blockNumber",
  "params": [],
  "id": 1
}
"""

@main def helloWorld(): Unit =
  val client = HttpClient.newHttpClient()
  val request = HttpRequest.newBuilder()
    .uri(URI.create("https://mainnet.infura.io/v3/caa8ec7e1aa74463ab6ec85cee26d091"))
    .header("Content-Type", "application/json")
    .POST(BodyPublishers.ofString(json))
    .build()

  val response = client.send(request, BodyHandlers.ofString())

  println(response.statusCode())
  println(response.body())

