package pkg_Exc1a;

public class Teste1 {

    public static int divide(int a,int b) {
        return a/b;
    }
    public static int f(int a,int b) {
        return divide(a,b);
    }
    public static void main(String args []) {      
        System.out.println(f(5,2));
        System.out.println(f(3,0));
        System.out.println(f(4,1)); 
    }
} 
