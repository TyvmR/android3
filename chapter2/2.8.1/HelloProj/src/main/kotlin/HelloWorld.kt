/*
* Created by 画画的程序员
* 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
* 邮箱：eorient@sina.com
*
*/

//代码文件：HelloProj/src/main/kotlin/HelloWorld.kt

//定义计算长方形面积函数
//函数类型(Double, Double) -> Double
fun rectangleArea(width: Double, height: Double): Double {
    return width * height
}

//定义计算三角形面积函数
//函数类型(Double, Double) -> Double
fun triangleArea(bottom: Double, height: Double) = 0.5 * bottom * height

fun main() {
    // 声明变量f1 它是(Double, Double) -> Double函数类型
    var f1: (Double, Double) -> Double

    f1 = ::triangleArea  // 给变量f1赋值，它可以接收函数引用（::rectangleArea）
    //调用函数f1
    println("计算三角形的面积：${f1(50.0, 40.0)}")
    f1 = ::rectangleArea  //重新给变量f1赋值
    //调用函数f1
    println("计算矩形的面积：${f1(50.0, 40.0)}")

}
