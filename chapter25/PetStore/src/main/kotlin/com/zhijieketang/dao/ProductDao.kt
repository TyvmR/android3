/*
* Created by 画画的程序员
* 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
* 邮箱：eorient@sina.com
*
*/
//代码文件：PetStore/src/main/kotlin/com/zhijieketang/dao/Product.kt
package com.zhijieketang.dao

import com.zhijieketang.domain.Product

//商品管理DAO
interface ProductDao {
    // 查询所有的商品信息
    fun findAll(): List<Product>

    // 根据主键查询商品信息
    fun findById(productid: String): Product?

    // 根据按照列表查询商品信息
    fun findByCategory(category: String): List<Product>

    // 创建商品信息
    fun create(product: Product)

    // 修改商品信息
    fun modify(product: Product)

    // 删除商品信息
    fun remove(product: Product)

}
