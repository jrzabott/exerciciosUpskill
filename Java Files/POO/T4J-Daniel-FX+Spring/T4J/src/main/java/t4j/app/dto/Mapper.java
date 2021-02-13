package t4j.app.dto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import t4j.app.exception.UsersAPIException;
import t4j.app.model.AreaAtividade;
import t4j.app.model.CaraterCompetenciaTecnica;
import t4j.app.model.CategoriaTarefa;
import t4j.app.model.Colaborador;
import t4j.app.model.CompetenciaTecnica;
import t4j.app.model.EnderecoPostal;
import t4j.app.model.GrauProficiencia;
import t4j.app.model.Organizacao;
import t4j.app.model.Tarefa;
import t4j.app.model.User;

public class Mapper {
    
    public static User UserInfoDTO2User(UserInfoDTO uidto) {
        User u = new User();
        u.setEmail(uidto.getEmail());
        u.setUsername(uidto.getUsername());
        u.setRoles(uidto.getRolenames());
        return u;
    }
    
    public static UserInfoDTO colaboradorDTO2UserInfoDTO(
            ColaboradorDTO gestorDTO, String rolesString) {
        UserInfoDTO uidto = new UserInfoDTO();
        uidto.setUsername(gestorDTO.getEmail());
        uidto.setEmail(gestorDTO.getEmail());
        uidto.setRolenames(rolesString);

        return uidto;
    }

// Organização ////////////////////////////////////////
    public static RegistoOrganizacoesDTO listOrganizacao2OrganizacaoDTO(
            ArrayList<Organizacao> organizacoes) throws NullPointerException {
        ArrayList<OrganizacaoDTO> organizacoesDTO = new ArrayList<>();
        for (Organizacao org : organizacoes) {
            try {
                OrganizacaoDTO odto = organizacao2OrganizacaoDTO(org);
                organizacoesDTO.add(odto);
            } catch (NullPointerException e) {
                // Does nothing
            }
        }
        RegistoOrganizacoesDTO rodto = new RegistoOrganizacoesDTO();
        rodto.setOrganizacoes(organizacoesDTO);
        return rodto;
    }
    
    public static Organizacao organizacaoDTO2Organizacao(OrganizacaoDTO odto) {
        /*
        private String nome;
    private long nif;
    private String website;
    private long telefone;
    private String email;
    private EnderecoPostal endereco;
    private Colaborador gestor;
    private ArrayList<Colaborador> colaboradores;
    private ListaTarefas listaTarefas;
        
         */
        
        Organizacao org = new Organizacao();
        org.setNome(odto.getNomeOrganizacao());
        org.setNif(odto.getNifOrganizacao());
        org.setTelefone(odto.getTelefoneOrganizacao());
        org.setEmail(odto.getEmailOrganizacao());
        org.setWebsite(odto.getWebsiteOrganizacao());

        // Endereço
        EnderecoPostal ep = new EnderecoPostal();
        ep = enderecoPostalDTO2enderecoPostal(odto.getEnderecoPostalDTO());
        org.setEndereco(ep);

        // Gestor
        Colaborador gestor = new Colaborador();
        gestor = colaboradorDTO2Colaborador(odto.getGestorDTO());
        org.setGestor(gestor);

        // Colaboradores
        if (odto.getColaboradores() != null && odto.getColaboradores().size()
                > 0) {
            ArrayList<Colaborador> colaboradoresList = new ArrayList<>();
            for (ColaboradorDTO colDTO : odto.getColaboradores()) {
                Colaborador col = new Colaborador();
                col = colaboradorDTO2Colaborador(colDTO);
                colaboradoresList.add(col);
            }
            org.setColaboradores(colaboradoresList);
        }

        // TODO RegistoDeTarefas - organizacaoDTO2Organizacao
        return org;
    }
    
    public static OrganizacaoDTO organizacao2OrganizacaoDTO(Organizacao org) {

//    private String nome;
//    private long nif;
//    private String website;
//    private long telefone;
//    private String email;
//    private EnderecoPostal endereco;
//    private Colaborador gestor;
//    private ArrayList<Colaborador> colaboradores;
//    private ListaTarefas listaTarefas;
        
        /**
         * 
         */
        OrganizacaoDTO odto = new OrganizacaoDTO();
        odto.setNomeOrganizacao(org.getNome());
        odto.setNifOrganizacao(org.getNif());
        odto.setWebsiteOrganizacao(org.getWebsite());
        odto.setTelefoneOrganizacao(org.getTelefone());
        odto.setEmailOrganizacao(org.getEmail());

        // Endereço
        /**
         * 
         */
        EnderecoPostalDTO epdto = new EnderecoPostalDTO();
        epdto.setCodPostal(org.getEndereco().getCodigoPostal());
        epdto.setLocalidade(org.getEndereco().getLocalidade());
        epdto.setMorada(org.getEndereco().getMorada());
        odto.setEnderecoPostalDTO(epdto);

        // Gestor
        /**
         * 
         */
        ColaboradorDTO gestorDTO = new ColaboradorDTO();
        gestorDTO = colaborador2ColaboradorDTO(org.getGestor());
        odto.setGestorDTO(gestorDTO);

        // Colaboradores
        /**
         * 
         */
        ArrayList<ColaboradorDTO> listaColaboradoresDTOs = new ArrayList<>();
        for (Colaborador colaborador : org.getColaboradores()) {
            ColaboradorDTO colaboradorDTO = colaborador2ColaboradorDTO(
                    colaborador);
            listaColaboradoresDTOs.add(colaboradorDTO);
        }
        odto.setColaboradores(listaColaboradoresDTOs);

        //TODO Lista de Tarefas DTO e Métodos de Conversão
        return odto;
    }

// Area de Atividade ////////////////////////////////////////
    /**
     * 
     * @param atividades
     * @return
     * @throws NullPointerException 
     */
    public static RegistoAreasAtividadeDTO listAtividade2AreaAtividadeDTO(ArrayList<AreaAtividade> atividades) throws NullPointerException {
        ArrayList<AreaAtividadeDTO> atividadesDTO = new ArrayList<>();
        for (AreaAtividade org : atividades) {
            try {
                AreaAtividadeDTO aadto = areaAtividade2AreaAtividadeDTO(org);
                atividadesDTO.add(aadto);
            } catch (NullPointerException e) {
                // Does nothing
            }
        }
        RegistoAreasAtividadeDTO raadto = new RegistoAreasAtividadeDTO();
        raadto.setAtividades(atividadesDTO);
        return raadto;
    }

    /**
     * 
     * @param areaAtividade
     * @return 
     */
    public static AreaAtividadeDTO areaAtividade2AreaAtividadeDTO(AreaAtividade areaAtividade) {
        AreaAtividadeDTO areaDTO = new AreaAtividadeDTO();
        areaDTO.setCodigo(areaAtividade.getCodigoAreaAtividade());
        areaDTO.setDescBreve(areaAtividade.getDescricaoBreve());
        areaDTO.setDescDetalhada(areaAtividade.getDescricaoDetalhada());
        return areaDTO;
    }

    /**
     * 
     * @param areaAtividadeDTO
     * @return 
     */
    public static AreaAtividade areaAtividadeDTO2AreaAtividade(AreaAtividadeDTO areaAtividadeDTO) {
        AreaAtividade area = new AreaAtividade();
        area.setCodigoAreaAtividade(areaAtividadeDTO.getCodigo());
        area.setDescricaoBreve(areaAtividadeDTO.getDescBreve());
        area.setDescricaoDetalhada(areaAtividadeDTO.getDescDetalhada());
        return area;
    }

// Endereço Postal  ////////////////////////////////////////
    /**
     * 
     * @param enderecoPostal
     * @return 
     */
    public static EnderecoPostalDTO enderecoPostal2enderecoPostalDTO(EnderecoPostal enderecoPostal) {
        EnderecoPostalDTO enderecoPostalDTO = new EnderecoPostalDTO();
        enderecoPostalDTO.setMorada(enderecoPostal.getMorada());
        enderecoPostalDTO.setCodPostal(enderecoPostal.getCodigoPostal());
        enderecoPostalDTO.setLocalidade(enderecoPostal.getLocalidade());
        return enderecoPostalDTO;
    }

    /**
     * 
     * @param enderecoPostalDTO
     * @return 
     */
    public static EnderecoPostal enderecoPostalDTO2enderecoPostal(EnderecoPostalDTO enderecoPostalDTO) {
        EnderecoPostal ep = new EnderecoPostal();
        ep.setMorada(enderecoPostalDTO.getMorada());
        ep.setCodigoPostal(enderecoPostalDTO.getCodPostal());
        ep.setLocalidade(enderecoPostalDTO.getLocalidade());
        return ep;
    }

// Categoria ////////////////////////////////////////
    /**
     * 
     * @param categorias
     * @return
     * @throws NullPointerException 
     */
    public static RegistoCategoriasDTO listCategoria2CategoriaDTO(ArrayList<CategoriaTarefa> categorias) throws NullPointerException {
        ArrayList<CategoriaTarefaDTO> categoriasDTO = new ArrayList<>();
        for (CategoriaTarefa org : categorias) {
            try {
                CategoriaTarefaDTO cdto = categoria2CategoriaDTO(org);
                categoriasDTO.add(cdto);
            } catch (NullPointerException e) {
                // Does nothing
            }
        }
        RegistoCategoriasDTO rcdto = new RegistoCategoriasDTO();
        rcdto.setCategorias(categoriasDTO);
        return rcdto;
    }

    /**
     * 
     * @param categoria
     * @return
     * @throws NullPointerException 
     */
    public static CategoriaTarefaDTO categoria2CategoriaDTO(CategoriaTarefa categoria) throws NullPointerException {
        CategoriaTarefaDTO categoriaDTO = new CategoriaTarefaDTO();
        categoriaDTO.setIdCategoria(String.valueOf(categoria.getIdCategoria()));
        categoriaDTO.setDescricao(categoria.getDescricaoCategoria());
        
        AreaAtividadeDTO areaAtividadeDTO = areaAtividade2AreaAtividadeDTO(
                categoria.getAreaAtividade());
        categoriaDTO.setAreaAtividade(areaAtividadeDTO);
        
        ArrayList<CaraterCompetenciaTecnicaDTO> cctdtos = new ArrayList<>();
        for (CaraterCompetenciaTecnica caraterCompetenciaTecnica : categoria.
                getListaCaraterCompetenciaTecnica()) {
            CaraterCompetenciaTecnicaDTO cctdto = caraterCT2CaraterCTDTO(
                    caraterCompetenciaTecnica);
            cctdtos.add(cctdto);
        }
        categoriaDTO.setCaraterCompetenciaTecnica(cctdtos);
        return categoriaDTO;
        
    }
    
    public static CategoriaTarefa categoriaDTO2Categoria(
            CategoriaTarefaDTO categoriaDTO) throws NullPointerException {
        CategoriaTarefa categoria = new CategoriaTarefa();
        
        AreaAtividade areaAtividade = areaAtividadeDTO2AreaAtividade(
                categoriaDTO.getAreaAtividade());

//        ArrayList<CaraterCompetenciaTecnica> cts = new ArrayList<>();
        ArrayList<CaraterCompetenciaTecnica> cts
                = listCaraterCompetenciaTecnicaDTO2CaraterCompetenciaTecnica(
                        categoriaDTO.getCaraterCompetenciaTecnica());
        
        categoria.setAreaAtividade(areaAtividade);
        categoria.
                setIdCategoria(Integer.parseInt(categoriaDTO.getIdCategoria()));
        categoria.setDescricaoCategoria(categoriaDTO.getDescricao());
        categoria.setListaCaraterCompetenciaTecnica(cts);
        return categoria;
    }

// Competência Técnica ////////////////////////////////////////    
    public static CompetenciaTecnicaDTO competenciaTecnica2CompetenciaTecnicaDTO(
            CompetenciaTecnica competenciaTecnica) throws NullPointerException {
        CompetenciaTecnicaDTO competenciaTecnicaDTO
                = new CompetenciaTecnicaDTO();
        competenciaTecnicaDTO.setCodigoCompetenciaTecnica(competenciaTecnica.
                getCodigoCompetenciaTecnica());
        competenciaTecnicaDTO.setDescricaoBreve(competenciaTecnica.
                getDescricaoBreve());
        competenciaTecnicaDTO.setDescricaoDetalhada(competenciaTecnica.
                getDescricaoDetalhada());
        AreaAtividadeDTO atDTO = areaAtividade2AreaAtividadeDTO(
                competenciaTecnica.getAreaAtividade());
        competenciaTecnicaDTO.setAreaAtividade(atDTO);
        RegistoGrausProficienciaDTO grausDTO = listGrau2GrauDTO(
                competenciaTecnica.getGrausProficiencia());
        competenciaTecnicaDTO.setGrausProficiencia(grausDTO.
                getGrausProficiencia());
        return competenciaTecnicaDTO;
    }

    /**
     * 
     * @param ctDTO
     * @return
     * @throws NullPointerException 
     */
    public static CompetenciaTecnica competenciaTecnicaDTO2CompetenciaTecnica(CompetenciaTecnicaDTO ctDTO) throws NullPointerException {
        CompetenciaTecnica ct = new CompetenciaTecnica();
        ct.setCodigoCompetenciaTecnica(ctDTO.getCodigoCompetenciaTecnica());
        ct.setDescricaoBreve(ctDTO.getDescricaoBreve());
        ct.setDescricaoDetalhada(ctDTO.getDescricaoDetalhada());
        AreaAtividade at = areaAtividadeDTO2AreaAtividade(ctDTO.
                getAreaAtividade());
        ct.setAreaAtividade(at);
        ArrayList<GrauProficiencia> graus = listGrauDTO2Grau(ctDTO.
                getGrausProficiencia());
        ct.setGrausProficiencia(graus);
        return ct;
    }

    /**
     * 
     * @param listaCT
     * @return
     * @throws NullPointerException 
     */
    public static RegistoCompetenciasTecnicasDTO listCompetenciasTecnicas2CompetenciasTecnicasDTO(ArrayList<CompetenciaTecnica> listaCT) throws NullPointerException {
        ArrayList<CompetenciaTecnicaDTO> listaCTDTO = new ArrayList<>();
        for (CompetenciaTecnica ct : listaCT)
            try {
            listaCTDTO.add(competenciaTecnica2CompetenciaTecnicaDTO(ct));
        } catch (NullPointerException e) {
            // Does nothing
        }
        RegistoCompetenciasTecnicasDTO regCTDTO = new RegistoCompetenciasTecnicasDTO();
        regCTDTO.setCompetenciasTecnicas(listaCTDTO);
        return regCTDTO;
    }

// Graus de Proficiência ////////////////////////////////////////   
    /**
     *
     * @param grau
     * @return
     */
    public static GrauProficienciaDTO grau2GrauDTO(GrauProficiencia grau) {
        GrauProficienciaDTO grauDTO = new GrauProficienciaDTO();
        grauDTO.setValor(grau.getValorGrauProficiencia());
        grauDTO.setDesignacao(grau.getDesignacaoGrauProficiencia());
        return grauDTO;
    }

    /**
     *
     * @param grauDTO
     * @return
     */
    public static GrauProficiencia grauDTO2Grau(GrauProficienciaDTO grauDTO) {
        GrauProficiencia grau = new GrauProficiencia();
        grau.setValorGrauProficiencia(grauDTO.getValor());
        grau.setDesignacaoGrauProficiencia(grauDTO.getDesignacao());
        return grau;
    }

    /**
     *
     * @param graus
     * @return
     * @throws NullPointerException
     */
    public static RegistoGrausProficienciaDTO listGrau2GrauDTO(ArrayList<GrauProficiencia> graus) throws NullPointerException {
        ArrayList<GrauProficienciaDTO> grausDTO = new ArrayList<>();
        for (GrauProficiencia grau : graus)
            try {
            GrauProficienciaDTO grauproficienciaDTO = grau2GrauDTO(grau);
            grausDTO.add(grauproficienciaDTO);
        } catch (NullPointerException e) {
            // Does nothing
        }
        RegistoGrausProficienciaDTO registoGrausProficienciaDTO = new RegistoGrausProficienciaDTO();
        registoGrausProficienciaDTO.setGrausProficiencia(grausDTO);
        return registoGrausProficienciaDTO;
    }

    /**
     *
     * @param grausDTO
     * @return
     * @throws NullPointerException
     */
    public static ArrayList<GrauProficiencia> listGrauDTO2Grau(ArrayList<GrauProficienciaDTO> grausDTO) throws NullPointerException {
        ArrayList<GrauProficiencia> graus = new ArrayList<>();
        for (GrauProficienciaDTO grauDTO : grausDTO)
            try {
            GrauProficiencia grauProficiencia = grauDTO2Grau(grauDTO);
            graus.add(grauProficiencia);
        } catch (NullPointerException e) {
            // Does nothing
        }
        return new ArrayList<GrauProficiencia>(graus);
    }

// Tarefa ////////////////////////////////////////
    /**
     *
     * @param tarefas
     * @return
     * @throws NullPointerException
     */
    public static RegistoTarefasDTO listTarefa2TarefaDTO(ArrayList<Tarefa> tarefas) throws NullPointerException {
        ArrayList<TarefaDTO> tarefasDTO = new ArrayList<>();
        for (Tarefa tarefa : tarefas) {
            try {
                TarefaDTO tarefaDTO = tarefa2TarefaDTO(tarefa);
                tarefasDTO.add(tarefaDTO);
            } catch (NullPointerException e) {     //does nothing. Actually, nothing is added to arraylist
            }
        }
        RegistoTarefasDTO rtdto = new RegistoTarefasDTO();
        rtdto.setTarefas(tarefasDTO);
        return rtdto;
    }

    /**
     *
     * @param tarefa
     * @return
     * @throws NullPointerException
     */
    public static TarefaDTO tarefa2TarefaDTO(Tarefa tarefa) throws NullPointerException {
        TarefaDTO tdto = new TarefaDTO();
        tdto.setReferencia(tarefa.getReferencia());
        tdto.setDesignacao(tarefa.getDesignacao());
        tdto.setDescricaoInformal(tarefa.getDescricaoInformal());
        tdto.setDescricaoTecnica(tarefa.getDescricaoTecnica());
        tdto.setDuracaoEstimada(tarefa.getDuracaoEstimada());
        tdto.setCustoEstimado(tarefa.getCustoEstimado());
        CategoriaTarefaDTO categoriaDTO = categoria2CategoriaDTO(tarefa.
                getCategoria());
        tdto.setCategoria(categoriaDTO);
        return tdto;
    }

    /**
     *
     * @param tarefaDTO
     * @return
     * @throws NullPointerException
     */
    public static Tarefa tarefaDTO2Tarefa(TarefaDTO tarefaDTO) throws NullPointerException {
        Tarefa tarefa = null;
        CategoriaTarefa categoria = categoriaDTO2Categoria(tarefaDTO.
                getCategoria());
        tarefa = new Tarefa();
        
        tarefa.setCategoria(categoria);
        tarefa.setCustoEstimado(tarefaDTO.getCustoEstimado());
        tarefa.setDescricaoInformal(tarefaDTO.getDescricaoInformal());
        tarefa.setDescricaoTecnica(tarefaDTO.getDescricaoTecnica());
        tarefa.setDesignacao(tarefaDTO.
                        getDesignacao());
        tarefa.setDuracaoEstimada(tarefaDTO.
                        getDuracaoEstimada());
        tarefa.setReferencia(tarefaDTO.getReferencia());

        return tarefa;
    }

// Colaborador  ////////////////////////////////////////
    /**
     *
     * @param colaboradores
     * @return
     * @throws NullPointerException
     */
    public static RegistoColaboradoresDTO listColaborador2ColaboradorDTO(ArrayList<Colaborador> colaboradores) throws NullPointerException {
        ArrayList<ColaboradorDTO> colaboradoresDTO = new ArrayList<>();
        for (Colaborador col : colaboradores) {
            try {
                ColaboradorDTO colaboradorDTO = colaborador2ColaboradorDTO(col);
                colaboradoresDTO.add(colaboradorDTO);
            } catch (NullPointerException e) {     //does nothing. Actually, nothing is added to arraylist
            }
        }
        RegistoColaboradoresDTO lista = new RegistoColaboradoresDTO();
        lista.setColaboradores(colaboradoresDTO);
        return lista;
    }

    /**
     *
     * @param colaborador
     * @return
     * @throws NullPointerException
     */
    public static ColaboradorDTO colaborador2ColaboradorDTO(Colaborador colaborador) throws NullPointerException {
        ColaboradorDTO cdto = new ColaboradorDTO();
        cdto.setNome(colaborador.getNome());
        cdto.setFuncao(colaborador.getFuncao());
        cdto.setEmail(colaborador.getEmail());
        cdto.setTelefone(colaborador.getTelefone());
        return cdto;
    }

    /**
     *
     * @param colaboradorDTO
     * @return
     * @throws NullPointerException
     */
    public static Colaborador colaboradorDTO2Colaborador(ColaboradorDTO colaboradorDTO) throws NullPointerException {
        Colaborador colaborador = null;
        colaborador = new Colaborador();
        colaborador.setNome(colaboradorDTO.getNome());
        colaborador.setFuncao(colaboradorDTO.getFuncao());
        colaborador.setEmail(colaboradorDTO.getEmail());
        colaborador.setTelefone(colaboradorDTO.getTelefone());
        return colaborador;
    }

    /**
     *
     * @param gestorDTO
     * @return
     */
    public static UserInfoDTO colaboradorDTO2UserInfoDTO(ColaboradorDTO gestorDTO) {
        UserInfoDTO u = new UserInfoDTO();
        u.setEmail(gestorDTO.getEmail());
        u.setUsername(gestorDTO.getEmail());
        return u;
    }

// Carater Competencia Tecnica ////////////////////////////////////////
    private static CaraterCompetenciaTecnica caraterCTDTO2CaraterCT(
            CaraterCompetenciaTecnicaDTO caraterCompetenciaTecnicaDTO) {
        CaraterCompetenciaTecnica cct = new CaraterCompetenciaTecnica();
        cct.setObrigatorio(caraterCompetenciaTecnicaDTO.isObrigatorio());
        GrauProficiencia gp = grauDTO2Grau(caraterCompetenciaTecnicaDTO.
                getGrauProficiencia());
        cct.setGrauProficiencia(gp);
        CompetenciaTecnica ct = competenciaTecnicaDTO2CompetenciaTecnica(
                caraterCompetenciaTecnicaDTO.getCompetenciaTecnica());
        cct.setCompetenciaTecnica(ct);
        return cct;
    }
    
    private static ArrayList<CaraterCompetenciaTecnica> listCaraterCompetenciaTecnicaDTO2CaraterCompetenciaTecnica(
            ArrayList<CaraterCompetenciaTecnicaDTO> caraterCompetenciaTecnicaDTOs) {
        ArrayList<CaraterCompetenciaTecnica> cts = new ArrayList<>();
        for (CaraterCompetenciaTecnicaDTO caraterCompetenciaTecnicaDTO
                : caraterCompetenciaTecnicaDTOs) {
            try {
                CaraterCompetenciaTecnica ct = caraterCTDTO2CaraterCT(
                        caraterCompetenciaTecnicaDTO);
                cts.add(ct);
            } catch (NullPointerException e) {
                // Does nothing
            }
        }
        return cts;
    }
    
    private static CaraterCompetenciaTecnicaDTO caraterCT2CaraterCTDTO(
            CaraterCompetenciaTecnica caraterCompetenciaTecnica) {
        CaraterCompetenciaTecnicaDTO cctdto = new CaraterCompetenciaTecnicaDTO();
        CompetenciaTecnicaDTO ctdto = competenciaTecnica2CompetenciaTecnicaDTO(
                caraterCompetenciaTecnica.getCompetenciaTecnica());
        cctdto.setCompetenciaTecnica(ctdto);
        
        GrauProficienciaDTO gpdto = grau2GrauDTO(caraterCompetenciaTecnica.
                getGrauProficiencia());
        cctdto.setGrauProficiencia(gpdto);
        
        cctdto.setObrigatorio(caraterCompetenciaTecnica.isObrigatorio());
        
        return cctdto;
    }
    
}
