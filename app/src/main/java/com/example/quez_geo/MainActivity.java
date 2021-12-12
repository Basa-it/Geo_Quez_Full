package com.example.quez_geo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //private static final String TAG = "MainActivity";

    private static final String KEY_INDEX = "index";

    private Button mTrueButton;
    private Button mFalseButton;
    private ImageButton mNextButton;
    private ImageButton mReturnButton;
    private TextView mQuestionTextView;

    private void updateQuestion(){
        int question = mQuestionBank[mCurrentIndex].getmQuestion();
        mQuestionTextView.setText(question);
    }

    private void checkAnswer(boolean userPresetTrue){
        boolean ansverIsTrue = mQuestionBank[mCurrentIndex].ismTrueQuestion();

        int messageResId = 0;

        if (userPresetTrue == ansverIsTrue){
            messageResId = R.string.correct_toast;
        }else {
            messageResId = R.string.incorrect_toast;
        }
        Toast.makeText(this, messageResId, Toast.LENGTH_SHORT).show();
    }

    private TrueFalse[] mQuestionBank = new TrueFalse[]{
            new TrueFalse(R.string.question_ocean, true),
            new TrueFalse(R.string.question_mideast,false),
            new TrueFalse(R.string.question_africa, false),
            new TrueFalse(R.string.question_american, true),
            new TrueFalse(R.string.question_asia, true),
    };

    private int mCurrentIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mQuestionTextView = findViewById(R.id.action_text);
        mQuestionTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCurrentIndex = (mCurrentIndex + 1)% mQuestionBank.length;
                updateQuestion();
            }
        });

        int question = mQuestionBank[mCurrentIndex].getmQuestion();
        mQuestionTextView.setText(question);

        mTrueButton = findViewById(R.id.true_button);
        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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

        mNextButton = findViewById(R.id.next_now);
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCurrentIndex = (mCurrentIndex + 1)% mQuestionBank.length;
                updateQuestion();
            }
        });

        mReturnButton= findViewById(R.id.return_now);
        mReturnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCurrentIndex = (mCurrentIndex + 1)% mQuestionBank.length;
                updateQuestion();
            }
        });
        updateQuestion();
    }


    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putInt(KEY_INDEX, mCurrentIndex);
        if (savedInstanceState != null){
            mCurrentIndex = savedInstanceState.getInt(KEY_INDEX, 0);
        }
        super.onSaveInstanceState(savedInstanceState);
        
        updateQuestion();
    }
}