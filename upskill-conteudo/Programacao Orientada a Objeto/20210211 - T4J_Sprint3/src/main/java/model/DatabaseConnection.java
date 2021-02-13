/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import oracle.jdbc.pool.*;

/**
 *
 * @author nunocastro
 */
public class DatabaseConnection {
    private OracleDataSource ods;
    private Connection conn;
    
    public DatabaseConnection(String url, String username, String password) {
        try {
            ods = new OracleDataSource();
            ods.setURL(url);
            conn = ods.getConnection(username, password);
            if (conn != null) {
                System.out.println("Connected to the database!");
            } else {
                System.out.println("Failed to make connection!");
            }
        } catch (SQLException e) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, e);
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }
    }

    public Connection getConnection() {
        return conn;
    }
    
}
