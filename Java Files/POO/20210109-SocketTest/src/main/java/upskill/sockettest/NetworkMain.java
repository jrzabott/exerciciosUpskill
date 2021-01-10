/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upskill.sockettest;

import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Collections;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 *
 * @author user
 */
public class NetworkMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Enumeration<NetworkInterface> e = NetworkInterface.getNetworkInterfaces();
            for (NetworkInterface ni : Collections.list(e)) {
                System.out.println(ni.getDisplayName() + " - " + ni.getName());
            }
            
        } catch (SocketException ex) {
            System.out.println(ex.getMessage());
        }
        
    }
    
}
