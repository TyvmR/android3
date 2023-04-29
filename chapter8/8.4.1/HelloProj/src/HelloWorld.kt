/*
* Created by 画画的程序员
* 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
* 邮箱：eorient@sina.com
*
*/

fun main() {

    val numbers = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

    for (i in numbers.indices) {
        if (i == 3) {
            break// 跳出循环
        }
        println("Count is: ${numbers[i]}")
    }

    label1@ for (x in 0..4) {
        for (y in 5 downTo 1) {
            if (y == x) {
                break@label1// 跳转到label1指向的外循环
            }
            println("($x,$y)")
        }
    }
    println("Game Over!")

}