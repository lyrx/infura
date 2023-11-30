import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.BeforeAndAfter
import org.mockito.Mockito.*

import java.net.http.{HttpClient, HttpRequest, HttpResponse}
import org.scalatestplus.mockito.MockitoSugar

import java.net.http.HttpResponse.{BodyHandler, BodyHandlers}
import scala.compiletime.ops.any
import org.mockito.ArgumentMatchers.any as mockitoAny


class JsonRpcClientTest extends AnyFunSuite with BeforeAndAfter with MockitoSugar {

  test("blockNumber should return valid response") {
    val mockResponse = mock[HttpResponse[String]]
    when(mockResponse.body()).thenReturn("""{"jsonrpc":"2.0","id":1,"result":"0x11d1edb"}""")

    val clientMock = mock[HttpClient]
    when(clientMock.send(mockitoAny[HttpRequest], mockitoAny[BodyHandler[String]])).thenReturn(mockResponse)
    val result = JsonRpcClient.blockNumber()
    assert(result.startsWith("0x"), "Block number should start with '0x'")
  }

  // Add more tests as needed
}
