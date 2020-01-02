package `in`.hocg.intellij.codeview.ui;

import com.intellij.notification.*
import com.intellij.openapi.project.Project
import com.intellij.openapi.project.ProjectManager

/**
 * Created by hocgin on 2019/12/27.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
object BalloonNotifications {
    val stickyBalloonDisplayId = "SmartFox Intellij IDEA Notification"
    val displayId = "SmartFox Intellij IDEA Balloon Notification"
    val TITLE = "SmartFox Intellij IDEA Plugin"
    val balloonGroup = NotificationGroup(displayId, NotificationDisplayType.BALLOON, true)
    val stickyBalloonGroup = NotificationGroup(stickyBalloonDisplayId, NotificationDisplayType.STICKY_BALLOON, true)

    /**
     * 创建并显示通知
     */
    fun showNotification(
        message: String,
        project: Project? = ProjectManager.getInstance().defaultProject,
        title: String = TITLE,
        notificationType: NotificationType = NotificationType.INFORMATION,
        notificationListener: NotificationListener? = null,
        sticky: Boolean = false
    ) {
        createNotification(message, title, notificationType, notificationListener, sticky)
            .notify(project)
    }

    /**
     * 创建并显示错误的通知
     */
    fun showErrorNotification(
        message: String,
        project: Project? = ProjectManager.getInstance().defaultProject,
        title: String = TITLE,
        notificationListener: NotificationListener? = null,
        sticky: Boolean = false
    ) {
        showNotification(message, project, title, NotificationType.ERROR, notificationListener, sticky)
    }

    /**
     * 创建并显示警告类型的通知
     */
    fun showWarningNotification(
        message: String,
        project: Project? = ProjectManager.getInstance().defaultProject,
        title: String = TITLE,
        notificationListener: NotificationListener? = null,
        sticky: Boolean = false
    ) {
        showNotification(message, project, title, NotificationType.WARNING, notificationListener, sticky)
    }

    /**
     * 创建通知
     */
    fun createNotification(
        title: String = TITLE,
        message: String,
        notificationType: NotificationType = NotificationType.INFORMATION,
        notificationListener: NotificationListener? = null,
        sticky: Boolean = false
    ): Notification {

        val group = if (sticky) {
            stickyBalloonGroup
        } else {
            balloonGroup
        }

        return group.createNotification(title, message, notificationType, notificationListener)
    }

}
