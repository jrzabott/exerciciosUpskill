package upskill.exerciciofiguras;

public class Retangulo extends Figura {
    private double comprimento;
    private double largura;

    private static final int COMPRIMENTO_POR_OMISSAO = 2;
    private static final int LARGURA_POR_OMISSAO = 1;

    public Retangulo(double comprimento, double largura, String cor) {
        super(cor);
        this.comprimento = comprimento;
        this.largura = largura;
    }

    public Retangulo(double comprimento, double largura) {
        super();
        this.comprimento = comprimento;
        this.largura = largura;           
    }

    public Retangulo(String cor) {
        super(cor);
        comprimento = COMPRIMENTO_POR_OMISSAO;
        largura = LARGURA_POR_OMISSAO;
    }

    public Retangulo() {
        super();
        comprimento = COMPRIMENTO_POR_OMISSAO;
        largura = LARGURA_POR_OMISSAO;
    }

    public double getComprimento() {
        return comprimento;
    }

    public double getLargura() {
        return largura;
    }

    public void setComprimento(double comprimento) {
        this.comprimento = comprimento;
    }

    public void setLargura(double largura) {
        this.largura = largura;
    }

    @Override
    public String toString() {
        return String.format("Retângulo: comprimento=%.1f largura=%.1f, "
                + "perimetro=%.1f, area=%.1f %s",
                comprimento, largura,this.calcularPerimetro(), 
                this.calcularArea() ,super.toString()
        );
    }

    @Override
    public double calcularArea() {
        return this.getComprimento() * this.getLargura();
    }

    @Override
    public double calcularPerimetro() {
        return this.getComprimento() * 2 + this.getLargura() * 2;
    }
    
    
}