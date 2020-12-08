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
public class CopyFile {

    public static void main(String[] args) {
        int i;
        String firstFile = "first.txt";
        String secondFile = "second.txt";

        //copy a file
        try (FileInputStream fin = new FileInputStream(firstFile);
                FileOutputStream fout = new FileOutputStream(secondFile)) {
            // Attempt to open the files
            do {
                i = fin.read();
                if (i != -1) {
                    fout.write(i);
                }
            } while (i != -1);
        } catch (IOException e) {
            System.out.println("I/O Error: " + e);
        }
    }
}
