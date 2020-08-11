package com.example.quiz_game_20;

import com.example.quiz_game_20.Network.Data.Result;

import java.util.List;

public class QuizDisplayPresenter implements QuizDisplayContract.Presenter{

    private QuizDisplayContract.Model model;
    private QuizRecyclerAdapter adapter;
    private MainActivity view;

    public QuizDisplayPresenter (QuizDisplayContract.Model model){this.model = model;}

    @Override
    public void onViewCreated(MainActivity view) {
        this.view = view;
        model.setPresenter(this);
        model.fetchData();
    }

    @Override
    public void dataFetched(List<Result> results) {
        adapter = new QuizRecyclerAdapter(results, this);
        view.setRecyclerView(results, adapter);
    }

    @Override
    public void onDestroy() {
        view = null;
        model.onDestroy();
    }
}
