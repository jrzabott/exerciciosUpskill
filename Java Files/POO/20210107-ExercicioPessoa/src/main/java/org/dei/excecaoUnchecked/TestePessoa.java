package org.dei.excecaoUnchecked;

import java.util.Scanner;

public class TestePessoa {

    public static void main(String[] args) {

        Scanner ler = new Scanner(System.in);

        Pessoa p = new Pessoa();

        do {
            try {
                System.out.println("\n\nNome:");
                String nome = ler.nextLine();
                p.setNome(nome);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (true);

        do {
            try {
                System.out.println("\n\nNº de ID Civil:");
                int idCivil = 0;
                try {
                    idCivil = ler.nextInt();

                } catch (java.util.InputMismatchException e) {
                    throw new ArgumentoForaDosLimitesException("# Id Civil Inválido.");
                } finally {
                    ler.nextLine();
                }
                p.setIDCivil(idCivil);
                break;
            } catch (ArgumentoForaDosLimitesException e) {
                System.out.println(e.getMessage());
            }
        } while (true);

        System.out.println("\nPessoa: " + p);

    }

}
