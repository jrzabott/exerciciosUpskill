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
public class ReadBytes {
    public static void main(String[] args) throws IOException{
        byte data[] = new byte[10];
        
        System.out.println("Enter some characters.");
        System.in.read(data);
        System.out.println("You entered: ");
        for (int i = 0; i < data.length; i++) {
            System.out.println((char) data[i]);
        }
    }
}
