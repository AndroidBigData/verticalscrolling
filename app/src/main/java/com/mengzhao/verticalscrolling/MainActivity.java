package com.mengzhao.verticalscrolling;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.mengzhao.verticalscrolling.upViewFlipper.UPMarqueeView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private UPMarqueeView upview;
    private List<String> data ;
    private List<View> views = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initParam();
        initData();
        initView();
    }

    private void initView() {
        setView();
        upview.setViews(views);
        upview.setOnItemClickListener(new UPMarqueeView.OnItemClickListener() {
            @Override
            public void onItemClick(int positon, View view) {
                Toast.makeText(getBaseContext(),"点击了" + positon + "个item",Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setView() {
        for (int i = 0;i<data.size();i = i + 2){
            final int position = i;
            //设置滚动布局
            LinearLayout moreView = (LinearLayout) LayoutInflater.from(getBaseContext()).inflate(R.layout.item_view,null);
            TextView tv1 = (TextView) moreView.findViewById(R.id.tv1);
            TextView tv2 = (TextView) moreView.findViewById(R.id.tv2);
            //对控件赋值
            tv1.setText(data.get(i).toString());
            if (data.size() > i + 1){
                //数据为奇数时，只显示一个
                tv2.setText(data.get(i + 1).toString());
            }else{
                moreView.findViewById(R.id.rl2).setVisibility(View.GONE);
            }
//            /**
//             * 设置监听
//             */
//            tv1.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Toast.makeText(getBaseContext(),position + "点击了" +data.get(position).toString(),Toast.LENGTH_SHORT).show();
//                }
//            });
//            tv2.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Toast.makeText(getBaseContext(),position + "点击了" +data.get(position).toString(),Toast.LENGTH_SHORT).show();
//                }
//            });
            views.add(moreView);
        }
    }

    private void initData() {
        data = new ArrayList<>();
        data.add("好消息，好消息，江南最大皮革城倒闭了！");
        data.add("黄鹤欠下5个亿，领着他的小姨子跑啦！");
        data.add("我们没有办法，只能打开仓门处理皮包！");
        data.add("原来都是100多，200多的钱包，皮包");
        data.add("现在统统10块啦，统统10快啦！");
        data.add("黄鹤你不是人，你还我们血汗钱！");
        data.add("黄鹤：一群渣渣，还想动老子~");
    }

    /**
     * 实例化控件
     */
    private void initParam() {
        upview = (UPMarqueeView) findViewById(R.id.up_view);
    }
}
