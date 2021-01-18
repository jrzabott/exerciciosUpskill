
package org.upskill.matrizgenerica.main;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.upskill.matrizgenerica.model.MatrizGenerica;
import org.upskill.matrizgenerica.model.TrabalhadorPeca;

public class MainMatrizGenerica {

    public static void main(String[] args) {
        MatrizGenerica<List<TrabalhadorPeca>> mmg1 = new MatrizGenerica<>();
        MatrizGenerica<List<Double>> mmg2 = new MatrizGenerica<>();
        MatrizGenerica<List<Serializable>> mmg3 = new MatrizGenerica<>();
        
        
        List<TrabalhadorPeca> listMmg1 = new ArrayList<TrabalhadorPeca>();
        for (int i = 0; i < 10; i++) {
            int index = (int) (Math.random()*(49 + 1));
            listMmg1.add(new TrabalhadorPeca(names[index]));
        }  
        for (int i = 0; i < 5; i++) {
            mmg1.adicionarLinha((Collection) listMmg1);
        }
        
        
        List<Double> listMmg2 = new ArrayList<Double>();
        for (int i = 0; i < 10; i++) {
            listMmg2.add(Math.random()*(999+1)+1);
        }
        for (int i = 0; i < 15; i++) {
            mmg2.adicionarLinha((Collection) listMmg2);
        }
                
        List<Serializable> listMmg3 = new ArrayList<Serializable>();
        for (int i = 0; i < ((int)(Math.random()*(100 + 1) + 1)); i++) {
            int index = (int) (Math.random()*(49 + 1));
            listMmg3.add(new TrabalhadorPeca(names[index]));
        }  
        for (int i = 0; i < 90; i++) {
            mmg3.adicionarLinha((Collection) listMmg3);
        }
        
        System.out.println("nothing");
    }
    
    
    public static String[] names = {
"Issac Vanmeter",
"Theola Mcmurtry",
"Celestina Boothby",
"Ruthe Rients",
"Benjamin Mccaskey",
"Davina May",
"Tam Herdt",
"Merilyn Watchman",
"Hulda Shick",
"Catina Kamen",
"Suzi Luce",
"Daryl Baros",
"Maurita Debose",
"Titus Emerson",
"Winfred Goers",
"Shanel Trotter",
"Claude Lupien",
"Taisha Gaulding",
"Desiree Mcmullin",
"Kacey Canchola",
"Leilani Balsley",
"Gabriele Nielsen",
"Louise Defreitas",
"Freida Trice",
"Ardella Kite",
"Harriette Arakaki",
"Shara Okafor",
"Virgie Sweeney",
"Shalanda Moscoso",
"Merna Chaloux",
"Nolan Shira",
"Joella Blacker",
"Mao Trusty",
"Andreas Lazaro",
"Sherwood Barrientos",
"Mui Anding",
"Janey Crutcher",
"Tari Kamin",
"Rodolfo Arbaugh",
"Tami Houde",
"Brittanie Tatom",
"Beulah Schweigert",
"Georgeanna Gusman",
"Carol Gisi",
"Thao Morein",
"Kathrin Skinner",
"Elise Maudlin",
"Maisie Weis",
"Roland Bushman",
"Renetta Legault"
    };
}
