package com.dotin.dotintasktwo.service;

import com.dotin.dotintasktwo.dao.CategoryRepository;
import com.dotin.dotintasktwo.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {


    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category findById(int Id) {
        Optional<Category> result = categoryRepository.findById(Id);

        Category category;

        if (result.isPresent()) {
            category = result.get();
        } else {
            // we didn't find the employee
            throw new RuntimeException("Did not find category id - " + Id);
        }

        return category;
    }

    @Override
    public void save(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public void deleteById(int Id) {
        categoryRepository.deleteById(Id);
    }
}
