package com.example.listviewdemo3;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView lv = findViewById(R.id.lv);

        //构造数据
        final List<Fruit> fruits = new ArrayList();
        for (int i = 0; i < 10; i++) {
            fruits.add(new Fruit("菠萝", R.drawable.pineapple));
            fruits.add(new Fruit("葡萄", R.drawable.grape));
            fruits.add(new Fruit("樱桃", R.drawable.cherry));
            fruits.add(new Fruit("草莓", R.drawable.strawberry));
        }

        /**
         * 创建自己定义的适配器
         * parameter1：上下文
         * parameter2：ListView每一项的页面布局
         * parameter3：数据源
         */
        TestAdapter testAdapter = new TestAdapter(MainActivity.this, R.layout.item_layout, fruits);
        //关联数据
        lv.setAdapter(testAdapter);

        //添加点击事件监听
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,
                        "您选择了" + fruits.get(position).getName(),
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}

class Fruit {
    private String name;
    private Object pic;

    public Fruit(String name, Object pic) {
        this.name = name;
        this.pic = pic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getPic() {
        return pic;
    }

    public void setPic(Object pic) {
        this.pic = pic;
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "name='" + name + '\'' +
                ", pic=" + pic +
                '}';
    }
}