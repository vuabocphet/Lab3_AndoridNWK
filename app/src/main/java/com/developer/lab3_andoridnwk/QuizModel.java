package com.developer.lab3_andoridnwk;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

 class Math {

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
    private List<Sport> sport = null;
    @SerializedName("maths")
    @Expose
    private List<Math> maths = null;

    public List<Sport> getSport() {
        return sport;
    }

    public void setSport(List<Sport> sport) {
        this.sport = sport;
    }

    public List<Math> getMaths() {
        return maths;
    }

    public void setMaths(List<Math> maths) {
        this.maths = maths;
    }

}


public class QuizModel {

    @SerializedName("quiz")
    @Expose
    private Quiz quiz;

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

}
 class Sport {

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