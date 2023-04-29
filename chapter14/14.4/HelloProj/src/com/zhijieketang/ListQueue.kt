/*
* Created by 画画的程序员
* 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
* 邮箱：eorient@sina.com
*
*/
//代码文件：com/zhijieketang/ListQueue.kt
package com.zhijieketang

import java.util.ArrayList

/**
 * 自定义的泛型队列集合
 */
class ListQueue<T> : IQueue<T> {

    // 声明保存队列元素集合items
    private val items: MutableList<T>

    // init代码块初始化是集合items
    init {
        this.items = ArrayList()
    }

    /**
     * 入队函数
     *
     * @param item
     * 参数需要入队的元素
     */
    override fun queue(item: T) {
        this.items.add(item)
    }

    /**
     * 出队函数
     *
     * @return 返回出队元素
     */
    override fun dequeue(): T? {
        return if (items.isEmpty()) {
            null
        } else {
            this.items.removeAt(0)
        }
    }

    override fun toString(): String {
        return items.toString()
    }

}
