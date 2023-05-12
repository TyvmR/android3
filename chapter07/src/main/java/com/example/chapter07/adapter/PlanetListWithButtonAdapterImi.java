package com.example.chapter07.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.chapter07.R;
import com.example.chapter07.bean.Planet;

import java.util.List;

public class PlanetListWithButtonAdapterImi extends BaseAdapter implements
        AdapterView.OnItemClickListener,AdapterView.OnItemLongClickListener {
    private List<Planet> planets;

    private Context context;

    private int focusMethod;

    public PlanetListWithButtonAdapterImi(List<Planet> planets, Context context, int focusMethod) {
        this.planets = planets;
        this.context = context;
        this.focusMethod = focusMethod;
    }

    @Override
    public int getCount() {
        return planets.size();
    }

    @Override
    public Object getItem(int position) {
        return planets.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if(convertView == null){
            holder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate( R.layout.item_list_with_button,null);
            holder.ll_item = convertView.findViewById(R.id.ll_item);
            holder.iv_icon = convertView.findViewById(R.id.iv_icon);
            holder.tv_name = convertView.findViewById(R.id.tv_name);
            holder.tv_desc = convertView.findViewById(R.id.tv_desc);
            holder.btn_oper = convertView.findViewById(R.id.btn_oper);
            convertView.setTag(holder); // 将视图持有者保存到转换视图当中
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        Planet planet = planets.get(position);
        holder.ll_item.setDescendantFocusability(focusMethod);
        holder.iv_icon.setImageResource(planet.image);
        holder.tv_name.setText(planet.name);
        holder.tv_desc.setText(planet.desc);
        holder.btn_oper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "您点击了"+planet.name, Toast.LENGTH_LONG).show();

            }
        });

        return convertView;
    }


    public final class ViewHolder {
        private LinearLayout ll_item; // 声明行星项的线性布局
        public ImageView iv_icon; // 声明行星图片的图像视图对象
        public TextView tv_name; // 声明行星名称的文本视图对象
        public TextView tv_desc; // 声明行星描述的文本视图对象
        public Button btn_oper; // 声明操作动作的按钮对象
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String desc = String.format("您点击了第%d个行星，它的名字是%s", position + 1,
                planets.get(position).name);
        Toast.makeText(context, desc, Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        String desc = String.format("您长按了第%d个行星，它的名字是%s", position + 1,
                planets.get(position).name);
        Toast.makeText(context, desc, Toast.LENGTH_LONG).show();

        return true;
    }
}
