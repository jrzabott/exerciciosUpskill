package pkg_Exc1a;

public class Teste5 {

    public static int divide(int a, int b) throws Excecao1 {
        if (b == 0) {
            throw new Excecao1("Divisao por zero!");
        }
        return a / b;
    }

    public static int f(int a, int b) throws Excecao1 {
        return divide(a, b); //ERRO de compilação
    }

    public static void main(String args[]) throws Excecao1 {
        System.out.println(f(5, 2));
        System.out.println(f(3, 0));
        System.out.println(f(4, 1));
    }
}
