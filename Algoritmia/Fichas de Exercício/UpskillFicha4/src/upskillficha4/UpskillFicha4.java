/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upskillficha4;

import java.util.Scanner;

/**
 *
 * @author jrzab
 */
public class UpskillFicha4 {

    private static Scanner s = new Scanner(System.in);
    private static String separator = new String("============================="
            + "===================================================");

    final private static String ESFERA = "esfera";
    final private static String CILINDRO = "cilindro";
    final private static String CONE = "cone";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {

        menu();
    }

    public static void Ficha4Ex1Sincrono() {
        System.out.println(separator);
        System.out.println("Esta função irá calcular os numeros perfeitos de "
                + "zero até 10.0000");
        System.out.println(separator);

        int limI;
        limI = 0;
        int limS;
        limS = 10000;

        for (int i = limI; i <= limS; i++) {
            if (perfeito(i)) {
                System.out.println(i + " is a perfect number");
            }
        }
    }

    public static void Ficha4Ex2Sincrono() {
        int nDisc, nAlunos, nPos;
        String nome;
        System.out.println(separator);
        System.out.println("Faça um programa que represente sob a forma de "
                + "gráficos de barras, o número de positivas e\n"
                + "negativas dos alunos de uma turma a um conjunto de "
                + "disciplinas. O programa deverá começar por\n"
                + "pedir o nº de disciplinas e para cada disciplina "
                + "pedirá o nome da disciplina, o nº de alunos da\n"
                + "disciplina e o nº de alunos aprovados.\n"
                + "Deve existir um módulo para imprimir a informação de uma "
                + "disciplina.");
        System.out.println(separator);
        System.out.print("Número de Disciplinas:\n>");
        nDisc = s.nextInt();
        s.nextLine();

        for (int i = 0; i < nDisc; i++) {
            System.out.print("Nome da Disciplina:\n>");
            nome = s.nextLine();
            System.out.print("Número de Alunos:\n>");
            nAlunos = s.nextInt();
            System.out.print("Número de Notas Positivas:\n>");
            nPos = s.nextInt();
            s.nextLine();
            System.out.println("");
            grafico(nome, nAlunos, nPos);
        }

    }

    public static void Ficha4Ex3Sincrono() {
        /*
        Faça um programa que determine quantos pontos (X,Y) introduzidos pelo 
        utilizador estão dentro de um círculo. A introdução de pontos termina 
        quando for introduzido um ponto igual ao centro. O programa deverá ler 
        os seguintes dados do teclado:
            • Coordenadas do centro do círculo;
            • Raio do círculo;
            • Pontos a serem testados.
        O programa deverá utilizar um módulo que calcule a distância entre dois 
        pontos. Desenvolva esse módulo atendendo a que para calcular a distância
        entre os dois pontos A(xa, ya) e B(xb, yb) usamos a expressão:
         */
        System.out.println(separator);
        System.out.println("Calcular se uma sequência de pontos encontra-se "
                + "dentro de um círculo, dadas as\ncoordenadas do "
                + "centro do círculo, raio do círculo e coordenadas dos "
                + "pontos");
        System.out.println(separator);

        double xCirc, yCirc, rCirc, xPoint, yPoint;
        System.out.print("Entre com as Coordenadas do círculo.\nCentro do "
                + "Círculo X: ");
        xCirc = s.nextDouble();
        System.out.print("Centro do Círculo Y: ");
        yCirc = s.nextDouble();
        System.out.print("Entre com o raio do círculo - Raio R: ");
        rCirc = s.nextDouble();

        int countP;
        int countDentroCirc;
        countP = 0;
        countDentroCirc = 0;

        do {
            countP++;

            System.out.print("\nEntre com as Coordenadas Ponto a Testar.\nCoord"
                    + " do Ponto - X: ");
            xPoint = s.nextDouble();
            System.out.print("Coord do Ponto - Y: ");
            yPoint = s.nextDouble();

            if (testarPonto(xCirc, yCirc, rCirc, xPoint, yPoint)) {
                System.out.println("DENTRO DO CÍRCULO");
                countDentroCirc++;
            } else {
                System.out.println("FORA DO CÍRCULO");
            }

        } while (xPoint != xCirc || yPoint != yCirc);
        System.out.println("\n\n" + separator + "\nTotal de pontos dentro do "
                + "círculo: "
                + countDentroCirc + "\nTotal de Pontos Testados: " + countP
                + "\n% de Precisão:"
                + ((countDentroCirc * 1.0) / (countP * 1.0) * 100.0 + "%\n"
                + separator));
//        Thread.sleep(3000);
        System.out.println("\nA sair da aplicação...");

    }

    public static void Ficha4Ex4SincronoA() {
        System.out.println(separator);
        System.out.println("Esta função irá mostrar a soma dos divisores pares "
                + "do número 8");
        System.out.println(separator);

        int someDivisores = somaDivPares(8);
        System.out.println(someDivisores);
    }

    public static void Ficha4Ex4SincronoB() {
        /*
        Elabore um programa que, dada uma sequência de números positivos, 
        determine e apresente a percentagem de números cuja soma dos seus 
        divisores pares é a maior.
         */
        System.out.println(separator);
        System.out.println("dada uma sequência de números positivos, "
                + "determine e apresente a\npercentagem de números cuja soma "
                + "dos seus divisores pares é a maior.");
        System.out.println(separator);

//        s.nextLine();
        int countN; // Conta numeros inseridos
        int countSoma; // contagem dos numeros que a soma é igual à maior soma.
        int somaDivPares; // armazena a soma dos div pares do numero corrent.
        int maiorSomaDivPares;
        int n; // entrada do user.
        maiorSomaDivPares = 0;
        somaDivPares = 0;
        countSoma = 0;
        countN = 0;

        do {
            System.out.println("Entre número positivo: ");
            n = s.nextInt();
            if (n > 0) {
                countN++;

                somaDivPares = somaDivPares(n);
                if (maiorSomaDivPares < somaDivPares) {
                    maiorSomaDivPares = somaDivPares;
                    countSoma = 0;
                }
                if (somaDivPares == maiorSomaDivPares) {
                    countSoma++;
                }
            }
        } while (n > 0);
        System.out.println("% de soma de div pares é a maior: " + ((countSoma
                * 1.0) / (countN * 1.0) * 100.0) + "%.");
    }

    public static void Ficha4Ex5SincronoA() {

        System.out.println(separator);
        System.out.println("Este programa lê 3 numeros inteiros positivos,"
                + " que representam os 3 lados de um triângulo.\nIrá calcular"
                + "a viabialidade de um triangulo com estes lados.");
        System.out.println(separator);

        double a, b, c;
        a = lerLadoTriangulo("a");
        b = lerLadoTriangulo("b");
        c = lerLadoTriangulo("c");

        boolean trianguloValido;
        trianguloValido = isTriangle(a, b, c);
        System.out.println("Triânguloe é válido? " + trianguloValido);
    }

    public static void Ficha4Ex5SincronoB() {

        System.out.println(separator);
        System.out.println("Este programa lê 3 numeros inteiros positivos,"
                + " que representam os 3 lados de um triângulo.\nIrá calcular"
                + "a viabialidade de um triangulo com estes lados,"
                + "\ncaso formem um triângulo, iremos calcular seus ângulos "
                + "internos.");
        System.out.println(separator);

        double a, b, c;
        a = lerLadoTriangulo("a");
        b = lerLadoTriangulo("b");
        c = lerLadoTriangulo("c");

        if (isTriangle(a, b, c)) {
            double aVb, bVc, aVc;
            aVb = calcularAngulo(a, b, c);
            aVc = calcularAngulo(a, c, b);
            bVc = calcularAngulo(b, c, a);
            System.out.println("Ângulo a^b: " + aVb + "rad ou "
                    + Math.toDegrees(aVb) + "º.");
            System.out.println("Ângulo a^c: " + aVc + "rad ou "
                    + Math.toDegrees(aVc) + "º.");
            System.out.println("Ângulo b^c: " + bVc + "rad ou "
                    + Math.toDegrees(bVc) + "º.");
        } else {
            System.out.println("Lados informados não geram um triângulo.");
        }

    }

    private static void Ficha4Ex6Sincrono() {
        System.out.println(separator);
        System.out.println("Esta função calcula a permanência de numero inteiro"
                + "e positivo");
        System.out.println(separator);

        int num = lerNumInt("Entre com um numero inteiro e positivo: ", 0);

        int perm = calcularPermanencia(num);
        System.out.println("\nPermanência: " + perm);
    }

    private static void Ficha4Ex1AssincronoA() {
        System.out.println(separator);
        System.out.println("Verifica se numero é capicua.");
        System.out.println(separator);

        int num = lerNumInt("Insira um numero inteiro positivo: ", 0);
        boolean eCapicua = eCapicua(num);
        if (eCapicua) {
            System.out.println("E Capicua");
        } else {
            System.out.println("Não é Capicua");
        }
    }

    private static void Ficha4Ex1AssincronoB() {
        System.out.println(separator);
        System.out.println("Verifica se um numero é capicua continuamente."
                + "\nAté que alcance 100 numeros ou ache um capicua.");
        System.out.println(separator);
        int count = 1;
        boolean eCapicua = false;

        while (!eCapicua && count <= 100) {
            int num = lerNumInt("Insira um numero inteiro positivo: ", 0);
            eCapicua = eCapicua(num);
            if (eCapicua) {
                System.out.println("Numero " + num + " é Capicua.\nFim...");
            } else {
//                System.out.println("Não é Capicua");
                count++;
            }
        }
        if (count >= 100) {
            System.out.println("100 numeros foram inseridos, nenhum deles "
                    + "capicua.");
        }
    }

    private static void Ficha4Ex2Assincrono() {
        System.out.println(separator);
        System.out.println("Mostra os primeiros N termos da sucessão de "
                + "Fibonacci onde N é definido\npelo utilizador.");
        System.out.println(separator);

        int n = lerNumInt("Entre com um numero positivo: ", 0);

        fib(n);
    }

    private static void Ficha4Ex3Assincrono() {
        System.out.println(separator);
        System.out.println("Calcula a área dos sólidos: cilindro cone ou esfera"
                + "");
        System.out.println(separator);
        String solido = new String();

        do {
            System.out.println("\n\nEntre com o solido desejado: ");
            solido = s.next();
            solido = solido.toLowerCase();
        } while (!solido.equals(CONE) && !solido.equals(CILINDRO)
                && !solido.equals(ESFERA));

        double raio = lerNumDouble("Entre com o raio do sólido: ", 0);
        double altura = 0.0;
        if (!solido.equals(ESFERA)) {
            altura = lerNumDouble("Entre com a altura do sólido: ", 0);
        }
        double area = calcularAreaSolidoRevolucao(solido, raio, altura);
        System.out.println("A area do solido \"" + solido + "\" é de: " + area);

    }

    private static void Ficha4Ex4AssincronoA() {

        System.out.println(separator);
        System.out.println("Verifica se um numero Decimal é Octal");
        System.out.println(separator);

        int num;
        num = lerNumInt("Entre com um número inteiro positivo de base 10: ", 0);

        if (eOctal(num)) {
            System.out.println("É Octal");
        } else {
            System.out.println("Não Octal");
        }

    }

    private static void Ficha4Ex4AssincronoB() {
        System.out.println(separator);
        System.out.println("Converte numero Octal em Decimal");
        System.out.println(separator);

        int nOct = lerNumInt("Entre com um numero octal inteiro e positivo: ",
                0);
        System.out.println(converteDecimalParaOctal(nOct));
    }

    private static void Ficha4Ex4AssincronoC() {
        System.out.println(separator);
        System.out.println("Converte uma seris de numeros octais em Decimal, "
                + "ate que um numero\nnão-octal seja inserido");
        System.out.println(separator);

        int nOct, nDec;
        boolean eOct = false;
        do {
            nOct = lerNumInt("Entre com um numero octal inteiro e positivo: ",
                    0);
            nDec = converteDecimalParaOctal(nOct);
            eOct = eOctal(nOct);
            if (eOct) {
                System.out.println("Número em Base 10: " + nDec + ".\n");
            }
        } while (eOct);
        System.out.println("Utilizador entrou com um numero não-octal.\n"
                + "Fim da aplicação.");

    }

    public static void menu() throws InterruptedException {
        int num = 0;
        Scanner s = new Scanner(System.in);
        do {
            System.out.print(
                    "\n\nSelecione o Exercicio que Deseja executar, entre -1 "
                    + "para sair:\n"
                    + " <===> Exercicios Sincronos: <==>\n"
                    + "1 - Exercicio 1 *\n"
                    + "2 - Exercicio 2 *\n"
                    + "3 - Exercicio 3 *\n"
                    + "4 - Exercicio 4 a) *\n"
                    + "5 - Exercicio 4 b) *\n"
                    + "6 - Exercicio 5 a) *\n"
                    + "7 - Exercicio 5 b) *\n"
                    + "8 - Exercicio 6 *\n"
                    + "\n"
                    + " ===> Exercicios Assincronos: ==>\n"
                    + "9 - Exercicio 1 a) *\n"
                    + "10 - Exercicio 1 b) *\n"
                    + "11 - Exercicio 2 *\n"
                    + "12 - Exercicio 3 *\n"
                    + "13 - Exercicio 4 a) *\n"
                    + "14 - Exercicio 4 b) *\n"
                    + "15 - Exercicio 4 c) *\n"
                    + ">");
            num = s.nextInt();

            if (num > -1) {
                switch (num) {
                    case 1:
                        Ficha4Ex1Sincrono();
                        break;
                    case 2:
                        Ficha4Ex2Sincrono();
                        break;
                    case 3:
                        Ficha4Ex3Sincrono();
                        break;
                    case 4:
                        Ficha4Ex4SincronoA();
                        break;
                    case 5:
                        Ficha4Ex4SincronoB();
                        break;
                    case 6:
                        Ficha4Ex5SincronoA();
                        break;
                    case 7:
                        Ficha4Ex5SincronoB();
                        break;
                    case 8:
                        Ficha4Ex6Sincrono();
                        break;
                    case 9:
                        Ficha4Ex1AssincronoA();
                        break;
                    case 10:
                        Ficha4Ex1AssincronoB();
                        break;
                    case 11:
                        Ficha4Ex2Assincrono();
                        break;
                    case 12:
                        Ficha4Ex3Assincrono();
                        break;
                    case 13:
                        Ficha4Ex4AssincronoA();
                        break;
                    case 14:
                        Ficha4Ex4AssincronoB();
                        break;
                    case 15:
                        Ficha4Ex4AssincronoC();
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

    /*
     * =====================================================================
     *                        FUNÇÕES AUXILIARES
     * =====================================================================
     */
    private static int lerLadoTriangulo(String nomeLado) {
        int num;
        do {
            System.out.print("Entre com o lado " + nomeLado + ") ");
            num = s.nextInt();
        } while (num < 1);
        return num;
    }

    private static int lerNumInt(String desc, int limite) {
        int num;
        do {
            System.out.print(desc);
            num = s.nextInt();
        } while (num < limite);
        return num;
    }

    private static void grafico(String nome, int nAlunos, int nPos) {
        System.out.println("Disciplina: " + nome);
        String linha = " - Positivas: ";
        for (int i = 1; i <= nPos; i++) {
            linha += "* ";
        }
        System.out.println(linha);

        linha = " - Negativas: ";
        for (int i = 0; i < nAlunos - nPos; i++) {
            linha += "* ";
        }
        System.out.println(linha);
    }

    private static boolean perfeito(int num) {
        //calcular divisores
        int soma = 0;
        for (int i = 1; i <= num / 2; i++) {
            if (num % i == 0) {
                soma += i;
            }
        }
        return (soma == num) ? true : false;
    }

    private static boolean testarPonto(double xCirc, double yCirc, double rCirc,
            double xPoint, double yPoint) {
        double distDoCentroDoCirculo;
        distDoCentroDoCirculo = calcularDistanciaEntreDoisPontos(xCirc, yCirc,
                xPoint, yPoint);
        return distDoCentroDoCirculo <= rCirc;
    }

    private static double calcularDistanciaEntreDoisPontos(double xCirc,
            double yCirc, double xPoint, double yPoint) {
        return Math.sqrt(Math.pow(xPoint - xCirc, 2) + Math.pow(yPoint - yCirc,
                2));
    }

    private static int somaDivPares(int num) {
        int soma = 0;
        for (int i = 1; i <= num / 2; i++) {
            if (i % 2 == 0 && num % i == 0) {
                soma += i;
            }
        }
        return soma;
    }

    private static boolean isTriangle(double a, double b, double c) {
        boolean ab, ac, bc;
        ab = checkTriangleSides(a, b, c);
        ac = checkTriangleSides(a, c, b);
        bc = checkTriangleSides(b, c, a);

        return ab && ac && bc;
    }

    private static boolean checkTriangleSides(double x, double y, double z) {
        return x + y > z;
    }

    private static double calcularAngulo(double x, double y, double z) {
        return Math.acos((x * x + y * y - z * z) / (2 * x * y));
    }

    private static int calcularPermanencia(int num) {

        int prod = 1;
        int dig, count;
        count = 0;

        while (num > 0) {
            dig = num % 10;
            num = num / 10;
            prod *= dig;
        }
        count++;
        System.out.print(prod + " ");
        if (prod / 10 > 0) {
            count += calcularPermanencia(prod);
        }

        return count;
    }

    private static boolean eCapicua(int num) {
        int numInv, numOrig;
        int dig;
        numOrig = num;
        numInv = 0;
        while (num > 0) {
            dig = num % 10;
            numInv = (numInv * 10 + dig);
            num /= 10;
        }
        return numOrig == numInv;
    }

    private static void fib(int n) {
        int n1 = 0, n2 = 1, tmp;
        System.out.println("1 ");
        for (int i = 1; i < n; i++) {
            System.out.println(n1 + n2 + " ");
            tmp = n1;
            n1 = n2;
            n2 += tmp;
        }
    }

    private static double lerNumDouble(String string, double limite) {
        double num;
        do {
            System.out.print(string);
            num = Double.parseDouble(s.next());
        } while (num < limite);
        return num;
    }

    private static double calcularAreaSolidoRevolucao(String solido, double raio, double altura) {

        double result = 0.0;

        switch (solido) {
            case CILINDRO:
                result = calcularAreaCilindro(raio, altura);
                break;
            case CONE:
                result = calcularAreaCone(raio, altura);
                break;
            case ESFERA:
                result = calcularAreaEsfera(raio);
                break;
            default:
                System.out.println("Calculo de Volume deste sólido não "
                        + "implementado.");
        }
        return result;
    }

    private static double calcularAreaCilindro(double raio, double altura) {
        return (Math.pow(raio, 2) * Math.PI * altura);
    }

    private static double calcularAreaCone(double raio, double altura) {
        return (Math.PI * Math.pow(raio, 2) * altura / 3.0);
    }

    private static double calcularAreaEsfera(double raio) {
        return (4.0 / 3.0 * Math.PI * Math.pow(raio, 3));
    }

    private static boolean eOctal(int num) {
        boolean result = true;
        int dig = 0;

        while (num > 0 && result) {
            dig = num % 10;
            num /= 10;
            if (dig > 7) {
                result = false;
            }
        }
        return result;
    }

    private static int converteDecimalParaOctal(int nOct) {
        int numDec = 0;
        int exp, dig;
        exp = 0;
        while (nOct > 0) {
            dig = nOct % 10;
            numDec += dig * ((int) Math.pow(8, exp));
            exp++;
            nOct /= 10;
        }
        return numDec;
    }

}
