import JsonRpcClient.blockNumber
import com.typesafe.config.ConfigFactory



@main def helloWorld(): Unit =
  println(blockNumber())

