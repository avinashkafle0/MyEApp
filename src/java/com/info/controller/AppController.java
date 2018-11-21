/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.info.controller;

import com.info.dao.CategoryDao;
import com.info.dao.GeneralUserDao;
import com.info.dao.ProductDao;
import com.info.model.Category;
import com.info.model.GeneralUser;
import com.info.model.Product;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author HP
 */
@Controller
public class AppController {
    
     @Autowired
    CategoryDao categoryDao;
      @Autowired
    ProductDao productDao;
        @Autowired
    GeneralUserDao generalUserDao;
    
      @RequestMapping(value = {"/","home"}, method = RequestMethod.GET)
    public ModelAndView homePage(){
        
        List<Category> categoryList = categoryDao.getCategoryList();
        List<Product> productList = productDao.getProductList();
        
        ModelAndView mv = new ModelAndView("home");
        mv.addObject("categoryList", categoryList);
        mv.addObject("productList", productList);
        return mv;
    }
    
    
     @RequestMapping(value = {"home/{categoryId}"}, method = RequestMethod.GET)
    public ModelAndView homePage(@PathVariable("categoryId")int categoryId){
        
        List<Category> categoryList = categoryDao.getCategoryList();
        List<Product> productList = productDao.getProductListByCategoryId(categoryId);
        
        ModelAndView mv = new ModelAndView("home");
        mv.addObject("categoryList", categoryList);
        mv.addObject("productList", productList);
        return mv;
    }
    
    
    @RequestMapping(value = {"add-cart/{productId}"} , method = RequestMethod.GET)
    public ModelAndView addToCart(@PathVariable("productId")int productId, HttpSession session){
        
        GeneralUser verifiedGeneralUser = (GeneralUser)session.getAttribute("verifiedGeneralUser");
        
        if(verifiedGeneralUser==null){
            ModelAndView mv = new ModelAndView("signin");
            return  mv;
        }else {
            
             
            List<Product> productsInCart = (ArrayList)session.getAttribute("productsInCart");
            productsInCart.add(productDao.getProduct(productId));
            
            generalUserDao.addGeneralUserProduct(verifiedGeneralUser.getGeneralUserId(), productId);
            
            session.setAttribute("productsInCart", productsInCart);
             ModelAndView mv = new ModelAndView("add-cart");
            return  mv;
        }
        
    
    }
    
    
    
}
