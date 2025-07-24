package com.harshal.quizapp.model;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;
    private String title ;
    @ManyToMany
    private List<Question> questions ;

    public void setitle(String title) {
        this.title = title ;
    }

    public void setQuestions(List<Question> questions) {
        this.questions =questions ;
    }

    public List<Question> getQuestions() {
        return questions;
    }
}
