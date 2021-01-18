package upskill.atletascomficheiros.model;

/**
 *
 * @author Jorge Pires Data de criação: 24/11/2020
 * @version 0.1
 *
 * @author Daniel Junior Data de criação: 24/11/2020
 * @version 0.2 Adicionados as constantes dos objetivos.
 */
public interface Atividade {

    /**
     * Constante - Caminhada
     */
    public static final String CAMINHADA = "Caminhada";

    /**
     * Constante - Corrida
     */
    public static final String CORRIDA = "Corrida";

    /**
     * Constante - Ciclismo
     */
    public static final String CICLISMO = "Ciclismo";

    /**
     * Constante - Natação
     */
    public static final String NATACAO = "Natação";

    /**
     * Constante - Intensidade de Treino com objetivo de queimar gordura
     */
    public static final double IT_QUEIMARGORDURA = 0.6;

    /**
     * Constante - Intensidade de Treino com objetivo de trabalhar a capacidade
     * cardiorrespiratória
     */
    public static final double IT_TREINOCARDIORESP = 0.75;

    /**
     * Constante - Masculino
     */
    public static final String GENERO_M = "Masculino";

    /**
     * Constante - Feminino
     */
    public static final String GENERO_F = "Feminino";
    
    /**
     * This enum was created in 20210117 1656 by Daniel Junior.
     * It was necessary (for the sake of simplicity) for filling the UI with data.
     */
    public static enum TipoAtividades{
        CAMINHADA {
            @Override
            public String toString() {
                return "Caminhada";
            }
        }, 
        CICLISMO{
            @Override
            public String toString() {
                return "Ciclismo";
            }
        }, 
        CORRIDA{
            @Override
            public String toString() {
                return "Corrida";
            }
        }, 
        NATACAO{
            @Override
            public String toString() {
                return "Natação";
            }
        }
        
    }
    public static enum IntensidadeTreinos{
        IT_QUEIMARGORDURA (0.6){
            @Override
            public String toString() {
                return "Queimar Gordura"; 
            }
        },
        IT_TREINOCARDIORESP (0.75){
            @Override
            public String toString() {
                return "Treino Cardiorespiratório";
            }
        };
        private double value;

        private IntensidadeTreinos(double value) {
            this.value = value;
        }

        public double getValue() {
            return value;
        }
        
    }
}
