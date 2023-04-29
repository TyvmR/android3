/*
* Created by 画画的程序员
* 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
* 邮箱：eorient@sina.com
*
*/
//代码文件：PetStore/src/main/kotlin/com/zhijieketang/ui/ProductTableModel.kt
package com.zhijieketang.ui

import com.zhijieketang.domain.Product
import javax.swing.table.AbstractTableModel

//商品列表表格模型
class ProductTableModel(val data: List<Product>) : AbstractTableModel() {

    // 表格列名columnNames
    private val columnNames = arrayOf("商品编号", "商品类别", "商品中文名", "商品英文名")

    // 返回列数
    override fun getColumnCount() = columnNames.size

    // 返回行数
    override fun getRowCount() = data.size

    // 获得某行某列的数据，而数据保存在对象数组data中
    override fun getValueAt(rowIndex: Int, columnIndex: Int): Any? {

        // 每一行就是一个Product商品对象
        val (productid, category, cname, ename) = data[rowIndex]

        return when (columnIndex) {
            0 -> productid // 第一列商品编号
            1 -> category // 第二列商品类别
            2 -> cname // 第三列商品中文名
            else -> ename // 第四列商品英文名
        }
    }

    override fun getColumnName(columnIndex: Int) = columnNames[columnIndex]
}
