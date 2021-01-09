/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upskill.sockettest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String hostname = "www.google.com";
        int port = 80;

//        for (port = 1; port < 100; port++) {
            final int portThread = port;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("port " + portThread);
                    try (
                            Socket echoSocket = new Socket(hostname, portThread);
                            PrintWriter out = new PrintWriter(echoSocket.getOutputStream(), true);
                            BufferedReader in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
                            BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));) {
                        String userInput;
                        while ((userInput = stdIn.readLine()).isEmpty()) {
                            out.println(userInput);
                            System.out.println("echo: " + in.readLine());
                        }
                    } catch (Exception e) {
                        System.out.println(portThread + " - " + e.getMessage());
                    }
                    
                }
            }).start();
            
//        }
    }

}
// TODO https://stackoverflow.com/questions/15788453/resolving-ip-address-of-a-hostname
// TODO https://docs.oracle.com/javase/tutorial/networking/sockets/readingWriting.html