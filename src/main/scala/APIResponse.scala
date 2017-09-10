import org.apache.http.HttpResponse
import org.apache.http.client.methods.CloseableHttpResponse
import org.apache.http.util.EntityUtils
import org.jsoup.Jsoup
import org.jsoup.nodes.Document

import scala.tools.nsc.interpreter.InputStream

object APIResponse {

}

class APIResponse {
  var response: CloseableHttpResponse = _
  var statusCode: Int = 0
  var reasonPhrase: String = _
  var consumed: Boolean = false
  var body: String = _

  def this(response: CloseableHttpResponse) = {
    this
    this.statusCode=response.getStatusLine.getStatusCode
    this.reasonPhrase=response.getStatusLine.getReasonPhrase
    this.response = response
  }

  def getReasonPhrase: String = this.reasonPhrase

  def getStatusCode: Int = this.statusCode

  def getBody: String = {
val aa: String= EntityUtils.toString(response.getEntity)
    aa

  }
}
