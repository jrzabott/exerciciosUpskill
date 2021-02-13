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
public class ConnectionFactory {
    private static ConnectionFactory cf;
    private DatabaseConnection c;

    public static ConnectionFactory getConnectionFactory() {
        if (cf == null) {
            cf = new ConnectionFactory();
        }
        return cf;
    }

    public DatabaseConnection getConnection() {
        if (c == null) {
            c = new DatabaseConnection(
                    "jdbc:oracle:thin:@vsrvbd1.dei.isep.ipp.pt:1521/pdborcl",                   
                    "UPSKILL_PLSQL_19",
                    "qwerty");
        }
        return c;
    }
}
