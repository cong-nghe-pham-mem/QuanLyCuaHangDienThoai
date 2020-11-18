/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.github.lgooddatepicker.components.DatePicker;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author DELL
 */
public class DateButton extends JButton {
    
    public DateButton(DatePicker dp) {
        ImageIcon dPickerIcon = new ImageIcon(getClass().getResource("/icons/icons8_calendar_31_30px.png"));
        JButton datePickerButton = dp.getComponentToggleCalendarButton();
        datePickerButton.setText("");
        datePickerButton.setIcon(dPickerIcon);
    }
    
}
