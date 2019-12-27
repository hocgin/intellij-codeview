package `in`.hocg.intellij.codeview.action

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.PlatformDataKeys
import com.intellij.openapi.util.TextRange

/**
 * Created by hocgin on 2019/12/26.
 * email: hocgin@gmail.com
 * 分享聚焦行
 * @author hocgin
 */
class ShareFocusLineAction : AnAction() {
    override fun actionPerformed(e: AnActionEvent) {
        // TODO: insert action logic here
        val editor = e.getData(PlatformDataKeys.EDITOR)
        val document = editor?.document

        // 这文本所有数据
        println("当前页内容: ${document?.text}")

        // 文本总行数
        println("总行数: ${document?.lineCount}")


        val caretModel = editor?.caretModel
        // 选中信息
        val primaryCaret = caretModel?.primaryCaret
        // 选中行-开始位置
        val selectionStart = primaryCaret?.selectionStart
        // 选中行-结束位置
        val selectionEnd = primaryCaret?.selectionEnd

        // 光标所在行信息
        val logicalPosition = primaryCaret?.logicalPosition
        // 行号
        val lineNumber = logicalPosition?.line!!

        val lineStartOffset = document?.getLineStartOffset(lineNumber)!!
        val lineEndOffset = document.getLineEndOffset(lineNumber)

        val lineText = document.getText(TextRange.create(lineStartOffset, lineEndOffset))
        println("当前行内容: ${lineText}")


    }
}