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
        FileInputStream fin;

//        //first make sure that a file has been specified.
//        if (args.length != 1) {
//            System.out.println("Usage: ShowFile File");
//            return;
//        }
        try {
            fin = new FileInputStream("test.txt");
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
            return;
        }

        try {
            // read bytes until EOF is encountered
            do {
                i = fin.read(); // read from file
                if (i != -1) {
                    System.out.print((char) i);
                }
            } while (i != -1); // -1 means EOF

        } catch (IOException e) {
            System.out.println("Error reading file.");
        } finally {
            try {
                fin.close(); // close the file
            } catch (IOException e) {
                System.out.println("Error closing file.");
            }
        }

    }
}
