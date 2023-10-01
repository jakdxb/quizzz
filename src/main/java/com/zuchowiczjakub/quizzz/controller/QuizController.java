package com.zuchowiczjakub.quizzz.controller;


import com.zuchowiczjakub.quizzz.model.Quiz;
import com.zuchowiczjakub.quizzz.model.QuizResponse;
import com.zuchowiczjakub.quizzz.repository.QuizRepository;
import com.zuchowiczjakub.quizzz.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quizzes")
public class QuizController {

    private final QuizService quizService;

    @Autowired
    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    @GetMapping
    public List<Quiz> getAllQuizzes() {
        return quizService.getAllQuizzes();
    }

    @GetMapping("/{id}")
    public Quiz getQuizById(@PathVariable Long id) {
        return quizService.getQuizById(id);
    }

    @PostMapping
    public Quiz createQuiz(@RequestBody Quiz quiz) {
        return quizService.createQuiz(quiz);
    }

    @PutMapping("/{id}")
    public Quiz updateQuiz(@PathVariable Long id, @RequestBody Quiz updatedQuiz) {
        return quizService.updateQuiz(id, updatedQuiz);
    }

    @DeleteMapping("/{id}")
    public void deleteQuiz(@PathVariable Long id) {
        quizService.deleteQuiz(id);
    }

    @PostMapping("/check/{id}")
    public QuizResponse checkAnswers(@PathVariable Long id, @RequestBody List<Long> userAnswers) {
        Quiz quiz = quizService.getQuizById(id);

        if (quiz == null) {
            return new QuizResponse(false, "Quiz not found");
        }

        boolean isCorrect = quizService.checkAnswers(quiz, userAnswers);

        if (isCorrect) {
            return new QuizResponse(true, "Correct answers");
        } else {
            return new QuizResponse(false, "Incorrect answers");
        }
    }
}
