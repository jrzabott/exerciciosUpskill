/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UpskillFicha5ExerciciosSincronos;

import java.util.Scanner;

/**
 *
 * @author user
 */
public class UpskillFicha5 {

    private static Scanner s = new Scanner(System.in);
    private static String separator = new String(
            "========================================"
            + "========================================");

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        menu();
    }

    /**
     * @author Daniel Junior
     * @lastEdit 202010271415
     */
    public static void Ficha5Ex1SincronoA() {
        System.out.println(separator);
        System.out.println("Calcula a média de valores inseridos num vetor.\n"
                + "Apresenta o valor mínimo contido neste mesmo vetor.");
        System.out.println(separator);

        int i, s = 0, c = 0;
//        int[] v = new int[10];
        int[] v = new int[5];
        Scanner ler = new Scanner(System.in);
        for (i = 0; i < v.length; i++) {
            System.out.println("Número ?");
            v[i] = ler.nextInt();
        }
        for (i = 0; i < v.length; i++) {
            if (v[i] % 2 == 0) {
                s = s + v[i];
                c++;
            }
        }
        if (c != 0) {
            System.out.println(((double) s) / c);
        } else {
            System.out.println("Operação impossível de realizar");
        }

    }

    /**
     * @author Daniel Junior
     * @lastEdit 202010271415
     */
    public static void Ficha5Ex1SincronoB() {
        System.out.println(separator);
        System.out.println("Calcula a média de valores inseridos num vetor.\n"
                + "Apresenta o valor mínimo contido neste mesmo vetor.");
        System.out.println(separator);

        int i, s = 0, c = 0;
//        int[] v = new int[10];
        int[] v = new int[5];
        Scanner ler = new Scanner(System.in);
        for (i = 0; i < v.length; i++) {
            System.out.println("Número ?");
            v[i] = ler.nextInt();
        }
        for (i = 0; i < v.length; i++) {
            if (v[i] % 2 == 0) {
                s = s + v[i];
                c++;
            }
        }
        if (c != 0) {
            System.out.println("Media dos valores inseridos: "
                    + ((double) s) / c);
        } else {
            System.out.println("Operação impossível de realizar");
        }
        System.out.println("Menor valor no Vetor: " + min(v));
    }

    /**
     *
     */
    public static void Ficha5Ex1SincronoC() {
        System.out.println(separator);
        System.out.println("Calcula a média de valores inseridos num vetor.\n"
                + "Apresenta o valor mínimo contido neste mesmo vetor.\n"
                + "Exibe o índice do menor valor");
        System.out.println(separator);

        int i, s = 0, c = 0;
//        int[] v = new int[10];
        int[] v = new int[5];
        Scanner ler = new Scanner(System.in);
        for (i = 0; i < v.length; i++) {
            System.out.println("Número ?");
            v[i] = ler.nextInt();
        }
        for (i = 0; i < v.length; i++) {
            if (v[i] % 2 == 0) {
                s = s + v[i];
                c++;
            }
        }
        if (c != 0) {
            System.out.println("Media dos valores inseridos: "
                    + ((double) s) / c);
        } else {
            System.out.println("Operação impossível de realizar");
        }
        int minVal = min(v);
        System.out.println("Os índices onde ocorre o menor valor são:");
        for (int j = 0; j < v.length; j++) {
            if (v[j] == minVal) {
                System.out.print(" " + j);
            }
        }
        System.out.println("");
    }

    /**
     *
     */
    public static void Ficha5Ex2SincronoA() {

        System.out.println(separator);
        System.out.println("Ler Nomes e Salarios até inserir FIM.");
        System.out.println(separator);

        String[] nomes = new String[20];
        double[] salarios = new double[20];

        int nElem = leitura(nomes, salarios);

        System.out.println("NOME        -        VENCIMENTOS");
        for (int i = 0; i < nElem; i++) {
            System.out.println(nomes[i] + "    -    €" + salarios[i]);
        }
    }

    /**
     *
     */
    public static void Ficha5Ex2SincronoB() {

        System.out.println(separator);
        System.out.println("Ler Nomes e Salarios até inserir FIM."
                + "\nConta Funcionarios com salario menor que a media.");
        System.out.println(separator);

        String[] nomes = new String[20];
        double[] salarios = new double[20];

        int nElem = leitura(nomes, salarios);

        int salMenorQueMedia = countFuncComVencimentoMenorQueMedia(salarios,
                nElem);
        System.out.println("Total de Funcionarios com Vencimentos < Media: "
                + salMenorQueMedia);
    }

    /**
     *
     */
    public static void Ficha5Ex2SincronoC() {

        System.out.println(separator);
        System.out.println("Ler Nomes e Salarios até inserir FIM."
                + "\nCalcula o Percentual dos funcionarios com salario menor "
                + "que valor informado");
        System.out.println(separator);

        String[] nomes = new String[20];
        double[] salarios = new double[20];

        int nElem = leitura(nomes, salarios);

        System.out.println("Entre o valor de comparação: ");
        double valorComparacao = s.nextDouble();

        double percMenorQueValor = percFuncSalMenorValor(salarios,
                nElem, valorComparacao);
        System.out.format("Total de Funcionarios com Vencimentos < Valor: "
                + "%.2f%%\n", percMenorQueValor * 100.0);
    }

    /**
     *
     */
    public static void Ficha5Ex3SincronoA() {
        /*
         * App que executa um menu até que entremos com a opção 3.
         * Ao invocar opção 1, ele chama função "lerNomes".
         * Ao invocar opção 2, executa função "enigma" abaixo.
         * A função enigma, procura por uma String num vetor, caso encontre,
         * deleta este valor, do contrário retorna o tamanho do vetor.
         */
        System.out.println(separator);
        System.out.println(""
                + "* App que executa um menu até que entremos com a opção 3."
                + "\n* Ao invocar opção 1, ele chama função \"lerNomes\"."
                + "\n* Ao invocar opção 2, executa função \"enigma\" abaixo."
                + "\n* A função enigma, procura por uma String num vetor, caso "
                + "encontre,"
                + "\n* deleta este valor, do contrário retorna o tamanho do "
                + "vetor.");
        System.out.println(separator);
        int n = 0;
        String nomes[] = new String[100];
        Scanner ler = new Scanner(System.in);
        String m = " 1-Ler Nomes\n2-Enigma Nome\n3-Terminar\nEscolha uma opção:";
        char op;
        do {
            System.out.println(m);
            op = ler.next().charAt(0);
            switch (op) {
                case '1':
                    n = lerNomes(nomes);
                    break;
                case '2':
                    System.out.println("Nome:");
                    String nome = ler.nextLine();
                    n = removerNomeOuRetornarComprimentoDaArray(nomes, nome, n);
                    break;
                case '3':
                    break;
                default:
                    System.out.println("Opção inválida!!");
            }
        } while (op != '3');
    }

    /**
     *
     */
    public static void Ficha5Ex3SincronoB() {
        /*
         * App que executa um menu até que entremos com a opção 3.
         * Ao invocar opção 1, ele chama função "lerNomes".
         * Ao invocar opção 2, executa função "enigma" abaixo.
         * A função enigma, procura por uma String num vetor, caso encontre,
         * deleta este valor, do contrário retorna o tamanho do vetor.
         */
        int n = 0;
        String nomes[] = new String[100];
        Scanner ler = new Scanner(System.in);
        String m = "1-Ler Nomes\n2-Enigma Nome\n3-Terminar\n"
                + "4-Listagem dos Nomes\nEscolha uma opção:";
        char op;
        do {
            System.out.println(m);
            op = ler.next().charAt(0);
            switch (op) {
                case '1':
                    n = lerNomes(nomes);
                    break;
                case '2':
                    System.out.println("Nome:");
                    String nome = ler.nextLine();
                    n = removerNomeOuRetornarComprimentoDaArray(nomes, nome, n);
                    break;
                case '3':
                    break;
                case '4':
                    System.out.println("Entre com o número de nomes a serem "
                            + "listados:");
                    int vecElem = ler.nextInt();
                    ler.nextLine();
                    listar(nomes, n, vecElem);
                    break;
                default:
                    System.out.println("Opção inválida!!");
            }
        } while (op != '3');
    }

    /**
     *
     */
    public static void Ficha5Ex3SincronoC() {
        /*
         * App que executa um menu até que entremos com a opção 3.
         * Ao invocar opção 1, ele chama função "lerNomes".
         * Ao invocar opção 2, executa função "enigma" abaixo.
         * A função enigma, procura por uma String num vetor, caso encontre,
         * deleta este valor, do contrário retorna o tamanho do vetor.
         */
        int n = 0;
        String nomes[] = new String[100];
        Scanner ler = new Scanner(System.in);
        String m = "1-Ler Nomes\n2-Enigma Nome\n3-Terminar\n"
                + "4-Listagem dos Nomes\nEscolha uma opção:";
        char op;
        do {
            System.out.println(m);
            op = ler.next().charAt(0);
            switch (op) {
                case '1':
                    n = lerNomes(nomes);
                    break;
                case '2':
                    System.out.println("Nome:");
                    String nome = ler.nextLine();
                    n = removerNomeOuRetornarComprimentoDaArray(nomes, nome, n);
                    break;
                case '3':
                    break;
                case '4':
                    System.out.println("Entre com o número de nomes a serem "
                            + "listados:");
                    int vecElem = ler.nextInt();
                    ler.nextLine();
                    listar(nomes, n, vecElem);
                    break;
                default:
                    System.out.println("Opção inválida!!");
            }
        } while (op != '3');
    }

    private static void Ficha5Ex4ASincrono() {
        System.out.println(separator);
        System.out.println("1) CRIA UM VETOR COM N ELEMENTOS, FORNECIDO PELO "
                + "UTILIZADOR."
                + "\n2) INVERTE ESTE VETOR"
                + "\n3) APRESENTA VETOR INVERTIDO"
                + "\n4) ROTAÇÃO DO VETOR (1 ELEMENTO, TORNAR-SE-Á O ÚLTIMO"
                + "\n5) APRESENTAÇÃO DO VETOR RODADO");
        System.out.println(separator);

        int qtNum;
        String message = "Entre com a quantidade de numeros a serem carregados";
        qtNum = lerNumInt(message);

        int[] arr = new int[qtNum];
        arr = carregarVetor(arr, qtNum);
        printVetor(arr);

        System.out.println("\nInverter Vetor...");
        arr = inverterVetor2(arr);
        printVetor(arr, "Vetor Invertido");

        System.out.println("Rodar Vetor...");
        arr = rodarVetor(arr);
        printVetor(arr, "Vetor Rodado");
    }


    /*
     * =====================================================================
     *                     FUNÇÕES AUXILIARES
     * =====================================================================
     *
     */
    private static int leitura(String[] nomes, double[] salarios) {
        int n = 0;
        boolean giveMoreNames = true;
        for (int i = 0; (giveMoreNames && i < nomes.length); i++) {
            System.out.print("Entre com o nome do funcionario (\"FIM\" "
                    + "para sair): ");
            nomes[i] = s.nextLine();
            giveMoreNames = !"FIM".equalsIgnoreCase(nomes[i]);

            if (giveMoreNames) {
                System.out.print("Entre com o salário do func: ");
                salarios[i] = s.nextDouble();
                s.nextLine();
            }
            n = i;
        }
        return n;
    }

    /**
     *
     * @param arr
     * @return
     */
    public static int min(int[] arr) {
        int minVal = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < minVal) {
                minVal = arr[i];
            }
        }
        return minVal;
    }

    private static int countFuncComVencimentoMenorQueMedia(double[] salarios,
            int nElem) {
        double media = 0, soma = 0;
        int count = 0;
        for (int i = 0; i < nElem; i++) {
            soma += salarios[i];
        }
        if (nElem > 0) {
            media = soma / (double) nElem;
        }
        for (int i = 0; i < nElem; i++) {
            if (salarios[i] < media) {
                count++;
            }
        }
        return count;

    }

    private static double percFuncSalMenorValor(double[] salarios, int nElem,
            double valComp) {
        double perc = 0.0;
        int count = 0;
        for (int i = 0; i < nElem; i++) {
            if (salarios[i] < valComp) {
                count++;
            }
        }
        if (nElem > 0) {
            perc = (double) count / (double) nElem;
        }
        return perc;
    }

    private static int lerNomes(String[] vec) {
        // Lê uma sequência de nomes terminada com a palavra FIM.
        // Armazena os nomes em vec e retorna o número desses
        //        nomes.
        return leitura(vec);
    }

    private static int leitura(String[] vec) {
        int n = 0;
        boolean giveMoreNames = true;
        System.out.println("");
        for (int i = 0; (giveMoreNames && i < vec.length); i++) {
            System.out.print("Entre com o nome desejado (\"FIM\" "
                    + "para sair): ");
            vec[i] = s.nextLine();
            giveMoreNames = !"FIM".equalsIgnoreCase(vec[i]);
            n = i;
        }
        System.out.println("");
        return n;
    }

    private static void listar(String[] vec, int nElem, int vecElem) {
// Apresenta os primeiros n elementos de vec
        System.out.println("");
        for (int i = 0; i < vecElem && i < nElem; i++) {
            System.out.println(+i + " - " + vec[i]);
        }
        System.out.println("");
    }

    private static int removerNomeOuRetornarComprimentoDaArray(String[] nomes, String nome, int n) {
        int i = 0;
        while (i < n && !nomes[i].equalsIgnoreCase(nome)) {
            i++;
        }
        if (i == n) {
            return n;
        } else {
            for (int j = i; j < n - 1; j++) {
                nomes[j] = nomes[j + 1];
            }
            return --n;
        }
    }

    private static int lerNumInt(String msg) {
        int num;
        do {
            System.out.print(msg + ": ");
            num = s.nextInt();
        } while (num < 0);
        System.out.println("");
        return num;
    }

    private static int lerNumInt() {
        int num;
        do {
            System.out.print("Entre com o nº int e positivo: ");
            num = s.nextInt();
        } while (num < 0);
        return num;
    }

    private static int[] carregarVetor(int[] arr, int qtNum) {
        for (int i = 0; i < qtNum; i++) {
            arr[i] = lerNumInt();
        }
        return arr;
    }

    private static void printVetor(int[] arr) {
        System.out.print("arr: [");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i != arr.length - 1) {
                System.out.print(", ");
            } else {
                System.out.print("].\n");
            }
        }
    }

    private static int[] inverterVetor(int[] arr) {
        int[] arrInv = arr.clone();
        int count = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            arrInv[count] = arr[i];
            count++;
        }
        return arrInv;
    }
    private static int[] inverterVetor2(int[] arr) {
        int count = 0;
        int tmp = 0;
        for (int i = arr.length - 1; i >= arr.length / 2; i--) {
            tmp = arr[i];
            arr[i] = arr[count];
            arr[count] = tmp;
            
            count++;
        }
        return arr;
    }

    private static void printVetor(int[] arr, String msg) {
        System.out.print(msg + ": [");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i != arr.length - 1) {
                System.out.print(", ");
            } else {
                System.out.print("].\n");
            }
        }
    }

    private static int[] rodarVetor(int[] arr) {
        int tmp = arr[0];
        for (int i = 1; i < arr.length; i++) {
            arr[i - 1] = arr[i];
        }
        arr[arr.length - 1] = tmp;
        return arr;
    }

    /**
     *
     */
    public static void menu() {
        int num = 0;
        do {
            System.out.println(separator);
            System.out.println("SELECION O EXERCICIO DESEJADO (0 para sair):\n"
                    + "\n1 - Ficha5 Exercicio 1"
                    + "\n2 - Ficha5 Exercicio 2"
                    + "\n3 - Ficha5 Exercicio 3"
                    + "\n4 - Ficha5 Exercicio 4"
                    + "\n\n0 - SAIR");
            System.out.println(separator);
            num = lerNumInt("Entre com a opção desejada para o exercicio " + ((num != 0) ? num : ""));
            System.out.println(separator);
            int alinea;
            switch (num) {
                case 1:
                    alinea = selectAlinea();
                    executaEx1(alinea);
                    break;
                case 2:
                    alinea = selectAlinea();
                    executaEx2(alinea);
                    break;
                case 3:
                    alinea = selectAlinea();
                    executaEx3(alinea);
                    break;
                case 4:
                    executaEx4();
                    break;
                case 0:
                    System.out.println("Finalizando Aplicação...");
                    break;
                default:
                    System.out.println("Exercicio Não Implementado");
            }
        }while (num != 0);
    }

    private static int selectAlinea() {
        System.out.println("Selecione o Exercício para visualizaçao:\n"
                + "\n1 - Alinea A"
                + "\n2 - Alinea B"
                + "\n3 - Alinea C");
        System.out.println(separator);
        int alinea = lerNumInt("Entre com a Alinea Desejada");
        return alinea;
    }

    private static void executaEx1(int alinea) {
        switch (alinea) {
            case 1:
                Ficha5Ex1SincronoA();
                break;
            case 2:
                Ficha5Ex1SincronoB();
                break;
            case 3:
                Ficha5Ex1SincronoC();
                break;
            default:
                System.out.println("Alinea Incorreta");
        }
    }

    private static void executaEx2(int alinea) {
        switch (alinea) {
            case 1:
                Ficha5Ex2SincronoA();
                break;
            case 2:
                Ficha5Ex2SincronoB();
                break;
            case 3:
                Ficha5Ex3SincronoC();
                break;
            default:
                System.out.println("Alinea Incorreta");
        }
    }

    private static void executaEx3(int alinea) {
        switch (alinea) {
            case 1:
                Ficha5Ex3SincronoA();
                break;
            case 2:
                Ficha5Ex3SincronoB();
                break;
            case 3:
                Ficha5Ex3SincronoC();
                break;
            default:
                System.out.println("Alinea Incorreta");
        }
    }

    private static void executaEx4() {
        Ficha5Ex4ASincrono();
    }

}
