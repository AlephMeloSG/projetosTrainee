package br.com.sgsistemas.udemyproject.service;

import br.com.sgsistemas.udemyproject.model.Category;
import br.com.sgsistemas.udemyproject.model.User;
import br.com.sgsistemas.udemyproject.repository.CategoryRepository;
import br.com.sgsistemas.udemyproject.repository.UserRepository;
import br.com.sgsistemas.udemyproject.service.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    public List<Category> listar() {
        return categoryRepository.findAll();
    }

    public Category listarID(Integer id) {
        Optional<Category> category = categoryRepository.findById(id);
        return category.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public void deleteById(Integer id) {
        categoryRepository.deleteById(id);
    }

    public Category update(Integer id, Category category) {
        Category category1 = categoryRepository.findById(id).get();
        category1.setName(category.getName());
        return categoryRepository.save(category1);
    }

    public Category insert(Category category) {
        categoryRepository.save(category);
        return category;
    }
}