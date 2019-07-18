package com.developer.lab3_andoridnwk.retrofit;

public class APIClient {
    private static String URL="http://dotplays.com";
    public static DataClient getData(){
        return RetrofitClient.getData(URL).create(DataClient.class);
    }
}
