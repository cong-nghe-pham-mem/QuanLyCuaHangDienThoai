/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package titleCustom;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import static java.awt.Frame.ICONIFIED;
import static java.awt.Frame.MAXIMIZED_BOTH;
import static java.awt.Frame.NORMAL;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Administrator
 */
public class BorderPanel extends JPanel{
    private JLabel close;
    private JLabel mini;
    private JLabel max;
    private JPanel cPanel;
    private ImageIcon minimize;
    private ImageIcon maximize;
    private ImageIcon closeI;
    private ImageIcon restoreDown;
    private int pX;
    private int pY;
    public BorderPanel(JFrame frame){
        /*ComponentResizer cr = new ComponentResizer();
        cr.registerComponent(frame);
        cr.setSnapSize(new Dimension(10,10));*/
        add(customPanel(frame));
    }
    private JPanel customPanel(JFrame frame){
        cPanel = new JPanel();
        //cPanel.setBackground(Color.black);
        minimize = new ImageIcon(new ImageIcon("src/icons/min.png").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
        mini = new JLabel(minimize);
        mini.setOpaque(true);
        mini.setBackground(Color.white);
        mini.setForeground(Color.black);
        mini.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        //maximize = new ImageIcon(new ImageIcon("src/icons/icons8-maximize-window-64.png").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
        //restoreDown = new ImageIcon(new ImageIcon("src/icons/icons8-restore-window-64.png").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
        max = new JLabel(maximize);
        max.setOpaque(true);
        max.setBackground(Color.white);
        max.setForeground(Color.black);
        max.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        closeI = new ImageIcon(new ImageIcon("src/icons/close.png").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
        close = new JLabel(closeI);
        close.setOpaque(true);
        close.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        close.setBackground(Color.white);
        close.setForeground(Color.black);
        cPanel.setLayout(new BorderLayout());
        cPanel.setVisible(true);
        close.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
                if(JOptionPane.showConfirmDialog(frame, "Bạn có muốn thoát chương trình?", "WARNING", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
                    frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));                
                }
            }
            @Override
            public void mouseEntered(MouseEvent e){
                close.setBackground(Color.red);
                close.setForeground(Color.white);
            }
            @Override
            public void mouseExited(MouseEvent e){
                close.setBackground(Color.white);
                close.setForeground(Color.black);
            }
        });
        mini.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
                frame.setState(ICONIFIED);
            }
            @Override
            public void mouseEntered(MouseEvent e){               
                mini.setBackground(Color.gray);
                mini.setForeground(Color.black);
            }
            @Override
            public void mouseExited(MouseEvent e){
                mini.setBackground(Color.white);
                mini.setForeground(Color.black);
            }
        });
        max.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
                if(frame.getExtendedState()==NORMAL) {
                    max.setIcon(restoreDown);
                    frame.setExtendedState(MAXIMIZED_BOTH);
                }
                else {
                    max.setIcon(maximize);
                    frame.setExtendedState(NORMAL);
                }
            }
            @Override
            public void mouseEntered(MouseEvent e){                
                max.setBackground(Color.gray);
                max.setForeground(Color.white);
            }
            @Override
            public void mouseExited(MouseEvent e){
                max.setBackground(Color.white);
                max.setForeground(Color.black);
            }
        });
        JPanel btnPane = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        btnPane.setBackground(Color.white);
        btnPane.add(mini);
        //btnPane.add(max);
        btnPane.add(close);
        cPanel.add(btnPane,BorderLayout.EAST);     
        cPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e){
                pX = e.getX();
                pY = e.getY();
            }            
        });
        cPanel.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e){
                frame.setLocation(frame.getLocation().x + e.getX() - pX, frame.getLocation().y + e.getY() - pY);
            }
        });
        return cPanel;
    }
    public JPanel getCustomPanel(){
        return cPanel;
    }


}
