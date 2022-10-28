package com.example.androidlab.lab2;


import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.androidlab.R;


public class Lab2EditActivity  extends AppCompatActivity {

    private int fromIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab2_editview);

        TextView textView = (TextView) super.findViewById(R.id.Lab2_editView_source);
        EditText editText = (EditText) super.findViewById(R.id.Lab2_editView_editText);
        Button button = (Button) super.findViewById(R.id.Lab2_editView_button);

        // 解析参数，从Intent传入的参数分析 获取来源信息
        this.setFromIndex(Integer.parseInt(getIntent().getStringExtra("textViewIndex")));
        String sourceText = "[来源ID检测]" + getFromIndex();
        textView.setText(sourceText);

        // 编辑框获得聚焦点时候，清空内容
        editText.setOnFocusChangeListener(((view, b) -> {
            if(b){
                ((EditText)view).setText("");
            }
        }));

        // 绑定按钮监听器
        button.setOnClickListener(view -> {
            Intent intent = new Intent();
            intent.putExtra("index", String.valueOf(fromIndex));
            intent.putExtra("newInfo", String.valueOf(editText.getText()));
            setResult(RESULT_OK, intent);
            finish();
            overridePendingTransition(0, 0);
        });

    }

    public void setFromIndex(int formIndex) {
        this.fromIndex = formIndex;
    }

    public int getFromIndex() {
        return fromIndex;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        overridePendingTransition(0, 0);
    }
}
