/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author nunocastro
 */
public interface IEmail {
    public void setTo(String email);
    public void setSubject(String subject);
    public void setText(String text);
    public void send();
}
