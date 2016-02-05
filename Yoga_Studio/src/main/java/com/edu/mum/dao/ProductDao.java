/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.edu.mum.dao;

import com.mum.edu.domain.Product;
import com.mum.edu.domain.Stock;
import java.util.List;

/**
 *
 * @author Sandy
 */
public interface ProductDao {
    public void addProduct(Product product);
    public List<Product> getAll();
    public Product get(long productId);
    public void update(long productID, Product product);
    public void delete(long productId);
    public Product getproduct(String productName);
    public void addStock(Stock stock);
}
