/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upskill.clubedesportivo;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import oracle.jdbc.*;
import oracle.jdbc.pool.*;
import oracle.jdbc.datasource.OracleDataSource;

/**
 *
 * @author user
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            OracleDataSource ods = new oracle.jdbc.pool.OracleDataSource();
            String url = "jdbc:oracle:thin:UPSKILL_BD_Turma2_12/Qwerty123@vsrvbd1.dei.isep.ipp.pt:1521/pdborcl";
//            String url = "vsrvbd1.dei.isep.ipp.pt:1521/pdborc";
            ods.setURL(url);
//            ods.setUser("UPSKILL_BD_Turma2_12");
//            ods.setPassword("Qwerty123");
            
            Connection c = ods.getConnection();
            
            
            Statement s = c.createStatement();
            
            String myQuery = "SELECT * FROM ATLETA";
            ResultSet resultSet = s.executeQuery(myQuery);
            while (resultSet.next()) {                
                System.out.println(resultSet.getString("nome"));
            }
            
            
            c.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(NewMain.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        
    }
    
}
