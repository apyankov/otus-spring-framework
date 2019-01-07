package ru.otus.homeworks.spring.spring_framework.service.interaction;

/**
 * Ввод данных пользователем - производим через этот сервис
 */
public interface UserInteractionService {

    /** Ввод пользователя, до перевода строки */
    String receiveInputLine();

    /** Отобразить сообщение пользователю */
    void present(String text);
}
