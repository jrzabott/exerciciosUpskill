/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upskill.exercicioimpostos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author user
 */
public class ContribuinteMain {

    private static String separator = "================================================================================";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<Contribuinte> contribuintes = new ArrayList<Contribuinte>();
        contribuintes.add(new Desempregado("Luís Vidal", "Lisboa", 230, 1));
        contribuintes.add(new Reformado("Valter Coelho", "Olival", 600, 400));
        contribuintes.add(new Desempregado("Paulo Santos", "Braga", 150, 4));
        contribuintes.add(new TrabalhadorContaOutrem("Ana", "Ovar", 1800, 300, "CMM"));
        contribuintes.add(new Reformado("Jaime Magalhães", "Porto", 1500, 100));
        contribuintes.add(new TrabalhadorContaOutrem("Sílvio", "Seixal", 8000, 1000, "SSB"));
        contribuintes.add(new TrabalhadorContaPropria("Mário", "Guarda", 1500, 300, "Eletricista"));
        contribuintes.add(new Reformado("Amílcar Silva", "Coimbra", 1000, 500));
        contribuintes.add(new TrabalhadorContaOutrem("João", "Lisboa", 800, 100, "CML"));
        contribuintes.add(new TrabalhadorContaPropria("Carla", "Porto", 15000, 1000, "Advogado"));
        contribuintes.add(new Desempregado("Maria Sá", "Afife", 230, 8));

        System.out.println("LISTAR CONTRIBUINTES NO CONTENTOR");
        listar(contribuintes);

        System.out.println(separator);
        System.out.println("LISTAR CONTRIBUINTES NO CONTENTOR APÓS A REMOÇÃO DO LUIS VIDAL");
        Contribuinte toBeRemoved = new Desempregado("Luís Vidal", "Lisboa", 230, 1);
//        Contribuinte toBeRemoved = contribuintes.get(0);  
        System.out.println("Are these items, equal? " + contribuintes.get(0).equals(toBeRemoved));
        System.out.println("Removed? " + contribuintes.remove(toBeRemoved));
        listar(contribuintes);

        System.out.println(separator);
        System.out.println("TESTAR EQUIVALENCIA DE DUAS INSTANCIAS IGUAIS E COM MESMAS CARACTERISTICAS");
        System.out.println("contribuintes.get(0).equals(new Reformado(\"Valter Coelho\", \"Olival\", 600, 400)) " + contribuintes.get(0).equals(new Reformado("Valter Coelho", "Olival", 600, 400)));

        System.out.println(separator);
        System.out.println("TESTAR EQUIVALENCIA DE DUAS INSTANCIAS DO MESMO TIPO COM CARACTERISTICAS DIFERENTES");
        System.out.println("contribuintes.get(0).equals(new Reformado(\"Coelho Valter\", \"Olival\", 600, 400)) " + contribuintes.get(0).equals(new Reformado("Coelho Valter", "Olival", 600, 400)));

        System.out.println(separator);
        System.out.println("TESTAR EQUIVALENCIA DE DUAS INSTANCIAS DE TIPOS DIFERENTES");
        System.out.println("new TrabalhadorContaOutrem(\"Ana\", \"Ovar\", 1800, 300, \"CMM\")" + contribuintes.get(0).equals(new TrabalhadorContaOutrem("Ana", "Ovar", 1800, 300, "CMM")));

        System.out.println(separator);
        System.out.println("ORDEM ALFABETICA DESC POR TIPO DE CONTRIBUINTES:");
        Collections.sort(contribuintes, Collections.reverseOrder(new ContribuinteTipoComparator()));
        listar(contribuintes);

        System.out.println(separator);
        System.out.println("ORDEM ALFABETICA POR TIPO DE CONTRIBUINTES SEGUIDOS PELO NOME:");
//        Collections.sort(contribuintes, new ContribuinteTipoComparator());
//        Collections.sort(contribuintes, new ContribuinteTipoComparator());
//        
//        Collections.sort(contribuintes, new ContribuinteTipoComparator().thenComparing(new ContribuinteNomeComparator()));
        
        
        Collections.sort(contribuintes, new ContribuinteTipoNomeComparator());
        listar(contribuintes);
    }

    static void listar(List items) {
        System.out.println(""
                + "---INICIO LISTA-------------------------------------------------------------");
        for (Object item : items) {
            System.out.println(item + " Classe:" + item.getClass().getSimpleName() + " Imposto: " + ((Contribuinte) item).calcularImposto());
        }
        System.out.println(""
                + "---FIM LISTA----------------------------------------------------------------");
    }

    /*
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
     */
//    private void lastSession20201105() {
//        Reformado ref1 = new Reformado(10000.0, "Jorge Silva", "Custóias - MTS", 3000);
//        Reformado ref2 = new Reformado(8000.0, "Marco Marquês", "Senhora da Hora - MTS", 8000);
//
//        TrabalhadorContaOutrem tCO1 = new TrabalhadorContaOutrem("Graviola Unipessoal", 30000, "Borges Medeiros", "PORTIC", 0);
//        TrabalhadorContaOutrem tCO2 = new TrabalhadorContaOutrem("Anonymous Inc", 31000, "Shawn Shank", "Rua XXX", 200000);
//
//        TrabalhadorContaPropria tCP1 = new TrabalhadorContaPropria("Analista de Sistemas", 14000, "George Wash In Town", "USA", 49000);
//        TrabalhadorContaPropria tCP2 = new TrabalhadorContaPropria("Professor", 14000, "Fernando DuEngenho", "Portugal", 59000);
//
//        Desempregado des1 = new Desempregado("Não faço nada Silva", "Casa de Parentes", 20000, 12);
//        Desempregado des2 = new Desempregado("Vagabond Junior", "Cidadão do Mundo", 40000, 60);
//
//        Object[] myArr = {ref1, ref2, tCO1, tCO2, tCP1, tCP2, des1, des2, null, null};
//
//        System.out.println("================================================================="
//                + "A varrer contentor de todos os objetos e retornar toString() + Imposto Extraordinários");
//        for (int i = 0; i < myArr.length; i++) {
//            if (myArr[i] != null) {
//                System.out.println(
//                        ((Contribuinte) myArr[i]).toString() + " "
//                        + ((Contribuinte) myArr[i]).calcularImposto()
//                );
//            }
//        }
//        System.out.println("=================================================================");
//        System.out.println("A varrer contentor para apresentação do nome e imposto extra dos desempregados");
//        for (int i = 0; i < myArr.length; i++) {
//            if (myArr[i] != null && myArr[i] instanceof Desempregado) {
//                System.out.println(
//                        ((Contribuinte) myArr[i]).getNome()
//                        + " " + ((Contribuinte) myArr[i]).calcularImposto()
//                );
//            }
//        }
//
//        System.out.println("=================================================================");
//        System.out.println("Alterada Taxa dos OR aos desempregados (02% ==> 25%)");
//        Desempregado.setTaxaOR(0.25);
//
//        System.out.println("A varrer novamente alínea dos desempregados com nova taxa de OR");
//        for (int i = 0; i < myArr.length; i++) {
//            if (myArr[i] != null && myArr[i] instanceof Desempregado) {
//                System.out.println(
//                        ((Contribuinte) myArr[i]).getNome()
//                        + " " + ((Contribuinte) myArr[i]).calcularImposto()
//                );
//            }
//        }
//    }
}

/*
CONTRIBUINTE
    |
    | - CONTRIBUINTE_COM_RENDIMENTOS_DE_TRABALHO
    |                   |
    |                   | - REFORMADO
    |                   | - TRABALHADOR POR CONTRA DE OUTREM
    |                   | - TRABALHADOR POR CONTRA PRÓPRIA
    |
    | - DESEMPREGADOS
 */
