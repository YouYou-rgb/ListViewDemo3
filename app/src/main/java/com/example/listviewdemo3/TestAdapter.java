package com.example.listviewdemo3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * 敲黑板，划重点
 */
public class TestAdapter extends BaseAdapter {
    private final int resourceId;//页面布局
    private Context mContext;//上下文
    private List<Fruit> data;//数据源

    public TestAdapter(Context context, int resourceId, List<Fruit> data) {
        this.mContext = context;
        this.resourceId = resourceId;
        this.data = data;
    }

    //数据源的长度，也就是ListView要显示多少条数据，我们就传入多长的数据源就可以了
    @Override
    public int getCount() {
        return data.size();
    }

    //获取每一条数据的位置
    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    //获取每一项的id
    @Override
    public long getItemId(int position) {
        return position;
    }

    //显示出数据源中的每一条数据
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(mContext).inflate(resourceId, null);
        ImageView image = view.findViewById(R.id.image);
        TextView name = view.findViewById(R.id.name);
        image.setImageResource((Integer) data.get(position).getPic());
        name.setText(data.get(position).getName());
        return view;
    }
}
