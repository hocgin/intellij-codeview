package `in`.hocg.intellij.codeview.service

import `in`.hocg.intellij.codeview.http.HttpClientUtils
import `in`.hocg.intellij.codeview.service.response.ShareTextResponse
import com.beust.klaxon.Klaxon

/**
 * Created by hocgin on 2020/1/2.
 * email: hocgin@gmail.com
 * @author hocgin
 */
object AppsService {

    /**
     * 分享文本
     */
    fun shareText(content: String = ""): ShareTextResponse {
        // ok code
        val body = HttpClientUtils.postString(
            url = "https://nutz.cn/s/api/create/txt?title=undefined",
            requestBody = """$content"""
        )
        return Klaxon().parse<ShareTextResponse>(body)!!
    }

}