/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package t4j.app.dao;

import java.util.List;
import t4j.app.model.Organizacao;

/**
 *
 * @author user
 */
public interface OrganizacaoDAO {
    List<Organizacao> findAll();
    List<Organizacao> findByNIF();
    
    boolean insertOrganizacao(Organizacao o);
//    boolean updateOrganizacao(Organizacao o);
//    boolean deleteOrganizacao(Organizacao o);
    
}
