package org.upskill.tributaveis;

public class MainTributaveis {

    public static void main(String[] args) {
        Veiculo v1 = new Veiculo("22-33-CC", 1000, "vermelho");
        System.out.println(v1);
        Veiculo v2 = new Veiculo("44-55-DD", 2500, Cores.AZUL);
        Veiculo v3 = new Veiculo("11-22-BB", 1400, Veiculo.VERDE);
        Moradia m1 = new Moradia("Rua do Bocage", 90, Moradia.CINZENTO);
        System.out.println(m1);

        Cores cor1;
        cor1 = v1;
        System.out.println(cor1);
        cor1 = m1;
        System.out.println(cor1);

        Tributavel[] tributaveis = new Tributavel[10];
        tributaveis[0] = v1;
        tributaveis[1] = v2;
        tributaveis[2] = v3;
        tributaveis[3] = m1;

        double somaImposto = 0.0;
        for (Tributavel itemTributavel : tributaveis) {
            if (itemTributavel != null) {
                somaImposto += itemTributavel.calcularImposto();
            }
        }
        System.out.println(String.format("Total de Imposto: %.2f", somaImposto));
        imprimirObjeto(v2);
        imprimirObjeto(m1);

    }

    private static void imprimirObjeto(Cores obj) {
        System.out.println(obj);
    }
}
