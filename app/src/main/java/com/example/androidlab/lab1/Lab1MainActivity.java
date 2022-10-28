package com.example.androidlab.lab1;
import android.os.Bundle;
import android.widget.Button;
import com.example.androidlab.R;
import androidx.appcompat.app.AppCompatActivity;

public class Lab1MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // 基本操作
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab1_main);

        // Lab1返回的按钮 绑定监听
        Button helloButton = findViewById(R.id.Lab1_mainView_button);
        helloButton.setOnClickListener(view -> finish());
    }
}