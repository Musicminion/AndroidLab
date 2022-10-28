package com.example.androidlab;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private LinearLayout linearLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // 基本操作
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 初始化页面布局
        linearLayoutInit();

        // 绑定监听器
        textViewListenerInit();
    }

    // 初始化页面布局 动态生成十个TextView
    private void linearLayoutInit(){
        linearLayout = (LinearLayout) super.findViewById(R.id.mainPageLinearLayout);
        for (int i = 0; i < 10; i++){
            TextView textView = createTextView("Lab" + (i + 1));
            linearLayout.addView(textView);
        }
    }

    // 绑定监听器
    private void textViewListenerInit(){
        for (int i = 0; i < 10; i++){
            if(i >= 2){
                linearLayout.getChildAt(i).setOnClickListener(view -> {
                    Snackbar.make(view, "这个Lab还没布置呐！慌啥！😊", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                });
                continue;
            }
            String action_Str = "VIEW_Lab" + String.valueOf(i + 1);
            linearLayout.getChildAt(i).setOnClickListener(view -> {
                Intent intent = new Intent(action_Str);
                startActivity(intent);
            });


        }


    }


    // 获取首页的一个指定样式的 LabX TextView
    private TextView createTextView(String title){
        TextView textView = new TextView(this);
        textView.setText(title);
        textView.setHeight(150);
        textView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        textView.setGravity(Gravity.CENTER);
        textView.setBackgroundResource(R.drawable.textview_background_rounded_border);
        textView.setTextSize(32);

        // 通过LayoutParams配置Margin参数
        LinearLayout.LayoutParams layoutParams =
                new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);
        layoutParams.setMargins(10,10,10,10);
        textView.setLayoutParams(layoutParams);
        return textView;
    }
}