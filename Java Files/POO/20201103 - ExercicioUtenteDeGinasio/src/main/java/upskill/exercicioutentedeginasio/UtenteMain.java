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
        
        System.out.println("================================================");
        System.out.println("UTENTES toString() e Nome+IMC+Classificacao");
        System.out.println("================================================");
        for (Utente utente : utentes) {
            System.out.println("To String: " + utente.toString());
            System.out.println(String.format("%s - IMC: %s, %s", 
                    utente.getName(), utente.calcIMC(), utente.weightCategory())
            );
        }   
        
        System.out.println("================================================");
        System.out.println("UTENTES NÃO SAUDÁVEIS");
        System.out.println("================================================");
        for (Utente utente : utentes) {
            if (utente.weightCategory() != Utente.SAUDAVEL_TEXTO_CLASSIFICACAO) {
                System.out.println(String.format("Paciente não saudável: %s | %s", utente.getName(), utente.weightCategory()));
            }
        }
        System.out.println("================================================");
        System.out.println("INDICES DE CLASSIFICACAO DE IMC ALdTERADOS");
        System.out.println("================================================");
        Utente.setClassificacaoMagro(15);
        Utente.setClassificacaoSaudavel(27);
        for (Utente utente : utentes) {
            System.out.println(String.format("%s - IMC: %s, %s", 
                    utente.getName(), utente.calcIMC(), utente.weightCategory())
            );
        }   
        
        System.out.println("================================================");
        System.out.println("IDADE DO UTENTE[1] TROCADA PELA IDADE DE [0]");
        System.out.println("================================================");
        System.out.println(String.format("Antes: utentes[0].getAge(): %d e utentes[1].getAge(): %d",utentes[0].getAge(), utentes[1].getAge()));
        int tmp = utentes[1].getAge();
        utentes[1].setAge(utentes[0].getAge());
        utentes[0].setAge(tmp);
        System.out.println(String.format("Depois: utentes[0].getAge(): %d e utentes[1].getAge(): %d",utentes[0].getAge(), utentes[1].getAge()));
        
        System.out.println("================================================");
        System.out.println("CHECAR QUAL DOS UTENTES É O MAIS NOVO:");
        System.out.println("================================================");
        System.out.println(utentes[0].isYounger(utentes[1]));
    }

    private static int generateRandomNumer(int min, int max) {
        int myRandomNumber = (int) (Math.random() * ((max - min) + 1)) + min;
        return myRandomNumber;
    }

    private static double generateRandomNumer(double min, double max) {
        double myRandomNumber = Math.random() * (((max - min) + 1)) + min;
        return myRandomNumber;
    }

}
