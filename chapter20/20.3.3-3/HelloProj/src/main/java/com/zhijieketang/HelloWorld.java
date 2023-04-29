/*
 * Created by 画画的程序员
 * 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
 * 邮箱：eorient@sina.com
 *
 */

//Java代码文件：HelloProj/src/main/java/com/zhijieketang/HelloWorld.java
package com.zhijieketang;

import java.util.Date;

public class HelloWorld {
    public static void main(String[] args) {
        Person p = new Person();
        //访问实例字段
        System.out.println(p.name);       //Tony
        System.out.println(p.birthDate);  //null
        //访问静态字段
        System.out.println(Singleton.x); //10
        Singleton.birthDate = new Date();
        System.out.println(Account.interestRate); //0.018
        System.out.println(StaticFieldDemo.MAX_COUNT); //500
        //访问静态函数
        Singleton.displayX();
        Account.interestBy(5000);
    }
}
