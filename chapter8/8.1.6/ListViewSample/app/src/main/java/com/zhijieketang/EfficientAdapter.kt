package com.zhijieketang

import android.content.Context
import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class EfficientAdapter(
    context: Context, resource: Int,
    dataSource: Array<String>, icons: IntArray
) : BaseAdapter() {

    //数据源数组属性
    private val mDataSource = dataSource

    //与数据源数组对应的图标id属性
    private val mIcons = icons

    //列表项布局文件属性
    private val mResource = resource

    //所在上下文属性
    private val mContext = context

    //布局填充器属性
    private val mInflater: LayoutInflater
        get() {
            //通过上下文对象创建布局填充器
            return LayoutInflater.from(mContext)
        }


    // 返回总数据源中总的记录数
    override fun getCount(): Int {
        return mDataSource.size
    }

    //根据选择列表项位置，返回列表项所需数据
    override fun getItem(position: Int): Any {
        return mDataSource[position]
    }

    //根据选择列表项位置，返回列表项id
    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    //返回列表项所在视图对象
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {
        var convertView = convertView
        val holder: ViewHolder
        if (convertView == null) {
            convertView = mInflater.inflate(mResource, null)

            //列表项中TextView
            val textView = convertView.findViewById<TextView>(R.id.textview)
            //列表项中ImageView
            val imageView = convertView.findViewById<ImageView>(R.id.icon)

            holder = ViewHolder(textView, imageView)
            convertView.tag = holder
        } else {
            holder = convertView.tag as ViewHolder
        }
        holder.textView.text = mDataSource[position]
        val icon = BitmapFactory.decodeResource(mContext.resources, mIcons[position])
        holder.imageView.setImageBitmap(icon)
        return convertView
    }

    //保存列表项中控件的封装类
    data class ViewHolder(
        val textView: TextView,  //列表项中TextView
        val imageView: ImageView //列表项中ImageView
    )
}