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
public class AvgNums {
    public static void main(String[] args) throws IOException{
        // Create a bufferedRead using System.in
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String str;
        int n;
        double sum = 0.0;
        double avg, t;
        
        System.out.print("How many numbers will you enter: ");
        str = br.readLine();
        try {
            n = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            System.out.println("Invalid Format");
            n = 0;
        }
        
        System.out.println("Enter " + n + " values.");
        for (int i = 0; i < n; i++) {
            System.out.print(": ");
            str = br.readLine();
            try {
                t = Double.parseDouble(str);
            } catch (NumberFormatException e) {
                System.out.println("Invalid Format");
                t = 0.0;
            }
            sum += t;
        }
        avg = sum / n;
        System.out.println("Average is " + avg);
    }
    
}
