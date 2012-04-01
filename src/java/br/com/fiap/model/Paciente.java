/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fiap.model;

import java.util.Date;
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.CascadeType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;


/**
 *
 * @author fsantiago
 */

@Entity
@Table(name = "paciente")
public class Paciente implements Serializable {
    
    @Id
    @GeneratedValue
    @Column(name = "idPaciente")
    private long id;
    
    private String nome;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataNascimento;
    private String cpf;
    private String rg;
    private String cidade;
    private String estado;
    private String cor;
    private String sexo;
    
    @ManyToOne
    @JoinColumn(name="idConvenio")
    private Convenio convenio; 
    
    @OneToMany(mappedBy = "idPaciente", cascade=CascadeType.ALL)
    private Collection<Agendamento> agendamentos;
    
    @ManyToMany(mappedBy = "idPaciente", cascade=CascadeType.ALL)
    private Collection<Atendimento> atendimentos;
    
    public Paciente(){}

    public Paciente(long id, String nome, Date dataNascimento, String cpf, String rg, String cidade, String estado, String cor, String sexo, Convenio convenio, Collection<Agendamento> agendamentos, Collection<Atendimento> atendimentos) {
        this.id = id;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
        this.rg = rg;
        this.cidade = cidade;
        this.estado = estado;
        this.cor = cor;
        this.sexo = sexo;
        this.convenio = convenio;
        this.agendamentos = agendamentos;
        this.atendimentos = atendimentos;
    }
    
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
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

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Convenio getConvenio() {
        return convenio;
    }

    public void setConvenio(Convenio convenio) {
        this.convenio = convenio;
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
