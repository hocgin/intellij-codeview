package `in`.hocg.intellij.codeview.service

import `in`.hocg.intellij.codeview.action.CopyLinkAction
import `in`.hocg.intellij.codeview.action.OpenTitleDialogAction
import `in`.hocg.intellij.codeview.http.HttpClientUtils
import `in`.hocg.intellij.codeview.service.ro.ShareTextRo
import `in`.hocg.intellij.codeview.ui.BalloonNotifications
import `in`.hocg.intellij.codeview.service.vo.Result
import com.beust.klaxon.Klaxon
import com.intellij.notification.NotificationType
import com.intellij.openapi.project.Project
import com.intellij.openapi.project.ProjectManager

/**
 * Created by hocgin on 2020/1/2.
 * email: hocgin@gmail.com
 * @author hocgin
 */
object AppsService {
    private val klaxon = Klaxon()

    /**
     * 分享文本
     */
    fun shareText(
        title: String = "",
        content: String = ""
    ): String {
        val url = """https://dear.hocgin.top/api/com/share-content"""
        val data = post<String>(url, ShareTextRo(title, content))
        return """https://dear.hocgin.top/view?u=${data}"""
    }

    fun shareTextAndNotify(
        title: String = "",
        content: String,
        project: Project? = ProjectManager.getInstance().defaultProject
    ) {
        val url = shareText(title = title, content = content)
        val notification = BalloonNotifications.createNotification(
            "通知",
            "分享成功",
            NotificationType.INFORMATION
        )
        notification.addAction(OpenTitleDialogAction(content = content))
            .addAction(CopyLinkAction(link = url))
            .notify(project)
    }


    fun <T> post(url: String, data: Any?): T {
        val body = HttpClientUtils.postString(
            url = url,
            requestBody = klaxon.toJsonString(data)
        )
        val response = klaxon.parse<Result<T>>(body)
        if (response == null || !response.success) {
            throw RuntimeException("分享失败 " + response?.message)
        }
        return response.data
    }
}