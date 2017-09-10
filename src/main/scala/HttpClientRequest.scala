import java.io.IOException

import org.apache.http.client.CookieStore
import org.apache.http.client.config.RequestConfig
import org.apache.http.client.methods.CloseableHttpResponse
import org.apache.http.client.protocol.HttpClientContext
import org.apache.http.impl.client.{CloseableHttpClient, HttpClients}

class HttpClientRequest {
  var httpClient: CloseableHttpClient = HttpClients.createDefault
  var cookieStore:CookieStore=_
  val requestConfig:RequestConfig =null
  def this(httpClient: CloseableHttpClient)={
    this
    this.httpClient=httpClient

  }

  def cookieStore(cookieStore: CookieStore): HttpClientRequest = {
    this.cookieStore = cookieStore
    this
  }
  def execute(request: APIRequests): APIResponse = {
    val context: HttpClientContext = HttpClientContext.create
    context.setAttribute("http.cookie-store", this.cookieStore)
    val httpUriRequest = request.httpRequest

    var response:CloseableHttpResponse = null
    try {
      response = this.httpClient.execute(httpUriRequest, context)
    }
    catch {
      case ex: IOException => ex.printStackTrace()
    }

    new APIResponse(response)
  }

  def tearDown(): Unit = {
    httpClient.close()
  }

}