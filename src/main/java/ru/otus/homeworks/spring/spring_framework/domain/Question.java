package ru.otus.homeworks.spring.spring_framework.domain;

/**
 * Вопрос, с полной информацией по его обработке
 */
public class Question {

    /** номер вопроса в исходном файле, считаем как id */
    private int number;
    /** текст вопроса */
    private String text;
    /** правильный вариант ответа  */
    private String correctAnswer;
    /** Варианты ответов (если подразумевается выбор из предложенных вариантов) */
    private String[] answers;


    public Question(int number, String text, String correctAnswer, String[] answers) {
        this.number = number;
        this.text = text;
        this.correctAnswer = correctAnswer;
        this.answers = answers;
    }


    public int getNumber() {
        return number;
    }

    public String getText() {
        return text;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public String[] getAnswers() {
        return answers;
    }
}
