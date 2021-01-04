/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavBegGui_chapter16;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

/**
 *
 * @author user
 */
public class SwingFC {

    JTextField tfFirst; // file 1
    JTextField tfSecond; // file 2

    JButton btnComp;

    JLabel lblFirst, lblSecond; // Prompts
    JLabel lblResult; // Results and Error messages

    public SwingFC() {
        JFrame frame = new JFrame("Compare Files");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        frame.setSize(200, 190);

        tfFirst = new JTextField(14);
        tfSecond = new JTextField(14);

        tfFirst.setActionCommand("fileA");
        tfSecond.setActionCommand("fileB");

        btnComp = new JButton("Compare");
        btnComp.addActionListener((e) -> {
            int i, j;
            i = j = 0;

            //c confirm file names are filled:
            if (tfFirst.getText().equals("")) {
                lblResult.setText("First file name is missing;");
                return;
            }
            if (tfSecond.getText().equals("")) {
                lblResult.setText("Second file name is missing;");
                return;
            }

            // compare files
            try (
                    FileInputStream f1 = new FileInputStream(tfFirst.getText());
                    FileInputStream f2 = new FileInputStream(tfSecond.getText())) {
                // check the content of each file:
                do {
                    i = f1.read();
                    j = f2.read();
                    if (i != j) {
                        break;
                    }
                } while (i != -1 && j != -1);

                if (i != j) {
                    lblResult.setText("Files are not the same.");
                } else {
                    lblResult.setText("Files compare equal.");
                }

            } catch (IOException ex) {
                lblResult.setText("File Error: " + ex.getMessage());
            }
        });

        lblFirst = new JLabel("First File: ");
        lblSecond = new JLabel("Second File: ");
        lblResult = new JLabel("");

        // everything to content;
        frame.add(lblFirst);
        frame.add(tfFirst);
        frame.add(lblSecond);
        frame.add(tfSecond);
        frame.add(btnComp);
        frame.add(lblResult);

        frame.setVisible(true);
    }

//    @Override
//    public void actionPerformed(ActionEvent e) {
//        int i, j;
//        i = j = 0;
//
//        //c confirm file names are filled:
//        if (tfFirst.getText().equals("")) {
//            lblResult.setText("First file name is missing;");
//            return;
//        }
//        if (tfSecond.getText().equals("")) {
//            lblResult.setText("Second file name is missing;");
//            return;
//        }
//
//        // compare files
//        try (
//                FileInputStream f1 = new FileInputStream(tfFirst.getText());
//                FileInputStream f2 = new FileInputStream(tfSecond.getText())) {
//            // check the content of each file:
//            do {
//                i = f1.read();
//                j = f2.read();
//                if (i != j) {
//                    break;
//                }
//            } while (i != -1 && j != -1);
//
//            if (i != j) {
//                lblResult.setText("Files are not the same.");
//            } else {
//                lblResult.setText("Files compare equal.");
//            }
//
//        } catch (IOException ex) {
//            lblResult.setText("File Error: " + ex.getMessage());
//        }
//    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SwingFC();
            }
        });
    }
}
