/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package t4j.app.dao;

import java.util.List;
import t4j.app.model.EnderecoPostal;

/**
 *
 * @author user
 */
public interface EnderecoDAO {
    List<EnderecoPostal> findById();
    
    boolean insertEndereco(EnderecoPostal e);
//    boolean updateEndereco(EnderecoPostal e);
//    boolean deleteEndereco(EnderecoPostal e);
}
