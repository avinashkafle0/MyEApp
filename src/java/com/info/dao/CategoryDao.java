/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.info.dao;

import com.info.model.Category;
import com.info.utils.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

/**
 *
 * @author HP
 */
@Repository
public class CategoryDao {

    public void addCategory(Category category) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        session.save(category);
        session.getTransaction().commit();
        session.close();

    }

    public List<Category> getCategoryList() {

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        Query qry = session.createQuery("from Category");
        List<Category> categoryList = qry.list();
        session.getTransaction().commit();
        session.close();
        return categoryList;
    }

    public Category getCategory(int categoryId) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        Category category = (Category) session.get(Category.class, categoryId);
        session.getTransaction().commit();
        session.close();
        return category;
    }

    public void deleteCategory(int categoryId) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();

        Category category = (Category) session.load(Category.class, categoryId);

        session.delete(category);

        session.getTransaction().commit();
        session.close();

    }

    
     public void updateCategory(Category category) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();

        Category category1 = (Category) session.load(Category.class, category.getCategoryId());
        category1.setCategoryName(category.getCategoryName());
        session.update(category1);

        session.getTransaction().commit();
        session.close();

    }
    
    
}
