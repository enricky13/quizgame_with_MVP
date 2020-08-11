package com.example.quiz_game_20;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.quiz_game_20.Network.Data.Result;

import java.util.List;

public class MainActivity extends AppCompatActivity implements QuizDisplayContract.View{
    private QuizDisplayContract.Presenter presenter;
    private RecyclerView quizRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new QuizDisplayPresenter(new QuizDisplayModel());
        setPresenter(presenter);
        presenter.onViewCreated(this);
    }

    @Override
    public void setPresenter(QuizDisplayContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void setRecyclerView(List<Result> results, QuizRecyclerAdapter adapter) {
        quizRecyclerView = findViewById(R.id.question_recyclerview);
        quizRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        quizRecyclerView.setAdapter(adapter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }
}
