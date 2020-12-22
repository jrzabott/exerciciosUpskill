/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavBegGui_chapter16;

import javax.swing.*;

/**
 *
 * @author user
 */
public class SwingDemo {

    SwingDemo() {
        JFrame jfrm = new JFrame("A simple Swing Application");

        jfrm.setSize(275, 100);

        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel jlab = new JLabel(" GUI programming with Swing.");

        jfrm.add(jlab);

        jfrm.setVisible(true);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SwingDemo();
            }
        });
    }

}
