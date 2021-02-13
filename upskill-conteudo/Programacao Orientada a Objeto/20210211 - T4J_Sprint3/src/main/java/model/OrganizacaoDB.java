/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nunocastro
 */
public class OrganizacaoDB extends Persistable {

    private Organizacao org;
    
    public OrganizacaoDB(Object object) {
        super(object);
        org = (Organizacao) object;
    }

    @Override
    public boolean save() {
        //Implementar método de persistência
        String strO = "{? = call novaOrganizacao(?,?,?,?,?)}";
        String strE = "{call adicionarEnderecoOrganizacao(?,?,?,?)}";
        Connection conn = Plataforma.getInstance().getConnection();
        try (CallableStatement csO = conn.prepareCall(strO);
             CallableStatement csE = conn.prepareCall(strE)) {
            
            //Início da transação.
            conn.setAutoCommit(false);
           
            //Organização
            csO.registerOutParameter(1, java.sql.Types.INTEGER);
            csO.setString(2, org.getNome());
            csO.setString(3, org.getNif());
            csO.setString(4, org.getSite());
            csO.setString(5, org.getTelefone());
            csO.setString(6, org.getEmail());
            csO.executeUpdate();
            Integer orgId = csO.getInt(1);
            
            //Endereço
            csE.setInt(1, orgId);
            csE.setString(2, org.getEndereco().getEndLocal());
            csE.setString(3, org.getEndereco().getEndPostal());
            csE.setString(4, org.getEndereco().getLocalidade());
            csE.executeUpdate();

            conn.commit();
            return true; 
        } catch (SQLException ex) {
            try {
                conn.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(OrganizacaoDB.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(OrganizacaoDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
