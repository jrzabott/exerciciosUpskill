/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avaliacaoalgoritmiaex3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.Scanner;

/**
 *
 * @author user
 */
public class AvaliacaoAlgoritmiaEx3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        Scanner ler = new Scanner(System.in);                       // PREPARA SCANNER PARA INPUT DO UTILIZADOR
        Scanner fichNotas = new Scanner(new File("notas.txt"));     // PREPARAR FICHEIRO QUE SERÁ LIDO
        Formatter f = new Formatter(new File("medias.txt"));        // PREPARAR FICHEIRO QUE SERÁ E-S-C-R-I-T-O
        boolean firstLine = true;                                   // FLAG PARA METER "nova linha - \n - %n"
        
        while(fichNotas.hasNextLine()){                             // IREMOS LER O FICHEIRO LINHA A LINHA
            String lineFromFile = fichNotas.nextLine();             // SALVA UMA LINHA DO FICHEIRO EM UMA STRING.
            String[] splittedLine = lineFromFile.split(",");        // PARTE A STRING EM PEDAÇOS, DIVIDOS POR "," E SALVA NUMA ARRAY DE STRINGS
                
            int countAlunos = 0;                                    // VAR AUX PARA CONTAR OS ALUNOS
            double soma = 0.0, media;                               // DECLARO SOMA COMO DOUBLE, PRA EVITAR "TYPE CAST" AO FIM.
            for (int i = 1; i < splittedLine.length; i++) {         // PERCORRER A STRING PARTIDA (ARRAY DE STRINGS - splittedLine). _
                                                                    //     COMEÇO NO INDICE 1, POIS O 0 É O NOME DA MATÉRIA
                if (i % 2 != 0) {                                   // SE O INDICE É IMPAR, QUER DIZER QUE É UM CÓDIGO DE ALUNO (AUMENTO O CONTADOR)
                countAlunos++;
                } else {                                            // SE O INDICE É PAR, É PORQUE É UMA NOTA, 
                    soma += Double.parseDouble(splittedLine[i]);    // SOMO TODAS AS NOTAS PARA CALCULAR A MÉDIA MAIS A FRENTE.
                }
            }
            media = soma / countAlunos;                             // CALCULO DA MEDIA
            if (!firstLine) {                                       // METER NOVA LINHA, A PARTIR DA SEGUNDA LINHA.
                f.format("%n", args);
            } else {
                firstLine = false;                                  // SE FOR A PRIMEIRA LINHA, MUDA A FLAG.
            }
            f.format("%s-%.2f", splittedLine[0], media);            // FINALMENTE, ESCREVO NO FICHEIRO O RESULTADO DE CADA LINHA, MATERIA E MEDIA.
        }
        f.close();                                                  // FECHAR AMBOS OS FICHEIROS. E É TUDO.
        fichNotas.close();
    }
    
}
