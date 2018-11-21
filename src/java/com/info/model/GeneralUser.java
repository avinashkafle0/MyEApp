/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.info.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

/**
 *
 * @author HP
 */
@Entity
public class GeneralUser implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int generalUserId;
    private String generalUserName;
    private String generalUserEmail;
    private String generalUserPassword;
    
    @ManyToMany
    @JoinTable(name = "generalUserProduct", joinColumns = @JoinColumn(name="generalUserId"), inverseJoinColumns = @JoinColumn(name="productId") )
    private List<Product> productList = new ArrayList();

    /**
     * @return the generalUserId
     */
    public int getGeneralUserId() {
        return generalUserId;
    }

    /**
     * @param generalUserId the generalUserId to set
     */
    public void setGeneralUserId(int generalUserId) {
        this.generalUserId = generalUserId;
    }

    /**
     * @return the generalUserName
     */
    public String getGeneralUserName() {
        return generalUserName;
    }

    /**
     * @param generalUserName the generalUserName to set
     */
    public void setGeneralUserName(String generalUserName) {
        this.generalUserName = generalUserName;
    }

    /**
     * @return the generalUserEmail
     */
    public String getGeneralUserEmail() {
        return generalUserEmail;
    }

    /**
     * @param generalUserEmail the generalUserEmail to set
     */
    public void setGeneralUserEmail(String generalUserEmail) {
        this.generalUserEmail = generalUserEmail;
    }

    /**
     * @return the generalUserPassword
     */
    public String getGeneralUserPassword() {
        return generalUserPassword;
    }

    /**
     * @param generalUserPassword the generalUserPassword to set
     */
    public void setGeneralUserPassword(String generalUserPassword) {
        this.generalUserPassword = generalUserPassword;
    }

    /**
     * @return the productList
     */
    public List<Product> getProductList() {
        return productList;
    }

    /**
     * @param productList the productList to set
     */
    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
    
    
    
    
}
