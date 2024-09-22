package com.example.demo.service;



import com.example.demo.model.Category;
import com.example.demo.model.Product;
import com.example.demo.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public Page<Category> getAllCategories(Pageable pageable) {
        return categoryRepository.findAll(pageable);
    }

    public Category getCategoryById(Long id) {
        Optional<Category> op = categoryRepository.findById((id));
        return op.get();
    }

    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }
    public Category updateCategory(Long old_id , Category newCategory)
    {
        Optional<Category>op = categoryRepository.findById(old_id);
        if(op.isEmpty())
        {
            return null;
        }
        Category oldCategory = op.get();
        oldCategory.setId(old_id);
        oldCategory.setName(newCategory.getName());
        return categoryRepository.save(oldCategory);
    }

    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }
}
