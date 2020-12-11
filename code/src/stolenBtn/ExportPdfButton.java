/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stolenBtn;

import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author 
 */
public class ExportPdfButton extends JButton {

    public ExportPdfButton() {
        this.setText("Xuất PDF");
        this.setIcon(new ImageIcon(this.getClass().getResource("/icons/pdf_icon.png")));
    }
}
