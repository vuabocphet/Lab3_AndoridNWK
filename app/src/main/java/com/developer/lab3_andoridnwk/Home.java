package com.developer.lab3_andoridnwk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.developer.lab3_andoridnwk.retrofit.DataClient;

public class Home extends AppCompatActivity {
      private DataClient dataClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sprot(View view) {
       stATVT("sport");
    }

    public void maths(View view) {
        stATVT("math");

    }



    private void stATVT(String q)
    {
        Intent intent=new Intent(this,QuizActivity.class);
        intent.putExtra("quiz",q);
        startActivity(intent);
    }


}
