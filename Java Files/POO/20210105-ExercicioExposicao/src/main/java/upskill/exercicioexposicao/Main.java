/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upskill.exercicioexposicao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author user
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Quadro q1 = new Quadro("Q1", "A1", 1900); // Item 5.a)
        Quadro q2 = new Quadro("Q2", "A1", 1935);
        Quadro q3 = new Quadro("Q3", "A2", 1920);
        Quadro q4 = new Quadro("Q4", "A2", 1969);
        Quadro q5 = new Quadro("Q5", "A3", 1912);

        List<Quadro> quadros = new ArrayList<>();
        quadros.add(q1); // Item 5.b)
        quadros.add(q2);
        quadros.add(q3);
        quadros.add(q4);
        quadros.add(q5);

        listar(quadros); // Item 5.c)

        List<Exposicao> exposicoes = new ArrayList<>();
        Exposicao e1 = new Exposicao("Mundo", 2000);
        Exposicao e2 = new Exposicao("Novo", 2012);
        Exposicao e3 = new Exposicao("NewWorld", 2011);
        Exposicao e4 = new Exposicao("WorldRenewed", 2020);

        exposicoes.add(e1);
        exposicoes.add(e2);
        exposicoes.add(e3);
        exposicoes.add(e4);

        listar(exposicoes);

        List<Quadro> quadrosE1 = new ArrayList<Quadro>();
        quadrosE1.add(q1);
        quadrosE1.add(q2);
        quadrosE1.add(q3);
        List<Quadro> quadrosE2 = new ArrayList<Quadro>();
        quadrosE2.add(q3);
        quadrosE2.add(q4);
        quadrosE2.add(q5);
        List<Quadro> quadrosE3 = new ArrayList<Quadro>();
        quadrosE3.add(q1);
        quadrosE3.add(q3);
        quadrosE3.add(q5);
        List<Quadro> quadrosE4 = new ArrayList<Quadro>();
        quadrosE4.add(q2);
        quadrosE4.add(q4);

        e1.setQuadros(quadrosE1);
        e2.setQuadros(quadrosE2);
        e3.setQuadros(quadrosE3);
        e4.setQuadros(quadrosE4);

        listar(exposicoes);

        q3.setDesignacao("La Fleur"); // Item 8

        List<Exposicao> sortedExposicoes = new ArrayList<Exposicao>(exposicoes);
        Collections.sort(sortedExposicoes);

        listar(sortedExposicoes);
        
        e4.addQuadro(new Quadro("New Ways", "Me!", 2021));
        e4.removeQuadro(q4);
        
        listar(exposicoes);
    }

    static void listar(List items) {
        for (Object item : items) {
            System.out.println(item);
        }
    }

}
