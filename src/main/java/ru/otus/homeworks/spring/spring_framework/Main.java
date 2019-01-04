package ru.otus.homeworks.spring.spring_framework;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.otus.homeworks.spring.spring_framework.domain.Question;
import ru.otus.homeworks.spring.spring_framework.service.*;

public class Main {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");

        AccountService accountService = context.getBean(AccountService.class);
        QuizProducerService quizProducerService = context.getBean(QuizProducerService.class);
        QuizProviderService quizProviderService = context.getBean(QuizProviderService.class);
        ScoreCalculatorService scoreCalculatorService = context.getBean(ScoreCalculatorService.class);
        ScorePresentationService scorePresentationService = context.getBean(ScorePresentationService.class);

        QuizLifecycleService quizLifecycleService = context.getBean(QuizLifecycleService.class);

        quizLifecycleService.runQuiz();
    }
}
