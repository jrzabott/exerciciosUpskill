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
public class RandomAccessDemo {
    public static void main(String[] args) {
        double data[] =  { 19.4 , 10.1 , 123.54 , 33.0 , 87.9 , 74.25 };
        double d;
        
        // Open and use a random access file
        try (RandomAccessFile raf = new RandomAccessFile("random.txt", "rw")) {
            // write values to the file
            for (double e : data) {
                raf.writeDouble(e);
            }
            
            // now lets read back specific values
            raf.seek(0); //seek the first double
            d = raf.readDouble();
            System.out.println("First value is: " + d);
            
            raf.seek(8); //seek the second double
            d = raf.readDouble();
            System.out.println("Second value is: " + d);
            
            raf.seek(8 * 3); //seek the fourth double
            d = raf.readDouble();
            System.out.println("Second value is: " + d);
            
            System.out.println();
            
            // Now, read every other value
            System.out.println("Here is every other value: ");
            for (int i = 0; i < data.length; i+= 2) {
                raf.seek(8 * i);
                d = raf.readDouble();
                System.out.print(d + " ");
            }
            
        } catch (IOException e) {
            System.out.println("I/O Error: " + e);
        }
    }
}
