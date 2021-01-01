/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chapter05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 *
 * @author user
 */
public class GameHelper {
    private static final String alphabet = "abcdefg";
    private int gridLength = 7;
    private int gridSize = 49;
    private int grid[] = new int[gridSize];
    private int comCount = 0;

    public String getUserInput(String prompt) {
        String inputLine = null;
        System.out.println(prompt + " ");
        try {
            BufferedReader is = new BufferedReader(
                    new InputStreamReader(System.in));
            inputLine = is.readLine();
            if (inputLine.length() == 0) {
                return null;
            }
        } catch (IOException e) {
            System.out.println("IOException: " + e);
        }
        return inputLine.toLowerCase();
    }

    ArrayList<String> placeDotCom(int comSize) {
        ArrayList<String> alphaCells = new ArrayList<>(); // hold coordinates
        
        String temp = null; // temp var for concat
        int coords[] = new int[comSize]; // current candidate coords
        int attempts = 0; // current attempts counters
        boolean success = false; // flag = found a good location?
        int location = 0; // current start location
        
        comCount++; // nth DotCom to place
        int incr = 1; // horizontal increment
        if ((comCount % 2) == 1) {  //if object is odd, place vertically
            incr = gridLength; // set vertical incr
        }
        
        while (!success & attempts++ < 200) { // main search loop
            location = (int) (Math.random() * gridSize); // get random start position
            System.out.print(" try " + location);
            int x = 0; // nth position in dot com to place
            success = true; // assume success
            while(success && x < comSize) { //look for adjacent unused spots
                if (grid[location] == 0) { // if not already used
                    coords[x++] = location; // save location
                    location += incr;   // try next adjacent spot
                    if (location >= gridSize) { // out of bounds (bottom)
                        success = false; // failure
                    }
                    if (x > 0 && (location % gridLength == 0)) { // out of bounds  (right edge)
                        success = false; // failure
                    }
                } else { // location already in use
                    System.out.print("used " + location);
                    success = false; // failure again
                }
            } // end of while
        }
        // turn location into alpha coords
        int x = 0;
        int row = 0;
        int column = 0;
        
        System.out.println();
        
        while (x < comSize) {            
            grid[coords[x]] = 1; // mark master grid pts as "used"
            row = (int) (coords[x] / gridLength); // get row value
            column = coords[x] % gridLength; // get numeric column value
            temp = String.valueOf(alphabet.charAt(column)); // convert to alpha
            alphaCells.add(temp.concat(Integer.toString(row)));
            x++;
            System.out.print(" coord " + x + " = " + alphaCells.get(x - 1));
        }
        System.out.println();
        return alphaCells;
    }
}
