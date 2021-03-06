/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upskill.AutarquiaWS.model;

import upskill.AutarquiaWS.exception.ElementoNaoExistenteException;
import upskill.AutarquiaWS.exception.NifDuplicadoException;
import upskill.AutarquiaWS.exception.NumeroFuncionarioDuplicadoException;

import java.io.Serializable;
import java.util.ArrayList;
import upskill.AutarquiaWS.exception.FreguesiaDuplicadoException;

public class Autarquia implements Serializable {
    
    private String nome;
    private ArrayList<Pessoa> pessoas;
    private ArrayList<Freguesia> freguesias;
    
    public Autarquia(String nome, Freguesia freguesia) {
        this.nome = nome;
        this.pessoas = new ArrayList<Pessoa>();
        this.freguesias = new ArrayList<Freguesia>();
        this.freguesias.add(freguesia);
    }
    
    public Autarquia(String nome) {
        this.nome = nome;
        this.pessoas = new ArrayList<Pessoa>();
        this.freguesias = new ArrayList<Freguesia>();
    }
    
    public ArrayList<Pessoa> getAllPessoas() {
        Pessoa pessoa;
        ArrayList<Pessoa> lista = new ArrayList<>();
        for (int i = 0; i < this.pessoas.size(); i++) {
            pessoa = this.pessoas.get(i);
            if (!(pessoa instanceof Funcionario)) {
                Pessoa copiaPessoa = new Pessoa(pessoa);
                lista.add(copiaPessoa);
            } else {
                Funcionario funcionarioFuncionario = new Funcionario((Funcionario) pessoa);
                lista.add(funcionarioFuncionario);
            }
        }
        return lista;
    }
//////////////////////////////////////////////////

    public ArrayList<Pessoa> getPessoas() {
        Pessoa pessoa;
        ArrayList<Pessoa> lista = new ArrayList<>();
        for (int i = 0; i < this.pessoas.size(); i++) {
            pessoa = this.pessoas.get(i);
            if (!(pessoa instanceof Funcionario)) {
                Pessoa copia = new Pessoa(pessoa);
                lista.add(copia);
            }
        }
        return lista;
    }
    
    public void addPessoa(Pessoa pessoa) throws NifDuplicadoException {
        Pessoa p = getPessoaByNif(pessoa.getNif());
        if (p == null) {
            this.pessoas.add(pessoa);
        } else {
            throw new NifDuplicadoException(p.getNif() + ": NIF já existe");
        }
    }
    
    public Pessoa getPessoa(long nif) {
        return getPessoaByNif(nif);
    }
    
    public void removePessoa(long nif) throws ElementoNaoExistenteException {
        Pessoa pessoa = null;
        for (int i = 0; i < this.pessoas.size(); i++) {
            pessoa = this.pessoas.get(i);
            if (pessoa.getNif() == nif) {
                if (!(pessoa instanceof Funcionario)) {
                    this.pessoas.remove(i);
                    return;
                } else {
                    throw new ElementoNaoExistenteException(nif + ": Não é uma pessoa, é um funcionário");
                }
            }
        }
        throw new ElementoNaoExistenteException(nif + ": Não existe essa pessoa");
    }
    
    public void updatePessoa(long nif, Pessoa p) throws ElementoNaoExistenteException {
        Pessoa pessoa = null;
        boolean updated = false;
        for (int i = 0; i < this.pessoas.size() && !updated; i++) {
            pessoa = this.pessoas.get(i);
            if (pessoa.getNif() == nif) {
//                pessoa = p;
                this.pessoas.set(i, p);
                updated = true;
            }
        }
        if (updated == false) {
            throw new ElementoNaoExistenteException(nif + ": Não existe essa pessoa");
        }
    }
    
    private Pessoa getPessoaByNif(long nif) {
        Pessoa pessoa = null;
        for (int i = 0; i < this.pessoas.size(); i++) {
            pessoa = this.pessoas.get(i);
            if (pessoa.getNif() == nif) {
                Pessoa copia = new Pessoa(pessoa);
                return copia;
            }
        }
        return null;
    }
///////////////////////////////////////////////
// Funcionários

    public ArrayList<Funcionario> getFuncionarios() {
        Pessoa pessoa;
        ArrayList<Funcionario> lista = new ArrayList<>();
        for (int i = 0; i < this.pessoas.size(); i++) {
            pessoa = this.pessoas.get(i);
            if (pessoa instanceof Funcionario) {
                Funcionario copia = new Funcionario((Funcionario) pessoa);
                lista.add(copia);
            }
        }
        return lista;
    }
    
    public void addFuncionario(Funcionario funcionario) throws NumeroFuncionarioDuplicadoException,
            NifDuplicadoException {
        Pessoa p = getPessoaByNif(funcionario.getNif());
        if (p == null) {
            Funcionario f = getFuncionarioByNr(funcionario.getNumeroFuncionario());
            if (f == null) {
                addPessoa(funcionario);
            } else {
                throw new NumeroFuncionarioDuplicadoException(f.getNumeroFuncionario() + ": Número de Funcionário já existe");
            }
        } else {
            throw new NifDuplicadoException(p.getNif() + ": NIF já existe");
        }
    }
    
    public Funcionario getFuncionario(int nr) {
        Funcionario funcionario = getFuncionarioByNr(nr);
        if (funcionario != null) {
            Funcionario copia = new Funcionario(funcionario);
            return copia;
        }
        return null;
    }
    
    public void removeFuncionario(int nr) throws ElementoNaoExistenteException {
        Pessoa pessoa = null;
        Funcionario funcionario = null;
        for (int i = 0; i < this.pessoas.size(); i++) {
            pessoa = this.pessoas.get(i);
            if (pessoa instanceof Funcionario) {
                if (pessoa instanceof Funcionario) {
                    funcionario = (Funcionario) pessoa;
                    if (funcionario.getNumeroFuncionario() == nr) {
                        this.pessoas.remove(i);
                        return;
                    }
                }
            }
        }
        throw new ElementoNaoExistenteException(nr + ": Não existe esse funcionário");
    }
    
    public void updateFuncionario(int nr, Funcionario f) throws ElementoNaoExistenteException {
        boolean updated = false;
        Pessoa pessoa = null;
        Funcionario funcionario = null;
        for (int i = 0; i < this.pessoas.size() && !updated; i++) {
            pessoa = this.pessoas.get(i);
            if (pessoa instanceof Funcionario) {
                funcionario = (Funcionario) pessoa;
                if (funcionario.getNumeroFuncionario() == nr) {
//                    funcionario = f;
                    this.pessoas.set(i, f);
                    updated = true;
                }
            }
        }
        if (updated == false) {
            throw new ElementoNaoExistenteException(nr + ": Não existe esse funcionario");
        }
    }
    
    private Funcionario getFuncionarioByNr(int nr) {
        Pessoa pessoa = null;
        Funcionario funcionario = null;
        for (int i = 0; i < this.pessoas.size(); i++) {
            pessoa = this.pessoas.get(i);
            if (pessoa instanceof Funcionario) {
                funcionario = (Funcionario) pessoa;
                if (funcionario.getNumeroFuncionario() == nr) {
                    return funcionario;
                }
            }
        }
        return null;
    }
    
    public void addFreguesia(Freguesia freguesia) throws NifDuplicadoException {
        Freguesia f = getFreguesiaById(freguesia.getId());
        if (f == null) {
            this.freguesias.add(freguesia);
        } else {
            throw new FreguesiaDuplicadoException(f.getId() + " - " + f.getNome() + ": ID de Freguesia já existe.");
        }
    }
    
    private Freguesia getFreguesiaById(long id) {
        Freguesia freguesia = null;
        for (int i = 0; i < this.freguesias.size(); i++) {
            freguesia = this.freguesias.get(i);
            if (freguesia.getId() == id) {
                Freguesia copia = new Freguesia(freguesia);
                return copia;
            }
        }
        return null;
    }
    
    public ArrayList<Freguesia> getFreguesias() {
        Freguesia freguesia;
        ArrayList<Freguesia> lista = new ArrayList<>();
        for (int i = 0; i < this.freguesias.size(); i++) {
            freguesia = this.freguesias.get(i);
            lista.add(freguesia);
        }
        return lista;
    }
    
    public Freguesia getFreguesia(long id) {
        return getFreguesiaById(id);
    }
    
    public void removeFreguesia(long id) {
        Freguesia freguesia = null;
        for (int i = 0; i < this.freguesias.size(); i++) {
            freguesia = this.freguesias.get(i);
            if (freguesia.getId() == id) {
                this.freguesias.remove(i
                );
                return;
            }
        }
        throw new ElementoNaoExistenteException(id + ": Não existe uma freguesia com este ID");
    }
    
    public void updateFreguesia(long id, Freguesia f) {
        Freguesia freguesia = null;
        boolean updated = false;
        for (int i = 0; i < this.freguesias.size() && !updated; i++) {
            freguesia = this.freguesias.get(i);
            if (freguesia.getId() == id) {
//                freguesia = f;
                this.freguesias.set(i, f);
                updated = true;
            }
        }
        if (!updated) {
            throw new ElementoNaoExistenteException(id + ": Não existe freguesia com este ID");
        }
    }
}
