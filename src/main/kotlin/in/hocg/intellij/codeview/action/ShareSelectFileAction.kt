package `in`.hocg.intellij.codeview.action

import `in`.hocg.intellij.codeview.ui.BalloonNotifications
import com.intellij.notification.NotificationType
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

        val file = e.getData(PlatformDataKeys.PSI_FILE)!!
        val fileContent = file.text


        println("文件内容: ${fileContent}")
        //        ActionManager.getInstance().registerAction();
        BalloonNotifications.createNotification("消息", "通知", NotificationType.INFORMATION)
            .addAction(OpenTitleDialogAction())
            .addAction(CopyLinkAction())
            .notify(project)
    }
}