/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fiap.model;


import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.CascadeType;
import javax.persistence.OneToMany;


/**
 *
 * @author fsantiago
 */


@Entity
@Table(name = "convenio")
public class Convenio implements Serializable {
    
    @Id
    @GeneratedValue
    @Column(name = "idConvenio")
    private long id;
    
    @Column(name = "descricaoConvenio")
    private String descricao;
    
    @OneToMany(mappedBy = "convenio", cascade=CascadeType.ALL)
    private Collection<Paciente> pacientes;
    
    @OneToMany(mappedBy = "convenio", cascade=CascadeType.ALL)
    private Collection<Tratamento> tratamentos;
    
    @OneToMany(mappedBy = "idConvenio", cascade=CascadeType.ALL)
    private Collection<Atendimento> atendimentos;

    public Convenio(){}

    public Convenio(long id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Collection<Paciente> getPacientes() {
        return pacientes;
    }

    public void setPacientes(Collection<Paciente> pacientes) {
        this.pacientes = pacientes;
    }

    public Collection<Tratamento> getTratamentos() {
        return tratamentos;
    }

    public void setTratamentos(Collection<Tratamento> tratamentos) {
        this.tratamentos = tratamentos;
    }

    public Collection<Atendimento> getAtendimentos() {
        return atendimentos;
    }

    public void setAtendimentos(Collection<Atendimento> atendimentos) {
        this.atendimentos = atendimentos;
    }
}