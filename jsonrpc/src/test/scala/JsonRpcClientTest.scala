import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.BeforeAndAfter
import org.mockito.Mockito.*

import java.net.http.{HttpClient, HttpRequest, HttpResponse}
import org.scalatestplus.mockito.MockitoSugar

import java.net.http.HttpResponse.{BodyHandler, BodyHandlers}
import scala.compiletime.ops.any
import org.mockito.ArgumentMatchers.any as mockitoAny

// Define a test suite for JsonRpcClient using ScalaTest and Mockito
class JsonRpcClientTest extends AnyFunSuite with BeforeAndAfter with MockitoSugar {

  // Test case for the blockNumber method
  test("blockNumber should return valid response") {
    // Create a mock HttpResponse
    val mockResponse = mock[HttpResponse[String]]
    // Define the behavior of the mock response's body method
    when(mockResponse.body()).thenReturn("""{"jsonrpc":"2.0","id":1,"result":"0x11d1edb"}""")

    // Create a mock HttpClient
    val clientMock = mock[HttpClient]
    when(clientMock.send(mockitoAny[HttpRequest], mockitoAny[BodyHandler[String]])).thenReturn(mockResponse)
    val result = JsonRpcClient.blockNumber()

    // Assert that the result is as expected
    assert(result.startsWith("0x"), "Block number should start with '0x'")
  }

  // Additional tests can be added here
}
