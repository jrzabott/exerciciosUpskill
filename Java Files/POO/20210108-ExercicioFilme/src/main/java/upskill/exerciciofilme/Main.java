/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upskill.exerciciofilme;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Realizador r1 = new Realizador("Daniel", CountriesEnum.AUSTRALIA, new Data(1986, 4, 1));
        Realizador r2 = new Realizador("Junior", CountriesEnum.DOMINICA, new Data(1986, 4, 1));

        Filme f1 = new Filme();
        Filme f2 = new Filme();
        Filme f3 = new Filme();
        Filme f4 = new Filme();
        Filme f5 = new Filme();

        ListaFilmes l1 = new ListaFilmes();
        ListaFilmes l2 = new ListaFilmes();

        try {
            f1.setTitulo("Movie From Daniel");
            f1.setCategoria("ação");
//            f1.setAnoRealizacao(1800); // Validation Error Expected
            f1.setAnoRealizacao(1899);
            f1.setRealizador(r1);
        } catch (AnoInvalidoException | CategoriaInvalidaException ex) {
            System.out.println(f1.getTitulo() + " . " + ex.getMessage());
        }

        try {
            f2.setTitulo("Movie From Daniel Part 2");
//            f2.setAnoRealizacao(1850); // Validation Error Expected
            f2.setAnoRealizacao(1851);
//            f2.setCategoria("acao"); // Validation Error Expected
            f2.setCategoria("ação");
            f2.setRealizador(r1);
        } catch (AnoInvalidoException | CategoriaInvalidaException ex) {
            System.out.println(f2.getTitulo() + " . " + ex.getMessage());
        }

        try { // All OK in this one
            f3.setTitulo("Movie From Daniel Part 3");
            f3.setCategoria("comédia");
            f3.setAnoRealizacao(1852);
            f3.setRealizador(r1);
        } catch (AnoInvalidoException | CategoriaInvalidaException ex) {
            System.out.println(f3.getTitulo() + " . " + ex.getMessage());
        }
        try {
            f4.setTitulo("Anima Daniel");
            f4.setAnoRealizacao(1950);
//            f4.setCategoria("acao"); // Validation Error Expected
            f4.setCategoria("ação"); // Validation Error Expected
            f4.setRealizador(r2);
        } catch (AnoInvalidoException | CategoriaInvalidaException ex) {
            System.out.println(f4.getTitulo() + " . " + ex.getMessage());
        }
        try {
            f5.setTitulo("Junior Mundi");
//            f5.setAnoRealizacao(2022); // Validation Error Expected
            f5.setAnoRealizacao(Data.dataAtual().getAno());
            f5.setCategoria("terror");
            f5.setRealizador(r1);
        } catch (AnoInvalidoException | CategoriaInvalidaException ex) {
            System.out.println(f5.getTitulo() + " . " + ex.getMessage());
        }

        try {
//            l1.setId("aDemir"); // Validation Error Expected
            l1.setId("Ademir");
        } catch (IdentificadorInvalidoException ex) {
            System.out.println(l1 + " . " + ex.getMessage());
        }
        try {
            l2.setId("Jorge");
        } catch (IdentificadorInvalidoException ex) {
            System.out.println(l2 + " . " + ex.getMessage());
        }

        l1.addFilme(f1);
        l1.addFilme(f2);
        l1.addFilme(f3);
        l2.addFilme(f4);
        l2.addFilme(f5);

        System.out.println("==========================\nLista de REALIZADORES\n----------------------");
        System.out.println(r1);
        System.out.println(r2);
        System.out.println("==========================\nLista de FILMES\n----------------------");
        System.out.println(f1);
        System.out.println(f2);
        System.out.println(f3);
        System.out.println(f4);
        System.out.println(f5);
        System.out.println("==========================\nLista de LISTAS\n----------------------");
        System.out.println(l1);
        System.out.println(l2);
    }

}
