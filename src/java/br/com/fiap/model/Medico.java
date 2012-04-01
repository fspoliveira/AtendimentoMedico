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
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author fsantiago
 */

@Entity
@Table(name = "medico")
public class Medico implements Serializable {
    
    @Id
    @GeneratedValue
    @Column(name = "idMedico")
    private long id;
    
    @Column(name = "nomeMedico")
    private String nome;
    
    @Column(name = "crmMedico")
    private String crm;
    
    @OneToOne
    @JoinColumn(name="login")
    private Usuario usuario;
    
    @OneToMany(mappedBy = "idMedico", cascade=CascadeType.ALL)
    private Collection<MedicoEspecialidade> medicosEspecialidade;    
    
    @OneToMany(mappedBy = "idMedico", cascade=CascadeType.ALL)
    private Collection<Agendamento> medicosAgendamento;
    
    @OneToMany(mappedBy = "idMedico", cascade=CascadeType.ALL)
    private Collection<Atendimento> atendimentos;

    public Medico(){}

    public Medico(long id, String nome, String crm, Collection<MedicoEspecialidade> medicosEspecialidade) {
        this.id = id;
        this.nome = nome;
        this.crm = crm;
        this.medicosEspecialidade = medicosEspecialidade;
    }
    
    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public long getId() {
       return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Collection<MedicoEspecialidade> getMedicosEspecialidade() {
        return medicosEspecialidade;
    }

    public void setMedicosEspecialidade(Collection<MedicoEspecialidade> medicosEspecialidade) {
        this.medicosEspecialidade = medicosEspecialidade;
    }

    public Collection<Agendamento> getMedicosAgendamento() {
        return medicosAgendamento;
    }

    public void setMedicosAgendamento(Collection<Agendamento> medicosAgendamento) {
        this.medicosAgendamento = medicosAgendamento;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Collection<Atendimento> getAtendimentos() {
        return atendimentos;
    }

    public void setAtendimentos(Collection<Atendimento> atendimentos) {
        this.atendimentos = atendimentos;
    }
    
}