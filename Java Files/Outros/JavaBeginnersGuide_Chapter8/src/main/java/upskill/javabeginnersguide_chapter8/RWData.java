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
public class RWData {
    public static void main(String[] args) {
        int i = 10;
        double d = 1023.56;
        boolean b = true;
        String fileName = "testDataStream.txt";
        
        // Write some values.
        try (DataOutputStream dataOut = new DataOutputStream(new FileOutputStream(fileName))) {
            System.out.println("Writing: " + i);
            dataOut.writeInt(i);
            
            System.out.println("Writing: " + d);
            dataOut.writeDouble(d);
            
            System.out.println("Writing: " + b);
            dataOut.writeBoolean(b);
            
            System.out.println("Writing: " + 12.2 * 7.4);
            dataOut.writeDouble(12.2 * 7.4);
            
        } catch (IOException e) {
            System.out.println("Write Error: " + e);
            return;
        }
        
        System.out.println();
        
        // Now, read them back.
        
        try (DataInputStream dataIn = new DataInputStream(new FileInputStream(fileName))) {
            i = dataIn.readInt();
            System.out.println("Reading " + i);
            
            d = dataIn.readDouble();
            System.out.println("Reading " + d);
            
            b = dataIn.readBoolean();
            System.out.println("Reading " + b);
            
            d = dataIn.readDouble();
            System.out.println("Reading " + d);
            
        } catch (IOException e) {
            System.out.println("Read Error: " + e);
            return;
        }
    }
}
