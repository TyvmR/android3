/*
* Created by 画画的程序员
* 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
* 邮箱：eorient@sina.com
*
*/
//代码文件：chapter15/src/com/zhijieketang/IQueue.kt
package com.zhijieketang

/**
 * 自定义的泛型队列集合
 */
interface IQueue<T> {

    /**
     * 入队函数
     *
     * @param item 参数需要入队的元素
     */
    fun queue(item: T)

    /**
     * 出队函数
     *
     * @return 返回出队元素
     */
    fun dequeue(): T?

}
