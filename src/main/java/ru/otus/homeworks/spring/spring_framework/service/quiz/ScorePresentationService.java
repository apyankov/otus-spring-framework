package ru.otus.homeworks.spring.spring_framework.service.quiz;

import ru.otus.homeworks.spring.spring_framework.domain.QuizScore;

/**
 * Отобразить результаты тестирования
 */
public interface ScorePresentationService {

    /** Отобразить результаты тестирования */
    void present(QuizScore score);
}
