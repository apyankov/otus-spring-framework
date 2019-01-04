package ru.otus.homeworks.spring.spring_framework.service;

import ru.otus.homeworks.spring.spring_framework.domain.Account;
import ru.otus.homeworks.spring.spring_framework.domain.Answer;
import ru.otus.homeworks.spring.spring_framework.domain.Question;

import java.util.List;

/**
 * Опросить студента по набору вопросов
 */
public interface QuizProviderService {

    /** Получить/запросить у пользователя ответы на эти вопросы */
    List<Answer> ask(Account account, List<Question> questions);
}
