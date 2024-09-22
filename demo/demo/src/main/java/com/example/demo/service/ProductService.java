package com.example.demo.service;


import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Page<Product> getAllProducts(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }
    public Product updateProduct(Long old_id , Product newProduct)
    {
        Optional<Product>op = productRepository.findById(old_id);
        if(op.isEmpty())
        {
            return null;
        }
        Product oldProduct = op.get();
        oldProduct.setId(old_id);
        oldProduct.setName(newProduct.getName());
        oldProduct.setPrice(newProduct.getPrice());
        oldProduct.setCategory(newProduct.getCategory());
        return productRepository.save(oldProduct);
    }
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
