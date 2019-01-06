package ru.otus.homeworks.spring.spring_framework.service.quiz;

import ru.otus.homeworks.spring.spring_framework.domain.Question;

import java.util.List;

/**
 * Получить вопросы, по которым проводить тестирование
 */
public interface QuizProducerService {

    /** Получить вопросы, по которым проводить тестирование */
    List<Question> produceQuiz();
}
