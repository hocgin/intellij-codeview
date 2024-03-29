package `in`.hocg.intellij.codeview.action

import `in`.hocg.intellij.codeview.service.AppsService
import `in`.hocg.intellij.codeview.ui.BalloonNotifications
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.PlatformDataKeys

/**
 * Created by hocgin on 2019/12/26.
 * email: hocgin@gmail.com
 * 分享聚焦页面的文本内容
 * @author hocgin
 */
class ShareFocusContentAction : AnAction() {
    override fun actionPerformed(e: AnActionEvent) {
        val project = e.project ?: return
        val editor = e.getData(PlatformDataKeys.EDITOR)
        val document = editor?.document
        val text = document?.text


        if (text == null || text.isBlank()) {
            BalloonNotifications.showWarningNotification("请选中要分享的内容")
            return
        }

        AppsService.shareTextAndNotify(
            content = text,
            project = project
        )
    }
}