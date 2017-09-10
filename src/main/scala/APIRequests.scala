import java.net.URI
import java.nio.charset.Charset
import java.util

import org.apache.http.NameValuePair
import org.apache.http.client.entity.UrlEncodedFormEntity
import org.apache.http.client.methods.{HttpGet, HttpPost, HttpUriRequest}
import org.apache.http.entity.{ContentType, StringEntity}
import org.apache.http.message.BasicNameValuePair

import scala.collection.mutable
object APIRequests{
  def get(url: String): APIRequests = new APIRequests(new HttpGet(url))

  def get(uri: URI): APIRequests = new APIRequests(new HttpGet(uri))

  def post(uri: URI): APIRequests = new APIRequests(new HttpPost(uri))

  def post(url: String): APIRequests = new APIRequests(new HttpPost(url))


}
class APIRequests {
  var httpRequest: HttpUriRequest = _
  var serviceURI: URI = _
  var body: StringEntity = _
  def  this(httpRequest: HttpUriRequest) {
    this
    this.serviceURI = httpRequest.getURI
    this.httpRequest = httpRequest
  }


  def addHeader(name: String, value: String): APIRequests = {
    this.httpRequest.addHeader(name, value)
    this
  }

  def setHeader(name: String, value: String): APIRequests = {
    this.httpRequest.setHeader(name, value)
    this
  }

  def removeHeader(name: String): APIRequests = {
    this.httpRequest.removeHeaders(name)
    this
  }

  def userAgent(agent: String): APIRequests = {
    this.httpRequest.setHeader("User-Agent", agent)
    this
  }

  def bodyForm(formParams: mutable.Map[String, Any]): APIRequests = {

    val arrayList:util.ArrayList[NameValuePair] = new util.ArrayList[NameValuePair]()
    //    val ideo:Iterator[(String, String)]=formParams.iterator
    formParams.keys.foreach(i => arrayList.add(new BasicNameValuePair(i, formParams(i).toString)))
//    val contentType = ContentType.create("application/x-www-form-urlencoded", Charset.forName("UTF-8"))
    val entity: StringEntity = new UrlEncodedFormEntity(arrayList, Charset.forName("UTF-8"))


    this.body =  entity
    this

  }

  def getBody: StringEntity = this.body

  def getServiceURI: URI = this.serviceURI

  def getRequest: HttpUriRequest = this.httpRequest


}
