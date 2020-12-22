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
public class CBDemo implements ItemListener {

    JLabel jlabSelected;
    JLabel jlabChanged;
    JCheckBox jcbAlpha;
    JCheckBox jcbBeta;
    JCheckBox jcbGamma;

    public CBDemo() {
        JFrame jfrm = new JFrame("Demonstrate Check Boxes");
        
        // Frame properties
        jfrm.setLayout(new FlowLayout());
        jfrm.setSize(280,120);
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Labels
        jlabSelected = new JLabel("");
        jlabChanged = new JLabel("");
        
        // Checkboxes
        jcbAlpha = new JCheckBox("Alpha");
        jcbBeta = new JCheckBox("Beta");
        jcbGamma = new JCheckBox("Gamma");
        
        // Event Listeners
        jcbAlpha.addItemListener(this);
        jcbBeta.addItemListener(this);
        jcbGamma.addItemListener(this);
        
        // Adding everything to the Frame
        jfrm.add(jcbAlpha);
        jfrm.add(jcbBeta);
        jfrm.add(jcbGamma);
        jfrm.add(jlabChanged);
        jfrm.add(jlabSelected);
        
        // make it appea on screen
        jfrm.setVisible(true);
    }
    
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CBDemo();
            }
        });
    }

    @Override
    public void itemStateChanged(ItemEvent ie) {
        String str = "";
        
        // Reference to the Checkbox that fired the event.
        JCheckBox cb = (JCheckBox) ie.getItem();
        
        if (cb.isSelected()) {
            jlabChanged.setText(cb.getText() + " was just selected.");
        } else {
            jlabChanged.setText(cb.getText() + " was just cleared.");
        }
        
        // Report all selected cheboxes:
        if (jcbAlpha.isSelected()) {
            str += "Alpha ";
        }
        if (jcbBeta.isSelected()) {
            str += "Beta ";
        }
        if (jcbGamma.isSelected()) {
            str += "Gamma ";
        }
        
        jlabSelected.setText("Selected check boxes: " + str);
    }
}
