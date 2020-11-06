/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upskill.exercicioimpostos;

/**
 *
 * @author user
 */
public class ContribuinteMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Reformado ref1 = new Reformado(10000.0, "Jorge Silva", "Custóias - MTS", 3000);
        Reformado ref2 = new Reformado(8000.0, "Marco Marquês", "Senhora da Hora - MTS", 8000);

        TrabalhadorContaOutrem tCO1 = new TrabalhadorContaOutrem("Graviola Unipessoal", 30000, "Borges Medeiros", "PORTIC", 0);
        TrabalhadorContaOutrem tCO2 = new TrabalhadorContaOutrem("Anonymous Inc", 31000, "Shawn Shank", "Rua XXX", 200000);

        TrabalhadorContaPropria tCP1 = new TrabalhadorContaPropria("Analista de Sistemas", 14000, "George Wash In Town", "USA", 49000);
        TrabalhadorContaPropria tCP2 = new TrabalhadorContaPropria("Professor", 14000, "Fernando DuEngenho", "Portugal", 59000);

        Desempregado des1 = new Desempregado("Não faço nada Silva", "Casa de Parentes", 20000, 12);
        Desempregado des2 = new Desempregado("Vagabond Junior", "Cidadão do Mundo", 40000, 60);

        Object[] myArr = {ref1, ref2, tCO1, tCO2, tCP1, tCP2, des1, des2, null, null};

        System.out.println("================================================================="
                + "A varrer contentor de todos os objetos e retornar toString() + Imposto Extraordinários");
        for (int i = 0; i < myArr.length; i++) {
            if (myArr[i] != null) {
                System.out.println(
                        ((Contribuinte) myArr[i]).toString() + " "
                        + ((Contribuinte) myArr[i]).calcularImposto()
                );
            }
        }
        System.out.println("=================================================================");
        System.out.println("A varrer contentor para apresentação do nome e imposto extra dos desempregados");
        for (int i = 0; i < myArr.length; i++) {
            if (myArr[i] != null && myArr[i] instanceof Desempregado) {
                System.out.println(
                        ((Contribuinte) myArr[i]).getNome()
                        + " " + ((Contribuinte) myArr[i]).calcularImposto()
                );
            }
        }

        System.out.println("=================================================================");
        System.out.println("Alterada Taxa dos OR aos desempregados (02% ==> 25%)");
        Desempregado.setTaxaOR(0.25);

        System.out.println("A varrer novamente alínea dos desempregados com nova taxa de OR");
        for (int i = 0; i < myArr.length; i++) {
            if (myArr[i] != null && myArr[i] instanceof Desempregado) {
                System.out.println(
                        ((Contribuinte) myArr[i]).getNome()
                        + " " + ((Contribuinte) myArr[i]).calcularImposto()
                );
            }
        }

    }

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
