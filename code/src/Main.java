/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import GUI_Bandt.DangNhap;
import java.awt.EventQueue;
/**
 *
 * @author Tuong Vy
 */
public class Main {
    public static void main(String[] args){
        EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
                                        new DangNhap().setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
    }
}
