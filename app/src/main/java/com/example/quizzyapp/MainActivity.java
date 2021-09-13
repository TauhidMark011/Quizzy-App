package com.example.quizzyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView mQuestionText;
    private Button mTrueButton, mFalseButton, mNextButton;

    private int mCurrentIndex = 0;
    private TrueFalse[] mQuestions = new TrueFalse[]{
            new TrueFalse(R.string.question_one, false),
            new TrueFalse(R.string.question_two, true),
            new TrueFalse(R.string.question_three, false),
            new TrueFalse(R.string.question_four, true),
            new TrueFalse(R.string.question_five, false),
            new TrueFalse(R.string.question_six, true),
            new TrueFalse(R.string.question_seven, true),
            new TrueFalse(R.string.question_eight, false),


    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mQuestionText = findViewById(R.id.question_text_view);
        final int Question = mQuestions[mCurrentIndex].getQuestion();
        mQuestionText.setText(Question);

        mTrueButton = findViewById(R.id.true_button);
        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(true);
            }
        });

        mFalseButton = findViewById(R.id.false_button);
        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(false);
            }
        });

        mNextButton = findViewById(R.id.next_button);
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentIndex = (mCurrentIndex + 1) % mQuestions.length;
                int question = mQuestions[mCurrentIndex].getQuestion();
                mQuestionText.setText(question);
            }
        });

    }


    private void checkAnswer(boolean userPressed) {
        boolean answer = mQuestions[mCurrentIndex].isTrueQuestion();
        if (userPressed == answer) {
            Toast.makeText(MainActivity.this, R.string.true_message, Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(MainActivity.this, R.string.false_message, Toast.LENGTH_SHORT).show();
        }
    }
}