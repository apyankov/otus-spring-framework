package ru.otus.homeworks.spring.spring_framework.dao;

import com.opencsv.CSVReader;
import ru.otus.homeworks.spring.spring_framework.domain.Question;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * LibraryDao, использует Csv-файл
 */
public class CsvFileLibraryDaoImpl implements LibraryDao {

    private static final char SEPARATOR = ';';

    private List<Question> questions;
    private Iterator<Question> questionIterator = null;
    private String[] columnNames;

    public CsvFileLibraryDaoImpl(String csvFileName) throws IOException {
        questions = new ArrayList<>();
        init(csvFileName);
    }

    private void init(String csvFileName) throws IOException {
        try (CSVReader reader = new CSVReader(new FileReader(getClass().getResource(csvFileName).getFile()), SEPARATOR)){
            columnNames = reader.readNext();
            String[] line;
            while ((line = reader.readNext()) != null) {
                questions.add(QuestionCsvUtil.parseCsvLine(line));
            }
        }
    }

    private Iterator<Question> getActualIterator(){
        if(questionIterator == null || !questionIterator.hasNext()){
            questionIterator = questions.iterator();
        }
        return questionIterator;
    }

    public Question getNextQuestion() {
        return getActualIterator().next();
    }

    public String[] getColumnNames() {
        return columnNames;
    }
}
