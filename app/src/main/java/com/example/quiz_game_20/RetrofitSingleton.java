package com.example.quiz_game_20;

import com.example.quiz_game_20.Network.QuizApi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitSingleton {
    private static Retrofit retrofitInstance;
    private static final String BASE_URL = "https://opentdb.com/";

    private RetrofitSingleton(){}

    public static Retrofit getInstance(){
        if(retrofitInstance == null){
            retrofitInstance = new Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(BASE_URL)
                    .build();
        }
        return retrofitInstance;
    }
}
