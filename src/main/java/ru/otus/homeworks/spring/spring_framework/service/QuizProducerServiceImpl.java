package ru.otus.homeworks.spring.spring_framework.service;

import ru.otus.homeworks.spring.spring_framework.dao.QuestionDao;
import ru.otus.homeworks.spring.spring_framework.domain.Question;

import java.util.List;

/**
 * Реализация QuizProducerService
 */
public class QuizProducerServiceImpl implements QuizProducerService {

    private QuestionDao questionDao;
    private int questionsPerQuiz;


    public QuizProducerServiceImpl(QuestionDao questionDao, int questionsPerQuiz) {
        this.questionDao = questionDao;
        this.questionsPerQuiz = questionsPerQuiz;
    }


    @Override
    public List<Question> produceQuiz() {
        return questionDao.findRandomQuestions(questionsPerQuiz);
    }
}
