package ru.otus.homeworks.spring.spring_framework.service;

import ru.otus.homeworks.spring.spring_framework.domain.Account;
import ru.otus.homeworks.spring.spring_framework.domain.Answer;
import ru.otus.homeworks.spring.spring_framework.domain.Question;

import java.util.List;

/**
 * Реализация QuizProviderService, использует System.in
 */
public class QuizProviderServiceConsoleImpl implements QuizProviderService {

    @Override
    public List<Answer> ask(Account account, List<Question> questions) {
        return null;
    }
}
