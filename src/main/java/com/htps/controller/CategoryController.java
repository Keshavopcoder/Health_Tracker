package com.htps.controller;

import com.htps.dto.CategoryDTO;
import com.htps.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/")
    public List<CategoryDTO> getCategories() {
        return categoryService.getCategories();
    }
}
