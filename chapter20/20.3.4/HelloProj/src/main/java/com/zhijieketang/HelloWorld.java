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
        Employee emp = new Employee();
        //访问Kotlin中内部可见性的Employee成员属性no
        int no = emp.getNo$HelloProj();

        Department dept = new Department();
        //访问Kotlin中公有可见性的Department成员属性name
        dept.setName("市场部");

        //访问Kotlin中公有可见性的Employee中成员属性dept
        emp.setDept(dept);
        System.out.println(emp.getDept());

        //访问Kotlin中内部可见性的顶层属性MAX_COUNT
        System.out.println(EmployeeKt.MAX_COUNT);
    }
}

class SubDepartment extends Department {
    void display() {
        //继承Kotlin中Department类保护可见性的成员属性no
        System.out.println(this.getNo());
        //继承Kotlin中Department类公有可见性的成员属性name
        System.out.println(this.getName());
    }
}