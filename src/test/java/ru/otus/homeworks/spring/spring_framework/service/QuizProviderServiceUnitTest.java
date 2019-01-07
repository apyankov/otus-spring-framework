package ru.otus.homeworks.spring.spring_framework.service;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import ru.otus.homeworks.spring.spring_framework.domain.Account;
import ru.otus.homeworks.spring.spring_framework.domain.Answer;
import ru.otus.homeworks.spring.spring_framework.domain.Question;
import ru.otus.homeworks.spring.spring_framework.service.interaction.UserInteractionService;
import ru.otus.homeworks.spring.spring_framework.service.quiz.QuizProducerServiceImpl;
import ru.otus.homeworks.spring.spring_framework.service.quiz.QuizProviderService;
import ru.otus.homeworks.spring.spring_framework.service.quiz.QuizProviderServiceImpl;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


/**
 * Unit-тест к сервису
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class QuizProviderServiceUnitTest {

    private UserInteractionService userInteractionService = mock(UserInteractionService.class);
    private QuizProviderService quizProviderService;

    private final String MOCK_ANSWER = "yes";
    private final Account MOCK_ACCOUNT = new Account("", "");
    private final List<Question> SAMPLE_QUESTIONS = Collections.singletonList(new Question(0, "", MOCK_ANSWER, new String[]{}));


    @BeforeAll
    void init() {
        quizProviderService = new QuizProviderServiceImpl(userInteractionService);
        when(userInteractionService.receiveInputLine()).thenReturn(MOCK_ANSWER);
    }


    @Test
    void useDaoTest() {
        List<Answer> answers = quizProviderService.ask(MOCK_ACCOUNT, SAMPLE_QUESTIONS);
        // проверяем, что было обращение к нужным сервисам: UserInteraction
        verify(userInteractionService).receiveInputLine();
        // проверяем, что сервис вернул ожидаемые рез-ты
        assertEquals(answers.size(), SAMPLE_QUESTIONS.size());
        assertEquals( // на все вопросы - ответ равен ожидаемому
                answers.stream()
                        .filter(answer -> answer.getTypedText().equals(MOCK_ANSWER))
                        .count(),
                SAMPLE_QUESTIONS.size()
        );
    }
}
