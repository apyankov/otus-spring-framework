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

    /** функция: сколько нужно правильных ответов, чтобы пройти тест из count вопросов, если проходной процент равен passPercent*/
    public static int passScoreByPercent(int passPercent, int count) {
        return (int)Math.ceil(1.0 * count * passPercent / 100);
    }

    @Override
    public QuizScore calculate(List<Answer> answers) {
        int totalCount = answers.size();
        int correctCount = (int) answers.stream()
                .filter(answer -> answer.getTypedText().equals(answer.getQuestion().getCorrectAnswer()))
                .count();
        int passScore = passScoreByPercent(passPercent, answers.size());

        return new QuizScore(totalCount, correctCount, passScore);
    }
}
