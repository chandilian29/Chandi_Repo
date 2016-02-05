/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.mum.service;

import com.mum.edu.domain.Product;
import com.mum.edu.domain.Stock;
import java.util.List;

/**
 *
 * @author Sandy
 */
public interface ProductService {

    public void addProduct(Product product);

    public Product addProduct(long id, String productName, String productPrice, String productDescription);

    public List<Product> getAll();

    public Product get(long productId);

    public void update(long productID, Product product);

    public void delete(long productId);

    public Product getproduct(String productName);

    public void addStock(Stock stock);
}
