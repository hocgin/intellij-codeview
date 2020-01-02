package `in`.hocg.intellij.codeview.http

import org.apache.http.HttpEntity
import org.apache.http.client.HttpClient
import org.apache.http.client.methods.HttpGet
import org.apache.http.client.methods.HttpPost
import org.apache.http.entity.StringEntity
import org.apache.http.impl.client.HttpClients
import org.apache.http.util.EntityUtils
import java.nio.charset.Charset

/**
 * Created by hocgin on 2019/12/28.
 * email: hocgin@gmail.com
 * @author hocgin
 */
object HttpClientUtils {

    /**
     * GET 请求
     */
    fun get(
        url: String,
        headers: Map<String, String> = HashMap()
    ): String {
        val request = HttpGet(url)

        headers.forEach { (k, v) ->
            request.addHeader(k, v)
        }

        val httpClient = getHttpClient()
        val response = httpClient.execute(request)
        return EntityUtils.toString(response.entity)
    }

    /**
     * POST 请求
     */
    private fun post(
        url: String,
        requestEntity: HttpEntity,
        headers: Map<String, String> = HashMap()
    ): String {
        val request = HttpPost(url)
        request.entity = requestEntity

        headers.forEach { (k, v) ->
            request.addHeader(k, v)
        }

        val httpClient = getHttpClient()
        val response = httpClient.execute(request)
        return EntityUtils.toString(response.entity)
    }

    fun postString(
        url: String,
        requestBody: String = "",
        headers: Map<String, String> = HashMap()
    ): String {
        return post(url, StringEntity(requestBody, Charset.forName("UTF-8")), headers)
    }

    private fun getHttpClient(): HttpClient {
        return HttpClients.createDefault()
    }
}
