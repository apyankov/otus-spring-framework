package ru.otus.homeworks.spring.spring_framework.domain;

/**
 * Ответ пользователя на один вопрос
 */
public class Answer {

    /** исходный вопрос */
    private Question question;
    /** ответ пользователя */
    private String typedText;


    public Answer(Question question, String typedText) {
        this.question = question;
        this.typedText = typedText;
    }


    public Question getQuestion() {
        return question;
    }

    public String getTypedText() {
        return typedText;
    }
}
