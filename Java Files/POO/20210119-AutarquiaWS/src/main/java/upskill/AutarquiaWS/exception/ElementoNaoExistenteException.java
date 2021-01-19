/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upskill.AutarquiaWS.exception;

/**
 *
 * @author user
 */
public class ElementoNaoExistenteException extends RuntimeException{

    public ElementoNaoExistenteException(String string) {
        super(string);
    }
    
}