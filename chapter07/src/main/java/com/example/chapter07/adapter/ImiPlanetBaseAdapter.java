package com.example.chapter07.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.chapter07.R;
import com.example.chapter07.bean.Planet;

import java.util.List;
import java.util.zip.Inflater;

public class ImiPlanetBaseAdapter extends BaseAdapter {
    private Context mContext; // 声明一个上下文对象
    private List<Planet> mPlanetList; // 声明一个行星信息列表

    // 行星适配器的构造方法，传入上下文与行星列表
    public ImiPlanetBaseAdapter(Context context, List<Planet> planet_list) {
        mContext = context;
        mPlanetList = planet_list;
    }

    // 获取列表项的个数
    public int getCount() {
        return mPlanetList.size();
    }

    // 获取列表项的数据
    public Object getItem(int arg0) {
        return mPlanetList.get(arg0);
    }

    // 获取列表项的编号
    public long getItemId(int arg0) {
        return arg0;
    }

    // 获取指定位置的列表项视图
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if( convertView == null){
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_list,null);
            viewHolder.iv_icon = convertView.findViewById(R.id.iv_icon);
            viewHolder.tv_name = convertView.findViewById(R.id.tv_name);
            viewHolder.tv_desc = convertView.findViewById(R.id.tv_desc);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ImiPlanetBaseAdapter.ViewHolder) convertView.getTag();

        }
        Planet planet = mPlanetList.get(position);
        viewHolder.iv_icon.setImageResource(planet.image); // 显示行星的图片
        viewHolder.tv_name.setText(planet.name); // 显示行星的名称
        viewHolder.tv_desc.setText(planet.desc); // 显示行星的描述
        viewHolder.iv_icon.requestFocus();
        return convertView;
    }

    // 定义一个视图持有者，以便重用列表项的视图资源
    public final class ViewHolder {
        public ImageView iv_icon; // 声明行星图片的图像视图对象
        public TextView tv_name; // 声明行星名称的文本视图对象
        public TextView tv_desc; // 声明行星描述的文本视图对象
    }
}
