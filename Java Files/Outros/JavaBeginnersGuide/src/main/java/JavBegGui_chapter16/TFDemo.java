/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavBegGui_chapter16;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author user
 */
public class TFDemo implements ActionListener{

    JTextField jtf;
    JButton jbtnRev;
    JLabel jlabPrompt, jlabContents;
    
    public TFDemo() {
        JFrame jfrm = new JFrame("Use a Text Field");
        
        jfrm.setLayout(new FlowLayout());
        jfrm.setSize(240, 120);
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        jtf = new JTextField(10);
        jtf.setText("myTF");
        
        jbtnRev = new JButton("Reverse");
        
        jtf.addActionListener(this);
        jbtnRev.addActionListener(this);
        
        jlabPrompt = new JLabel("Enter text: ");
        jlabContents = new JLabel("");
        
        jfrm.add(jlabPrompt);
        jfrm.add(jtf);
        jfrm.add(jbtnRev);
        jfrm.add(jlabContents);
        
        jfrm.setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getActionCommand().equals("Reverse")) {
            String orgString = jtf.getText();
            String resStr = "";
            
            for (int i = orgString.length() - 1; i >= 0; i--) {
                resStr += orgString.charAt(i);
            }
            
            jtf.setText(resStr);
        } else {
            jlabContents.setText("You pressed ENTER. Text is: '" + jtf.getText() + "'");
        }
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
         new TFDemo();
            }
        });
    }
}
