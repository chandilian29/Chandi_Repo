/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mum.edu.domain;

import java.util.HashMap;
import java.util.Map;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

/**
 *
 * @author Sandy
 */
@Entity
public class ProductCatalog {
    @Id
    @GeneratedValue
    private long id;
    @OneToMany(cascade =CascadeType.ALL)
    @JoinColumn(name ="product_id")
    Map<Product,Integer> map=new HashMap<Product,Integer>();;

    
    public void addProduct(Product product, Integer quantity){
        map.put(product,quantity);
    }
    
    
    public ProductCatalog() {
    }

    public ProductCatalog(long id, Map<Product, Integer> map) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Map<Product, Integer> getMap() {
        return map;
    }

    public void setMap(Map<Product, Integer> map) {
        this.map = map;
    }
    
}
