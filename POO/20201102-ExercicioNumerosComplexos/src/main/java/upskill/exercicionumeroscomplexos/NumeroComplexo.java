/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upskill.exercicionumeroscomplexos;

/**
 *
 * @author Daniel Junior
 * @version 0.1 This Class was created as an exercise to handle complex numbers.
 */
public class NumeroComplexo {

    private double parteReal;
    private double parteImaginaria;

    /**
     *
     * @param parteReal
     * @param parteImaginaria
     */
    public NumeroComplexo(double parteReal, double parteImaginaria) {
        this.parteReal = parteReal;
        this.parteImaginaria = parteImaginaria;
    }

    /**
     * Zero param Constructor
     */
    public NumeroComplexo() {
    }

    /**
     *
     * @return Real part of the number
     */
    public double getParteReal() {
        return parteReal;
    }

    /**
     *
     * @return Imaginary part of a complex number
     */
    public double getParteImaginaria() {
        return parteImaginaria;
    }

    /**
     *
     * @param parteReal
     */
    public void setParteReal(double parteReal) {
        this.parteReal = parteReal;
    }

    /**
     *
     * @param parteImaginaria
     */
    public void setParteImaginaria(double parteImaginaria) {
        this.parteImaginaria = parteImaginaria;
    }

    @Override
    public String toString() {
        return String.format("NumeroComplexo{Numero complexo = %.2f + (i * %.2f)", getParteReal(), getParteImaginaria());
    }

    /**
     *
     * @return true if the number has no Real part.
     */
    public boolean isReal() {
        return (getParteImaginaria() == 0);
    }

    /**
     *
     * @return trus if the number has no Imaginary part
     */
    public boolean isImaginario() {
        return (getParteReal() == 0);
    }

    /**
     *
     * @param n2 and compare if both numbers are equal
     * @return true if both parts are equal (Real and Imaginary)
     */
    public boolean isEqual(NumeroComplexo n2) {
        return (this.getParteReal() == n2.getParteReal() && this.getParteImaginaria() == n2.getParteImaginaria());
    }

    /**
     *
     * @return the module (length of the vector) of a complex number.
     */
    public double modulo() {
        return Math.sqrt(Math.pow(getParteReal(), getParteReal()) + Math.pow(getParteImaginaria(), getParteImaginaria()));
    }

    /**
     *
     * @return angle in Rad scale.
     */
    public double argumentosEmRad() {
        double seno = getParteImaginaria() / this.modulo();
        double coseno = getParteReal() / this.modulo();
        return seno / coseno;
    }

    /**
     *
     * @return the angle in Degrees
     */
    public double argumentosEmGraus() {
        return argumentosEmRad() * 180 / Math.PI;
    }

    /**
     *
     * @return get the mirrored version of the complex number.
     */
    public NumeroComplexo getConjugado() {
        return new NumeroComplexo(getParteReal(), getParteImaginaria() * (-1));
    }

    /**
     *
     * @param n2 is summed with this ComplexNumber
     * @return a new ComplexNumber
     */
    public NumeroComplexo soma(NumeroComplexo n2) {
        return new NumeroComplexo(this.getParteReal() + n2.getParteReal(), this.getParteImaginaria() + n2.getParteImaginaria());
    }

    /**
     *
     * @param n2 analogue to add
     * @return
     */
    public NumeroComplexo subtracao(NumeroComplexo n2) {
        return new NumeroComplexo(this.getParteReal() - n2.getParteReal(), this.getParteImaginaria() - n2.getParteImaginaria());
    }

    /**
     *
     * @param n2 return the product of a complex number for another
     * @return a Complex Number
     */
    public NumeroComplexo multiplicacao(NumeroComplexo n2) {
        return new NumeroComplexo((this.getParteReal() * n2.getParteReal() - this.getParteImaginaria() * n2.getParteImaginaria()), (this.getParteReal() * n2.getParteImaginaria() + n2.getParteReal() * n2.getParteReal()));
    }

    /**
     *
     * @param n2 analogue to product.
     * @return
     */
    public NumeroComplexo divisao(NumeroComplexo n2) {
        return this.multiplicacao(n2.inversoNumeroComplexo());
    }

    /**
     *
     * @return the inverse of a Complex Number (z ^ -1)
     */
    public NumeroComplexo inversoNumeroComplexo() {
        return new NumeroComplexo(
                getParteReal() / (Math.pow(getParteReal(), 2)
                + Math.pow(getParteImaginaria(), 2)),
                (-1 * getParteImaginaria()) / (Math.pow(getParteReal(), 2)
                + Math.pow(getParteImaginaria(), 2)));
    }
}
