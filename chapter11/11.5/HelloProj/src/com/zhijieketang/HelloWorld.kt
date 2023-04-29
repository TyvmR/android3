/*
* Created by 画画的程序员
* 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
* 邮箱：eorient@sina.com
*
*/

//代码文件：/com/zhijieketang/HelloWorld.kt

package com.zhijieketang

sealed class Result
class Success(val message: String) : Result()
class Failure(val error: Error) : Result()


fun onResult(result: Result) {
    when (result) {
        is Success -> println("${result}输出成功消息：${result.message}")
        is Failure -> println("${result}输出失败消息：${result.error.message}")
        //else -> 不再需要
    }
}

sealed class ContentType {
    class Text(val body: String) : ContentType()
    class Image(val url: String, val caption: String) : ContentType()
    class Audio(val url: String, val duration: Int) : ContentType()
}

fun renderCotent(contentType: ContentType): Unit {
    when (contentType) {
        is ContentType.Text -> println("文本：${contentType.body}")
        is ContentType.Audio -> println("音频:${contentType.duration}秒")
        is ContentType.Image -> println("图片：${contentType.caption}")
    }
}

fun main() {

    val result1 = Success("数据更新成功")
    onResult(result1)
    val result2 = Failure(Error("主键重复，插入数据失败"))
    onResult(result2)
}