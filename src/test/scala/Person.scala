//import java.util
//
//import org.apache.http.NameValuePair
//import org.apache.http.client.HttpClient
//import org.apache.http.client.entity.UrlEncodedFormEntity
//import org.apache.http.client.methods.HttpPost
//import org.apache.http.message.BasicNameValuePair
//
//class Person {
//var a:String=null
//}
//object   Preson1{
//
//    val httpClient:HttpClient = null;
//    val httpPost:HttpPost = null;
//    val result:String = null;
//    try{
//      httpClient = new SSLClient();
//      httpPost = new HttpPost(url);
//      //设置参数
//      val list:util.ArrayList[NameValuePair] = new util.ArrayList[NameValuePair];
//      val iterator:Iterator = map.entrySet().iterator();
//      while(iterator.hasNext()){
//         elem:Entry[String,String] = (Entry<String, String>) iterator.next();
//        list.add(new BasicNameValuePair(elem.getKey(),elem.getValue()));
//      }
//      if(list.size() > 0){
//        UrlEncodedFormEntity entity = new UrlEncodedFormEntity(list,charset);
//        httpPost.setEntity(entity);
//      }
//      HttpResponse response = httpClient.execute(httpPost);
//      if(response != null){
//        HttpEntity resEntity = response.getEntity();
//        if(resEntity != null){
//          result = EntityUtils.toString(resEntity,charset);
//        }
//      }
//    }catch(Exception ex){
//      ex.printStackTrace();
//    }
//    return result;
//
//}