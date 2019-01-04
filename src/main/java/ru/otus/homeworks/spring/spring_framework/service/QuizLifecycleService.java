package ru.otus.homeworks.spring.spring_framework.service;

/**
 * Собирает в единую последовательность все действия по прохождению тестирования студентом
 */
public interface QuizLifecycleService {

    /** Выполнить тестирование студента */
    void runQuiz();
}
