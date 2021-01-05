/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upskill.exercicioempregado;

import upskill.utilitarios.Data;
import upskill.utilitarios.Tempo;

/**
 *
 * @author user
 */
public class MainEmpregado {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Data d1 = new Data();
        System.out.println("\n#### 4.a) ####");
        System.out.println(d1);
        
        Tempo t1 = new Tempo();
        Tempo t2 = new Tempo();
        System.out.println("\n#### 4.b) ####");
        System.out.println(t1);
        System.out.println(t2);
        
        Empregado e1 = new Empregado("primeiro", "empregado", d1, t1, t2);
        Empregado e2 = new Empregado("primeiro", "empregado", d1, t1, t2);
        System.out.println("\n#### 4.d) ####");
        
        System.out.println(
                e1.getDataContrato().hashCode() + " / " + e2.getDataContrato().hashCode()
        );
        
        System.out.println("e1.getDataContrato().equals(e2.getDataContrato())");
        System.out.println(e1.getDataContrato().equals(e2.getDataContrato()));
        System.out.println("e1.getDataContrato()");
        System.out.println(e1.getDataContrato());
        System.out.println("e2.getDataContrato()");
        System.out.println(e2.getDataContrato());
        System.out.println("--- Changing Date: d1.setData(2021, 1, 5); ---");
        d1.setData(2021, 1, 5);
        System.out.println("e1.getDataContrato().equals(e2.getDataContrato())");
        System.out.println(e1.getDataContrato().equals(e2.getDataContrato()));
        System.out.println("e1.getDataContrato()");
        System.out.println(e1.getDataContrato());
        System.out.println("e2.getDataContrato()");
        System.out.println(e2.getDataContrato());
        
        
        System.out.println("\n#### 4.e) ####");
        System.out.println("e1.getHoraEntrada().equals(e2.getHoraEntrada())");
        System.out.println(e1.getHoraEntrada().equals(e2.getHoraEntrada()));
        System.out.println("e1.getHoraEntrada()");
        System.out.println(e1.getHoraEntrada());
        System.out.println("e2.getHoraEntrada()");
        System.out.println(e2.getHoraEntrada());
        System.out.println("--- Changing t1: t1.setHoras(3);");
        t1.setHoras(3);
        System.out.println("e1.getHoraEntrada().equals(e2.getHoraEntrada())");
        System.out.println(e1.getHoraEntrada().equals(e2.getHoraEntrada()));
        System.out.println("e1.getHoraEntrada()");
        System.out.println(e1.getHoraEntrada());
        System.out.println("e2.getHoraEntrada()");
        System.out.println(e2.getHoraEntrada());
        
        
        
    }
    
}
