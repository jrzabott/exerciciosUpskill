/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ficha7exercicioassincrono;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.Scanner;

/**
 * a
 *
 * @author user a) Carregar os dados do ficheiro para memória; b) Inserir
 * funcionário; c) Listar todos os funcionários; d) Atualizar vencimento de um
 * funcionário; e) Eliminar um funcionário; f) Mostrar informação ordenada por
 * nome de funcionário; g) Gravar dados (situação atual da memória) no ficheiro
 * inicial (substitui os dados anteriores)
 */
public class Ficha7ExercicioAssincrono {

    private static Scanner ler = new Scanner(System.in);
    private static String[] funcionarios = {};
    private static int[] vencimentos = {};

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        menu();
    }

    private static void menu() throws FileNotFoundException {
        String menuMsg = "a) Carregar os dados do ficheiro para memória;"
                + "\nb) Inserir funcionário;"
                + "\nc) Listar todos os funcionários;"
                + "\nd) Atualizar vencimento de um funcionário;"
                + "\ne) Eliminar um funcionário;"
                + "\nf) Mostrar informação ordenada por nome de funcionário;"
                + "\ng) Gravar dados (situação atual da memória) no ficheiro inicial (substitui os dados anteriores);"
                + "\nh) Sair;";

        String option = "";
        while (!"h".equalsIgnoreCase(option)) {

            System.out.println(menuMsg);
            do {
                System.out.print("OPÇÃO: ");
                option = ler.nextLine();
            } while (!("a".equalsIgnoreCase(option)
                    || "b".equalsIgnoreCase(option)
                    || "c".equalsIgnoreCase(option)
                    || "d".equalsIgnoreCase(option)
                    || "e".equalsIgnoreCase(option)
                    || "f".equalsIgnoreCase(option)
                    || "g".equalsIgnoreCase(option)
                    || "h".equalsIgnoreCase(option)));
            processaAcao(option.toLowerCase());
        }

    }

    private static void processaAcao(String option) throws FileNotFoundException {
        switch (option) {
            case "a":
                lerFicheiro();
                break;
            case "b":
                inserirFuncionario();
                break;
            case "c":
                listarTodosOsFuncionarios();
                break;
            case "d":
                atualizarVencimentoFuncionario();
                break;
            case "e":
                eliminarFuncionario();
                break;
            case "f":
                mostrarInformacaoOrdenadaPorFuncionario();
                break;
            case "g":
                gravarFicheiro();
                break;
            default:
        }
    }

    private static void lerFicheiro() throws FileNotFoundException {
        Scanner fichFuncR = new Scanner(new File("funcionarios.txt"));

        if (funcionarios.length > 0) {
            System.out.println("Ficheiro já carregado.\n\n");
            return;
        }

        while (fichFuncR.hasNextLine()) {
            String linha = fichFuncR.nextLine();
            String[] dadosFuncionario = linha.split(":");
            funcionarios = addItem(funcionarios, dadosFuncionario[0]);
            vencimentos = addItem(vencimentos, Integer.parseInt(dadosFuncionario[1]));
        }
        fichFuncR.close();
        System.out.println("Ficheiro lido com sucesso.\n\n");
    }

    private static void inserirFuncionario() {
        if (funcionarios.length == 0) {
            System.out.println("Ficheiro não carregado.");
            return;
        }
        System.out.println("Entre com o nome do Funcionario:");
        String nomeFunc = ler.nextLine();
        System.out.println("Entre com o vencimento de [" + nomeFunc + "]: ");
        int vencFunc = ler.nextInt();
        ler.nextLine();
        funcionarios = addItem(funcionarios, nomeFunc);
        vencimentos = addItem(vencimentos, vencFunc);
        System.out.println("Funcionario Inserido com Sucesso.");
    }

    private static void listarTodosOsFuncionarios() {
        if (funcionarios.length == 0) {
            System.out.println("Ficheiro não carregado.");
            return;
        }
        for (String funcionario : funcionarios) {
            System.out.println(funcionario);
        }
        System.out.println("\n\n");
    }

    private static void atualizarVencimentoFuncionario() {
        // TODO atualizarVencimentoFuncionario()
        if (funcionarios.length == 0) {
            System.out.println("Ficheiro não carregado.");
            return;
        }
        System.out.println("\n\nFuncionários: ");
        for (int i = 0; i < funcionarios.length; i++) {

            System.out.println((i + 1) + ") " + funcionarios[i]);
        }
        System.out.print("\nEnter o numero do colaborador para alterar seus vencimentos: ");
        int codFunc = ler.nextInt();
        ler.nextLine();
        System.out.print("\nEntre com o novo vencimento: ");
        int novoVenc = ler.nextInt();
        ler.nextLine();

        vencimentos[codFunc - 1] = novoVenc;
        System.out.println("\nSalario Alterado com Sucesso.\n\n");
    }

    private static void eliminarFuncionario() {
        // TODO eliminarFuncionario
        if (funcionarios.length == 0) {
            System.out.println("Ficheiro não carregado.");
            return;
        }
        System.out.println("\n\nFuncionários: ");
        for (int i = 0; i < funcionarios.length; i++) {

            System.out.println((i + 1) + ") " + funcionarios[i]);
        }
        System.out.print("\nEnter o numero do colaborador para removê-lo: ");
        int codFunc = ler.nextInt();
        ler.nextLine();

        funcionarios = removerItem(funcionarios, codFunc - 1);
        vencimentos = removerItem(vencimentos, codFunc - 1);

        System.out.println("\nColaborador Removido com Sucesso.\n\n");

    }

    private static void mostrarInformacaoOrdenadaPorFuncionario() {
        // TODO mostrarInformacaoOrdenadaPorFuncionario

        for (int i = 0; i < funcionarios.length - 1; i++) {
            for (int j = i + 1; j < funcionarios.length; j++) {
                if (funcionarios[i].compareToIgnoreCase(funcionarios[j]) > 0) {
                    String tmpFunc = funcionarios[i];
                    funcionarios[i] = funcionarios[j];
                    funcionarios[j] = tmpFunc;
                    
                    int tmp = vencimentos[i];
                    vencimentos[i] = vencimentos[j];
                    vencimentos[j] = tmp;
                }
            }
        }
        listarTodosOsFuncionarios();
    }

    private static void gravarFicheiro() throws FileNotFoundException {
        if (funcionarios.length == 0) {
            System.out.println("Ficheiro não carregado.");
            return;
        }

        Formatter fichFuncW = new Formatter(new File("funcionarios.txt"));
        for (int i = 0; i < funcionarios.length; i++) {
            fichFuncW.format("%s:%d%n", funcionarios[i], vencimentos[i]);
//            System.out.printf("%s:%d%n", funcionarios[i], vencimentos[i]);
        }
        fichFuncW.close();
        System.out.println("\nFicheiro Gravado com Sucesso.\n\n");

    }

    private static String[] addItem(String[] arr, String string) {
        String[] newArr = new String[arr.length + 1];
        int index = 0;
        for (String item : arr) {
            newArr[index] = item;
            index++;
        }
        newArr[newArr.length - 1] = string;
        return newArr;
    }

    private static int[] addItem(int[] arr, int num) {
        int[] newArr = new int[arr.length + 1];
        int index = 0;
        for (int item : arr) {
            newArr[index] = item;
            index++;
        }
        newArr[newArr.length - 1] = num;
        return newArr;
    }

    private static String[] removerItem(String[] arr, int num) {
        String[] newArr = new String[arr.length - 1];
        int counter = 0;
        for (int i = 0; i < num; i++) {
            newArr[counter] = arr[i];
            counter++;
        }
        for (int i = num + 1; i < arr.length; i++) {
            newArr[counter] = arr[i];
            counter++;
        }
        return newArr;
    }

    private static int[] removerItem(int[] arr, int num) {
        int[] newArr = new int[arr.length - 1];
        int counter = 0;
        for (int i = 0; i < num; i++) {
            newArr[counter] = arr[i];
            counter++;
        }
        for (int i = num + 1; i < arr.length; i++) {
            newArr[counter] = arr[i];
            counter++;
        }
        return newArr;
    }

}
