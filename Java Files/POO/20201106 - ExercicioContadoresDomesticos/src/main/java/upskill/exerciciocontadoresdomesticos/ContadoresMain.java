/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upskill.exerciciocontadoresdomesticos;

/**
 *
 * @author user
 */
public class ContadoresMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("========================================================");
        System.out.println("A CRIAR OBJETOS E INSERI-LOS NUM CONTENTOR");
        System.out.println("========================================================");
        System.out.println("...");

        ContadorGas cg1 = new ContadorGas(100, "Daniel Junior");
        ContadorGas cg2 = new ContadorGas(220, "Junior Daniel");

        ContadorEletricidadeTarifarioSimples cts1 = new ContadorEletricidadeTarifarioSimples(
                6.8, "Economicus", 300
        );
        ContadorEletricidadeTarifarioSimples cts2 = new ContadorEletricidadeTarifarioSimples(
                8.8, "Gastavius", 700
        );

        ContadorEletricidadeTarifarioBiHorario cbh1 = new ContadorEletricidadeTarifarioBiHorario("Trabalhilson", 100, 30);
        ContadorEletricidadeTarifarioBiHorario cbh2 = new ContadorEletricidadeTarifarioBiHorario("Vagabudson", 100, 200);
        ContadorEletricidadeTarifarioBiHorario cbh3 = new ContadorEletricidadeTarifarioBiHorario("Daniel Junior", 1000, 500);

        Object[] objArr = new Object[10];
        objArr[0] = cg1;
        objArr[2] = cg2;
        objArr[3] = cts1;
        objArr[5] = cts2;
        objArr[7] = cbh3;
        objArr[9] = cbh1;
        objArr[8] = cbh2;

        System.out.println("========================================================");
        System.out.println("A LISTAR IDs E NOMES:");
        System.out.println("========================================================");

        for (int i = 0; i < objArr.length; i++) {
            if (objArr[i] != null) {
                System.out.println(((Contador) objArr[i]).getId() + "  ---  " + ((Contador) objArr[i]).getNome());
            }
        }
        System.out.println("FIM.");

        System.out.println("========================================================");
        System.out.println("N DE CONTADORES DE ELETRICIDADES CRIADOS:");
        System.out.println("========================================================");
        System.out.println((ContadorEletricidade.getEletricidadeIDCounter() - 1));

        System.out.println("FIM.");

        System.out.println("========================================================");
        System.out.println("LISTAR IDs BI-HORARIOS:");
        System.out.println("========================================================");
        for (int i = 0; i < objArr.length; i++) {
            if (objArr[i] != null && objArr[i] instanceof ContadorEletricidadeTarifarioBiHorario) {
                System.out.println(((Contador) objArr[i]).getId());
            }
        }
        System.out.println("FIM.");

        System.out.println("========================================================");
        System.out.println("LISTAR IDs E CUSTOS DE CONSUMOS");
        System.out.println("========================================================");
        for (int i = 0; i < objArr.length; i++) {
            if (objArr[i] != null) {
                System.out.println(((Contador) objArr[i]).getId() + "  ---  " + ((Contador) objArr[i]).calcularConsumo());
            }
        }
        System.out.println("FIM.");

        System.out.println("========================================================");
        System.out.println("MAIOR CONSUMO GAS");
        System.out.println("========================================================");
        double maiorGas = 0;
        for (int i = 0; i < objArr.length; i++) {
            if (objArr[i] != null && objArr[i] instanceof ContadorGas) {
                if (((Contador) objArr[i]).calcularConsumo() > maiorGas) {
                    maiorGas = ((Contador) objArr[i]).calcularConsumo();
                }
            }
        }
        System.out.println(maiorGas);
        System.out.println("FIM.");

        System.out.println("========================================================");
        System.out.println("NOMES DOS PROPRIETARIOS SEM REPETICAO");
        System.out.println("========================================================");
        String[] nomes = new String[objArr.length];
        int counter = 0;
        int index = 0;
        for (Object cont : objArr) {
            if (cont != null) {
                for (int i = 0; i < nomes.length; i++) {
                    if (((Contador) cont).getNome().equals(nomes[i])) {
                        counter++;
                    }
                }
                if (counter == 0) {
                    nomes[index] = ((Contador) cont).getNome();
                    index++;
                }
                counter = 0;
            }
        }
        for (String nome : nomes) {
            if (nome != null) {

                System.out.println(nome);
            }
        }
        System.out.println("FIM.");

    }

}
