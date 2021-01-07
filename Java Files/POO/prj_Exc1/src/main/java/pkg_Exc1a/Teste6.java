package pkg_Exc1a;

public class Teste6 {

    public static int divide(int a, int b) {
        try {
            if (b == 0) {
                throw new Excecao1("Divisao por zero!");
            }
            return a / b;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Resultado nao valido:");
            
            return 0;
        }
    }

    public static int f(int a, int b) {
        return divide(a, b);
    }

    public static void main(String args[]) {
        System.out.println(f(5, 2));
        System.out.println(f(3, 0));
        System.out.println(f(4, 1));
    }
}
