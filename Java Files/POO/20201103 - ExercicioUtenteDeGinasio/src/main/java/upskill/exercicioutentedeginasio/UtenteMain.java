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
        "Danielius Costa",
        "Jaslene Sousa",
        "Marium Denman",
        "Hailee Banks",
        "Alizay Vigil",
        "Madelynn Brown",
        "Ivie Greenberg",
        "Jaide Banning",
        "Jennifer Gagli",
        "Jennah Jordan",
        "Jorgia Muniz",
        "Evie Carroll",
        "Jordyn Chen",
        "Sareena Albano",
        "Vidyuth Zepeda",
        "Keria Jobe",
        "Kary Gittens",
        "Willam Medina",
        "Joie Alford",
        "Vanesa Aycock",
        "Shanaia Hahn",
        "Laney Donovan",
        "Kamia Hooker",
        "Anshu Glover",
        "Alisa Pruett",
        "Jolyn Padgett",
        "Allissa Holly",
        "Clare Higgins",
        "Lyndee Mckinney",
        "Daylin Phelps",
        "Johnasia Mcauley",
        "Jaisa Wall",
        "Briana Mark",
        "Aimee Edick",
        "Mico Mccain",
        "Jacalyn Eaton",
        "Taimane Pires",
        "Marisol Hosking",
        "Sheridan Hartmann",
        "Mallory Babin",
        "Danity Byers",
        "Zandra Gayle",
        "Naimah Swift",
        "Haleigh French",
        "Melyssa Appleby",
        "Jasmin Rangel",
        "Elianna Greenberg",
        "Xiomara Erickson",
        "Lianette Stiles",
        "Chloe Cline",
        "Kira Davenport",
        "Kylie Paine",
        "Sabina Mellor",
        "Gareth Greene",
        "Lillie-Mae Barnard",
        "Jemma Felix",
        "Theodore Ali",
        "Phoebe Coleman",
        "Yasin Carey",
        "Jamila Weir",
        "Julian Chamberlain",
        "Baran Mcknight",
        "Giulia Lang",
        "Cydney Millar",
        "Isma Simpson",
        "Chay Beech",
        "Nyle Barclay",
        "Elijah Hawkins",
        "Skyla Oneill",
        "Anthony Wilkerson",
        "Gillian Carrillo",
        "Susan Maguire",
        "Manraj Harris",
        "Weronika Huerta",
        "Arianna Padilla",
        "Cheyanne Stevenson",
        "Celia Hale",
        "Elara Dale",
        "Hakeem Welsh",
        "Pooja Mathis",
        "Raees Finley",
        "Rees Novak",
        "Yusra Guthrie",
        "Suzanne Mcclain",
        "Reginald York",
        "Neel Stephens",
        "Kendal Austin",
        "Alyssia Portillo",
        "Findlay Armitage",
        "Saeed Jordan",
        "Elysia Major",
        "Rares Rahman",
        "Arandeep O'Doherty",
        "Marlon Ibarra",
        "Ellenor Zuniga",
        "Devonte Miles",
        "Freddy Mays",
        "Callen Foster",
        "Rojin Lovell",
        "Bridie Lane",
        "Khalil Hughes",
        "Umaiza Seymour",
        "Donnie Coombes",
        "Beauden Fellows",
        "Josiah Parkinson",
        "Nyla Adam",
        "Annika Davila",
        "Dale Le",
        "Haleemah Cantu",
        "Morris Gamble",
        "Ronny Mackenzie",
        "Taya Horne",
        "Orlaith Redman",
        "Nieve Edge",
        "Ava-Grace Kaye",
        "Arman Cline",
        "Hadi Stone",
        "Sarah-Jane Kay",
        "Mahdi Maxwell",
        "Kian Pittman",
        "Franciszek Oliver",
        "Siya Lester",
        "Haiden Gardner",
        "Chenai Mueller",
        "Leigha Mcfadden",
        "Ridwan Benson",
        "Abida Ahmad",
        "Chanelle Leon",
        "Chloe-Ann Mcarthur",
        "Siraj Stubbs",
        "Nolan Nguyen",
        "Elouise Gill",
        "Una Mccaffrey",
        "Callam Woodcock",
        "Ronaldo Mill",
        "Shane Petersen",
        "Phoenix Mcfarlane",
        "Vlad Rice",
        "Zaydan Porter",
        "Ayaz Ramirez",
        "Orion Short",
        "Verity Tanner",
        "Eryn Knight",
        "Aaminah Craig",
        "Manisha Sosa",
        "Emilio Stanton",
        "Dougie Patterson",
        "Beau Clements",
        "Rhea Bentley",
        "Destiny Friedman",
        "Harvey-Lee Schmitt"};

    private static String[] genders = {"Female", "Male"};

    public static void main(String[] args) {
        Utente[] utentes = new Utente[10000];
        for (int i = 0; i < utentes.length; i++) {
            utentes[i] = new Utente(
                    names[i % names.length],
                    genders[generateRandomNumer(0, 1)],
                    generateRandomNumer(0, 99),
                    generateRandomNumer(0.9, 2.5),
                    generateRandomNumer(30.0, 250.0)
            );
//            if(utentes[i].getHeight() > 2.498) {
//                System.out.printf("UPPER BOUND: %.3f%n", utentes[i].getHeight());
//            }
//                        if(utentes[i].getHeight() < 0.91) {
//                System.out.printf("LOWER BOUND: %.3f%n", utentes[i].getHeight());
//            }
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
        System.out.println(String.format("Antes: utentes[0].getAge(): %d e utentes[1].getAge(): %d", utentes[0].getAge(), utentes[1].getAge()));
        int tmp = utentes[1].getAge();
        utentes[1].setAge(utentes[0].getAge());
        utentes[0].setAge(tmp);
        System.out.println(String.format("Depois: utentes[0].getAge(): %d e utentes[1].getAge(): %d", utentes[0].getAge(), utentes[1].getAge()));

//        utentes[0].setAge(tmp);
//        utentes[1].setAge(tmp);
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
        double myRandomNumber = (Math.random() * (max - min)) + min;
        return myRandomNumber;
    }

}
