package br.com.sgsistemas.udemyproject.service;

import br.com.sgsistemas.udemyproject.model.Product;
import br.com.sgsistemas.udemyproject.model.User;
import br.com.sgsistemas.udemyproject.repository.ProductRepository;
import br.com.sgsistemas.udemyproject.service.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public List<Product> listar() {
        return productRepository.findAll();
    }

    public Product listarID(Integer id) {
        Optional<Product> product = productRepository.findById(id);
        return product.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public void deleteById(Integer id) {
        productRepository.deleteById(id);
    }

    public Product update(Integer id, Product product) {
        Product product1 = productRepository.findById(id).get();
        dataUpdate(product1,product);
        return productRepository.save(product1);
    }

    private void dataUpdate(Product product1, Product product) {
        product1.setName(product.getName());
        product1.setDescription(product.getDescription());
        product1.setPrice(product.getPrice());
        product1.setImgUrl(product.getImgUrl());
    }

    public Product insert(Product product) {
        productRepository.save(product);
        return product;
    }
}
