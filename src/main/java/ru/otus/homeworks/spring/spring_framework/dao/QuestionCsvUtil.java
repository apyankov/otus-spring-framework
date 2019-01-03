package ru.otus.homeworks.spring.spring_framework.dao;

import ru.otus.homeworks.spring.spring_framework.domain.Question;

public class QuestionCsvUtil {

    public static Question parseCsvLine(String[] cells){
        int number = Integer.parseInt(cells[0]);
        String text = cells[1];
        int correctNumber = Integer.parseInt(cells[2]);
        String[] answers = new String[cells.length - 3];
        for(int i=0; i<answers.length; i++){
            answers[i] = cells[3+i];
        }
        return new Question(number, text, correctNumber, answers);
    }
}
