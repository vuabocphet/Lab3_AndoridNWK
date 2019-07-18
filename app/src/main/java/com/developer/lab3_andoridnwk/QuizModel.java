package com.developer.lab3_andoridnwk;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

class Maths implements Serializable{

    @SerializedName("q1")
    @Expose
    private Q1_ q1;
    @SerializedName("q2")
    @Expose
    private Q2 q2;

    public Q1_ getQ1() {
        return q1;
    }

    public void setQ1(Q1_ q1) {
        this.q1 = q1;
    }

    public Q2 getQ2() {
        return q2;
    }

    public void setQ2(Q2 q2) {
        this.q2 = q2;
    }

}

class Q1 {

    @SerializedName("question")
    @Expose
    private String question;
    @SerializedName("options")
    @Expose
    private List<String> options = null;
    @SerializedName("answer")
    @Expose
    private String answer;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

}

class Q1_ {

    @SerializedName("question")
    @Expose
    private String question;
    @SerializedName("options")
    @Expose
    private List<String> options = null;
    @SerializedName("answer")
    @Expose
    private String answer;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

}

class Q2 {

    @SerializedName("question")
    @Expose
    private String question;
    @SerializedName("options")
    @Expose
    private List<String> options = null;
    @SerializedName("answer")
    @Expose
    private String answer;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

}

class Quiz {

    @SerializedName("sport")
    @Expose
    private Sport sport;
    @SerializedName("maths")
    @Expose
    private Maths maths;

    public Sport getSport() {
        return sport;
    }

    public void setSport(Sport sport) {
        this.sport = sport;
    }

    public Maths getMaths() {
        return maths;
    }

    public void setMaths(Maths maths) {
        this.maths = maths;
    }

}


public class QuizModel implements Serializable {

    @SerializedName("quiz")
    @Expose
    private Quiz quiz;

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    public QuizModel() {}

}

class Sport implements Serializable {

    @SerializedName("q1")
    @Expose
    private Q1 q1;

    public Q1 getQ1() {
        return q1;
    }

    public void setQ1(Q1 q1) {
        this.q1 = q1;
    }

}
