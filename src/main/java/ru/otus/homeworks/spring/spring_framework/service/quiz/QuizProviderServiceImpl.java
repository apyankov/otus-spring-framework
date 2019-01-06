package ru.otus.homeworks.spring.spring_framework.service.quiz;

import ru.otus.homeworks.spring.spring_framework.domain.Account;
import ru.otus.homeworks.spring.spring_framework.domain.Answer;
import ru.otus.homeworks.spring.spring_framework.domain.Question;
import ru.otus.homeworks.spring.spring_framework.service.interaction.UserInteractionService;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Реализация QuizProviderService
 */
public class QuizProviderServiceImpl implements QuizProviderService {

    private UserInteractionService userInteractionService;


    public QuizProviderServiceImpl(UserInteractionService userInteractionService) {
        this.userInteractionService = userInteractionService;
    }


    @Override
    public List<Answer> ask(Account account, List<Question> questions) {
        int number = 1;
        int count = questions.size();

        return questions.stream()
                .map(question -> askOneQuestion(number, count, question))
                .collect(Collectors.toList());
    }

    private Answer askOneQuestion(int number, int count, Question question) {
        userInteractionService.present("Вопрос " + number + " из " + count);
        userInteractionService.present(question.getText());

        if(question.getAnswers().length > 0){
            int optionNumber = 1;
            for(String option: question.getAnswers()){
                userInteractionService.present("Вариант " + optionNumber + ": " + option);
                optionNumber++;
            }
            userInteractionService.present("Ваш вариант ответа:");
        }else {
            userInteractionService.present("Введите ответ:");
        }

        String typedText = userInteractionService.receiveInputLine();

        return new Answer(question, typedText);
    }
}
