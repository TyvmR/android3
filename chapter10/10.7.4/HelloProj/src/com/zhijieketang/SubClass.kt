/*
* Created by 画画的程序员
* 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
* 邮箱：eorient@sina.com
*
*/
//代码文件：com/zhijieketang/SubClass.kt
package com.zhijieketang

class SubClass : ProtectedClass() {

    fun display() {
        printX()//printX()函数是从父类继承过来
        println(x)//x属性是从父类继承过来
    }
}
