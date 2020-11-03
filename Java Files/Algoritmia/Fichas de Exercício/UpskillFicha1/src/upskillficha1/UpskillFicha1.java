/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upskillficha1;

import java.util.Scanner;

/**
 *
 * @author jrzab
 */
public class UpskillFicha1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        double limiteSuperior, num, soma, menorNum;
        Scanner s = new Scanner(System.in);
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


    

    public static void Ficha1Ex1Sincrono() {
        int num, d1, d2, d3;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Introduza o número: ");
        num = scanner.nextInt();

        if (num < 100 || num > 999) {
            System.out.println("Número não tem 3 dígitos");
        } else {
            d3 = num % 10;
            d2 = (num / 10) % 10;
            d1 = (num / 100) % 10;
            System.out.println(d1 + " " + d2 + " " + d3);
        }

    }

    public static void Ficha1Ex2Sincrono() {

        Scanner s = new Scanner(System.in);

        System.out.println("Hora de Partida: ");
        int hp = s.nextInt();
        System.out.println("Minuto de Partida: ");
        int mp = s.nextInt();
        System.out.println("Horas de Duração: ");
        int hc = s.nextInt();
        System.out.println("Minutos de Duração: ");
        int mc = s.nextInt();

        int soma = (hp + hc) * 60 + mp + mc;
        hc = soma / 60;
        mc = soma % 60;

        if (hc >= 24) {
            System.out.println("Chegará no dia Seguinte: " + (hc - 24) + ":" + mc + ".");
        } else {
            System.out.println("Chegará no mesmo Dia: " + hc + ":" + mc + ".");
        }
    }

    public static void Ficha1Ex3aSincrono() {
        int a, b, c;
        Scanner s = new Scanner(System.in);
        System.out.println("a: ");
        a = s.nextInt();
        System.out.println("b: ");
        b = s.nextInt();
        System.out.println("c: ");
        c = s.nextInt();

        if (a < b && a < c) {
            if (b < c) {
                System.out.println(a + "  " + b + "  " + c);
            } else {
                System.out.println(a + "  " + c + "  " + b);
            }
        } else if (b < a && b < c) {
            if (a < c) {
                System.out.println(b + "  " + a + "  " + c);
            } else {
                System.out.println(b + "  " + c + "  " + a);
            }

        } else {
            if (a < b) {
                System.out.println(c + "  " + a + "  " + b);
            } else {
                System.out.println(c + "  " + b + "  " + a);
            }
        }

    }

    public static void Ficha1Ex3bSincrono() {
        int a, b, c, copo;
        Scanner s = new Scanner(System.in);
        System.out.println("a: ");
        a = s.nextInt();
        System.out.println("b: ");
        b = s.nextInt();
        System.out.println("c: ");
        c = s.nextInt();

        if (a > b) {
            copo = a;
            a = b;
            b = copo;
        }
        if (a > c) {
            copo = a;
            a = c;
            c = copo;
        }
        if (b > c) {
            copo = b;
            b = c;
            c = copo;
        }
        System.out.print(a);
        System.out.print("  ");
        System.out.print(b);
        System.out.print("  ");
        System.out.print(c);
        System.out.println();
    }
}
