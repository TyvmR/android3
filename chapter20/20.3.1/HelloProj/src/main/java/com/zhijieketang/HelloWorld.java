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
        User user = new User("Tom", "12345");
        System.out.println(user.getName()); //Tom
        user.setPassword("54321");
        System.out.println(user.getPassword());//54321
    }
}
