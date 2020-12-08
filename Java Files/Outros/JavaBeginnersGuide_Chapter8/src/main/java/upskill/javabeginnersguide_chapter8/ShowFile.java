/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upskill.javabeginnersguide_chapter8;

import java.io.*;

/**
 *
 * @author user
 */
public class ShowFile {

    public static void main(String[] args) {
        int i;
        FileInputStream fin = null;

        try {
            fin = new FileInputStream("test.txt");

            // read bytes until EOF is encountered
            do {
                i = fin.read(); // read from file
                if (i != -1) {
                    System.out.print((char) i);
                }
            } while (i != -1); // -1 means EOF

        } catch (FileNotFoundException e) {
            System.out.println("File not Found.");
        } catch (IOException e) {
            System.out.println("An I/O Error Occurred");
        } finally {
            // close the file in all cases
            try {
                if (fin != null) {
                    fin.close(); // close the file
                }
            } catch (IOException e) {
                System.out.println("Error closing file.");
            }
        }

    }
}
