package t4j.app.controller;

import t4j.app.dto.CategoriaTarefaDTO;
import t4j.app.dto.RegistoCategoriasDTO;
import t4j.app.dto.TarefaDTO;
import t4j.app.service.TarefasService;

public class UIEspecificarTarefaController {

    public boolean addTarefa(TarefaDTO tdto) {
        return TarefasService.addTarefa(tdto);
    }

    /**
     *
     * @param referencia referência da tarefa
     * @param designacao designação da tarefa
     * @param descricaoInformal descrição infromal da tarefa
     * @param descricaoTecnica descrição técnica da tarefa
     * @param duracaoEstimada duração estimada da tarefa
     * @param custoEstimado custo estimado da tarefa
     * @param categoria categoria da tarefa
     * @return true se foi especificada uma nova tarefa e false se contrário
     */
    public static boolean especificarTarefa(String referencia, String designacao,
            String descricaoInformal, String descricaoTecnica,
            String duracaoEstimada, String custoEstimado, CategoriaTarefaDTO categoria) {
        boolean result;
        TarefaDTO tdto = new TarefaDTO();
        tdto.setReferencia(referencia);
        tdto.setDesignacao(designacao);
        tdto.setDescricaoInformal(descricaoInformal);
        tdto.setDescricaoTecnica(descricaoTecnica);
        tdto.setDuracaoEstimada(duracaoEstimada);
        tdto.setCustoEstimado(custoEstimado);
        tdto.setCategoria(categoria);
        result = TarefasService.addTarefa(tdto);
        return result;
    }

    public RegistoCategoriasDTO getRegistoCategoriasDTO() {
        return CategoriaTarefasService.getRegistoCategorias();
    }
}
