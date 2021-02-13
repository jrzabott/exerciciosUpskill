/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package t4j.app.controller;

import java.util.ArrayList;
import t4j.app.dto.CategoriaTarefaDTO;
import t4j.app.dto.Mapper;
import t4j.app.dto.RegistoCategoriasDTO;
import t4j.app.exception.ElementoInvalidoException;
import t4j.app.model.CategoriaTarefa;
import t4j.app.model.Plataforma;
import t4j.app.model.RegistoCategorias;
import t4j.app.repo.Dados;

/**
 *
 * @author user
 */
class CategoriaTarefasService {

    static boolean addCategoriaTarefa(CategoriaTarefaDTO ctdto) {
        try {

            CategoriaTarefa ct = Mapper.categoriaDTO2Categoria(ctdto);
            if (ct != null) {
                Plataforma p = Dados.carregarDados();
                RegistoCategorias rc = p.getRegistoCategorias();

                if (rc.getCategorias().size() > 0) {
                    int idIncremental = rc.getCategorias().get(0).
                            getIdCategoria();
                    for (CategoriaTarefa categoria : rc.getCategorias()) {
                        if (categoria.getIdCategoria() > idIncremental) {
                            idIncremental = categoria.getIdCategoria();
                        }
                    }
                    idIncremental += 1;
                    ctdto.setIdCategoria(String.valueOf(idIncremental));
                    ct.setIdCategoria(idIncremental);
                }
                boolean result = rc.addCategoria(ct);
                if (result) {
                    Dados.guardarDados(p);
                    return result;
                }
            }
            return false;
        } catch (Exception e) {
            throw new ElementoInvalidoException("CategoriaTarefaDTO\n" + e.
                    getMessage());
        }
    }

    public static RegistoCategoriasDTO getRegistoCategorias() {
        Plataforma p = Dados.carregarDados();
        RegistoCategorias rc = p.getRegistoCategorias();
        RegistoCategoriasDTO rcdto = Mapper.listCategoria2CategoriaDTO(rc.
                getCategorias());
        return rcdto;

    }

}
