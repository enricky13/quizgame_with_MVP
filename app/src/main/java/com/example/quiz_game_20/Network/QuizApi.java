package com.example.quiz_game_20.Network;

import com.example.quiz_game_20.Network.Data.QuizResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface QuizApi {
    @GET("api.php")
    Call<QuizResponse> getQuestionList(
            @Query("amount") int amount,
            @Query("category") int category,
            @Query("difficulty") String difficulty,
            @Query("type") String type
    );
}
