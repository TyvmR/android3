/*
* Created by 画画的程序员
* 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
* 邮箱：eorient@sina.com
*
*/

//代码文件：PetStore/src/main/kotlin/com/zhijieketang/domain/Product.kt
package com.zhijieketang.domain

import java.math.BigDecimal

data class Product(
        var productid: String? = null,// 商品Id
        var category: String? = null,// 商品类别
        var cname: String? = null,// 商品中文名
        var ename: String? = null,// 商品英文名
        var image: String? = null,// 商品描述
        var descn: String? = null,// 商品描述
        var listprice:BigDecimal = BigDecimal(0),// 商品市场价
        var unitcost: BigDecimal =  BigDecimal(0)// 商品单价
)