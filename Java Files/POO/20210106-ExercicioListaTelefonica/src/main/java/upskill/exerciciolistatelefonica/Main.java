/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upskill.exerciciolistatelefonica;

/**
 *
 * @author user
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Contacto c1 = new Contacto("Manuel", "933333333", "manuel@exemplo.pt");
        Contacto c2 = new Contacto("António", "966666666", "antonio@exemplo.pt");
        Contacto c3 = new Contacto("Joaquim", "911111111", "joaquimg@exemplo.pt");
        
//        System.out.println(c);
        
        ListaTelefonica lt = new ListaTelefonica();
        
        lt.novoContacto(c1);
        lt.novoContacto(c2);
        lt.novoContacto(c3);
        
        for (Contacto con : lt.getLista()) {
            System.out.println(con);
        }
        
        System.out.println("");
        System.out.println(lt.getLista());
        
    }
    
}
