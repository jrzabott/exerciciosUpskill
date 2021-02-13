package t4j.app.model;

import java.io.Serializable;
import t4j.app.exception.ElementoDuplicadoException;
import java.util.ArrayList;
import java.util.Objects;

@SuppressWarnings({"serial", "ClassWithoutLogger"})
public class RegistoOrganizacoes implements Serializable {

    /**
     * Variável de instância - contentor do tipo ArrayList que guarda todas as instâncias do tipo organização
     */
    private ArrayList<Organizacao> organizacoes;
    
    /**
     * Variável de instância - plataforma
     */
    private Plataforma plataforma;

    /**
     *  Construtor vazio de registo de organização
     */
    public RegistoOrganizacoes() {
        this.organizacoes = new ArrayList<>();
    }

    /**
     * 
     * @param organizacoes 
     */
    public RegistoOrganizacoes(ArrayList<Organizacao> organizacoes) {
        this.organizacoes = new ArrayList<>(organizacoes);
    }

    /**
     * Construtor cópia de registo de organizações
     * @param regOrg 
     */
    public RegistoOrganizacoes(RegistoOrganizacoes regOrg) {
        this.organizacoes = new ArrayList<>(regOrg.organizacoes);
    }

    /**
     * 
     * @return contentor do tipo ArrayList que guarda todas as instâncias do tipo organização
     */
    public ArrayList<Organizacao> getOrganizacoes() {
        return organizacoes;
    }

    /**
     * 
     * @return a lista de tarefas
     */
    public RegistoTarefas getAllTarefas() {
        RegistoTarefas lista = new RegistoTarefas();
        for (Organizacao org : organizacoes) {
            for (Tarefa tarefa : org.getListaTarefas().getTarefas()) {
                lista.addTarefa(tarefa);
            }
        }
        return lista;
    }

    /**
     * 
     * @param org organização a adicionar
     * @return adiciona uma nova organização
     */
    public boolean addOrganizacao(Organizacao org) {
        return (validaOrganizacao(org) != null) ? organizacoes.add(org) : false;
    }

    /**
     * 
     * @param nif o nif da organização que se quer obter
     * @return a organização à qual corresponde o nif passado por parâmetro
     */
    public Organizacao getOrganizacaoByNif(String nif) {
        for (Organizacao organizacao : organizacoes) {
            if (organizacao.getNif().equalsIgnoreCase(nif)) {
                return organizacao;
            }
        }
        return null;
    }

    /**
     * 
     * @param email o email da organização que se quer obter
     * @return a organização à qual corresponde o email passado por parâmetro
     */
    public Organizacao getOrganizacaoByEmail(String email) {
        for (Organizacao organizacao : organizacoes) {
            if (organizacao.getEmail() == email) {
                return organizacao;
            }
        }
        return null;
    }
// REMOVIDO
// Daniel Junior - 20200202 10:41
// Não faz parte dos casos de uso. O Gestor é criado somente quando da criação da organização.
//    //Test
//    public void setGestorComoUtilizador(Colaborador gestor) {
//        String[] papeis = {"Gestor", "Colaborador"};
//        plataforma.getUsersAPI().registaUtilizadorComPapeis(gestor.getNome(), gestor.getEmail(), plataforma.getAgp().geraPassword(), papeis);
//    }
    
    /**
     * 
     * @param outroObjeto instância de organização a ser comparada
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
        RegistoOrganizacoes outroRegOrg = (RegistoOrganizacoes) outroObjeto;
        return organizacoes.equals(outroRegOrg.organizacoes);
    }

    /**
     * 
     * @return Override do hashCode
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + Objects.hashCode(this.organizacoes);
        return hash;
    }

    /**
     * 
     * @param org instância do tipo organização a validar
     * @return valida a organização
     * @throws ElementoDuplicadoException 
     */
    private Organizacao validaOrganizacao(Organizacao org) throws ElementoDuplicadoException {
        if (getOrganizacaoByNif(org.getNif()) == null) {
            return org;
        } else {
            throw new ElementoDuplicadoException("Já existe uma organização com esse NIF!");
        }
    }

//    public void sendPwd(String emailG, String pwd) {
//        return;
//    }
//    
//    public void removeOrganizacao(int nif) throws ElementoNaoExistenteException {
//        if (getOrganizacaoByNif(nif) != null)
//            organizacoes.remove(getOrganizacaoByNif(nif));
//        else throw new ElementoNaoExistenteException(nif + ": Não existe organização com esse NIF.");
//    }
//    
//    public void updateOrganizacao(int nif, Organizacao o) {
//        if (getOrganizacaoByNif(nif) != null)
//            o = getOrganizacaoByNif(nif);
//        else throw new ElementoNaoExistenteException(nif + ": Não existe organização com esse NIF.");
//    }
//    
//    public RegistoColaboradores getAllColaboradores() {
//        RegistoColaboradores lista = new RegistoColaboradores();
//        for (Organizacao org : organizacoes)
//            for (Colaborador colab : org.getColaboradores());
//                lista.addColaborador(colab);
//        return lista;
//    }
//
//    public void sendPwd(String emailG, String pwd) {
//        return;
//    }
//    
//    public void removeOrganizacao(int nif) throws ElementoNaoExistenteException {
//        if (getOrganizacaoByNif(nif) != null)
//            organizacoes.remove(getOrganizacaoByNif(nif));
//        else throw new ElementoNaoExistenteException(nif + ": Não existe organização com esse NIF.");
//    }
//    
//    public void updateOrganizacao(int nif, Organizacao o) {
//        if (getOrganizacaoByNif(nif) != null)
//            o = getOrganizacaoByNif(nif);
//        else throw new ElementoNaoExistenteException(nif + ": Não existe organização com esse NIF.");
//    }
}
