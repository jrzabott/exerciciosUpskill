/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavBegGui_chapter08;

import java.io.*;

/**
 *
 * @author user
 */
public class ShowFile {

    public static void main(String[] args) {
        int i;
        String fileName = "test.txt";

        try (FileInputStream fin = new FileInputStream(fileName)){

            // read bytes until EOF is encountered
            do {
                i = fin.read(); // read from file
                if (i != -1) {
                    System.out.print((char) i);
                }
            } while (i != -1); // -1 means EOF

        } catch (IOException e) {
            System.out.println("An I/O Error Occurred: " + e);
        } //.
    }
}
