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
public class OrderDTO {
    private int IdOrder;
    private int Id;
    private String manv;
    private String time;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public OrderDTO(int IdOrder, int Id, String manv, int Totalmoney, String Orderdate, String time) {
        this.IdOrder = IdOrder;
        this.Id = Id;
        this.manv = manv;
        this.Totalmoney = Totalmoney;
        this.Orderdate = Orderdate;
        this.time = time;
    }

    public String getManv() {
        return manv;
    }

    public void setManv(String manv) {
        this.manv = manv;
    }

    public OrderDTO() {
    }

    public OrderDTO(int IdOrder, int Id, int Totalmoney, String Orderdate, String time) {
        this.IdOrder = IdOrder;
        this.Id = Id;
        this.Totalmoney = Totalmoney;
        this.Orderdate = Orderdate;
        this.time = time;
    }
    private int Totalmoney;
    private String Orderdate;

    public int getIdOrder() {
        return IdOrder;
    }

    public void setIdOrder(int IdOrder) {
        this.IdOrder = IdOrder;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }


    public int getTotalmoney() {
        return Totalmoney;
    }

    public void setTotalmoney(int Totalmoney) {
        this.Totalmoney = Totalmoney;
    }

    public String getOrderdate() {
        return Orderdate;
    }

    public void setOrderdate(String Orderdate) {
        this.Orderdate = Orderdate;
    }
}
