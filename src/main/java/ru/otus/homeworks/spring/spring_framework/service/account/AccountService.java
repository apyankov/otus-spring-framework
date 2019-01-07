package ru.otus.homeworks.spring.spring_framework.service.account;

import ru.otus.homeworks.spring.spring_framework.domain.Account;

/**
 * Вся работа с аккаунтом пользователя
 */
public interface AccountService {

    /** Получить имя,фамилию пользователя */
    Account getUserAccount();
}
