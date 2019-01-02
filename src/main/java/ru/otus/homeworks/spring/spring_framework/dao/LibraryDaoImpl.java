package ru.otus.homeworks.spring.spring_framework.dao;

import ru.otus.homeworks.spring.spring_framework.domain.Question;

import java.util.Random;

public class LibraryDaoImpl implements LibraryDao {

    public Question getNextQuestion() {
        return new Question("question-text: " + new Random().nextInt(1000));
    }
}
