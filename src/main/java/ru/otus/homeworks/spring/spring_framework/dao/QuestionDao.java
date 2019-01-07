package ru.otus.homeworks.spring.spring_framework.dao;

import ru.otus.homeworks.spring.spring_framework.domain.Question;

import java.util.List;

/**
 * Доступ к данным: вопросы для тестирования студентов
 */
public interface QuestionDao {

    /** Выбрать несколько вопросов, случайным образом */
    List<Question> findRandomQuestions(int count);
}
