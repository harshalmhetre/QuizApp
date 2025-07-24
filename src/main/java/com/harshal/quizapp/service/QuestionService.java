package com.harshal.quizapp.service;

import com.harshal.quizapp.model.Question;
import com.harshal.quizapp.dao.QuestionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    private QuestionDao questionDao;

    public List<Question> getAllQuestions() {
        return questionDao.findAll();
    }

    public Question addQuestion(Question question) {
        return questionDao.save(question);
    }

    public List<Question> getQuestionsByCategory(String category) {
        return questionDao.findByCategory(category);
    }

    public Question updateQuestion(Question question) {
        if (!questionDao.existsById(question.getId())) {
            throw new RuntimeException("Question with ID " + question.getId() + " not found");
        }
        return questionDao.save(question); // save() updates if ID exists
    }

    public void deleteQuestion(Integer id) {
        if (!questionDao.existsById(id)) {
            throw new RuntimeException("Question with ID " + id + " not found");
        }
        questionDao.deleteById(id);
    }
}
