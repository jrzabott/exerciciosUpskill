/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upskill.exercicioaniversario;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Formatter;

/**
 *
 * @author user
 */
public class Utils {

    static Formatter sFicheiro;
    static BufferedReader sTeclado;

    private Utils() {
    }

    public static Formatter lerFicheiro() {

        sTeclado = getReader();
        System.out.println("File? ");

        do {
            try {
                String nomeFicheiro = sTeclado.readLine();
                sFicheiro = new Formatter(new FileWriter(nomeFicheiro, true));
            } catch (FileNotFoundException fileNotFoundException) {
                System.out.println("Não foi possível criar ficheiro");
            } catch (IOException ioe) {
                System.out.println(ioe.getMessage());
            }
        } while (sFicheiro == null);

        System.out.println("Ficheiro criado com sucesso.");
        return sFicheiro;
    }

    public static Formatter lerFicheiro(String nomeFicheiro) {

        do {
            try {
                sFicheiro = new Formatter(new FileWriter(nomeFicheiro, true));
            } catch (FileNotFoundException fileNotFoundException) {
                System.out.println("Não foi possível criar ficheiro");
            } catch (IOException ioe) {
                System.out.println(ioe.getMessage());
            }
        } while (sFicheiro == null);

        System.out.println("Ficheiro criado com sucesso.");
        return sFicheiro;
    }

    public static String obterNome() {
        String nome;
        sTeclado = getReader();

        System.out.println("Nome:");
        try {
            nome = sTeclado.readLine();
        } catch (IOException iOException) {
            throw new IllegalArgumentException("Não foi possível obter o Nome. Tente novamente.");
        }
        return nome;
    }

    public static Data obterData() {
        String data;
        Data returnData = null;
        sTeclado = getReader();

        do {
            System.out.println("Data:");
            try {
                data = sTeclado.readLine();
            } catch (IOException iOException) {
                throw new IllegalArgumentException("Não foi possível obter a Data. Tente novamente.");
            }

            try {
                if (Data.validaDataString(data)) {
                    int ano, mes, dia;
                    String temp[] = data.split("/");

                    ano = Integer.parseInt(temp[0]);
                    mes = Integer.parseInt(temp[1]);
                    dia = Integer.parseInt(temp[2]);
                    returnData = new Data(ano, mes, dia);
                }
            } catch (MesInvalidoException | DiaInvalidoException | IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }
        } while (returnData == null);

        return returnData;
    }

    static BufferedReader getReader() {
        if (sTeclado == null) {
            sTeclado = new BufferedReader(new InputStreamReader(System.in));
        }
        return sTeclado;
    }
}
