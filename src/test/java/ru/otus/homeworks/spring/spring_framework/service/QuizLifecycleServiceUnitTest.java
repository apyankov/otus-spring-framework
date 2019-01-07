package ru.otus.homeworks.spring.spring_framework.service;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import ru.otus.homeworks.spring.spring_framework.domain.Account;
import ru.otus.homeworks.spring.spring_framework.domain.Answer;
import ru.otus.homeworks.spring.spring_framework.domain.Question;
import ru.otus.homeworks.spring.spring_framework.domain.QuizScore;
import ru.otus.homeworks.spring.spring_framework.service.account.AccountService;
import ru.otus.homeworks.spring.spring_framework.service.quiz.*;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.mockito.Mockito.*;

/**
 * Unit-тест к сервису
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class QuizLifecycleServiceUnitTest {

    private AccountService accountService = mock(AccountService.class);
    private QuizProducerService quizProducerService = mock(QuizProducerService.class);
    private QuizProviderService quizProviderService = mock(QuizProviderService.class);
    private ScoreCalculatorService scoreCalculatorService = mock(ScoreCalculatorService.class);
    private ScorePresentationService scorePresentationService = mock(ScorePresentationService.class);

    private QuizLifecycleService quizLifecycleService;

    private final String SAMPLE_ANSWER = "yes";
    private final Account SAMPLE_ACCOUNT = new Account("", "");
    private final List<Question> SAMPLE_QUESTIONS = Collections.singletonList(new Question(0, "", SAMPLE_ANSWER, new String[]{}));
    private final List<Answer> SAMPLE_ANSWERS = SAMPLE_QUESTIONS.stream()
            .map(question -> new Answer(question, SAMPLE_ANSWER))
            .collect(Collectors.toList());
    private final QuizScore SAMPLE_SCORE = new QuizScore(1, 1, 1);


    @BeforeAll
    void init() {
        quizLifecycleService = new QuizLifecycleServiceImpl(accountService, quizProducerService, quizProviderService, scoreCalculatorService, scorePresentationService);
        when(accountService.getUserAccount()).thenReturn(SAMPLE_ACCOUNT);
        when(quizProducerService.produceQuiz()).thenReturn(SAMPLE_QUESTIONS);
        when(quizProviderService.ask(SAMPLE_ACCOUNT, SAMPLE_QUESTIONS)).thenReturn(SAMPLE_ANSWERS);
        when(scoreCalculatorService.calculate(SAMPLE_ANSWERS)).thenReturn(SAMPLE_SCORE);
    }

    @Test
    void lifecycleTest() {
        quizLifecycleService.runQuiz();

        // проверяем, что было обращение ко всем сервисам
        verify(accountService).getUserAccount();
        verify(quizProducerService).produceQuiz();
        verify(quizProviderService).ask(SAMPLE_ACCOUNT, SAMPLE_QUESTIONS);
        verify(scoreCalculatorService).calculate(SAMPLE_ANSWERS);
        verify(scorePresentationService).present(SAMPLE_SCORE);
    }
}
