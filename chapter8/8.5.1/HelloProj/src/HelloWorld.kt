/*
* Created by 画画的程序员
* 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
* 邮箱：eorient@sina.com
*
*/

fun main() {

    for (x in 0..5) {   //声明闭区间包含0和5
        print("$x,")
    }
    println()

    for (x in 0 until 5) {  //声明半开区间包含0，不包含5
        print("$x,")
    }
    println()
    for (x in 'A'..'E') {  //声明闭区间包含'A'和'E'
        print("$x,")
    }
    println()

    for (x in 'A' until 'E') { //声明半开区间包含'A'，不包含'E'
        print("$x,")
    }
}