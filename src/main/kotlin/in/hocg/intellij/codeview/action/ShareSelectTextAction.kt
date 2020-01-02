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
 * 分享选中的文本
 * @author hocgin
 */
class ShareSelectTextAction : AnAction() {
    override fun actionPerformed(e: AnActionEvent) {
        val project = e.project ?: return
        val editor = e.getData(PlatformDataKeys.EDITOR)
        val caretModel = editor?.caretModel
        val document = editor?.document

        // 选中信息
        val primaryCaret = caretModel?.primaryCaret

        // 选中行-开始位置
        val selectionStart = primaryCaret?.selectionStart!!

        // 选中行-结束位置
        val selectionEnd = primaryCaret.selectionEnd

        val text = document?.getText(TextRange.create(selectionStart, selectionEnd))
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