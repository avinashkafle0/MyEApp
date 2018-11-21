/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.info.dao;

import com.info.model.Category;
import com.info.model.GeneralUser;
import com.info.model.Product;
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
public class GeneralUserDao {
    
    public GeneralUser verifyGeneralUser(GeneralUser generalUser){
        GeneralUser verifiedGeneralUser = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        Query qry = session.createQuery("from GeneralUser where generalUserEmail=:generalUserEmail and generalUserPassword=:generalUserPassword");
       qry.setParameter("generalUserEmail", generalUser.getGeneralUserEmail());
       qry.setParameter("generalUserPassword", generalUser.getGeneralUserPassword());
       List<GeneralUser> generalUsersList = qry.list();
       if(generalUsersList!=null && !generalUsersList.isEmpty()){
        verifiedGeneralUser = generalUsersList.get(0);
       }
        session.getTransaction().commit();
        session.close();
       return verifiedGeneralUser;
    }
    
    
    public void addGeneralUserProduct(int generalUserId, int productId){
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        
        GeneralUser generalUser = (GeneralUser)session.load(GeneralUser.class, generalUserId);
        Product product = (Product)session.load(Product.class, productId);
        
        List<Product> productList = new ArrayList<Product>();
        productList.add(product);
        generalUser.setProductList(productList);
        
         List<GeneralUser> generalUserList = new ArrayList<GeneralUser>();
        product.setGeneralUserList(generalUserList);
        
        session.saveOrUpdate(generalUser);
        session.saveOrUpdate(product);
        
        session.getTransaction().commit();
        session.close();
    }
    
    
}
