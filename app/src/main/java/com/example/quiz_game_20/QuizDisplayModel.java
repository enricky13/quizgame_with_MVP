package com.example.quiz_game_20;

import android.util.Log;

import com.example.quiz_game_20.Network.Data.QuizResponse;
import com.example.quiz_game_20.Network.QuizApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class QuizDisplayModel implements QuizDisplayContract.Model{

    private QuizDisplayContract.Presenter presenter;

    @Override
    public void setPresenter(QuizDisplayContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void fetchData() {
        RetrofitSingleton.getInstance()
                .create(QuizApi.class)
                .getQuestionList(10,9, "easy", "multiple")
                .enqueue(new Callback<QuizResponse>() {
                    @Override
                    public void onResponse(Call<QuizResponse> call, Response<QuizResponse> response) {
                        assert response.body() != null;
                        Log.d("FINDME", response.body().getResults().get(0).getQuestion());
                        presenter.dataFetched(response.body().getResults());
                    }

                    @Override
                    public void onFailure(Call<QuizResponse> call, Throwable t) {
                        Log.d("FINDME", t.getMessage());
                    }
                });
    }

    @Override
    public void onDestroy() {
        presenter = null;
    }
}
