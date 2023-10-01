package com.zuchowiczjakub.quizzz.service;

import com.zuchowiczjakub.quizzz.model.Quiz;
import com.zuchowiczjakub.quizzz.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizService {

    private final QuizRepository quizRepository;

    @Autowired
    public QuizService(QuizRepository quizRepository) {
        this.quizRepository = quizRepository;
    }

    public Quiz createQuiz(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    public Quiz updateQuiz(Long id, Quiz updatedQuiz) {
        return quizRepository.findById(id)
                .map(quiz -> {
                    quiz.setTitle(updatedQuiz.getTitle());
                    quiz.setText(updatedQuiz.getText());
                    quiz.setOptions(updatedQuiz.getOptions());
                    quiz.setAnswers(updatedQuiz.getAnswers());
                    return quizRepository.save(quiz);
                })
                .orElse(null);
    }

    public List<Quiz> getAllQuizzes() {
        return quizRepository.findAll();
    }

    public Quiz getQuizById(Long id) {
        return quizRepository.findById(id).orElse(null);
    }

    public void deleteQuiz(Long id) {
        quizRepository.deleteById(id);
    }

    public boolean checkAnswers(Quiz quiz, List<Long> userAnswers) {
        List<Long> correctAnswers = quiz.getAnswers();

        if (userAnswers.size() != correctAnswers.size()) {
            return false;
        }

        for (Long userAnswer : userAnswers) {
            if (!correctAnswers.contains(userAnswer)) {
                return false;
            }
        }

        return true;
    }
}
