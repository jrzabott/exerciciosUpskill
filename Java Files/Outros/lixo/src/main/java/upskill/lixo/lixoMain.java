/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upskill.lixo;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author user
 */
public class lixoMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        testArrayList tal = new testArrayList(22);
        tal.Atletas.add("Teste");
        System.out.println(tal);

        
//        JFrame frame = new JFrame("My 1st Frame");
//        frame.add(new mainJPanel());
//        frame.setSize(400, 400);
//        frame.setVisible(true);
//        frame.addWindowListener(new WindowAdapter() {
//            @Override
//            public void windowClosing(WindowEvent e) {
//                super.windowClosing(e);
//                frame.dispose();
//            }
//        });

    }


}
