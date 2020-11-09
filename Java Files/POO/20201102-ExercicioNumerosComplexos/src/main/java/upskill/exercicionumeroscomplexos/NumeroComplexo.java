/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upskill.exercicionumeroscomplexos;

/**
 *
 * @author user
 */
public class NumeroComplexo {
    
    private double parteReal;
    private double parteImaginaria;
    
    public NumeroComplexo(double parteReal, double parteImaginaria) {
        this.parteReal = parteReal;
        this.parteImaginaria = parteImaginaria;
    }
    
    public NumeroComplexo() {
    }
    
    public double getParteReal() {
        return parteReal;
    }
    
    public void setParteReal(double parteReal) {
        this.parteReal = parteReal;
    }
    
    public double getParteImaginaria() {
        return parteImaginaria;
    }
    
    public void setParteImaginaria(double parteImaginaria) {
        this.parteImaginaria = parteImaginaria;
    }
    
    @Override
    public String toString() {
        return String.format("NumeroComplexo{Numero complexo = %.2f + (i * %.2f)",parteReal,parteImaginaria );
    }
    
    public boolean isReal() {
        return (parteImaginaria == 0);
    }
    
    public boolean isImaginario() {
        return (parteReal == 0);
    }
    
    public boolean isEqual(NumeroComplexo n2) {
        return (this.parteReal == n2.parteReal && this.parteImaginaria == n2.parteImaginaria);
    }
    
    public double modulo() {
        return Math.sqrt(Math.pow(parteReal, parteReal) + Math.pow(parteImaginaria, parteImaginaria));
    }
    
    public double argumentosEmRad() {
        double seno = parteImaginaria / this.modulo();
        double coseno = parteReal / this.modulo();
        return seno / coseno;
    }
    
    public double argumentosEmGraus() {
        return argumentosEmRad() * 180 / Math.PI;
    }
    
    public NumeroComplexo getConjugado() {
        return new NumeroComplexo(parteReal, parteImaginaria * (-1));
    }
    
    public NumeroComplexo soma(NumeroComplexo n2) {
        return new NumeroComplexo(this.parteReal + n2.parteReal, this.parteImaginaria + n2.parteImaginaria);
    }
    
    public NumeroComplexo subtracao(NumeroComplexo n2) {
        return new NumeroComplexo(this.parteReal - n2.parteReal, this.parteImaginaria - n2.parteImaginaria);
    }
    
    public NumeroComplexo multiplicacao(NumeroComplexo n2) {
        return new NumeroComplexo((this.parteReal * n2.parteReal - this.parteImaginaria * n2.parteImaginaria), (this.parteReal * n2.parteImaginaria + n2.parteReal * n2.parteReal));
    }
    
    public NumeroComplexo divisao(NumeroComplexo n2) {
        return this.multiplicacao(n2.inversoNumeroComplexo());
    }
    
    public NumeroComplexo inversoNumeroComplexo() {
        return new NumeroComplexo(
                parteReal / (Math.pow(parteReal, 2) 
                        + Math.pow(parteImaginaria, 2)),
                (-1 * parteImaginaria) / (Math.pow(parteReal, 2) 
                        + Math.pow(parteImaginaria, 2)));
    }
}

/*
(a + ib)(c - id)/(c + id)(c - id) = (a + ib)[(c- id)/(c2 + d2)] = z1.z2-1

*/