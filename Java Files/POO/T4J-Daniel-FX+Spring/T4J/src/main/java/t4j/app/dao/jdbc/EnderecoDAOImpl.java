/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package t4j.app.dao.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import t4j.app.dao.EnderecoDAO;
import t4j.app.model.EnderecoPostal;
import t4j.app.model.Plataforma;

public class EnderecoDAOImpl implements EnderecoDAO {

    private Connection connection = Plataforma.getInstance().getConnection();

    @Override
    public List<EnderecoPostal> findById() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean insertEndereco(EnderecoPostal e) {
        String sql
                = "{CALL addEndereco ( ?, ?, ?, ?)}";
        String sql2
                = "SELECT * FROM ENDERECO";
        try {
            connection.setAutoCommit(false);
            CallableStatement cs = connection.prepareCall(sql);

            cs.registerOutParameter(4, Types.NUMERIC);
            
            cs.setString(1, e.getMorada());
            cs.setString(2, e.getCodigoPostal());
            cs.setString(3, e.getLocalidade());
            cs.executeUpdate();
            
            
            ResultSet rs = cs.getResultSet();
            PreparedStatement ps = connection.prepareStatement(sql2);
            ps.execute();
            rs = ps.getResultSet();

            while (rs.next()) {
                for (int i = 0; i < rs.getMetaData().getColumnCount(); i++) {
                    System.out.printf("%s;", rs.getString(i + 1));
                }
                System.out.println("");
            }
            connection.commit();
            connection.setAutoCommit(true);

            return true;

        } catch (SQLException ex) {
            Logger.getLogger(EnderecoDAOImpl.class.getName())
                    .log(Level.SEVERE, null, ex);
        } finally {
            try {
                this.connection.close();
            } catch (SQLException ex) {
                System.out.println("What!?");
            }
        }
        return false;
    }

    public static void main(String[] args) {
        EnderecoDAO e = new EnderecoDAOImpl();
        EnderecoPostal e1 = new EnderecoPostal();
        e1.setCodigoPostal("1234-321");
        e1.setMorada("xxxxxxxxxdx");
        e1.setLocalidade("Rio Largo");
        e.insertEndereco(e1);
    }
}
