/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg_Exc1;

/**
 *
 * @author user
 */
public class ExcecaoVencimentoNegativo extends Exception{

    public ExcecaoVencimentoNegativo() {
        super();
    }

    public ExcecaoVencimentoNegativo(String msg) {
        super(msg);
    }
}

