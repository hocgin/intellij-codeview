package `in`.hocg.intellij.codeview.action

import `in`.hocg.intellij.codeview.service.AppsService
import `in`.hocg.intellij.codeview.ui.BalloonNotifications
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.PlatformDataKeys

/**
 * Created by hocgin on 2019/12/26.
 * email: hocgin@gmail.com
 * 分享选中的文件
 * @author hocgin
 */
class ShareSelectFileAction : AnAction() {
    override fun actionPerformed(e: AnActionEvent) {
        val project = e.project ?: return
        val file = e.getData(PlatformDataKeys.PSI_FILE)
        val text = file?.text

        if (text == null
            || text.isBlank()
        ) {
            BalloonNotifications.showWarningNotification("请选中要分享的内容")
            return
        }

        AppsService.shareTextAndNotify(
            content = text,
            project = project
        )
    }
}