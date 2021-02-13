/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upskill.AutarquiaWS.repo;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.nio.file.StandardOpenOption.CREATE;
import upskill.AutarquiaWS.model.Autarquia;
import upskill.AutarquiaWS.model.Freguesia;

/**
 *
 * @author user
 */
public class Dados {

    static final String AUTARQUIA_FILE = "autarquia_dados.dat";

    public static Autarquia carregarDados() {
//        Autarquia autarquia = new Autarquia("Curral de Moinas");
        Freguesia freguesiaInicial = new Freguesia(0, "");
        Autarquia autarquia = new Autarquia("Curral de Moinas", freguesiaInicial);

        Path file = Paths.get(AUTARQUIA_FILE);
        try {
            ObjectInputStream o = new ObjectInputStream(new FileInputStream(file.toString()));
            autarquia = (Autarquia) o.readObject();
            o.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return autarquia;
    }

    public static void guardarDados(Autarquia autarquia) {
        Path file = Paths.get(AUTARQUIA_FILE);
        try {
            ObjectOutputStream o;
            o = new ObjectOutputStream(Files.newOutputStream(file, CREATE));
            o.writeObject(autarquia);
            o.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
