package ru.otus.homeworks.spring.spring_framework.service;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class QuizLifecycleServiceImpl implements QuizLifecycleService {

    private QuizProducerService quizProducerService;
    private QuizProviderService quizProviderService;
    private AccountService accountService;
    private ScoreCalculatorService scoreCalculatorService;
    private ScorePresentationService scorePresentationService;


    public QuizLifecycleServiceImpl(QuizProducerService quizProducerService, QuizProviderService quizProviderService, AccountService accountService, ScoreCalculatorService scoreCalculatorService, ScorePresentationService scorePresentationService) {
        this.quizProducerService = quizProducerService;
        this.quizProviderService = quizProviderService;
        this.accountService = accountService;
        this.scoreCalculatorService = scoreCalculatorService;
        this.scorePresentationService = scorePresentationService;
    }


    @Override
    public void runQuiz() {
        throw new NotImplementedException();
    }
}
