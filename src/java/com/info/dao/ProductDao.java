/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.info.dao;

import com.info.model.Category;
import com.info.model.Product;
import com.info.utils.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

/**
 *
 * @author HP
 */
@Repository
public class ProductDao {
    
     public void addProduct(Product product) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        session.save(product);
        session.getTransaction().commit();
        session.close();

    }
    
    
      public List<Product> getProductList() {

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        Query qry = session.createQuery("from Product");
        List<Product> productList = qry.list();
        session.getTransaction().commit();
        session.close();
        return productList;
    }
     
      public Product getProduct(int productId) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        
        Product product = (Product)session.get(Product.class, productId);
        
        session.getTransaction().commit();
        session.close();
        return product;
    }
      
      
        public List<Product> getProductListByCategoryId(int categoryId) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        Query qry = session.createQuery("from Product where category.categoryId=:categoryId");
        qry.setParameter("categoryId", categoryId);
        List<Product> productList = qry.list();
        session.getTransaction().commit();
        session.close();
        return productList;
    }
     
}
