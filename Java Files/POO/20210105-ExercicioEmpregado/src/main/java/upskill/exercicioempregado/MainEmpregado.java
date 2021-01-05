/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upskill.exercicioempregado;

import java.util.ArrayList;
import java.util.List;
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
        Empregado e2 = new Empregado("segundo", "empregado", d1, t1, t2);
        System.out.println("\n#### 4.d) ####");
        
        System.out.println(
                "HashCode dos Objetos Data: " + 
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
        System.out.println(
                "HashCode dos Objetos Tempo t1 (hora de entrada): " + 
                e1.getHoraEntrada().hashCode() + " / " + e2.getHoraEntrada().hashCode()
        );
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
        
        System.out.println("\n#### 4.f) ####");
        // Já feito acima
        
        
        System.out.println("\n#### 4.g) ####");
        System.out.println(String.format("%s%n%s%n%s%n%s%n%s%n", d1, t1, t2, e1, e2));
        
        System.out.println("\n#### 4.h) ####");
        System.out.println("A criar 2 novos empregados que não partilhem referências...");
        Empregado e3 = new Empregado("terceiro", "empregado");
        Empregado e4 = new Empregado("quarto", "empregado");
        e4.setDataContrato(new Data(2021, 1, 4));
        e4.setHoraEntrada(new Tempo(8));
        e4.setHoraSaida(new Tempo(18));
        System.out.println(e3);
        System.out.println(e4);
        
        System.out.println("\n#### 4.i) ####");
        List<Empregado> empregados = new ArrayList<Empregado>();
        empregados.add(e1);
        empregados.add(e2);
        empregados.add(e3);
        empregados.add(e4);
        
        
        System.out.println("\n#### 4.j) ####");
        for (Empregado empregado : empregados) {
            System.out.println(empregado);
        }
        
        System.out.println("\n#### 4.k) ####");
        for (Empregado empregado : empregados) {
            System.out.println(
                    String.format(
                            "Nome: %s%nHorasSemanais: %.2f horas%nAntiguidade: %d dias%n"
                            , empregado.getPrimeiroNome() + " " + empregado.getUltimoNome()
                            , empregado.calculateHorasTrabalhoSemanal()
                            , empregado.calculateTempoContrato()
                    ));
        }
    }
    
}
