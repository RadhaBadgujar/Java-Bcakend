package com.telusko.SpringEcomProject.service;

import com.telusko.SpringEcomProject.model.Product;
import com.telusko.SpringEcomProject.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepo productRepo;
    public List<Product> getAllProducts() {
return  productRepo.findAll();
    }

    public Product getProductById(int id) {
//        return  productRepo.findById(id).orElse(null);           //1st method return empty product
        return  productRepo.findById(id).orElse(new Product(-1));         //2nd method return empty product
    }

    public Product addProduct(Product product, MultipartFile image) throws IOException {
   //this method res for store data in database
        product.setImageName(image.getOriginalFilename());
        product.setImageType(image.getContentType());
        product.setImageData(image.getBytes());
     return  productRepo.save(product);

    }
}
