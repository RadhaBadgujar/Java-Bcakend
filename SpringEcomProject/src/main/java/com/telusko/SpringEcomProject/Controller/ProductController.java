package com.telusko.SpringEcomProject.Controller;

import com.telusko.SpringEcomProject.service.ProductService;
import com.telusko.SpringEcomProject.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin


public class ProductController {
    @Autowired
    private ProductService productService;

//    @GetMapping("/Products")
//    public List<Product> getProducts(){
//        return  productService.getAllProducts();
@GetMapping("/Products")               //for update status -code use ResponseEntity-Method
public ResponseEntity<List<Product>> getProducts(){
    return new  ResponseEntity<>( productService.getAllProducts(), HttpStatus.ACCEPTED);
    }
    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable int id){
    Product product=productService.getProductById(id);
//    if(product !=null)
        if(product.getId()>0)
    return  new ResponseEntity<>(product,HttpStatus.OK);
    else
        return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
 }

     @PostMapping("/product")
     public ResponseEntity<?> addProduct(@RequestPart Product product, @RequestPart MultipartFile imageFile) {
         Product savedProduct = null;
         try {
             savedProduct = productService.addProduct(product, imageFile);
             return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
         } catch (IOException e) {
             return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
         }

     }


 }


