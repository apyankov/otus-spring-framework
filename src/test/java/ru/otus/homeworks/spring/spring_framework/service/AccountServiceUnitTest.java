package ru.otus.homeworks.spring.spring_framework.service;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import ru.otus.homeworks.spring.spring_framework.domain.Account;
import ru.otus.homeworks.spring.spring_framework.service.account.AccountService;
import ru.otus.homeworks.spring.spring_framework.service.account.AccountServiceImpl;
import ru.otus.homeworks.spring.spring_framework.service.interaction.UserInteractionService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


/**
 * Unit-тест к сервису
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AccountServiceUnitTest {

    private static final String MOCK_STRING = "mock-string";

    private final UserInteractionService userInteractionService = mock(UserInteractionService.class);

    private AccountService accountService;


    @BeforeAll
    void init() {
        accountService = new AccountServiceImpl(userInteractionService);
        when(userInteractionService.receiveInputLine()).thenReturn(MOCK_STRING);
    }

    @Test
    void passPercentTest() {
        // проверяем, что будет создан Account, с теми данными, которые введет пользователь
        Account account = accountService.getUserAccount();
        assertEquals(account, new Account(MOCK_STRING, MOCK_STRING));
    }
}
