package com.harshal.quizapp.dao;

import com.harshal.quizapp.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Map;

public interface QuizDao extends JpaRepository<Quiz, Integer> {

    Quiz findById(int id);}
