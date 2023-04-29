/*
* Created by 画画的程序员
* 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
* 邮箱：eorient@sina.com
*
*/
//代码文件：PetStore/src/main/kotlin/com/zhijieketang/ui/CartTableModel.kt
package com.zhijieketang.ui

import java.math.BigDecimal
import javax.swing.table.AbstractTableModel


//购物车表格模型
class CartTableModel(private val data: Array<Array<Any?>>?) : AbstractTableModel() {// 表格中数据保存在data二维数组中

    // 表格列名columnNames
    private val columnNames = arrayOf("商品编号", "商品名", "商品单价", "数量", "商品应付金额")

    // 返回列数
    override fun getColumnCount() = columnNames.size

    // 返回行数
    override fun getRowCount() = data!!.size

    // 获得某行某列的数据，而数据保存在对象数组data中
    override fun getValueAt(rowIndex: Int, columnIndex: Int)= data!![rowIndex][columnIndex]

    override fun getColumnName(columnIndex: Int)=columnNames[columnIndex]

    override fun isCellEditable(rowIndex: Int, columnIndex: Int) = columnIndex == 3

    override fun setValueAt(aValue: Any?, rowIndex: Int, columnIndex: Int) {
        // 只允许修改数量列
        if (columnIndex != 3) {
            return
        }
        try {
            // 从表中获得修改之后的商品数量，从表而来的数据都String类型
            val quantity = (aValue as String).toInt()
            // 商品数量不能小于0
            if (quantity < 0) {
                return
            }
            // 更新数量列
            data!![rowIndex][3] = quantity
            // 计算商品应付金额
            val unitcost = data[rowIndex][2] as BigDecimal
            val totalPrice = unitcost * BigDecimal(quantity)
            // 更新商品应付金额列
            data[rowIndex][4] = totalPrice
        } catch (e: Exception) {
        }
    }
}

