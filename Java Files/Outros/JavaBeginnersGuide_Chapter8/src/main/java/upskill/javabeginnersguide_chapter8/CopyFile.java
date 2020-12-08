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
        FileInputStream fin = null;
        FileOutputStream fout = null;
        
        String firstFile = "first.txt";
        String secondFile = "second.txt";
        
        //copy a file
        try {
            // Attempt to open the files
            fin = new FileInputStream(firstFile);
            fout = new FileOutputStream(secondFile);
            
            do {
                i = fin.read();
                if (i != -1) fout.write(i);
            } while (i != -1);
        } catch (IOException e) {
            System.out.println("I/O Error: " + e);
        } finally {
            try {
                if (fin != null) fin.close();
            } catch (IOException e) {
                System.out.println("Error Closing Input File: " + e);
            }
            try {
                if (fout != null) fout.close();
            } catch (IOException e) {
                System.out.println("Error Closing Output File: " + e);
            }
        }
    }
}
