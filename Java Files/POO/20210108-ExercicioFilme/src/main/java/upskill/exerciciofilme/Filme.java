/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upskill.exerciciofilme;

import java.util.Objects;

/**
 *
 * @author user
 */
public class Filme {
    private String titulo;
    private int anoRealizacao;
    private Realizador realizador;
    private CategoriaEnum categoria;
    
    private static final String TITULO_DEFAULT = "Sem Titulo";
    private static final int ANO_REALIZACAO_DEFAULT = 1850;
    private static final Realizador REALIZADOR_DEFAULT = new Realizador();
    private static final CategoriaEnum CATEGORIA_DEFAULT = CategoriaEnum.ACAO;

//    public Filme(String titulo, int anoRealizacao, Realizador realizador, CategoriaEnum categoria) {
//        this.titulo = titulo;
//        this.anoRealizacao = anoRealizacao;
//        this.realizador = realizador;
//        this.categoria = categoria;
//    }

    public Filme() {
        this.titulo = TITULO_DEFAULT;
        this.anoRealizacao = ANO_REALIZACAO_DEFAULT;
        this.realizador = REALIZADOR_DEFAULT;
        this.categoria = CATEGORIA_DEFAULT;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAnoRealizacao() {
        return anoRealizacao;
    }

    public void setAnoRealizacao(int anoRealizacao) throws AnoInvalidoException {
        if (!validaAnoRealizacao(anoRealizacao)) {
            throw new AnoInvalidoException("Ano inválido. Deve estar compreendido entre 1850 e " + Data.dataAtual().getAno());
        }
        this.anoRealizacao = anoRealizacao;
    }

    public Realizador getRealizador() {
        return realizador;
    }

    public void setRealizador(Realizador realizador) {
        this.realizador = realizador;
    }

    public CategoriaEnum getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaEnum categoria) {
        this.categoria = categoria;
    }
    
    public void setCategoria(String categoria) throws CategoriaInvalidaException {
        CategoriaEnum ce;
        if (!validaCategoria(categoria)) {
            throw new CategoriaInvalidaException("Categoria inválida, tente novamente.");
        }
        
        this.categoria = obterCategoriaViaString(categoria);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.titulo);
        hash = 59 * hash + this.anoRealizacao;
        hash = 59 * hash + Objects.hashCode(this.realizador);
        hash = 59 * hash + Objects.hashCode(this.categoria);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Filme other = (Filme) obj;
        if (this.anoRealizacao != other.anoRealizacao) {
            return false;
        }
        if (!Objects.equals(this.titulo, other.titulo)) {
            return false;
        }
        if (!Objects.equals(this.realizador, other.realizador)) {
            return false;
        }
        if (this.categoria != other.categoria) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Título: ").append(titulo);
        sb.append(", Lançado em: ").append(anoRealizacao);
        sb.append(", Idealizado por: ").append(realizador);
        sb.append(", na Categoria: ").append(categoria);
        sb.append(".\n");
        return sb.toString();
    }
    
    private boolean validaAnoRealizacao(int ano) {
        return (ano > 1850 || ano <= Data.dataAtual().getAno());
        
    }

    private boolean validaCategoria(String categoria) {
        boolean categoriaEValida = false;
        for (CategoriaEnum ce : CategoriaEnum.values()) {
            if (ce.getNomeCategoria().equals(categoria)){
                categoriaEValida = true;
            } 
        }
        return categoriaEValida;
    }

    private CategoriaEnum obterCategoriaViaString(String categoria) {
        CategoriaEnum result = null;
        for (CategoriaEnum ce : CategoriaEnum.values()) {
            if (ce.getNomeCategoria().equals(categoria)){
                result = ce;
            }
        }
        return result;
    }
}
