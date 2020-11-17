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

public class DetailOrDTO {

    private int idOrder;
    private int idProd;
    private int sl;
    private int money;
    private String Orderstatus;

    public DetailOrDTO() {
    }

    public DetailOrDTO(int idOrder, int idProd, int sl, int money, String Orderstatus) {
        this.idOrder = idOrder;
        this.idProd = idProd;
        this.sl = sl;
        this.money = money;
        this.Orderstatus = Orderstatus;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    
    
    
    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public int getIdProd() {
        return idProd;
    }

    public void setIdProd(int idProd) {
        this.idProd = idProd;
    }

    public int getSl() {
        return sl;
    }

    public void setSl(int sl) {
        this.sl = sl;
    }


    public String getOrderstatus() {
        return Orderstatus;
    }

    public void setOrderstatus(String Orderstatus) {
        this.Orderstatus = Orderstatus;
    }
    
}
