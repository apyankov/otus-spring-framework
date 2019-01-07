package ru.otus.homeworks.spring.spring_framework.service.account;

import ru.otus.homeworks.spring.spring_framework.domain.Account;
import ru.otus.homeworks.spring.spring_framework.service.interaction.UserInteractionService;

/**
 * Реализация AccountService,
 */
public class AccountServiceImpl implements AccountService {

    private UserInteractionService userInteractionService;


    public AccountServiceImpl(UserInteractionService userInteractionService) {
        this.userInteractionService = userInteractionService;
    }


    @Override
    public Account getUserAccount() {
        userInteractionService.present("Enter your first name: ");
        String firstName = userInteractionService.receiveInputLine();

        userInteractionService.present("Enter your last name: ");
        String lastName = userInteractionService.receiveInputLine();

        return new Account(firstName, lastName);
    }
}
