package t4j.app.utils;

import java.util.Random;

public class AlgoritmoGeradorPasswords {

    public final static String MIX = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890!@#$%=-";
    public final static String NUMEROS = "1234567890";
    public final static String LETRAS_MAIUSCULAS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public final static String LETRAS_MINUSCULAS = "abcdefghijklmnopqrstuvwxyz";
    public final static String LETRAS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public final static String LETRAS_NUMEROS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";

    /**
     *
     * @param chars caractéres permitidos na criação da string aleatória
     * @param length tamanho da string gerada
     * @return uma string com caractéres aleatórios e com tamanho definido por parâmetro
     */
    public static String geraString(String chars, int length) {
        String SALTCHARS;
        if (chars.isEmpty()) {
            SALTCHARS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890!@#$%=-";
        } else {
            SALTCHARS = chars;
        }
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < length) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;
    }

 
}
