/*
 * Created by 画画的程序员
 * 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
 * 邮箱：eorient@sina.com
 *
 */

//Java代码文件：HelloProj/src/main/java/com/zhijieketang/Calculable.java

package com.zhijieketang;

//可计算接口
@FunctionalInterface
public interface Calculable {
    // 计算两个int数值
    int calculateInt(int a, int b);
}
