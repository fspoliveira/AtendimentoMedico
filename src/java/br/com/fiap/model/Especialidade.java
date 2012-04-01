/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fiap.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.OneToMany;

/**
 *
 * @author fsantiago
 */

@Entity
@Table(name = "especialidade")
public class Especialidade implements Serializable {
    
    @Id
    @GeneratedValue
    @Column(name = "idEspecialidade")
    private long id;
    
    @Column(name = "descricaoEspecialidade")
    private String especialidade;
    
    @OneToMany(mappedBy = "idEspecialidade", cascade=CascadeType.ALL)
    private Collection<MedicoEspecialidade> especialidadeMedicos;
    
    @OneToMany(mappedBy = "idEspecialidade", cascade=CascadeType.ALL)
    private Collection<Tratamento> tratamentos;
    
    @OneToMany(mappedBy = "idEspecialidade", cascade=CascadeType.ALL)
    private Collection<Agendamento> agendamentos;
    
    @OneToMany(mappedBy = "idEspecialidade", cascade=CascadeType.ALL)
    private Collection<Atendimento> atendimentos;

    public Collection<MedicoEspecialidade> getEspecialidadeMedicos() {
        return especialidadeMedicos;
    }

    public void setEspecialidadeMedicos(Collection<MedicoEspecialidade> especialidadeMedicos) {
        this.especialidadeMedicos = especialidadeMedicos;
    }
      
    public Especialidade(){}

    public Especialidade(long id, String especialidade) {
        this.id = id;
        this.especialidade = especialidade;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Collection<Tratamento> getTratamentos() {
        return tratamentos;
    }

    public void setTratamentos(Collection<Tratamento> tratamentos) {
        this.tratamentos = tratamentos;
    }

    public Collection<Agendamento> getAgendamentos() {
        return agendamentos;
    }

    public void setAgendamentos(Collection<Agendamento> agendamentos) {
        this.agendamentos = agendamentos;
    }

    public Collection<Atendimento> getAtendimentos() {
        return atendimentos;
    }

    public void setAtendimentos(Collection<Atendimento> atendimentos) {
        this.atendimentos = atendimentos;
    }
    
}