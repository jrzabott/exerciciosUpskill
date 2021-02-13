package t4j.app.repo;

import t4j.app.model.Plataforma;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import static java.nio.file.StandardOpenOption.CREATE;

public class Dados {

    /**
     * Constante - nome da plataforma
     */
    // DANIEL JUNIOR 20210212 12:52
    // MOVIDO PARA PLATAFORMA. PLATAFORMA AGORA É SINGLETON
//    static final String TITULO_PLATAFORMA = "T4J";
    /**
     * Constante - nome do ficeiro onde são serializados os dados da plataforma
     */
    static final String PLATAFORMA_FILE = "plataforma_dados.dat";

    /**
     *
     * @return correga os dados da plataforma
     */
    public static Plataforma carregarDados() {

        //DANIEL JUNIOR 20210212 12:53
        //REMOVIDO PARA QUE A PLATAFORMA SEJA SINGLETON.        
//        Plataforma plataforma = new Plataforma(TITULO_PLATAFORMA);
        Plataforma plataforma = Plataforma.getInstance();
        Path file = Paths.get(PLATAFORMA_FILE);
        try {
            ObjectInputStream o = new ObjectInputStream(new FileInputStream(file
                    .toString()));
            plataforma = (Plataforma) o.readObject();
            o.close();
        } catch (Exception e) {
            //DANIEL JUNIOR 20210212 12:53
            //REMOVIDO PARA QUE A PLATAFORMA SEJA SINGLETON.        
//        Plataforma plataforma = new Plataforma(TITULO_PLATAFORMA);
            Plataforma p1 = Plataforma.getInstance();
//            Plataforma p1 = new Plataforma(Dados.getTITULO_PLATAFORMA());
            Dados.guardarDados(p1);
            System.out.println(
                    "===============================================\n"
                    + "Erro na Desserialização. Possível diferença de "
                    + "versões entre Classes SerialUID.\n"
                    + "Criado novo ficheiro binário.\n\n" + e.getMessage()
                    + "\n===============================================\n\n\n");
        }
        return plataforma;
    }

    /**
     *
     * @return nome do ficeiro onde são serializados os dados da plataforma
     */
    public static String getPLATAFORMA_FILE() {
        return PLATAFORMA_FILE;
    }

    /**
     *
     * @return nome da plataforma
     */
    public static String getTITULO_PLATAFORMA() {
        //DANIEL JUNIOR 20210212 12:53
        //REMOVIDO PARA QUE A PLATAFORMA SEJA SINGLETON.        
//        return TITULO_PLATAFORMA;
        return Plataforma.getTITULO_APLICACAO();
    }

    /**
     *
     * @param plataforma guarda os dados da plataforma
     */
    public static void guardarDados(Plataforma plataforma) {
        Path file = Paths.get(PLATAFORMA_FILE);
        try {
            ObjectOutputStream o = new ObjectOutputStream(Files.newOutputStream(
                    file, StandardOpenOption.CREATE));
            o.writeObject(plataforma);
            o.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
