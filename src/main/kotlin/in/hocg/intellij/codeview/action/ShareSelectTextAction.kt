package `in`.hocg.intellij.codeview.action

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent

/**
 * Created by hocgin on 2019/12/26.
 * email: hocgin@gmail.com
 * 分享选中的文本
 * @author hocgin
 */
class ShareSelectTextAction : AnAction() {
    override fun actionPerformed(e: AnActionEvent) {
        val project = e.project ?: return
    }
}