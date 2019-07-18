package com.developer.lab3_andoridnwk;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Result extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        TextView textView=findViewById(R.id.tx);
        if (getIntent().getStringExtra("kq")!=null && !getIntent().getStringExtra("kq").equals("")){
            textView.setText(getIntent().getStringExtra("kq"));
        }

    }
}
