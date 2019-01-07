package ru.otus.homeworks.spring.spring_framework.service;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import ru.otus.homeworks.spring.spring_framework.dao.QuestionDao;
import ru.otus.homeworks.spring.spring_framework.domain.Question;
import ru.otus.homeworks.spring.spring_framework.service.quiz.QuizProducerService;
import ru.otus.homeworks.spring.spring_framework.service.quiz.QuizProducerServiceImpl;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

/**
 * Unit-тест к сервису
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class QuizProducerServiceUnitTest {

    private final int QUESTION_COUNT = 1;

    private QuestionDao questionDao = mock(QuestionDao.class);
    private QuizProducerService quizProducerService;

    private Question sampleQuestion = new Question(0, "sample-text", "yes", new String[]{});
    private List<Question> sample = Collections.singletonList(sampleQuestion);


    @BeforeAll
    void init() {
        quizProducerService = new QuizProducerServiceImpl(questionDao, QUESTION_COUNT);
        when(questionDao.findRandomQuestions(QUESTION_COUNT)).thenReturn(sample);
    }

    @Test
    void useDaoTest() {
        List<Question> questions = quizProducerService.produceQuiz();
        // проверяем, что было обращение к Dao
        verify(questionDao).findRandomQuestions(QUESTION_COUNT);
        // проверяем, что сервис вернул ожидаемое кол-во вопросов
        assertEquals(questions.size(), QUESTION_COUNT);
    }
}
