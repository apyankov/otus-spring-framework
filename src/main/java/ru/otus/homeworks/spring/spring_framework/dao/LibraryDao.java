package ru.otus.homeworks.spring.spring_framework.dao;

import ru.otus.homeworks.spring.spring_framework.domain.Question;

/**
 * Доступ к набору вопрос-ответы
 */
public interface LibraryDao {

    public Question getNextQuestion();

}
