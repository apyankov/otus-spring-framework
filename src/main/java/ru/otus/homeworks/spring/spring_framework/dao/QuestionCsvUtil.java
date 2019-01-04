package ru.otus.homeworks.spring.spring_framework.dao;

import ru.otus.homeworks.spring.spring_framework.domain.Question;

public class QuestionCsvUtil {

    /** Превращаем строку из csv-файла в Question */
    public static Question parseCsvLine(String[] cells){
        int number = Integer.parseInt(cells[0]);
        String text = cells[1];
        String correctAnswer = cells[2];
        String[] answers = new String[cells.length - 3];

        System.arraycopy(cells, 3, answers, 0, answers.length);

        return new Question(number, text, correctAnswer, answers);
    }
}
