package com.example.quez_geo;

public class TrueFalse {
    private int mQuestion;
    private boolean mTrueQuestion;

    public TrueFalse(int question, boolean trueQuestion){
        mQuestion = question;
        mTrueQuestion = trueQuestion;

    }

    public int getmQuestion() {
        return mQuestion;
    }
    public void setmQuestion(int question) {
        this.mQuestion = question;
    }

    public boolean ismTrueQuestion() {
        return mTrueQuestion;
    }

    public void setmTrueQuestion(boolean trueQuestion) {
        this.mTrueQuestion = trueQuestion;
    }
}
