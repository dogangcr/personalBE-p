package com.example.easynotes.controller;

 

import com.example.easynotes.exception.ResourceNotFoundException;
import com.example.easynotes.model.Category;
import com.example.easynotes.model.Note;
import com.example.easynotes.model.Options;
import com.example.easynotes.repository.CategoryRepository;
import com.example.easynotes.repository.NoteRepository;
import com.example.easynotes.repository.OptionsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

 
@RestController
@RequestMapping("/api")
public class OptionsController {

    @Autowired
    OptionsRepository optionsRepository;

    @GetMapping("/options/user")
   
    public List<Options> getAllNotes() {
        return optionsRepository.findAll();
    }

    @PostMapping("/options/admin")
    public Options createCategory(@Valid @RequestBody Options opt) {
        return optionsRepository.save(opt);
    }

    @GetMapping("/options/admin/{id}")
    public Options getCategoryById(@PathVariable(value = "id") Long opID) {
        return optionsRepository.findById(opID)
                .orElseThrow(() -> new ResourceNotFoundException("category", "id", opID));
    }
    @DeleteMapping("/options/admin/{id}")
    public ResponseEntity<?> deleteNote(@PathVariable(value = "id") Long opID) {
        Options opt = optionsRepository.findById(opID)
                .orElseThrow(() -> new ResourceNotFoundException("note", "id", opID));

        optionsRepository.delete(opt);

        return ResponseEntity.ok().build();
    }
     
}
