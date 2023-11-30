import com.typesafe.config.ConfigFactory

import java.net.URI
import java.net.http.{HttpClient, HttpRequest, HttpResponse}
import java.net.http.HttpRequest.BodyPublishers
import java.net.http.HttpResponse.BodyHandlers
import org.json.JSONObject

object JsonRpcClient {

  def call(method: String, params: Seq[String] = Seq.empty, endpoint:String): HttpResponse[String] = {
    val json = s"""
    {
      "jsonrpc": "2.0",
      "method": "$method",
      "params": [${params.mkString(",")}],
      "id": 1
    }
    """

    val client = HttpClient.newHttpClient()
    val request = HttpRequest.newBuilder()
      .uri(URI.create(endpoint))
      .header("Content-Type", "application/json")
      .POST(BodyPublishers.ofString(json))
      .build()

    client.send(request, BodyHandlers.ofString())
  }


  /* {"jsonrpc":"2.0","id":1,"result":"0x11d1edb"} */
  def blockNumber() =     new JSONObject(
    call("eth_blockNumber",
      Seq(),
      ConfigFactory.load().getString("infura.url")
    ).body()).getString("result")

}

