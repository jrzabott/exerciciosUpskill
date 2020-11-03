/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author user
 */
public class MainData {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Alínea a)
        Data data1 = new Data(2020, 10, 30);
        // Alinea b)
        System.out.println(data1.toString());
        
        // Alínea c)
        Data data2 = new Data(1974, 04, 25);
        
        // Alínea d)
        System.out.println(data2.toAnoMesDiaString());
        
        // Alínea e)
        System.out.println(data1.isMaior(data2));
        
        // Alínea f)
        System.out.println("Distância entre data1 e data2: " + data1.calcularDiferenca(data2));
        
        // Alínea g)
        System.out.println("Faltam para o Natal: " + data1.calcularDiferenca(2020, 12, 25));
        
        // Alínea h)
        System.out.println("25 de Abril de 1974 foi uma: " + data2.determinarDiaDaSemana());
        
        
        // Alínea h)
        int ano1974 = data2.getAno();
        System.out.println((data2.isAnoBissexto(ano1974)) ? "É bissexto": "Não é bissexto.");
        System.out.println((Data.isAnoBissexto(ano1974)) ? "É bissexto": "Não é bissexto.");
        // FIM
        
        
    }
    
}
