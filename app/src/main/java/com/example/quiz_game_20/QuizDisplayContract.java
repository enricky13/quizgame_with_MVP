package com.example.quiz_game_20;

import com.example.quiz_game_20.Network.Data.Result;

import java.util.List;

public interface QuizDisplayContract {

    interface Presenter {
        void onViewCreated(MainActivity view);
        void dataFetched(List<Result> results);
        void onDestroy();
    }

    interface View {
        void setPresenter(QuizDisplayContract.Presenter presenter);
        void setRecyclerView(List<Result> results, QuizRecyclerAdapter adapter);
    }

    interface Model {
        void setPresenter(QuizDisplayContract.Presenter presenter);
        void fetchData();
        void onDestroy();
    }

}
