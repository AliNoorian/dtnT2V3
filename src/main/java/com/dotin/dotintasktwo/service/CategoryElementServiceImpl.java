package com.dotin.dotintasktwo.service;

import com.dotin.dotintasktwo.dao.CategoryElementRepository;
import com.dotin.dotintasktwo.entity.CategoryElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CategoryElementServiceImpl implements CategoryElementService {

    private final CategoryElementRepository categoryElementRepository;

    @Autowired
    public CategoryElementServiceImpl(CategoryElementRepository categoryElementRepository) {
        this.categoryElementRepository = categoryElementRepository;
    }

    @Override
    public List<CategoryElement> findAll() {
        return categoryElementRepository.findAll();
    }

    @Override
    public CategoryElement findById(int Id) {
        Optional<CategoryElement> result = categoryElementRepository.findById(Id);

        CategoryElement categoryElement;

        if (result.isPresent()) {
            categoryElement = result.get();
        } else {
            // we didn't find the employee
            throw new RuntimeException("Did not find categoryElement id - " + Id);
        }

        return categoryElement;
    }

    @Override
    public void save(CategoryElement categoryElement) {
        categoryElementRepository.save(categoryElement);
    }

    @Override
    public void deleteById(int Id) {
        categoryElementRepository.deleteById(Id);
    }
}
