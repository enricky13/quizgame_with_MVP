package com.example.quiz_game_20;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quiz_game_20.Network.Data.Result;

import java.util.List;

public class QuizRecyclerAdapter extends RecyclerView.Adapter<QuizViewHolder>{
    private List<Result> quizResults;
    private QuizDisplayContract.Presenter presenter;

    public QuizRecyclerAdapter(List<Result> quizResults, QuizDisplayContract.Presenter presenter){
        this.quizResults = quizResults;
        this.presenter = presenter;
    }

    @NonNull
    @Override
    public QuizViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new QuizViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.question_itemview, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull QuizViewHolder holder, int position) {
        holder.onBind(quizResults.get(position));
    }

    @Override
    public int getItemCount() {
        return quizResults.size();
    }
}
