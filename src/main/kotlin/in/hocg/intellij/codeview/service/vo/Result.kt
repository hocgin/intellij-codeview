package `in`.hocg.intellij.codeview.service.vo

/**
 * Created by hocgin on 2022/3/16
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
data class Result<T>(
    val success: Boolean,
    val message: String,
    val data: T
)