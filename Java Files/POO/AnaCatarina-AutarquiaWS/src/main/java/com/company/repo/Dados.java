
package com.company.repo;

import com.company.model.Autarquia;
import java.io.FileInputStream; 
import java.io.ObjectInputStream; 
import java.io.ObjectOutputStream; 
import java.nio.file.Files;
import java.nio.file.Path; 
import java.nio.file.Paths;
import static java.nio.file.StandardOpenOption.CREATE;

public class Dados {

    static final String AUTARQUIA_FILE ="autarquia_dados.dat";

    public static Autarquia carregarDados(){
        Autarquia autarquia = new Autarquia("Curral de Moinas"); 
        Path file = Paths.get(AUTARQUIA_FILE);
        try {
            ObjectInputStream o = new ObjectInputStream(new FileInputStream(file.toString())); 
            autarquia = (Autarquia)o.readObject();
            o.close();
        }catch (Exception e) {
            System.out.println(e.getMessage()); 
        }
        return autarquia; 
    }

    public static void guardarDados(Autarquia autarquia) { 
        Path file = Paths.get(AUTARQUIA_FILE);
        try{
            ObjectOutputStream o = new ObjectOutputStream(Files.newOutputStream(file, CREATE)); 
            o.writeObject(autarquia);
        o.close();
        } catch (Exception e){ 
            System.out.println(e);
        } 
    }
}
