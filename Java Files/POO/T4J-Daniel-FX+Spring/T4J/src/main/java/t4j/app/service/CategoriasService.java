package t4j.app.service;

import java.util.ArrayList;
import t4j.app.dto.CategoriaTarefaDTO;
import t4j.app.dto.Mapper;
import t4j.app.dto.RegistoCategoriasDTO;
import t4j.app.exception.ConversaoException;
import t4j.app.model.CategoriaTarefa;
import t4j.app.model.Plataforma;
import t4j.app.model.RegistoCategorias;
import t4j.app.repo.Dados;

public class CategoriasService {

    /**
     *
     * @return o registo de categorias
     */
    public static RegistoCategoriasDTO getCategorias() {
        RegistoCategoriasDTO rcdto;
        Plataforma plataforma = Dados.carregarDados();
        RegistoCategorias rc = plataforma.getRegistoCategorias();
        ArrayList<CategoriaTarefa> categorias = rc.getCategorias();
        rcdto = Mapper.listCategoria2CategoriaDTO(categorias);
        return rcdto;
    }

    /**
     *
     * @param id id da categoria que se pretende
     * @return uma categoria identificada pelo seu id
     */
    public static CategoriaTarefaDTO getCategoria(int id) {
        Plataforma plataforma = Dados.carregarDados();
        CategoriaTarefa categoria = plataforma.getRegistoCategorias().getCategoriaById(id);
        if (categoria == null) {
            return null;
        }
        CategoriaTarefaDTO categoriaDTO = Mapper.categoria2CategoriaDTO(categoria);
        if (categoriaDTO != null) {
            return categoriaDTO;
        } else {
            throw new ConversaoException("CategoriaDTO");
        }
    }

    /**
     *
     * @param categoriaDTO categoria a ser adicionada
     */
    public static void addCategoria(CategoriaTarefaDTO categoriaDTO) {
        CategoriaTarefa categoria = Mapper.categoriaDTO2Categoria(categoriaDTO);
        Plataforma plataforma = Dados.carregarDados();
        if (categoria != null) {
            plataforma.getRegistoCategorias().addCategoria(categoria);
            Dados.guardarDados(plataforma);
        } else {
            throw new ConversaoException("CategoriaDTO");
        }
    }

    /**
     *
     * @param id código da categoria que se pretende atualizar
     * @param categoriaDTO categoria identificada pelo seu id de categoria a ser atualizada
     */
    public static void updateCategoria(int id, CategoriaTarefaDTO categoriaDTO) {
        CategoriaTarefa categoria = Mapper.categoriaDTO2Categoria(categoriaDTO);
        Plataforma plataforma = Dados.carregarDados();
        if (categoria != null) {
            plataforma.getRegistoCategorias().updateCategoria(id, categoria);
            Dados.guardarDados(plataforma);
        } else {
            throw new ConversaoException("CategoriaDTO");
        }
    }

    /**
     *
     * @param id id da categoria que se pretende remover
     */
    public static void removeCategoria(int id) {
        Plataforma plataforma = Dados.carregarDados();
        plataforma.getRegistoCategorias().removeCategoria(id);
        Dados.guardarDados(plataforma);
    }
}
