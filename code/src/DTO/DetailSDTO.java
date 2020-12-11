/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author FelixNguyen
 */
public class DetailSDTO {
    private int Idsale;

    public DetailSDTO() {
    }

    public DetailSDTO(int Idsale, int idprod, String discount) {
        this.Idsale = Idsale;
        this.idprod = idprod;
        this.discount = discount;
    }
    private int idprod;
    private String discount;

    public int getIdsale() {
        return Idsale;
    }

    public void setIdsale(int Idsale) {
        this.Idsale = Idsale;
    }

    public int getIdprod() {
        return idprod;
    }

    public void setIdprod(int idprod) {
        this.idprod = idprod;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }
}
