package t4j.app.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;
import t4j.app.exception.ElementoDuplicadoException;
import t4j.app.exception.ElementoNaoExistenteException;

@SuppressWarnings({"serial", "ClassWithoutLogger"})
public class RegistoCategorias implements Serializable {

    /**
     * Variável de instância - contentor do tipo ArrayList que guarda todas as
     * instâncias do tipo categoria
     */
    private ArrayList<CategoriaTarefa> categorias;

    /**
     * Construtor completo de lista de categorias
     *
     * @param categorias contentor do tipo ArrayList que guarda todas as
     * instâncias do tipo categorias
     */
    public RegistoCategorias(ArrayList<CategoriaTarefa> categorias) {
        this.categorias = new ArrayList<>(categorias);
    }

    /**
     * Construtor vazio de lista de categorias
     */
    public RegistoCategorias() {
        this.categorias = new ArrayList<>();
    }

    /**
     * Construtor cópia de lista de categorias
     *
     * @param outroRegistoCategorias
     */
    public RegistoCategorias(RegistoCategorias outroRegistoCategorias) {
        this.categorias = new ArrayList<>(outroRegistoCategorias.categorias);
    }

    /**
     *
     * @return contentor do tipo ArrayList que guarda todas as instâncias do
     * tipo categoria
     */
    public ArrayList<CategoriaTarefa> getCategorias() {
        return categorias;
    }

    /**
     *
     * @return
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Registo de categorias:\n");
        for (int i = 0; i < categorias.size(); i++) {
            categorias.get(i).toString();
            sb.append(categorias.get(i).toString());
        }
        return sb.toString();
    }

    /**
     *
     * @param idCategoria ID de categoria
     * @return a categoria ao qual pertence o ID introduzido por parâmetro
     */
    public CategoriaTarefa getCategoriaById(int idCategoria) {
        for (CategoriaTarefa categoria : categorias) {
            if (categoria.getIdCategoria() == idCategoria) {
                return categoria;
            }
        }
        return null;
    }

    /**
     *
     * @param categoria instância do tipo categoria a ser adicionada ao
     * contentor categorias
     * @return devolve verdadeiro se adicionou e falso se não adicionou
     */
    public boolean addCategoria(CategoriaTarefa categoria) {
        boolean result = validaCategoria(categoria) != null;
        return (result) ? categorias.add(categoria) : false;
    }

    /**
     *
     * @param idCategoria ID de categoria
     * @throws ElementoNaoExistenteException
     */
    public void removeCategoria(int idCategoria) throws ElementoNaoExistenteException {
        CategoriaTarefa categoria = null;
        for (int i = 0; i < this.categorias.size(); i++) {
            categoria = this.categorias.get(i);
            if (categoria.getIdCategoria() == idCategoria) {
                this.categorias.remove(i);
                return;
            } else {
                throw new ElementoNaoExistenteException(idCategoria + ": Não existe esta categoria!!");
            }
        }
    }

    /**
     *
     * @param idCategoria ID de categoria
     * @param c instância do tipo categoria a ser atualizada no contentor categorias
     * @throws ElementoNaoExistenteException
     */
    public void updateCategoria(int idCategoria, CategoriaTarefa c) throws ElementoNaoExistenteException {
        CategoriaTarefa categoria = null;
        boolean updated = false;
        for (int i = 0; i < this.categorias.size(); i++) {
            categoria = this.categorias.get(i);
            if (categoria.getIdCategoria() == idCategoria) {
                this.categorias.set(i, c);
                updated = true;
            }
        }
        if (updated == false) {
            throw new ElementoNaoExistenteException(idCategoria + ": Não existe esta categoria!!");
        }
    }

    /**
     *
     * @param outroObjeto instância de lista de categorias a ser comparada
     * @return reescrita do método equals e retorna um booleano
     */
    @Override
    public boolean equals(Object outroObjeto) {
        if (this == outroObjeto) {
            return true;
        }
        if (outroObjeto == null || getClass() != outroObjeto.getClass()) {
            return false;
        }
        RegistoCategorias outroRegistoCategorias = (RegistoCategorias) outroObjeto;
        return categorias.equals(outroRegistoCategorias.categorias);
    }

    /**
     *
     * @return Override do hashCode
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 73 * hash + Objects.hashCode(this.categorias);
        return hash;
    }

    /**
     *
     * @param categoria instância do tipo categoria a ser validada
     * @return retorna a instância do tipo categoria para adição ao contentor
     * depois de validada
     * @throws ElementoDuplicadoException
     */
    private CategoriaTarefa validaCategoria(CategoriaTarefa categoria) throws ElementoDuplicadoException {
        CategoriaTarefa ct = getCategoriaById(categoria.getIdCategoria());
        if (ct == null) {
            return categoria;
        } else {
            throw new ElementoDuplicadoException("Já existe uma categoria com este ID!");
        }
    }
}
