package com.example.easynotes.controller;

import com.example.easynotes.exception.ResourceNotFoundException;
import com.example.easynotes.model.Category;
import com.example.easynotes.model.Note;
import com.example.easynotes.repository.CategoryRepository;
import com.example.easynotes.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by rajeevkumarsingh on 27/06/17.
 */
@RestController
@RequestMapping("/api")
public class CategoryController {

    @Autowired
    CategoryRepository categoryRepository;

    @GetMapping("/category/user")
   
    public List<Category> getAllNotes() {
        return categoryRepository.findAll();
    }

    @PostMapping("/category/admin")
    public Category createCategory(@Valid @RequestBody Category category) {
        return categoryRepository.save(category);
    }

    @GetMapping("/category/admin/{id}")
    public Category getCategoryById(@PathVariable(value = "id") Long categoryID) {
        return categoryRepository.findById(categoryID)
                .orElseThrow(() -> new ResourceNotFoundException("category", "id", categoryID));
    }
    @DeleteMapping("/category/admin/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable(value = "id") Long categoryID) {
        Category category = categoryRepository.findById(categoryID)
                .orElseThrow(() -> new ResourceNotFoundException("Category", "id", categoryID));

        categoryRepository.delete(category);

        return ResponseEntity.ok().build();
    }
     
}
