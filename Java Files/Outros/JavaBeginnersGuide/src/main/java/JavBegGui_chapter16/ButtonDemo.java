package JavBegGui_chapter16;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author user
 */
public class ButtonDemo implements ActionListener{
    JLabel jlab;

    public ButtonDemo() {
        JFrame jfrm = new JFrame("A Button Example");
        jfrm.setLayout(new FlowLayout());
        jfrm.setSize(220, 90);
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Make two buttons
        JButton jbtnUp = new JButton("UP");
        JButton jbtnDown = new JButton("DOWN");
        
        jbtnUp.addActionListener(this);
        jbtnDown.addActionListener(this);
        
        jfrm.add(jbtnUp);
        jfrm.add(jbtnDown);
        
        jlab = new JLabel("Press a Button:");
        
        jfrm.add(jlab);
        jfrm.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if (ae.getActionCommand().equals("UP")) {
            jlab.setText("You pressed: UP");
        } else {
            jlab.setText("You pressed: DOWN");
        }
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
         new ButtonDemo();
            }
        });
    }
}
