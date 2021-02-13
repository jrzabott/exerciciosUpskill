package t4j.app.service;

import t4j.app.dto.ColaboradorDTO;
import t4j.app.dto.Mapper;
import t4j.app.dto.UserInfoDTO;
import t4j.app.model.Colaborador;
import t4j.app.model.Organizacao;
import t4j.app.model.Plataforma;
import t4j.app.model.RegistoOrganizacoes;
import t4j.app.repo.Dados;
import t4j.app.repo.EnumRoles;
import t4j.app.repo.UsersAPI;
import t4j.app.utils.AlgoritmoGeradorPasswords;

public class ColaboradoresService {

    
    /**
     *
     * @param organizacaoNif nif do colaborador que se pretende adicionar
     * @param cdto colaborador que se pretende adicionar e que é identificado
     * pelo seu nif
     * @return true se um novo colaborador foi adicionado e false se contrário
     */
    public static boolean addColaborador(String organizacaoNif,
            ColaboradorDTO cdto) {
        boolean result = false;

        Colaborador colaborador = Mapper.colaboradorDTO2Colaborador(cdto);

        if (colaborador != null) {
            Plataforma p = Dados.carregarDados();
            RegistoOrganizacoes ro = p.getRegistoOrganizacoes();
            Organizacao o = ro.getOrganizacaoByNif(organizacaoNif);
            result = o.addColaborador(colaborador);

            if (result) {
                UserInfoDTO u = Mapper.colaboradorDTO2UserInfoDTO(cdto);
                u.setPassword(AlgoritmoGeradorPasswords.geraString(
                        AlgoritmoGeradorPasswords.MIX, 16));
                result = ColaboradoresService.addUtilizadorGestor(u);
                if (result) {
                    UsersService.sendPassword(u.getEmail(), u.getPassword());
                    Dados.guardarDados(p);
                }
            }
        }
        return result;
    }

    /**
     *
     * @param u informação do utilizador que se pretende adicionar
     * @return true se um novo utilizador foi adicionado e false se contrário
     */
    public static boolean addUtilizador(UserInfoDTO u) {
        Plataforma p = Dados.carregarDados();
        UsersAPI uapi = p.getUsersAPI();
        return uapi.registerUser(u);
    }

    /**
     *
     * @param u informação do utilizador colaborador que se pretende adicionar
     * @return true se um novo utilizador colaborador foi adicionado e false se
     * contrário
     */
    public static boolean addUtilizadorColaborador(UserInfoDTO u) {
        String rolesString = EnumRoles.COLABORADOR.toString();
        u.setRolenames(rolesString);
        return addUtilizador(u);
    }

    /**
     *
     * @param u informação do utilizador gestor que se pretende adicionar
     * @return true se um novo utilizador gestor foi adicionado e false se
     * contrário
     */
    public static boolean addUtilizadorGestor(UserInfoDTO u) {
        String rolesString = EnumRoles.GESTOR.toString() + ","
                + EnumRoles.COLABORADOR.toString();
        u.setRolenames(rolesString);
        return addUtilizador(u);
    }

}
