/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upskill.sockettest;

import java.io.BufferedReader;
import java.io.IOException;
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

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                String[] args = {"10000"};
                try {
                    KnockKnockServer.main(args);
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }).start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                String[] args = {"localhost","10000"};
                try {
                    KnockKnockClient.main(args);
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }).start();
    }
    
    /**
     * @param args the command line arguments
     */
    public static void old_main(String[] args) {
//        String hostname = "localhost";
//        int port = 10000;

//        for (port = 1; port < 100; port++) {
//        final int portThread = port;
        new Thread(new Runnable() {
            @Override
            public void run() {
                String[] args = {"10000"};
                try {
                    EchoServer.main(args);
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
                
            }
        }).start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            
        }
        
        new Thread(new Runnable() {
            @Override
            public void run() {
                String[] args = {"localhost", "10000"};
                try {
                    EchoClient.main(args);
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }).start();
//        }
    }

}
// TODO https://stackoverflow.com/questions/15788453/resolving-ip-address-of-a-hostname
// TODO https://docs.oracle.com/javase/tutorial/networking/sockets/readingWriting.html
