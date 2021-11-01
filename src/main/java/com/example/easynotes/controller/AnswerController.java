package com.example.easynotes.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.easynotes.exception.ResourceNotFoundException;
import com.example.easynotes.model.Answer;
import com.example.easynotes.model.Options;
import com.example.easynotes.repository.AnswerRepository;
import com.example.easynotes.repository.OptionsRepository;

 
@RestController
@RequestMapping("/api")
public class AnswerController {

    @Autowired
    AnswerRepository answerRepository;

    @GetMapping("/answer/user")
   
    public List<Answer> getAllAnswer() {
        return answerRepository.findAll();
    }

    @PostMapping("/answer/admin")
    public Answer createAnswer(@Valid @RequestBody Answer ans) {
        return answerRepository.save(ans);
    }

    @GetMapping("/answer/admin/{id}")
    public Answer getAnswerById(@PathVariable(value = "id") Long ansID) {
        return answerRepository.findById(ansID)
                .orElseThrow(() -> new ResourceNotFoundException("answer", "id", ansID));
    }
    @DeleteMapping("/answer/admin/{id}")
    public ResponseEntity<?> deleteAnswer(@PathVariable(value = "id") Long ansID) {
    	Answer opt = answerRepository.findById(ansID)
                .orElseThrow(() -> new ResourceNotFoundException("answer", "id", ansID));

        answerRepository.delete(opt);

        return ResponseEntity.ok().build();
    }
     
}