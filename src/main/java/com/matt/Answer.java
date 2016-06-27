package com.matt;

import java.io.Serializable;

public class Answer implements Serializable{
    private int answer;

    public Answer(){}
    
    public Answer(int answer){
        this.answer = answer;
    }

    public int getAnswer() {
        return answer;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }
}