package ru.otus.homeworks.spring.spring_framework.service;

import ru.otus.homeworks.spring.spring_framework.domain.Answer;
import ru.otus.homeworks.spring.spring_framework.domain.QuizScore;

import java.util.List;

/**
 * Расчет резульатов тестирования
 */
public interface ScoreCalculatorService {

    /** Рассчитать результаты тестирования */
    QuizScore calculate(List<Answer> answers);
}
