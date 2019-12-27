package `in`.hocg.intellij.codeview.action

import `in`.hocg.intellij.codeview.ui.TitleDialog
import com.intellij.notification.Notification
import com.intellij.notification.NotificationAction
import com.intellij.openapi.actionSystem.AnActionEvent

/**
 * Created by hocgin on 2019/12/27.
 * email: hocgin@gmail.com
 * 点击打开设置标题弹窗
 * @author hocgin
 */
class OpenTitleDialogAction(text: String = "设置标题") : NotificationAction(text) {
    override fun update(e: AnActionEvent) {
    }

    override fun actionPerformed(e: AnActionEvent, notification: Notification) {
        val dialog = TitleDialog()
        dialog.pack()
        dialog.isVisible = true
    }

}