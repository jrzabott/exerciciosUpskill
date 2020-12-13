/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upskill.javabeginnersguide_chapter8;

/**
 *
 * @author user
 */
public class SumArray {
    private int sum;
    
    synchronized int sumArray(int nums[]){
//    int sumArray(int nums[]){
        sum = 0; // reset sum
        
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            System.out.println(String.format("Running total for %s is %d", Thread.currentThread().getName(), sum));
            
            try {
                Thread.sleep(50); //Allow task switch
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted.");
            }
        }
        return sum;
    }
}
