package com.example.quiz_game_20;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quiz_game_20.Network.Data.Result;

class QuizViewHolder extends RecyclerView.ViewHolder {
    private TextView questionDisplay, answerOne, answerTwo, answerThree, answerFour;

    QuizViewHolder(@NonNull View itemView) {
        super(itemView);
        questionDisplay = itemView.findViewById(R.id.question_display_tv);
        answerOne = itemView.findViewById(R.id.answer_one_tv);
        answerTwo = itemView.findViewById(R.id.answer_two_tv);
        answerThree = itemView.findViewById(R.id.answer_three_tv);
        answerFour = itemView.findViewById(R.id.answer_four_tv);
    }

    void onBind(Result result){
        questionDisplay.setText(result.getQuestion());
        answerOne.setText(result.getIncorrectAnswers().get(0));
        answerTwo.setText(result.getIncorrectAnswers().get(1));
        answerThree.setText(result.getIncorrectAnswers().get(2));
        answerFour.setText(result.getCorrectAnswer());


    }
}
