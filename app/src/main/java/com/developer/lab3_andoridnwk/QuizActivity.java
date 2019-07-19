package com.developer.lab3_andoridnwk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.developer.lab3_andoridnwk.retrofit.APIClient;
import com.developer.lab3_andoridnwk.retrofit.DataClient;

import java.util.ArrayList;
import java.util.List;

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
    private List<Math> math;
    private List<Sport> sport;
    private String answerSport = "", answerMath = "";
    private String quiz = "";
    int i=0,ii=0;

    Button button;
    private int radioID;


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
        math =new ArrayList<>();
        sport =new ArrayList<>();
        math.clear();
        sport.clear();
        button=findViewById(R.id.appy);
        button.setVisibility(View.GONE);

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
                    ask.setText("Câu hỏi 1:" + response.body().getQuiz().getMaths().get(0).getQuestion());
                    da1.setText(response.body().getQuiz().getMaths().get(0).getOptions().get(0));
                    da2.setText(response.body().getQuiz().getMaths().get(0).getOptions().get(1));
                    da3.setText(response.body().getQuiz().getMaths().get(0).getOptions().get(2));
                    da4.setText(response.body().getQuiz().getMaths().get(0).getOptions().get(3));

                } else {

                    sport = response.body().getQuiz().getSport();
                    ask.setText("Câu hỏi :" + response.body().getQuiz().getSport().get(0).getQuestion());
                    da1.setText(response.body().getQuiz().getSport().get(0).getOptions().get(0));
                    da2.setText(response.body().getQuiz().getSport().get(0).getOptions().get(1));
                    da3.setText(response.body().getQuiz().getSport().get(0).getOptions().get(2));
                    da4.setText(response.body().getQuiz().getSport().get(0).getOptions().get(3));
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
        if (ii == 0) {
            button.setVisibility(View.VISIBLE);
            button.setText("Tiếp tục");
        }
        radioID = radioGroup.getCheckedRadioButtonId();
        final RadioButton radioButton = findViewById(radioID);
        final String chondapan = radioButton.getText().toString().trim();
        findViewById(R.id.appy).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (quiz.equals("math")) {
                      if (ii==0){
                           ii++;
                           if (chondapan.equals(math.get(0).getAnswer())) {
                               i++;
                           }
                           radioButton.setChecked(false);
                           ask.setText("Câu hỏi 2:" + math.get(1).getQuestion());
                           da1.setText(math.get(1).getOptions().get(0));
                           da2.setText(math.get(1).getOptions().get(1));
                           da3.setText(math.get(1).getOptions().get(2));
                           da4.setText(math.get(1).getOptions().get(3));
                           button.setText("Kết thúc");

                      }else {
                           if (chondapan.equals(math.get(1).getAnswer())) {
                               i++;
                           }

                           Intent intent=new Intent(QuizActivity.this,Result.class);
                           intent.putExtra("kq","Bạn đã làm đúng:"+i+"/2");
                           startActivity(intent);
                           finish();
                       }





                } else {
                    if (ii==0){
                        ii++;
                        if (chondapan.equals(sport.get(0).getAnswer())) {
                            i++;
                        }
                        da1.setChecked(false);
                        da2.setChecked(false);
                        da3.setChecked(false);
                        da4.setChecked(false);
                        ask.setText("Câu hỏi 2:" + sport.get(1).getQuestion());
                        da1.setText(sport.get(1).getOptions().get(0));
                        da2.setText(sport.get(1).getOptions().get(1));
                        da3.setText(sport.get(1).getOptions().get(2));
                        da4.setText(sport.get(1).getOptions().get(3));
                        button.setText("Kết thúc");
                    }else {
                        if (chondapan.equals(sport.get(1).getAnswer())) {
                            i++;
                        }
                        Intent intent=new Intent(QuizActivity.this,Result.class);
                        intent.putExtra("kq","Bạn đã làm đúng:"+i+"/2");
                        startActivity(intent);
                        finish();
                    }

                }
            }
        });

    }


}
