package `in`.hocg.intellij.codeview.action

import `in`.hocg.intellij.codeview.service.AppsService
import `in`.hocg.intellij.codeview.ui.BalloonNotifications
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.PlatformDataKeys
import com.intellij.openapi.util.TextRange

/**
 * Created by hocgin on 2019/12/26.
 * email: hocgin@gmail.com
 * 分享光标所在行
 * @author hocgin
 */
class ShareFocusLineAction : AnAction() {
    override fun actionPerformed(e: AnActionEvent) {
        val project = e.project ?: return
        val editor = e.getData(PlatformDataKeys.EDITOR)
        val document = editor?.document
        val caretModel = editor?.caretModel

        // 选中信息
        val primaryCaret = caretModel?.primaryCaret

        // 光标所在行信息
        val logicalPosition = primaryCaret?.logicalPosition

        // 行号
        val lineNumber = logicalPosition?.line!!

        val lineStartOffset = document?.getLineStartOffset(lineNumber)!!
        val lineEndOffset = document.getLineEndOffset(lineNumber)

        val text = document.getText(TextRange.create(lineStartOffset, lineEndOffset))

        if (text.isBlank()) {
            BalloonNotifications.showWarningNotification("请选中要分享的内容")
            return
        }

        AppsService.shareTextAndNotify(
            content = text,
            project = project
        )

    }
}