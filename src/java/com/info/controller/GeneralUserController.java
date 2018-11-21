/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.info.controller;

import com.info.dao.GeneralUserDao;
import com.info.model.GeneralUser;
import com.info.model.Product;
import java.util.ArrayList;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author HP
 */
@Controller
@SessionAttributes({"verifiedGeneralUser", "productsInCart"})
public class GeneralUserController {

    @Autowired
    GeneralUserDao generalUserDao;

    @RequestMapping(value = "verify-general-user", method = RequestMethod.POST)
    public ModelAndView verifyController(@ModelAttribute GeneralUser generalUser, HttpSession session) {

        GeneralUser verifiedGeneralUser = generalUserDao.verifyGeneralUser(generalUser);
       
        if (verifiedGeneralUser == null) {
            ModelAndView mv = new ModelAndView("signin");
            return mv;
        } else {

            ModelAndView mv = new ModelAndView("redirect:home");
            mv.addObject("verifiedGeneralUser", verifiedGeneralUser);
            mv.addObject("productsInCart", new ArrayList<Product>());
            return mv;
        }
    }

}
