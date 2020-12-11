/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.util.Date;

/**
 *
 * @author FelixNguyen
 */
public class SaleDTO {
    private int idsale;
    private Date startsale;
    private Date endsale;
    private String typeofprog;
    private String promotion;

    public SaleDTO() {
    }

    public SaleDTO(int idsale, Date startsale, Date endsale, String typeofprog, String promotion) {
        this.idsale = idsale;
        this.startsale = startsale;
        this.endsale = endsale;
        this.typeofprog = typeofprog;
        this.promotion = promotion;
    }

    public int getIdsale() {
        return idsale;
    }

    public void setIdsale(int idsale) {
        this.idsale = idsale;
    }

    public Date getStartsale() {
        return startsale;
    }

    public void setStartsale(Date startsale) {
        this.startsale = startsale;
    }

    public Date getEndsale() {
        return endsale;
    }

    public void setEndsale(Date endsale) {
        this.endsale = endsale;
    }

    public String getTypeofprog() {
        return typeofprog;
    }

    public void setTypeofprog(String typeofprog) {
        this.typeofprog = typeofprog;
    }

    public String getPromotion() {
        return promotion;
    }

    public void setPromotion(String promotion) {
        this.promotion = promotion;
    }

}
