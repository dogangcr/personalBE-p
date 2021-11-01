package com.example.easynotes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.easynotes.model.Answer;
import com.example.easynotes.model.Category;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long> {

}
