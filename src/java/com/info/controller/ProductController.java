/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.info.controller;

import com.info.dao.CategoryDao;
import com.info.dao.ProductDao;
import com.info.model.Category;
import com.info.model.Product;

import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author HP
 */
@Controller
public class ProductController {
    
    @Autowired
    ProductDao productDao;
    
     @Autowired
    CategoryDao categoryDao;
    
    @RequestMapping(value = {"product-form"}, method = RequestMethod.GET)
    public ModelAndView productForm(){
        
        List<Category> categoryList = categoryDao.getCategoryList();
        
        ModelAndView mv = new ModelAndView("product-form");
        mv.addObject("categoryList", categoryList);
        return mv;
    }
    
     @RequestMapping(value = {"add-product"}, method = RequestMethod.POST)
    public ModelAndView addProduct(@ModelAttribute Product product, 
            @RequestParam(value = "image", required = false) MultipartFile image, HttpServletRequest request ){
        
        product.setProductImage(product.getProductCode()+".jpeg");
        
        
        String	rootDirectory	=request.getSession().getServletContext().getRealPath("/");
		System.out.println("5--->>>" + rootDirectory);
		
		File reportLocation = new File(rootDirectory+"/photo/" + product.getProductImage() + "/");
		
		try {
			FileUtils.writeByteArrayToFile(reportLocation, image.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        productDao.addProduct(product);
        List<Product> productList = productDao.getProductList();
        ModelAndView mv = new ModelAndView("product-list");
        mv.addObject("productList", productList);
        return mv;
    }
        
    
    
    
    
    
}
