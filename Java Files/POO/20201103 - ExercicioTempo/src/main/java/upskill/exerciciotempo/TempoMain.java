/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upskill.exerciciotempo;

/**
 *
 * @author user
 */
public class TempoMain {

    private static String separator = "========================================"
            + "========================================";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Tempo t = new Tempo(10, 00, 00);
        System.out.println(t);
        t.tick();
        System.out.println(t);

        t.setSs(59);
        t.tick();
        System.out.println(t);

        t.setSs(59);
        t.setMm(59);
        t.tick();
        System.out.println(t);

        t.setSs(59);
        t.setMm(59);
        t.setHh(23);
        t.tick();
        System.out.println(t);

        System.out.println(t.secondsToTempoObject(3700));
        String separator = "========================================"
                + "========================================";

        System.out.println(separator);
        System.out.println("Crie uma instância da classe Tempo com o nome t1 e "
                + "que represente o tempo: \n5 horas, 30 minutos e 12 segundos."
        );
        System.out.println(separator);
        Tempo t1 = new Tempo(5, 30, 12);
        System.out.println(t1);

        System.out.println(separator);
        System.out.println("Mostre o tempo t1 usando o formato hh:mm:ss AM "
                + "(ou PM)"
        );
        System.out.println(separator);
        System.out.println(t1.formatAMPM());

        System.out.println(separator);
        System.out.println("Acrescente 1 segundo ao tempo t1.");
        System.out.println(separator);
        t1.tick();
        System.out.println("t1.tick()");

        System.out.println(separator);
        System.out.println("Mostre novamente t1 usando o formato “hh:mm:ss AM "
                + "(ou PM)”.");
        System.out.println(separator);
        System.out.println(t1.formatAMPM());

        System.out.println(separator);
        System.out.println("Crie uma outra instância da classe Tempo chamada t2"
                + "que guarde o tempo:18 horas,\n5 minutos e 20 segundos.");
        System.out.println(separator);
        Tempo t2 = new Tempo(18, 5, 20);
        System.out.println("Tempo t2 = new Tempo(18, 5, 20);");

        System.out.println(separator);
        System.out.println("Mostre o tempo t2 usando o formato “hh:mm:ss AM "
                + "(ou PM)”.");
        System.out.println(separator);
        System.out.println(t2.formatAMPM());

        System.out.println(separator);
        System.out.println("Verifique se o tempo t1 é maior do que o tempo 23"
                + "horas, 7 minutos\ne 4 segundos usando o método que recebe "
                + "por parâmetro as horas, os minutos e\nos segundos de um "
                + "tempo.");
        System.out.println(separator);
        System.out.println("t1.isGreater(23, 7, 4): " + t1.isGreater(23, 7, 4));

        System.out.println(separator);
        System.out.println("Determinar a diferença entre o tempo t1 e o tempo "
                + "t2:");
        System.out.println("Segundos");
        System.out.println(separator);
        System.out.println("t1.calcDiffReturnsSeconds(t2): " 
                + t1.calcDiffReturnsSeconds(t2))
                ;

        System.out.println(separator);
        System.out.println("Determinar a diferença entre o tempo t1 e o tempo "
                + "t2:");
        System.out.println("Objeto Tempo");
        System.out.println(separator);
        System.out.println("t1.calcDiffReturnsSeconds(t2): "
                + t1.calcDiffReturnsTempoObject(t2).toString() + ",ou ainda: " 
                + t1.calcDiffReturnsTempoObject(t2).formatAMPM()
                );

    }

}
