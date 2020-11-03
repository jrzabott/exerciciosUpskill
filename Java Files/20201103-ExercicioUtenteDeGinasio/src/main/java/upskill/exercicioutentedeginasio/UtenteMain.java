/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upskill.exercicioutentedeginasio;

/**
 *
 * @author user
 */
public class UtenteMain {

    /**
     * @param args the command line arguments
     */
    private static String[] names = {
        "Heena Conley",
        "Sofie Mcbride",
        "Myrtle Delgado",
        "Aayat Gardner",
        "Chyna Lester",
        "Domas Nguyen",
        "Nichola Barnard",
        "Azra Blackmore",
        "Aleyna Allan",
        "Danielius Costa",};

    private static String[] genders = {"Female", "Male"};

    public static void main(String[] args) {
        Utente[] utentes = new Utente[10];
        for (int i = 0; i < 10; i++) {
            utentes[i] = new Utente(
                    names[i],
                    genders[generateRandomNumer(0, 1)],
                    generateRandomNumer(0, 99),
                    generateRandomNumer(0.6, 2.5),
                    generateRandomNumer(30.0, 300.0)
            );
        }
        
        for (Utente utente : utentes) {
            System.out.println("To String: " + utente.toString());
        }
        
    }

    private static int generateRandomNumer(int min, int max) {
        int myRandomNumber = min + (int) (Math.random() * ((max - min + 1)));
        return myRandomNumber;
    }

    private static double generateRandomNumer(double min, double max) {
        double myRandomNumber = min + (Math.random() * ((max - min + 1)));
        return myRandomNumber;
    }

}
