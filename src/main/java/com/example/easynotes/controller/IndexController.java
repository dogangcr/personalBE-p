package com.example.easynotes.controller;


import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.easynotes.model.Note;

@Controller
@RequestMapping("/")
public class IndexController {

    @GetMapping
    public String sayHello(Model model) {
       // return "Hello and Welcome to the EasyNotes application. You can create a new Note by making a POST request to /api/notes endpoint.";
    	return "main.html";
    }
    
    @GetMapping("/index")
    public String getAllNotes(Model model) {
    	return "index.html";
    }
    @GetMapping("/category")
    public String getAll(Model model) {
    	return "category.html";
    }
}
