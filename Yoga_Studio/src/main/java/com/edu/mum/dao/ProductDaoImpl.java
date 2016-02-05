/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.mum.dao;

import com.mum.edu.domain.Product;
import com.mum.edu.domain.Stock;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Sandy
 */
@Transactional
public class ProductDaoImpl implements ProductDao {

    private SessionFactory sf;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sf = sessionFactory;
    }

    @Override
    public void addStock(Stock stock) {
        sf.getCurrentSession().persist(stock);
    }

    @Override
    public void addProduct(Product product) {
        sf.getCurrentSession().persist(product);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void delete(long productId) {
        Product p = get(productId);
        sf.getCurrentSession().delete(p);
    }

    public Product get(long productId) {
        return (Product) sf.getCurrentSession().load(Product.class, productId);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void update(long productID, Product product) {
        Product p = get(productID);
        p.setProductName(product.getProductName());
        p.setProductPrice(product.getProductPrice());
        p.setProductDescription(product.getProductDescription());
    }

    public List<Product> getAll() {
        Query q = sf.getCurrentSession().createQuery("from Product");
        return q.list();
    }

    public Product getproduct(String productName) {
        Query query = sf.getCurrentSession().createQuery("Select p from Product p where p.productName=:productName");
        query.setParameter("productName", productName);
        return (Product) query.list().get(0);
    }
}
