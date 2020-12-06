/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */
public class MainObserver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ISubject s = Subject.getInstance();
        
        IObserver o1 = new Observer();
        IObserver o2 = new Observer();
        IObserver o3 = new Observer();
        IObserver o4 = new Observer();
        
        s.addObserver(o1);
        s.addObserver(o3);
        s.addObserver(o4);
        s.setState("Novo estado 1");
        
        s.addObserver(o2);
        s.setState("estado 2");
        s.removeObserver(o1);
        s.removeObserver(o1);
        
        System.out.println(s.getState());
        System.out.println(s);
    }
    
}
