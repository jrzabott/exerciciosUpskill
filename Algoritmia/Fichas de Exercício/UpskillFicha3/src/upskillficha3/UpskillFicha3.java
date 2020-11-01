/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upskillficha3;

import java.util.Scanner;

/**
 *
 * @author jrzab
 */
public class UpskillFicha3 {

    private static Scanner s = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        int num = 0;
        Scanner s = new Scanner(System.in);
        do {
            System.out.print(
                    "\n\nSelecione o Exercicio que Deseja executar, entre -1 "
                    + "para sair:\n"
                    + " <===> Exercicios Sincronos: <==>\n"
                    + "1 - Exercicio 1 a) *\n"
                    + "2 - Exercicio 1 b) *\n"
                    + "3 - Exercicio 2\n"
                    + "4 - Exercicio 3 *\n"
                    + "5 - Exercicio 4\n"
                    + "6 - Exercicio 5\n"
                    + "\n"
                    + " ===> Exercicios Assincronos: ==>\n"
                    + "7 - Exercicio 1 *\n"
                    + "8 - Exercicio 2\n"
                    + "9 - Exercicio 3 *\n"
                    + "10 - Exercicio 4 *\n"
                    + "11 - Exercicio 5 *\n"
                    + ">");
            num = s.nextInt();

            if (num > -1) {
                switch (num) {
                    case 1:
                        Ficha3Ex1SincronoA();
                        break;
                    case 2:
                        Ficha3Ex1SincronoB();
                        break;
                    case 4:
                        Ficha3Ex3Sincrono();
                        break;
                    case 7:
                        Ficha3Ex1Assincrono();
                        break;
                    case 9:
                        Ficha3Ex3Assincrono();
                        break;
                    case 10:
                        Ficha3Ex4Assincrono();
                        break;
                    case 11:
                        Ficha3Ex5Assincrono();
                        break;
                    default:
                        System.out.println("\nNÃO IMPLEMENTADO\n");
                }
                Thread.sleep(2000);
            } else {
                System.out.println("A sair da aplicação...");

            }

        } while (num > -1);

    }

    public static void Ficha3Ex1SincronoA() {
        int num, dig, somaP = 0;
        dig = 0;
        System.out.println("\n================================================="
                + "===============================\n"
                + "Esta função irá ler umum numero inteiro e somar os algorismos"
                + "pares."
                + "\n=================================================="
                + "==============================\n");

        do {
            System.out.print("Entre com o alrogismo:\n>");
            num = s.nextInt();
            System.out.println("");
            if (num <= 0) {
                System.out.println("Inserir um numero inteiro positivo.");
            }
        } while (num <= 0);

        while (num % 10 > 0) {
            dig = num % 10;
            if (dig % 2 == 0) {
                somaP += dig;
            }
            num /= 10;
        }
        if (somaP > 0) {
            System.out.println("Soma dos algorismos pares: " + somaP);
        }
    }

    public static void Ficha3Ex1SincronoB() {
        int num, dig, somaP;
        System.out.println("\n================================================="
                + "===============================\n"
                + "Esta função irá ler uma sequência de numeros inteiros "
                + "positivos  e somar os algorismos pares."
                + "\n=================================================="
                + "==============================\n");

        System.out.print("Entre com o algorismo:\n>");
        num = s.nextInt();
        while (num > 0) {
            somaP = 0;
            dig = 0;

            while (num % 10 > 0) {
                dig = num % 10;
                if (dig % 2 == 0) {
                    somaP += dig;
                }
                num /= 10;
            }
            if (somaP > 0) {
                System.out.println("Soma dos algorismos pares: " + somaP);
            }
            System.out.print("Entre com o alrogismo:\n>");
            num = s.nextInt();
            System.out.println("");
        }
        System.out.println("Utilizador Inseriu numero não-positivo. A sair da aplicação...");
    }

    public static void Ficha3Ex1Assincrono() {
        /*
        Elabore um algoritmo que peça ao utilizador um valor par, com quatro 
        dígitos e apresente todos os inteiros múltiplos de 7, entre 0 e esse 
        valor. O pedido do valor deve manter-se até o utilizador introduzir um 
        valor nas condições pretendidas.
         */
        int count = 7, num;
        Scanner s = new Scanner(System.in);

        System.out.println("\n================================================="
                + "===============================\n"
                + "Esta função irá apresentar todos os múltiplos de 7 até o "
                + "valor inserido. \n A entrada deve ser um número par com "
                + "4 dígitos."
                + "\n=================================================="
                + "==============================\n");
        do {
            System.out.println("Entre com um número: ");
            num = s.nextInt();
        } while (num % 2 != 0 || num < 999 || num > 10000);

        for (int i = 0; i <= num; i += 7) {
            System.out.println(i);
        }

    }

    public static void Ficha3Ex3Assincrono() {
        /*
        Leia a altura de duas crianças e o número de centímetros que crescem por
        ano. Pretende-se saber se a criança mais baixa pode alcançar a mais alta
        e nesse caso em quantos anos isso acontece, visualizando a evolução das 
        alturas ano a ano.
         */
        Scanner scanner = new Scanner(System.in);
        System.out.println("Entre com a altura da 1ª criança: ");
        double alt1 = scanner.nextFloat();
        System.out.println("Entre com a Taxa de Crescimento da 1ª criança: ");
        double tx1 = scanner.nextFloat();
        System.out.println("Entre com a altura da 2ª criança: ");
        double alt2 = scanner.nextFloat();
        System.out.println("Entre com a Taxa de Crescimento altura da 2ª "
                + "criança: ");
        double tx2 = scanner.nextFloat();
        double tmp;
        int ano = 0;
        if (alt2 < alt1) {
            System.out.println("2ª criança é mais alta. \nEste algoritmo "
                    + "considera a criança 1 a mais baixa.\nA inverter "
                    + "alturas...");
            tmp = alt1;
            alt1 = alt2;
            alt2 = tmp;
            tmp = tx1;
            tx1 = tx2;
            tx2 = tmp;
        }
        if (tx1 > tx2) {
            System.out.println("RESULTADO: CRIANÇA 1 ALCANÇARÁ A CRIANÇA 2.");
            do {
                alt1 += tx1;
                alt2 += tx2;
                ano++;
                System.out.println("ANO: " + ano + " CRIANÇA 1: " + alt1
                        + " CRIANÇA 2: " + alt2);
            } while (alt1 < alt2);
            System.out.println("NÚMERO DE ANOS NECESSÁRIOS: " + ano);
        } else {
            System.out.println("RESULTADO: CRIANÇA 1 NUNCA CRESCERÁ MAIS QUE "
                    + "CRIANÇA 2");
        }

    }

    public static void Ficha3Ex4Assincrono() {
        /*
        Elabore um algoritmo que, dado um número inteiro positivo, determine o 
        comprimento máximo de um segmento crescente dos seus algarismos.
        Exemplo:
            • Entrada: 321477
            • Saída: 3
         */
        System.out.println("\n================================================="
                + "===============================\n"
                + "comprimento máximo de um segmento crescente dos seus algarismos"
                + "\n=================================================="
                + "==============================\n");
        Scanner scanner = new Scanner(System.in);
        int num = 0;
        do {
            num = scanner.nextInt();
        } while (num <= 0);
        int dig;
        int countSeq = 1;
        int maiorSeq = 1;
        while (num > 0) {
            dig = num % 10;
            num = num / 10;

            if (dig > num % 10) {
                countSeq++;
                if (countSeq > maiorSeq) {
                    maiorSeq = countSeq;
                }
            } else {
                countSeq = 1;
            }
        }
        System.out.println(maiorSeq);
    }

    public static void Ficha3Ex5Assincrono() {
        /*
        Crie um algoritmo que leia um número entre 2 e 20 e visualize no ecrã 
        a sequencia expressa no exemplo seguinte:
            • Entrada: 4
            • Saída: 1 1 2 1 2 3 1 2 3 4 1 2 3 1 2 1
            • A sequencia anterior pode ser melhor compreendida usando a 
              formatação seguinte:
            1 
            1 2
            1 2 3
            1 2 3 4
            1 2 3
            1 2
            1
         */
        System.out.println("\n================================================="
                + "===============================\n"
                + "Esta função irá ler um numero entre 2 e 20. "
                + "Irá imprimir os numeros em um formato geométrico."
                + "\n=================================================="
                + "==============================\n");
        Scanner scanner = new Scanner(System.in);
        int num;
        int count = 1;
        do {
            num = scanner.nextInt();
        } while (num < 2 || num > 20);

        for (int i = 0; i < num; i++) {
            while (count <= i + 1) {
                System.out.print(count + " ");
                count++;
            }
            System.out.println();
            count = 1;
        }
        count = 1;
        for (int i = num - 1; i > 0; i--) {
            while (count <= i) {
                System.out.print(count + " ");
                count++;
            }
            count = 1;
            System.out.println();
        }
//         System.out.println(num);
    }

    private static void Ficha3Ex3Sincrono() {
        int num, num1, dig;
        dig = 0;
        System.out.println("\n================================================="
                + "===============================\n"
                + "Esta função irá ler um número inteiro positivo e invertê-lo "
                + "\n=================================================="
                + "==============================\n");

        do {
            System.out.print("Inserir Número:\n>");
            num = s.nextInt();
            if (num % 2 != 0 || num % 3 == 0) {
                System.out.println("Numero não pode ser multiplo de 3, e deve "
                        + "ser par");
            }
        } while (num % 2 != 0 || num % 3 == 0);
        num1 = 0;
        while (num != 0) {
            dig = num % 10;
            num1 = (num1 * 10) + dig;
            num = num / 10;
        }
        System.out.println("Resultado: " + num1);

    }
}
