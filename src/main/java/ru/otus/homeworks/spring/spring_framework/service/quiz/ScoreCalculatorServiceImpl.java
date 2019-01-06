package ru.otus.homeworks.spring.spring_framework.service.quiz;

import ru.otus.homeworks.spring.spring_framework.domain.Answer;
import ru.otus.homeworks.spring.spring_framework.domain.QuizScore;

import java.util.List;

/**
 * Реализация ScoreCalculatorService
 */
public class ScoreCalculatorServiceImpl implements ScoreCalculatorService {

    private int passPercent;


    public ScoreCalculatorServiceImpl(int passPercent) {
        this.passPercent = passPercent;
    }


    @Override
    public QuizScore calculate(List<Answer> answers) {
        int totalCount = answers.size();
        int correctCount = (int) answers.stream()
                .filter(answer -> answer.getTypedText().equals(answer.getQuestion().getCorrectAnswer()))
                .count();
        int passScore = (int) (1.0 * answers.size() * passPercent / 100);

        return new QuizScore(totalCount, correctCount, passScore);
    }
}
