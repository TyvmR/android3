/*
 * Created by 画画的程序员
 * 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
 * 邮箱：eorient@sina.com
 *
 */

//Java代码文件：HelloProj/src/main/java/com/zhijieketang/HelloWorld.java
package com.zhijieketang;

public class HelloWorld {
    public static void main(String[] args) {

        Animal animal1 = new Animal(10, true);
        Animal animal2 = new Animal(10);

        DisplayOverloading dis1 = new DisplayOverloading();
        dis1.display('A');
        dis1.display('B', 20);

        AnimalKt.makeCoffee();
        AnimalKt.makeCoffee("摩卡咖啡");
    }
}
