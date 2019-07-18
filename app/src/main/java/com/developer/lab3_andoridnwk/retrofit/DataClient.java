package com.developer.lab3_andoridnwk.retrofit;


import com.developer.lab3_andoridnwk.QuizModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface DataClient {



    @GET("/android/lab3.json")
    Call<QuizModel> getDataAll();
}
