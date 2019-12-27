package `in`.hocg.intellij.codeview.action

import com.intellij.notification.Notification
import com.intellij.notification.NotificationAction
import com.intellij.openapi.actionSystem.AnActionEvent

/**
 * Created by hocgin on 2019/12/27.
 * email: hocgin@gmail.com
 * 点击复制链接
 * @author hocgin
 */
class CopyLinkAction(text: String = "复制链接") : NotificationAction(text) {
    override fun update(e: AnActionEvent) {
    }

    override fun actionPerformed(e: AnActionEvent, notification: Notification) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}