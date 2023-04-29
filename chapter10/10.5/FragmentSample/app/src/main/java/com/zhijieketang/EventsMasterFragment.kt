package com.zhijieketang

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.ListFragment


/**
 * 比赛项目Master碎片
 */
class EventsMasterFragment : ListFragment() {
    // 实现OnTitleSelectedListener接口的回调对象
    var mCallback: OnTitleSelectedListener? = null

    // 当前碎片所在的活动必须实现该接口，碎片通过该接口可以回调所在活动
    interface OnTitleSelectedListener {
        //单击列表项选择时候调用
        fun onEventsSelected(position: Int)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        //context参数事实上是MainActivity对象
        mCallback = context as OnTitleSelectedListener
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val dao = EventsDAO()

        //返回所有项目名称String集合
        val titles = dao.list.map { it.name }

        listAdapter = activity?.let {
            ArrayAdapter(
                it,
                android.R.layout.simple_list_item_activated_1, titles
            )
        }
    }

    override fun onListItemClick(l: ListView, v: View, position: Int, id: Long) {
        //回调活动，通过活动选中的列表项位置
        mCallback?.onEventsSelected(position)
    }
}
