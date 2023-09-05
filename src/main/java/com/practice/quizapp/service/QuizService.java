package com.practice.quizapp.service;

import com.practice.quizapp.dao.QuestionDao;
import com.practice.quizapp.dao.QuizDao;
import com.practice.quizapp.model.Question;
import com.practice.quizapp.model.QuestionWrapper;
import com.practice.quizapp.model.Quiz;
import com.practice.quizapp.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {
    @Autowired
    QuizDao quizDao;
    @Autowired
    private final QuestionDao questionDao;

    public QuizService(QuestionDao questionDao) {
        this.questionDao = questionDao;
    }

    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
        List<Question> questions = questionDao.findRandomQuestionsByCategory(category, numQ);
        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        quizDao.save(quiz);
        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
        Optional<Quiz> quiz = quizDao.findById(id);
        List<Question> questionsFromDb = quiz.get().getQuestions();
        List<QuestionWrapper> questionsForUsers = new ArrayList<>();
        for(Question q : questionsFromDb){
            QuestionWrapper qw = new QuestionWrapper(q.getId(),q.getQuestionTitle(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
            questionsForUsers.add(qw);
        }

        return new ResponseEntity<>(questionsForUsers, HttpStatus.OK);
    }

    public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {
        Optional<Quiz> quiz = quizDao.findById(id);

        List<Question> questions = quiz.get().getQuestions();
        int right =0;
        int i = 0;
        System.out.println("responses = "+responses.get(0));
        System.out.println("responses = "+responses.get(1));
        System.out.println("responses = "+responses.get(2));
        System.out.println("responses = "+responses.get(3));
        System.out.println("responses = "+responses.get(4));

        for(Response response : responses){
            System.out.println("Answer = "+questions.get(i).getCorrectAnswer());
            if(response.getResponse().equals(questions.get(i).getCorrectAnswer()))
                right++;
            i++;
        }
        System.out.println(right);
        return  new ResponseEntity<>(right, HttpStatus.OK);
    }
}
