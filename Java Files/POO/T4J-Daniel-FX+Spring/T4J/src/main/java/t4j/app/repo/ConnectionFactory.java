/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package t4j.app.repo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class ConnectionFactory {

    private static ConnectionFactory cf;
    private DatabaseConnection c;

    public static ConnectionFactory getConnectionFactory() {
        if (cf == null) {
            cf = new ConnectionFactory();
        }
        return cf;
    }

    // Daniel Junior - 20210212 15:11 - info hard-coded.
    // Connection String: jdbc:oracle:thin:UPSKILL_BD_Turma2_12/Qwerty123@vsrvbd1.dei.isep.ipp.pt:1521/pdborcl
    public DatabaseConnection getConnection() {
        if (c == null) {
            c = new DatabaseConnection(
                    "jdbc:oracle:thin:@vsrvbd1.dei.isep.ipp.pt:1521/pdborcl",
                    "UPSKILL_BD_Turma2_12",
                    "Qwerty123");
        }
        return c;
    }

//    public static void main(String[] args) {
//        ConnectionFactory cf = new ConnectionFactory();
//        DatabaseConnection conn = cf.getConnection();
//        Connection connection = conn.getConnection();
//        
//        String sql = "SELECT * FROM USER_TABLES";
//        
//        try {
//            Statement createStatement = connection.createStatement();
//            createStatement.execute(sql);
//            ResultSet resultSet = createStatement.getResultSet();
//            int countRow = 0;
//            while (resultSet.next()) {
//                countRow++;
//            }
//            System.out.println("Numer of itens: " + countRow);
//            resultSet = createStatement.getResultSet();
//            int columnCount = resultSet.getMetaData().getColumnCount();
//            for (int i = 0; i < columnCount; i++) {
//                System.out.print(resultSet.getMetaData().getColumnName(
//                        i + 1) + "\t");
//            }
//            System.out.println("");
//
//            columnCount = resultSet.getMetaData().getColumnCount();
//            for (int i = 0; i < columnCount; i++) {
//                System.out.print(resultSet.getMetaData().getColumnLabel(
//                        i + 1) + "\t");
//            }
//            System.out.println("");
//
//            createStatement.execute(sql);
//            resultSet = createStatement.getResultSet();
//            while (resultSet.next()) {
//                System.out.println(resultSet.getString("TABLE_NAME"));
//            }
//        } catch (SQLException ex) {
//            System.out.println(ex.getMessage());
//        }
//    }
}
