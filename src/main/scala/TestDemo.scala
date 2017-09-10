import scala.collection.mutable

object TestDemo extends HttpClientRequest {
  def main(args: Array[String]): Unit = {
    val res = new APIRequests
    val resp = new APIResponse
    val orginUrl = "http://www.onlinesjtu.com/"
    val loginUrl = "http://www.onlinesjtu.com/Index.aspx"
    val requests: APIRequests = APIRequests.get(orginUrl).userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.113 Safari/537.36")
    val response: APIResponse = execute(requests)
    val loginMap: mutable.HashMap[String, Any] = mutable.HashMap()
    loginMap += ("__VIEWSTATE" -> "/wEPDwUKMTExOTI5NDk3OWQYAQUeX19Db250cm9sc1JlcXVpcmVQb3N0QmFja0tleV9fFgEFImN0bDAwJENvbnRlbnRQbGFjZUhvbGRlcjEkaWJ0TG9naW7UcgS82I2VmoQMeY9GdU2K8I+8zQ==")
    loginMap += ("__VIEWSTATEGENERATOR" -> "90059987")
    loginMap += ("__EVENTVALIDATION" -> "/wEWCAKHwK2XDAKP6repDwL59L30DgLs64TUCQLz64TUCQLy64TUCQL8hK66BQKflO50CfaHMVnqLBIAhLgyEgQIbayqmQw=")
    loginMap += ("ctl00$ContentPlaceHolder1$tbuserid" -> "716101520010")
    loginMap += ("ctl00$ContentPlaceHolder1$tbpassword" -> "yanjiankai")
    loginMap += ("ctl00$ContentPlaceHolder1$rblusertype" -> 0)
    loginMap += ("ctl00$ContentPlaceHolder1$ibtLogin.x" -> 36)
    loginMap += ("ctl00$ContentPlaceHolder1$ibtLogin.y" -> 18)
    val loginRequest: APIRequests = APIRequests.post(orginUrl).bodyForm(loginMap)
    val loginResponse:APIResponse=execute(loginRequest)
    //    APIRequests.apply
    println(loginResponse.getBody)
    println(loginResponse.getStatusCode)
    println(loginResponse.getReasonPhrase)

  }
}
