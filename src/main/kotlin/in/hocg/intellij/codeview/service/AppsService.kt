package `in`.hocg.intellij.codeview.service

import `in`.hocg.intellij.codeview.action.CopyLinkAction
import `in`.hocg.intellij.codeview.action.OpenTitleDialogAction
import `in`.hocg.intellij.codeview.http.HttpClientUtils
import `in`.hocg.intellij.codeview.service.response.ShareTextResponse
import `in`.hocg.intellij.codeview.ui.BalloonNotifications
import com.beust.klaxon.Klaxon
import com.intellij.notification.NotificationType
import com.intellij.openapi.project.Project

/**
 * Created by hocgin on 2020/1/2.
 * email: hocgin@gmail.com
 * @author hocgin
 */
object AppsService {

    /**
     * 分享文本
     */
    fun shareText(
        title: String = "",
        content: String = ""
    ): String? {
        // ok code
        val body = HttpClientUtils.postString(
            url = """https://nutz.cn/s/api/create/txt?title=$title""",
            requestBody = content
        )
        val response = Klaxon().parse<ShareTextResponse>(body)

        if (response != null) {
            return """https://nutz.cn/s/c/${response.code}"""
        }
        throw RuntimeException("分享失败")
    }

    fun shareTextAndNotify(
        title: String = "",
        content: String,
        project: Project
    ) {
        val url = shareText(title = title, content = content)!!
        val notification = BalloonNotifications.createNotification(
            "通知",
            "分享成功",
            NotificationType.INFORMATION
        )
        notification.addAction(OpenTitleDialogAction())
            .addAction(CopyLinkAction(link = url))
            .notify(project)
    }

}