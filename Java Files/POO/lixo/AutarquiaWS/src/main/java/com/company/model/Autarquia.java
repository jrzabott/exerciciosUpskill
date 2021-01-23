package com.company.model;

import com.company.exception.NomeFreguesiaInvalido;
import com.company.exception.ElementoNaoExistenteException;
import com.company.exception.NifDuplicadoException;
import com.company.exception.NumeroFuncionarioDuplicadoException;
import java.io.Serializable;
import java.util.ArrayList;

public class Autarquia implements Serializable {

    private String nome;
    private ArrayList<Pessoa> pessoas;
    private ArrayList<Freguesia> freguesias;

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
            throw new NifDuplicadoException(p.getNif() + ": NIF j´a existe");
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
                    throw new ElementoNaoExistenteException(nif + ": N~ao ´euma pessoa, ´eum funcion´ario");
                }
            }
        }
        throw new ElementoNaoExistenteException(nif + ": N~ao existe essa pessoa");
    }

    public void updatePessoa(long nif, Pessoa p) throws ElementoNaoExistenteException {
        Pessoa pessoa = null;
        boolean updated = false;
        for (int i = 0; i < this.pessoas.size() && !updated; i++) {
            pessoa = this.pessoas.get(i);
            if (pessoa.getNif() == nif) {
                pessoa = p;
                updated = true;
            }
        }
        if (updated == false) {
            throw new ElementoNaoExistenteException(nif + ": N~ao existe essa pessoa");
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
// Funcion´arios

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
                throw new NumeroFuncionarioDuplicadoException(f.getNumeroFuncionario() + ": N´umero de Funcion´ario j´aexiste");
            }
        } else {
            throw new NifDuplicadoException(p.getNif() + ": NIF j´a existe");
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
        throw new ElementoNaoExistenteException(nr + ": N~ao existe esse funcion´ario");
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
                    funcionario = f;
                    updated = true;
                }
            }
        }
        if (updated == false) {
            throw new ElementoNaoExistenteException(nr + ": N~ao existe esse funcionario");
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

    ////Freguesias******************************************
    public ArrayList<Freguesia> getFreguesias() {
        Freguesia freguesia;
        ArrayList<Freguesia> lista = new ArrayList<>();
        for (int i = 0; i < this.freguesias.size(); i++) {
            freguesia = this.freguesias.get(i);
            Freguesia copiaFreguesia = new Freguesia(freguesia);
            lista.add(copiaFreguesia);
        }
        return lista;
    }

    public void addFreguesia(Freguesia freguesia) throws NomeFreguesiaInvalido {
        Freguesia f = getFreguesiabyNome(freguesia.getNome());
        if (f == null) {
            this.freguesias.add(f);
        } else {
            throw new NomeFreguesiaInvalido(f.getNome() + "Invalido");
        }
    }

    public void updateFreguesia(String nome, Freguesia uf) throws ElementoNaoExistenteException {
        boolean updated = false;
        Freguesia f = null;
        for (int i = 0; i < this.freguesias.size() && !updated; i++) {
            f = this.freguesias.get(i);
            if (f.getNome().equals(nome)) {
                f = uf;
                updated = true;
            }
        }
        if (updated == false) {
            throw new ElementoNaoExistenteException(nome + ": N~ao existe esse funcionario");
        }
    }

     public Freguesia getFreguesia(String nome) {
        Freguesia f = getFreguesiabyNome(nome);
        if (f != null) {
            Freguesia copia = new Freguesia(f);
            return copia;
        }
        return null;
    }
  
    public void removeFreguesia(String nome) throws ElementoNaoExistenteException {
        Freguesia freguesia = null;
        for (int i = 0; i < this.freguesias.size(); i++) {
            freguesia = this.freguesias.get(i);
            if (freguesia.getNome().equals(nome)) {
                this.freguesias.remove(i);
            } else {
                throw new ElementoNaoExistenteException(nome + ": nao existe esta freguesia");
            }
        }
    }

    private Freguesia getFreguesiabyNome(String nome) {
        Freguesia freguesia = null;
        for (int i = 0; i < this.freguesias.size(); i++) {
            freguesia = this.freguesias.get(i);
            if (freguesia.getNome().equals(nome)) {
                Freguesia fCopia = new Freguesia(freguesia);
                return fCopia;
            }
        }
        return null;
    }
}
