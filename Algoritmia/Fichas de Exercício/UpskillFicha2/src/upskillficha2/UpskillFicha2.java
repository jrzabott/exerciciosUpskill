/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upskillficha2;

import java.util.Scanner;

/**
 *
 * @author jrzab
 */
public class UpskillFicha2 {

    private static Scanner s = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        menu();
    }

    public static void menu() throws InterruptedException {
        int num = 0;
        Scanner s = new Scanner(System.in);
        do {
            System.out.print(
                    "\n\nSelecione o Exercicio que Deseja executar, entre -1 para "
                    + "sair:\n"
                    + " <===> Exercicios Sincronos: <==>\n"
                    + "1 - Exercicio 1\n"
                    + "2 - Exercicio 2 *\n"
                    + "3 - Exercicio 3\n"
                    + "\n"
                    + " ===> Exercicios Assincronos: ==>\n"
                    + "4 - Exercicio 1 *\n"
                    + "5 - Exercicio 2 *\n"
                    + "6 - Exercicio 3 *\n"
                    + "7 - Exercicio 4 *\n"
                    + "8 - Exercicio 5\n"
                    + "9 - Exercicio 6\n"
                    + ">");
            num = s.nextInt();

            switch (num) {
//                case 1:
//                    Ficha2Ex1Sincrono();
//                    break;
                case 2:
                    Ficha2Ex2Sincrono();
                    break;
//                case 3:
//                    Ficha2Ex3Sincrono();
//                    break;
                case 4:
                    Ficha2Ex1Assincrono();
                    break;
                case 5:
                    Ficha2Ex2Assincrono();
                    break;
                case 6:
                    Ficha2Ex3Assincrono();
                    break;
                case 7:
                    Ficha2Ex4Assincrono();
                    break;
//                case 8:
//                    Ficha2Ex5Assincrono();
//                    break;
//                case 9:
//                    Ficha2Ex6Assincrono();
//                    break;
                default:
                    System.out.println("\nNÃO IMPLEMENTADO\n");
            }
            Thread.sleep(2000);

        } while (num > -1);

    }

    public static void Ficha2Ex2Sincrono() {
        /*
        Desenvolva um algoritmo que permita ler as notas que N alunos obtiveram 
        numa disciplina e mostre a percentagem de notas positivas e a média das 
        notas negativas. O número de alunos (N) deve ser introduzido pelo 
        utilizador e validado.
         */
        double nota, somaN;
        double percP, mediaN;
        int alunos, countP;
        somaN = 0;
        countP = 0;
        System.out.println("\n================================================="
                + "===============================\n"
                + "Esta função irá ler um nº de alunos."
                + "\n"
                + "Ler as notas, calcular positivas e negativas (sem validação)"
                + "\n"
                + "Ao fim exibirá o % de positivas e a MÉDIA das negativas."
                + "\n=================================================="
                + "==============================\n");

        do {
            System.out.print("Inserir o nº de Alunos:\n>");
            alunos = s.nextInt();
            System.out.println();
            if (alunos < 1) {
                System.out.println("O Nº de alunos deve ser positivo:\n\n");
            }
        } while (alunos < 1);
        for (int i = 0; i < alunos; i++) {
            System.out.print("Inserir Nota do Aluno(" + (i + 1) + "): ");
            nota = s.nextDouble();
            if (nota > 9.0) {
                countP++;
            } else {
                somaN += nota;
            }
        }
        percP = (countP * 1.0) / (alunos * 1.0);
        mediaN = somaN / (alunos - countP);
        System.out.println("% Positivas: " + percP + " Média Negativas: "
                + mediaN);

    }

    public static void Ficha2Ex1Assincrono() {
        /*
        Desenvolva um algoritmo que permita ler uma sequência de números 
        positivos terminada por um número não positivo e mostre a percentagem 
        dos nº pares e a média dos ímpares.
         */
        double num, somaI = 0, mediaI = 0;
        int countP = 0, count = 0;

        System.out.println("\n================================================="
                + "===============================\n"
                + "Esta função irá ler uma sequencia de numeros positivos. "
                + "Para interromper a leitura, deves inserir um numero <= 0"
                + "Ao fim exibirá o % de nºs pares e a MÉDIA dos nºs impares."
                + "\n=================================================="
                + "==============================\n");
        System.out.println("Entre com um número: ");
        num = s.nextDouble();

        while (num > 0) {
            count++;
            if (num % 2 == 0) {
                countP++;
            } else {
                somaI += num;
            }
            System.out.println("Entre com um número: ");
            num = s.nextDouble();
        }

        if (count > 0) {
            mediaI = (countP * 1.0) / (count * 1.0);
            System.out.println("% Pares: " + mediaI + " | Média Impares: " + (somaI / (count - countP)));
        }

    }

    public static void Ficha2Ex2Assincrono() {
        /*
     * Elabore um algoritmo para listar todos os números pares múltiplos de 3 de 
     * um intervalo fechado à esquerda e aberto à direita, definido pelo 
     * utilizador. Este intervalo deve ser validado.
         */
        int limI, limS, tmp;

        do {
            System.out.println("Entre com o limite Inferior do Intervalo: ");
            limI = s.nextInt();
        } while (limI <= 0);

        do {
            System.out.println("Entre com o limite Superior do Intervalo: ");
            limS = s.nextInt();
        } while (limS <= 0);

        if (limI > limS) {
            tmp = limI;
            limI = limS;
            limS = tmp;
        }

        for (int i = limI; i < limS; i++) {
            if (i % 3 == 0) {
                System.out.println(i);
            }
        }

    }

    public static void Ficha2Ex3Assincrono() {
        double limiteSuperior, num, soma, menorNum;
        soma = 0;
        menorNum = 1;
        System.out.println("Limite ");
        limiteSuperior = s.nextDouble();
        System.out.println("Introduza o segundo número");
        num = s.nextDouble();
        menorNum = num;
        while (limiteSuperior > soma) {
            soma = soma + num;
            if (num < menorNum) {
                menorNum = num;
            }
            System.out.println("Introduza o segundo número");
            num = s.nextDouble();
        }
        System.out.println("O numero menor de todos os números é o " + menorNum);
    }

    public static void Ficha2Ex4Assincrono() {
        /*
        Uma pequena empresa nacional vai começar a processar os salários para o 
        corrente mês. Os seus funcionários fizeram horas extraordinárias no mês 
        anterior, as quais serão pagas juntamente com o salário base. O preço de
        cada hora extraordinária é de 2% do salário base.
        Construa um algoritmo que ajude a contabilidade nesta tarefa. O referido
        algoritmo deve:
            • Ler o número de horas extraordinárias e o salário base de cada 
              funcionário;
            • Calcular e mostrar o salário mensal que cada empregado irá receber
              (salário base + valor referente às horas extraordinárias);
            • Calcular e mostrar a média dos salários mensais pagos pela 
              empresa, no mês corrente.
        Nota: Termine a leitura dos dados introduzindo o valor -1 nas horas 
              extraordinárias. Todos os valores introduzidos pelo utilizador 
              devem ser validados.
         */
        double he, sal, soma = 0, media;
        int count = 0;

        System.out.println("Entre o numero de Horas Extraordinárias: ");
        he = s.nextDouble();

        while (he > -1) {
            do {
                System.out.println("Entre o Salário Base do Colaborador: ");
                sal = s.nextDouble();
            } while (sal < 0);

            System.out.println("Salário Base: " + sal + " Valor das HE: " + (0.02 * he * sal));

            soma += (1 + (0.02 * he)) * sal;
            count++;
            System.out.println("\n\nEntre o numero de Horas Extraordinárias: ");
            he = s.nextDouble();

        }
        if (soma > 0) {
            media = soma / count;
            System.out.println("Média de Salários dos Colaboradores: " + media);
        }

    }
}
