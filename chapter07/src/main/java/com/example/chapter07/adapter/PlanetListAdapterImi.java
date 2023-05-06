package com.example.chapter07.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.chapter07.R;
import com.example.chapter07.bean.Planet;

import java.util.List;

public class PlanetListAdapterImi extends BaseAdapter implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {


    private Context mContext;

    private List<Planet> mPlanetList;


    public PlanetListAdapterImi(Context context, List<Planet> planetList){
        this.mContext = context;
        this.mPlanetList = planetList;
    }


    @Override
    public int getCount() {
        return mPlanetList.size();
    }

    @Override
    public Object getItem(int position) {
        return mPlanetList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView = LayoutInflater.from(mContext).inflate(R.layout.item_list,null);
        ImageView ig = convertView.findViewById(R.id.iv_icon);
        TextView tx_name = convertView.findViewById(R.id.tv_name);
        TextView tx_desc = convertView.findViewById(R.id.tv_desc);
        Planet planet = mPlanetList.get(position);
        ig.setImageResource(planet.image);
        tx_name.setText(planet.name);
        tx_desc.setText(planet.desc);
        return convertView;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String desc = String.format("您点击了第%d个行星，它的名字是%s", position + 1,
                mPlanetList.get(position).name);
        Toast.makeText(mContext, desc, Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        String desc = String.format("您长按了第%d个行星，它的名字是%s", position + 1,
                mPlanetList.get(position).name);
        Toast.makeText(mContext, desc, Toast.LENGTH_LONG).show();
        return true;
    }

    public final class ViewHolder {
        public ImageView iv_icon; // 声明行星图片的图像视图对象
        public TextView tv_name; // 声明行星名称的文本视图对象
        public TextView tv_desc; // 声明行星描述的文本视图对象
    }
}
