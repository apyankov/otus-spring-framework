package ru.otus.homeworks.spring.spring_framework;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.otus.homeworks.spring.spring_framework.domain.Question;
import ru.otus.homeworks.spring.spring_framework.service.LibraryService;
import ru.otus.homeworks.spring.spring_framework.service.LibraryServiceImpl;

public class Main {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");
        LibraryService service = context.getBean(LibraryServiceImpl.class);
        Question nextQuestion = service.findNextQuestion();
        System.out.println("question: " + nextQuestion.getText());
    }
}
