package com.example.easynotes.repository;

import com.example.easynotes.model.Category;
import com.example.easynotes.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
 
@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
