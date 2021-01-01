/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavBegGui_chapter16;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;


/**
 *
 * @author user
 */
public class ListDemo implements ListSelectionListener{

    JList<String> list;
    JLabel label;
    JScrollPane scrollPanel;
    
    String names[] = {
        "Sherry", "Jon", "Rachel", "Sasha", "Josselyn", "Randy", "Tom", "Mary",
        "Ken", "Andrew", "Matt", "Todd"
    };
    
    public ListDemo() {
        // Frame
        JFrame frame = new JFrame("JList Demo");
        
        // Frame props
        frame.setLayout(new FlowLayout());
        frame.setSize(250, 160);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Populating the list component
        list = new JList<String>(names);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // Setting list pop - single selection only
        
        // Create the scroll panel and inserting the list into it.
        scrollPanel = new JScrollPane(list);
        
        // scroll panels props
        scrollPanel.setPreferredSize(new Dimension(200, 120));
        
        label = new JLabel("Please choose a name");
        
        list.addListSelectionListener(this); // setting the listener
        
        frame.add(scrollPanel); // will this include the "list"?
        frame.add(label);
        frame.setVisible(true);
    }

    
    
    @Override
    public void valueChanged(ListSelectionEvent e) {
        // get the index of the changed item:
        int index = list.getSelectedIndex();
        
        // display selection if the item was selected.
        if (index != -1) {
            label.setText("Current Selection: " + names[index]);
        } else
            label.setText("Please choose a name");
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ListDemo();
            }
        });
    }
    
}
