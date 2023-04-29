/*
* Created by 画画的程序员
* 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
* 邮箱：eorient@sina.com
*/

//代码文件：Person.kt

class Person(val name: String, val age: Int) {
    //自定义比较规则
    override fun equals(other: Any?): Boolean {
        if (other == null || other !is Person) {
            return false
        }
        return (name == other.name && age == other.age)
    }
}