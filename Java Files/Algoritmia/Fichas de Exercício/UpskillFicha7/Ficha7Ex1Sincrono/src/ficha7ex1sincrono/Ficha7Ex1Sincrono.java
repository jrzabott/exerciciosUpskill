/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ficha7ex1sincrono;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author user
 */
public class Ficha7Ex1Sincrono {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        
        String[] nomes = new String[20];
        double soma = 0;
        double[] vencimentos = new double[20];
        int nElem = 0;
        Scanner fichFunc = new Scanner(new File("funcionarios.txt"));
        while (fichFunc.hasNextLine()) {            
            String linha = fichFunc.nextLine();
            
            String[] vetLinha = linha.split(",");
            nomes[nElem] =vetLinha[0];
            vencimentos[nElem] = Double.parseDouble(vetLinha[1].trim());
            soma += vencimentos[nElem];
            nElem++;
        }
        fichFunc.close();
        double media = soma / nElem;
        System.out.println("Nomes de func. com " + "vencimento > media + (" + media + ")");
        for (int i = 0; i < nElem; i++) {
            if(vencimentos[i] > media) {
                System.out.println(nomes[i] + " - €" +vencimentos[i]);
            }
        }
    }
    
}
