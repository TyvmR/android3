package com.zhijieketang

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment

/**
 * 比赛项目Detail碎片
 */
// 保存选中列表项位置到Bundle，所需要的键
const val EVENTS_POSITION = "position"

class EventsDetailFragment : Fragment() {
    // 选中列表项位置
    var mCurrentPosition = -1
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        if (savedInstanceState != null) {
            // 恢复之前保存的选中列表项位置
            mCurrentPosition = savedInstanceState.getInt(EVENTS_POSITION)
        }
        // 从布局文件中创建视图
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onStart() {
        super.onStart()
        // 获得碎片中的参数
        val args: Bundle? = arguments
        if (args != null) {
            // 通过选中列表项位置，设置详细视图
            updateDetailView(args.getInt(EVENTS_POSITION))
        } else if (mCurrentPosition != -1) {
            // 在onCreateView调用期间，设置详细视图
            updateDetailView(mCurrentPosition)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        // 保存选中项目的位置，以备在碎片重新创建时使用
        outState.putInt(EVENTS_POSITION, mCurrentPosition)
    }

    /**
     * 设置详细视图
     */
    fun updateDetailView(position: Int) {

        // 获取选中的比赛项目
        val dao = EventsDAO()
        // 获取选中的比赛项目
        val events = dao.list[position]

        // 获取当前碎片所在的活动
        val activity = this.activity
        // 获取选中的比赛项目

        // 获得碎片中的ImageView对象
        val imageView = activity?.findViewById<ImageView>(R.id.imageView_detail)
        val id = getLogoResId(events.logo)
        if (id != null) {
            imageView?.setImageResource(id)
        }

        //  获得碎片中的TextView对象
        val textView = activity?.findViewById<TextView>(R.id.textView_detail)
        textView?.text = events.description
        mCurrentPosition = position

    }

    // 通过logo资源文件名获得资源id
    private fun getLogoResId(logo: String): Int? {
        // 获得活动的包名
        val packageName: String? = this.activity?.packageName

        // 截取掉文件后缀名
        val pos = logo.indexOf(".")
        val logoFile = logo.substring(0, pos)

        // 资源文件名获得资源id
        return this.activity?.resources?.getIdentifier(logoFile, "mipmap", packageName)
    }
}
