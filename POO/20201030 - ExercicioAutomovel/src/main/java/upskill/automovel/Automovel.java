package upskill.automovel;

public class Automovel {                                                    // Ordem de criação (convenção) dos elementos de classes.
                                                                            // 1º variavies de instâncias.
    private String matricula;                                               // 2º Constantes
    private String marca;                                                   // 3º variaǘeis estáticas
    private int cilindrada;                                                 // 4º Construtores
                                                                            // 5º Todos os métodos de Instâncias (Gets, Sets, toString e todos os outros métodos de insância)
    private static final String MATRICULA_POR_OMISSAO = "sem matrícula";    // 6º Todos os métodos de Classe (static)
    private static final String MARCA_POR_OMISSAO = "sem marca";
    private static final int CILINDRADA_POR_OMISSAO = 0;

    private static int totalAutomoveis = 0;

    public Automovel(String matricula, String marca, int cilindrada) {
        this.matricula = matricula;
        this.marca = marca;
        this.cilindrada = cilindrada;
        totalAutomoveis++;
    }

    public Automovel(String matricula, String marca) {
        this.matricula = matricula;
        this.marca = marca;
        cilindrada = CILINDRADA_POR_OMISSAO;
        totalAutomoveis++;
    }

    public Automovel(String marca, int cilindrada) {
        matricula = MATRICULA_POR_OMISSAO;
        this.marca = marca;
        this.cilindrada = cilindrada;
        totalAutomoveis++;
    }

    public Automovel() {
        matricula = MATRICULA_POR_OMISSAO;
        marca = MARCA_POR_OMISSAO;
        cilindrada = CILINDRADA_POR_OMISSAO;
        totalAutomoveis++;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getMarca() {
        return marca;
    }

    public int getCilindrada() {
        return cilindrada;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setCilindrada(int cilindrada) {
        this.cilindrada = cilindrada;
    }

    public String toString() {
        return String.format("Automóvel com matrícula %s é um %s e " +
              "tem cilindrada de %d cc", matricula, marca, cilindrada);

        // Alternativa menos eficiente:
        // return "Automóvel com matrícula " + matricula + " é um " + marca + 
        //        " e tem cilindrada de " + cilindrada + " cc";

    }

    public int calcularDiferencaCilindrada(Automovel outroAutomovel) {
        return cilindrada - outroAutomovel.cilindrada;
        // Alternativa: 
        // return cilindrada - outroAutomovel.getCilindrada();
    }

    public boolean isCilindradaMaior(Automovel outroAutomovel) {
        return cilindrada > outroAutomovel.cilindrada;
        // Alternativa: 
        // return cilindrada - outroAutomovel.getCilindrada();
    }

    public boolean isCilindradaMaior(int cilindrada) {
        return this.cilindrada > cilindrada;
    }

    public static int getTotalAutomoveis() {
        return totalAutomoveis;
    }

}
