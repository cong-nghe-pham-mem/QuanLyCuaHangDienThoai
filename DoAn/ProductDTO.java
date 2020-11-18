/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.io.Serializable;

/**
 *
 * @author FelixNguyen
 */
public class ProductDTO implements Serializable{
    private int idProd;
    private String nameProd;
    private String description;
    private int price;
    private int SL;

    public ProductDTO(int idProd, String nameProd, String description, int price, int SL) {
        this.idProd = idProd;
        this.nameProd = nameProd;
        this.description = description;
        this.price = price;
        this.SL = SL;
    }

    public ProductDTO(String nameProd, String description, int price, int SL) {
        this.nameProd = nameProd;
        this.description = description;
        this.price = price;
        this.SL = SL;
    }
    public ProductDTO() {
        
    }

    public int getIdProd() {
        return idProd;
    }

    public void setIdProd(int idProd) {
        this.idProd = idProd;
    }

    public String getNameProd() {
        return nameProd;
    }

    public void setNameProd(String nameProd) {
        this.nameProd = nameProd;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getSL() {
        return SL;
    }

    public void setSL(int SL) {
        this.SL = SL;
    }

}
