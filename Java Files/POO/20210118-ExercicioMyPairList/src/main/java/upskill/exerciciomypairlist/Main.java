/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upskill.exerciciomypairlist;

/**
 *
 * @author user
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MyPairList list = new MyPairList();
        list.addPair(new String("Daniel"), new Integer(34));
        list.addPair(new String("Daniel"), new Integer(34));
        list.addPair(new String("Daniel"), new Integer(36));
        list.addPair(new String("Junior"), new Integer(32));
        list.addPair(new String("Junior"), new Integer(32));
        list.addPair(new String("Afranio"), new Integer(33));
        
        System.out.println("--- Lista inicial");
        System.out.println(list.toString());

        list.ordenarListaELimparDuplicados();
        
        System.out.println("--- Lista Limpar e Ordenada");
        System.out.println(list.toString());
        
        Pair samplePair = new Pair(new String("Junior"), new Integer(30));
        System.out.println("--- Lista dos objetos maiores que um obj Pair: " + samplePair.toString());
        System.out.println(list.listaDosObjetosMaioresQue(samplePair).toString());
        Pair samplePair2 = new Pair(new String("Daniel"), new Integer(34));
        System.out.println("--- Lista dos objetos maiores que um obj Pair: " + samplePair2.toString());
        System.out.println(list.listaDosObjetosMaioresQue(samplePair2).toString());
        
        String firstParameter = new String("Daniel");
        System.out.println("--- Lista dos valores do segundo atributo em quem o primeiro atributo é igual a: " + firstParameter);
        System.out.println(list.listaDosObjetosComPrimeiroElementoIgualA(firstParameter).toString());
    }
    
}
