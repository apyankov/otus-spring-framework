package ru.otus.homeworks.spring.spring_framework.dao;

import com.opencsv.CSVReader;
import ru.otus.homeworks.spring.spring_framework.domain.Question;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Реализация QuestionDao, использует Csv-файл
 */
public class CsvFileQuestionDaoImpl implements QuestionDao {

    private final String fileName;
    private final char separator;


    public CsvFileQuestionDaoImpl(String fileName, char separator) {
        this.fileName = fileName;
        this.separator = separator;
    }


    private List<Question> readQuestions() throws IOException {
        List<Question> questions = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new FileReader(getClass().getResource(fileName).getFile()), separator)) {
            // вычитываем первую строку - это список столбцов
            String[] columnNames = reader.readNext();

            // вычитываем все строки с вопросами
            String[] line;
            while ((line = reader.readNext()) != null) {
                questions.add(QuestionCsvUtil.parseCsvLine(line));
            }
        }
        return questions;
    }


    @Override
    public List<Question> findRandomQuestions(int count) {
        try {
            List<Question> bank = readQuestions();
            if(bank.size() < count)
                throw new IllegalArgumentException("Запрошено вопросов больше, чем есть уникальных: " + count + ", против " + bank.size());
            else if(bank.size() == count)
                return bank;
            else {
                Random random = new Random();
                List<Question> result = new ArrayList<>();
                for(int i=0; i<count; i++){
                    int number = random.nextInt(bank.size());
                    result.add(bank.get(number));
                    bank.remove(number);
                }
                return result;
            }
        }catch(IOException e){
            throw new RuntimeException(e);
        }
    }
}
