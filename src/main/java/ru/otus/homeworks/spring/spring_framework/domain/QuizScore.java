package ru.otus.homeworks.spring.spring_framework.domain;

/**
 * Результат прохождения тестов
 */
public class QuizScore {

    private int totalQuestions;
    private int correctAnswers;
    private int passScore;


    public QuizScore(int totalQuestions, int correctAnswers, int passScore) {
        this.totalQuestions = totalQuestions;
        this.correctAnswers = correctAnswers;
        this.passScore = passScore;
    }


    /** пройден ли тест на удовлетворительную оценку */
    public boolean isPassed(){
        return correctAnswers >= passScore;
    }


    public int getTotalQuestions() {
        return totalQuestions;
    }

    public int getCorrectAnswers() {
        return correctAnswers;
    }

    public int getPassScore() {
        return passScore;
    }
}
