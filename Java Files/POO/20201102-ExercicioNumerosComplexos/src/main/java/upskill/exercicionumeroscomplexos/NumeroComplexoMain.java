/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upskill.exercicionumeroscomplexos;

/**
 *
 * @author user
 */
public class NumeroComplexoMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        NumeroComplexo n1 = new NumeroComplexo(3, 2);
        NumeroComplexo n2 = new NumeroComplexo(4, 10);
        NumeroComplexo nReal = new NumeroComplexo(5, 0);
        NumeroComplexo nImaginario = new NumeroComplexo(0, 5);
        NumeroComplexo nIgual = new NumeroComplexo(3, 2);
        
        System.out.println("===============================================");
        System.out.println("É real?");
        System.out.println(nReal.isReal());        
        System.out.println(nReal.isImaginario());        
        System.out.println("===============================================");
        System.out.println(nImaginario.isReal());        
        System.out.println(nImaginario.isImaginario());        
        System.out.println("===============================================");
        System.out.println("É igual?");
        System.out.println(n1.isEqual(nIgual));
        System.out.println(n1.isEqual(n2));
        System.out.println("===============================================");
        System.out.println("Modulo");
        System.out.println(n1.modulo());
        System.out.println(n2.modulo());
        System.out.println("===============================================");
        System.out.println("Argumento em Graus e Radianos");
        System.out.println("n1,graus: "+n1.argumentosEmGraus());
        System.out.println("n1.rad: "+n1.argumentosEmRad());
        System.out.println("n2,graus: "+n2.argumentosEmGraus());
        System.out.println("n2,rad: "+n2.argumentosEmRad());
        System.out.println("===============================================");
        System.out.println("Conjugado de n1");
        System.out.println(n1);
        System.out.println(n1.getConjugado());
        System.out.println("===============================================");
        System.out.println("n1 e n2 - Add, Sub, Multi and Div, in order:");
        System.out.println(n1.soma(n2));
        System.out.println(n1.subtracao(n2));
        System.out.println(n1.multiplicacao(n2));
        System.out.println(n1.divisao(n2));
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        
    }
    
}
