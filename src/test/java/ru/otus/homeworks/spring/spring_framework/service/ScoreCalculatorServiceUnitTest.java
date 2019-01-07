package ru.otus.homeworks.spring.spring_framework.service;

import org.junit.jupiter.api.Test;
import ru.otus.homeworks.spring.spring_framework.domain.Answer;
import ru.otus.homeworks.spring.spring_framework.domain.Question;
import ru.otus.homeworks.spring.spring_framework.domain.QuizScore;
import ru.otus.homeworks.spring.spring_framework.service.quiz.ScoreCalculatorService;
import ru.otus.homeworks.spring.spring_framework.service.quiz.ScoreCalculatorServiceImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import static ru.otus.homeworks.spring.spring_framework.service.quiz.ScoreCalculatorServiceImpl.passScoreByPercent;

/**
 * Unit-тест к сервису
 */
public class ScoreCalculatorServiceUnitTest {

    private final ScoreCalculatorService service = new ScoreCalculatorServiceImpl(80);


    @Test
    void passPercentTest() {
        // проверяем, сколько вопросов нужно ответить для прохождения теста
        assertEquals(passScoreByPercent(0,0), 0);
        assertEquals(passScoreByPercent(50,0), 0);
        assertEquals(passScoreByPercent(100,0), 0);
        assertEquals(passScoreByPercent(0,10), 0);
        assertEquals(passScoreByPercent(50,10), 5);
        assertEquals(passScoreByPercent(100,10), 10);
        assertEquals(passScoreByPercent(50,11), 6);
    }


    @Test
    void emptyAnswersTest() {
        // проверяем, что сервис не развалится на пустых данных
        QuizScore score = service.calculate(new ArrayList<>());

        assertEquals(score.getTotalQuestions(), 0);
        assertEquals(score.getCorrectAnswers(), 0);
        assertEquals(score.getPassScore(), 0);
    }

    @Test
    void someAnswersTest() {
        // проверяем, что сервис рассчитает корректно для некоторого известного набора данных
        List<Answer> answers = Collections.singletonList(
                new Answer(
                        new Question(0,"", "yes" , new String[]{}),
                        "yes"
                )
        );
        QuizScore score = service.calculate(answers);

        assertTrue(score.isPassed());
        assertEquals(score.getTotalQuestions(), 1);
        assertEquals(score.getCorrectAnswers(), 1);
        assertEquals(score.getPassScore(), 1);
    }
}
