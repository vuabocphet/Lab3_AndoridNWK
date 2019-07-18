package com.developer.lab3_andoridnwk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.developer.lab3_andoridnwk.retrofit.APIClient;
import com.developer.lab3_andoridnwk.retrofit.DataClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class QuizActivity extends AppCompatActivity {
    private DataClient dataClient;
    private RadioGroup radioGroup;
    private TextView ask;
    private RadioButton da1;
    private RadioButton da2;
    private RadioButton da3;
    private RadioButton da4;
    private Maths math;
    private Sport sport;
    private String answerSport = "", answerMath = "";
    private String quiz = "";
    int i=0,ii=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sport);
        radioGroup = findViewById(R.id.rdgroud);
        ask = (TextView) findViewById(R.id.ask);
        da1 = (RadioButton) findViewById(R.id.da1);
        da2 = (RadioButton) findViewById(R.id.da2);
        da3 = (RadioButton) findViewById(R.id.da3);
        da4 = (RadioButton) findViewById(R.id.da4);
        quiz = getIntent().getStringExtra("quiz");
        math = new Maths();
        sport = new Sport();

        dataClient = APIClient.getData();
        dataClient.getDataAll().enqueue(new Callback<QuizModel>() {
            @Override
            public void onResponse(Call<QuizModel> call, Response<QuizModel> response) {
                if (!response.isSuccessful()) {
                    {
                        Toast.makeText(QuizActivity.this, "Code" + response.code(), Toast.LENGTH_SHORT).show();
                        return;
                    }
                }
                Log.e("DATA", response.body().getQuiz().getMaths() + "");
                if (quiz.equals("math")) {

                    math = response.body().getQuiz().getMaths();
                    ask.setText("Câu hỏi 1:" + response.body().getQuiz().getMaths().getQ1().getQuestion());
                    da1.setText(response.body().getQuiz().getMaths().getQ1().getOptions().get(0));
                    da2.setText(response.body().getQuiz().getMaths().getQ1().getOptions().get(1));
                    da3.setText(response.body().getQuiz().getMaths().getQ1().getOptions().get(2));
                    da4.setText(response.body().getQuiz().getMaths().getQ1().getOptions().get(3));

                } else {

                    sport = response.body().getQuiz().getSport();
                    ask.setText("Câu hỏi :" + response.body().getQuiz().getSport().getQ1().getQuestion());
                    da1.setText(response.body().getQuiz().getSport().getQ1().getOptions().get(0));
                    da2.setText(response.body().getQuiz().getSport().getQ1().getOptions().get(1));
                    da3.setText(response.body().getQuiz().getSport().getQ1().getOptions().get(2));
                    da4.setText(response.body().getQuiz().getSport().getQ1().getOptions().get(3));
                }
            }

            @Override
            public void onFailure(Call<QuizModel> call, Throwable t) {
                Toast.makeText(QuizActivity.this, "Err" + t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.e("ERR", t.getMessage());
            }
        });


    }

    public void check(View view) {

        int radioID = radioGroup.getCheckedRadioButtonId();
        RadioButton radioButton = findViewById(radioID);
        final String chondapan = radioButton.getText().toString().trim();
        findViewById(R.id.appy).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (quiz.equals("math")) {


                       if (ii==0){
                           ii++;
                           if (chondapan.equals(math.getQ1().getAnswer())) {
                               i++;
                           }
                           da1.setChecked(false);
                           da2.setChecked(false);
                           da3.setChecked(false);
                           da4.setChecked(false);
                           ask.setText("Câu hỏi 2:" + math.getQ2().getQuestion());
                           da1.setText(math.getQ2().getOptions().get(0));
                           da2.setText(math.getQ2().getOptions().get(1));
                           da3.setText(math.getQ2().getOptions().get(2));
                           da4.setText(math.getQ2().getOptions().get(3));
                       }else {
                           if (chondapan.equals(math.getQ2().getAnswer())) {
                               i++;
                           }

                           Intent intent=new Intent(QuizActivity.this,Result.class);
                           intent.putExtra("kq","Bạn đã làm đúng:"+i+"/2");
                           startActivity(intent);
                           finish();
                       }





                } else {
                    if (chondapan.equals(sport.getQ1().getAnswer())) {
                        i++;
                    }
                    Intent intent=new Intent(QuizActivity.this,Result.class);
                    intent.putExtra("kq","Bạn đã làm đúng:"+i+"/1");
                    startActivity(intent);
                    finish();
                }
            }
        });

    }


}
