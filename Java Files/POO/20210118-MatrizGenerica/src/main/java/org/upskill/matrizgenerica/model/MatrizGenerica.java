package org.upskill.matrizgenerica.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MatrizGenerica<E> {

    private List< List<E>> matrizGenerica;
    private int numeroMaximoColunas;

    public MatrizGenerica() {
        this.matrizGenerica = new ArrayList<>();
        this.numeroMaximoColunas = 0;
    }

    // 4.b)
    public boolean adicionarLinha(Collection<E> novaLinha) {
        if (novaLinha.size() > numeroMaximoColunas) {
            numeroMaximoColunas = novaLinha.size();
        }
        List<E> novaLista = new ArrayList<>(novaLinha);
        return matrizGenerica.add((List<E>) novaLista);
    }

    //4.f)
    // Estou a assumir que todas as linhas possuem a coluna solicitada.
    // Não estou a verificar se de facto o elemento em questão é do tipo E.
    // Apesar do prof não ter falado em aula, não se pode criar arrays de tipos
    // genéricos. Uma forma de dar a volta a isto é criar uma array de Object.
    public E[] colunaComoArray(int col, E[] arr) {
        int i = 0;

        // check array capacity
        if (arr.length < getNumeroDeLinhas()) {
            arr = (E[]) new Object[getNumeroDeLinhas()];
        }
        if (arr.length > getNumeroDeLinhas()) {
            arr[getNumeroDeLinhas()] = null;
        }

        // get all elems from a given column and add to a new array
        for (List<E> row : matrizGenerica) {
            arr[i++] = row.get(col);
        }

        return arr;
    }

    //4.c)
    public boolean contemElemento(E elem) {
        boolean result = false;
        for (List<E> row : matrizGenerica) {
            if (row.contains(elem))
                result = true;
        }
        return result;
    }

    public int getNumeroDeColunas(int indiceLinha) {
        verificarIndiceLinha(indiceLinha);
        return this.matrizGenerica.get(indiceLinha).size();
    }

    public int getNumeroDeLinhas() {
        return this.matrizGenerica.size();
    }

    public void limpar() {
        this.matrizGenerica.clear();
    }

    // 4.a)
    public E obterElemento(int linha, int coluna) {
        verificarIndices(linha, coluna);
        return matrizGenerica.get(linha).get(coluna);
    }

    //4.e)
    public List<E> removerLinha(int row) {
        verificarIndiceLinha(row);
        return matrizGenerica.remove(row);
    }

    //4.d)
    public E substituirElem(int row, int col, E elem) {
        verificarIndices(row, col);
        return matrizGenerica.get(row).set(col, elem);
    }

    private String mensagemIndiceColunaInvalido(int indice) {
        return " Índice Coluna: " + indice
                + ", Tamanho: " + this.matrizGenerica.get(indice).size();
    }

    private String mensagemIndiceLinhaInvalido(int indice) {
        return "Índice Linha: " + indice
                + ", Tamanho: " + this.matrizGenerica.size();
    }

    private int tamanhoColuna(int indice) {
        verificarIndiceColuna(indice);
        int numeroLinhas = 0;
        for (List<E> linha : this.matrizGenerica) {
            if (indice < linha.size()) {
                numeroLinhas++;
            }
        }
        return numeroLinhas;
    }

    private void verificarIndiceColuna(int indiceColuna) {
        if (indiceColuna < 0 || indiceColuna >= this.numeroMaximoColunas) {
            throw new IndexOutOfBoundsException(
                    " Índice Coluna: " + indiceColuna
                    + ", Tamanho: " + this.numeroMaximoColunas);
        }
    }

    private void verificarIndiceLinha(int indice) {
        if (indice < 0 || indice >= this.matrizGenerica.size()) {
            throw new IndexOutOfBoundsException(
                    "Índice Linha: " + indice
                    + ", Tamanho: " + this.matrizGenerica.size());
        }
    }

    private void verificarIndices(int indiceLinha, int indiceColuna) {
        if (indiceLinha < 0
                || indiceLinha >= this.matrizGenerica.size()
                || indiceColuna < 0
                || indiceColuna >= this.matrizGenerica.get(indiceLinha).size()) {
            String mensagem = mensagemIndiceLinhaInvalido(indiceLinha)
                    + mensagemIndiceColunaInvalido(indiceLinha);
            throw new IndexOutOfBoundsException(mensagem);
        }
    }

}
