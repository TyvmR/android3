/*
* Created by 画画的程序员
* 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
* 邮箱：eorient@sina.com
*
*/
//代码文件：com/zhijieketang/Rectangle.kt
package com.zhijieketang

/*class Rectangle constructor(w: Int, h: Int) {
    // 矩形宽度
    var width: Int
    // 矩形高度
    var height: Int
    // 矩形面积
    var area: Int

    init {//初始化代码块
        width = w
        height = h
        area = w * h// 计算矩形面积
    }
}*/

/*
class Rectangle constructor(var width: Int, var height: Int) {
    // 矩形面积
    var area: Int

    init {//初始化代码块
        area = width * height// 计算矩形面积
    }
}*/

class Rectangle(var width: Int, var height: Int) {
    // 矩形面积
    var area: Int

    init {//初始化代码块
        area = width * height// 计算矩形面积
    }

    constructor(width: Int, height: Int, area: Int) : this(width, height) {
        this.area = area
    }

    constructor(area: Int) : this(200, 100) {//width=200 height=100
        this.area = area
    }
}