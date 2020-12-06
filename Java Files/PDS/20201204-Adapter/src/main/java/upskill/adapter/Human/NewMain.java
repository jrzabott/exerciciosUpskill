/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upskill.adapter.Human;

/**
 *
 * @author user
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Food f1 = new Food(false, false, false);
        Food f2 = new Food(false, true, false);
        Food f3 = new Food(false, false, true);
        Food f4 = new Food(true, true, true);

        Human h = new Human("Daniel", "953");
        
        h.eat(f1);
        System.out.println(f1);
        System.out.println("");
        
        h.eat(f2);
        System.out.println(f2);
        System.out.println("");
        
        h.eat(f3);
        System.out.println(f3);
        System.out.println("");
        
        h.eat(f4);
        System.out.println(f4);
        System.out.println("");
        
    }
    
}
