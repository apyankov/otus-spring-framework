package ru.otus.homeworks.spring.spring_framework.service.quiz;

import ru.otus.homeworks.spring.spring_framework.domain.QuizScore;
import ru.otus.homeworks.spring.spring_framework.service.interaction.UserInteractionService;

/**
 * Реализация ScorePresentationService, использует System.out
 */
public class ScorePresentationServiceImpl implements ScorePresentationService {

    private UserInteractionService userInteractionService;


    public ScorePresentationServiceImpl(UserInteractionService userInteractionService) {
        this.userInteractionService = userInteractionService;
    }


    @Override
    public void present(QuizScore score) {
        String isPassed = score.isPassed() ? "пройден" : "не пройден";
        userInteractionService.present("Результат тестирования: " + isPassed);
        userInteractionService.present("Всего вопросов: " + score.getTotalQuestions());
        userInteractionService.present("Правильных ответов: " + score.getCorrectAnswers());
        userInteractionService.present("При проходном уровне: " + score.getPassScore());
    }
}
