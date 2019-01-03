package ru.otus.homeworks.spring.spring_framework.domain;

public class Question {

    private int number;
    private String text;
    private int correct;
    private String[] answers;


    public Question(int number, String text, int correct, String[] answers) {
        this.number = number;
        this.text = text;
        this.correct = correct;
        this.answers = answers;
    }


    public int getNumber() {
        return number;
    }

    public String getText() {
        return text;
    }

    public int getCorrect() {
        return correct;
    }

    public String[] getAnswers() {
        return answers;
    }
}
