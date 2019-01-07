package ru.otus.homeworks.spring.spring_framework.service.quiz;

import ru.otus.homeworks.spring.spring_framework.domain.Account;
import ru.otus.homeworks.spring.spring_framework.domain.Answer;
import ru.otus.homeworks.spring.spring_framework.domain.Question;
import ru.otus.homeworks.spring.spring_framework.domain.QuizScore;
import ru.otus.homeworks.spring.spring_framework.service.account.AccountService;

import java.util.List;

public class QuizLifecycleServiceImpl implements QuizLifecycleService {

    private AccountService accountService;
    private QuizProducerService quizProducerService;
    private QuizProviderService quizProviderService;
    private ScoreCalculatorService scoreCalculatorService;
    private ScorePresentationService scorePresentationService;


    public QuizLifecycleServiceImpl(AccountService accountService, QuizProducerService quizProducerService, QuizProviderService quizProviderService, ScoreCalculatorService scoreCalculatorService, ScorePresentationService scorePresentationService) {
        this.accountService = accountService;
        this.quizProducerService = quizProducerService;
        this.quizProviderService = quizProviderService;
        this.scoreCalculatorService = scoreCalculatorService;
        this.scorePresentationService = scorePresentationService;
    }


    @Override
    public void runQuiz() {
        Account account = accountService.getUserAccount();
        List<Question> questions = quizProducerService.produceQuiz();
        List<Answer> answers = quizProviderService.ask(account, questions);
        QuizScore score = scoreCalculatorService.calculate(answers);
        scorePresentationService.present(score);
    }
}
