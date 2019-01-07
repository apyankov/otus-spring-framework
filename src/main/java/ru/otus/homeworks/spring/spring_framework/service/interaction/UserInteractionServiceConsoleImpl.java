package ru.otus.homeworks.spring.spring_framework.service.interaction;

import java.util.Scanner;

/**
 * Реализация UserInteractionService, использует console
 */
public class UserInteractionServiceConsoleImpl implements UserInteractionService {

    private Scanner scanner = new Scanner(System.in);

    @Override
    public String receiveInputLine() {
        return scanner.nextLine();
    }

    @Override
    public void present(String text) {
        System.out.println(text);
    }
}
