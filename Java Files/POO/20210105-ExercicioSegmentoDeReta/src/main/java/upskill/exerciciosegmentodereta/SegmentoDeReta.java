/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upskill.exerciciosegmentodereta;

/**
 *
 * @author user
 */
public class SegmentoDeReta extends Ponto {

    private Ponto A;
    private Ponto B;

    public SegmentoDeReta(Ponto A, Ponto B) {
        this.A = A;
        this.B = B;
    }

    public SegmentoDeReta(Ponto B) {
        this.A = new Ponto();
        this.B = B;
    }

    public SegmentoDeReta() {
        this.A = new Ponto();
        this.B = new Ponto();
    }

    /**
     * @return the A
     */
    public Ponto getA() {
        return A;
    }

    /**
     * @return the B
     */
    public Ponto getB() {
        return B;
    }

    /**
     * @param A the A to set
     */
    public void setA(Ponto A) {
        this.A = A;
    }

    /**
     * @param B the B to set
     */
    public void setB(Ponto B) {
        this.B = B;
    }

    @Override
    public void incY(int i) {
        A.incY(i);
        B.incY(i);
    }

    @Override
    public void incX(int i) {
        A.incX(i);
        B.incX(i);
    }

    public double length() {
        return Math.sqrt(
                Math.pow(
                        (double) B.getX() - (double) A.getX(),
                        2.0)
                + Math.pow(
                        (double) B.getY() - (double) A.getY(),
                        2.0)
        );
    }

    public double angleX() {
        return (((double) B.getY() - (double) A.getY())
                / ((double) B.getX() - (double) A.getX()));
    }
}
