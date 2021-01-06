/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upskill;

/**
 *
 * @author user
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Carta c = new Carta(Carta.EnumCartaTipo.OITO, Carta.EnumCartaNaipe.PAUS);
        System.out.println(c);
        
        Baralho b = new Baralho(Baralho.EnumTipoBaralho.C40);
        System.out.println(b);
        b.baralhar();
        System.out.println(b);
        
        
        MaoDeJogo m = new MaoDeJogo();
        System.out.println(m);
        
        for (int i = 0; i < 10; i++) {
            m.addCarta(b.retirarCarta());
        }
        m.ordenar();
        System.out.println(m);
        int countCartas = 0;
        for (Carta carta : b.getCartas()) {
            countCartas++;
        }
        System.out.println("Total de Cartas no Baralho: " + countCartas);
    }
    
}
