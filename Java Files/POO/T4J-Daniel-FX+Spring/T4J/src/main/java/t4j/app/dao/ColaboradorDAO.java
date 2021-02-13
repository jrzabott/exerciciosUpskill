/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package t4j.app.dao;

import java.util.List;
import t4j.app.model.Colaborador;

/**
 *
 * @author user
 */
public interface ColaboradorDAO {

    List<Colaborador> findAll();
    List<Colaborador> findByEmail();
    
    boolean insertColaborador(Colaborador c);
//    boolean updateColaborador(Colaborador c);
//    boolean deleteColaborador(Colaborador c);
    
    
}
