package ru.otus.homeworks.spring.spring_framework.service;

import ru.otus.homeworks.spring.spring_framework.dao.LibraryDao;
import ru.otus.homeworks.spring.spring_framework.domain.Question;

public class LibraryServiceImpl implements LibraryService {

    private LibraryDao libraryDao;


    public LibraryServiceImpl(LibraryDao libraryDao) {
        this.libraryDao = libraryDao;
    }


    public Question findNextQuestion() {
        return libraryDao.getNextQuestion();
    }
}
