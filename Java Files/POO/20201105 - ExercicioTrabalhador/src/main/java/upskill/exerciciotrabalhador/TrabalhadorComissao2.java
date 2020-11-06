/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upskill.exerciciotrabalhador;

/**
 *
 * @author user
 */
public class TrabalhadorComissao2 extends Trabalhador{
    private double salarioBase;
    private double comissao;
    private double vendas;
    
    private final double SALARIO_BASE_DEFAULT = 580;
    private final double COMISSAO_DEFAULT = 0.0;
    private final double VENDAS_DEFAULT = 0.0;

    public TrabalhadorComissao2(double salarioBase, double vendas, double comissao, String nome) {
        super(nome);
        this.salarioBase = salarioBase;
        this.comissao = comissao;
        this.vendas = vendas;
    }

    public TrabalhadorComissao2() {
        this.salarioBase = SALARIO_BASE_DEFAULT;
        this.comissao = COMISSAO_DEFAULT;
        this.vendas = VENDAS_DEFAULT;
    }
    
    /**
     * @return the salarioBase
     */
    public double getSalarioBase() {
        return salarioBase;
    }

    /**
     * @return the comissao
     */
    public double getComissao() {
        return comissao;
    }

    /**
     * @param salarioBase the salarioBase to set
     */
    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    /**
     * @param comissao the comissao to set
     */
    public void setComissao(double comissao) {
        this.comissao = comissao;
    }

    @Override
    public float calcularVencimento() {
        return (float) (salarioBase + (getComissao() * getVendas()));
    }

    /**
     * @return the vendas
     */
    public double getVendas() {
        return vendas;
    }

    /**
     * @param vendas the vendas to set
     */
    public void setVendas(double vendas) {
        this.vendas = vendas;
    }
    
    
}
