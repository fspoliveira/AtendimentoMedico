/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fiap.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

/**
 *
 * @author fsantiago
 */

@Entity
@Table(name = "tratamento")
public class Tratamento implements Serializable{
    
    @Id
    @GeneratedValue
    @Column(name = "idTratamento")
    private long idTratamento;
    
    @ManyToOne
    @JoinColumn(name="idEspecialidade")
    private Especialidade idEspecialidade;
    
    @Column(name = "descricaoTratamento")
    private String descricao;
    
    @ManyToOne
    @JoinColumn(name="idConvenio")
    private Convenio convenio;
    
    @OneToMany(mappedBy = "idTratamento", cascade=CascadeType.ALL)
    private Collection<Atendimento> atendimentos;
    
    private double valorTratamento;   

    public Tratamento(){}

    public Tratamento(long idTratamento, Especialidade idEspecialidade, String descricao) {
        this.idTratamento = idTratamento;
        this.idEspecialidade = idEspecialidade;
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public long getIdTratamento() {
        return idTratamento;
    }

    public void setIdTratamento(long idTratamento) {
        this.idTratamento = idTratamento;
    }

    public Especialidade getIdEspecialidade() {
        return idEspecialidade;
    }

    public void setIdEspecialidade(Especialidade idEspecialidade) {
        this.idEspecialidade = idEspecialidade;
    }

    public Convenio getConvenio() {
        return convenio;
    }

    public void setConvenio(Convenio convenio) {
        this.convenio = convenio;
    }

    public double getValorTratamento() {
        return valorTratamento;
    }

    public void setValorTratamento(double valorTratamento) {
        this.valorTratamento = valorTratamento;
    }

    public Collection<Atendimento> getAtendimentos() {
        return atendimentos;
    }

    public void setAtendimentos(Collection<Atendimento> atendimentos) {
        this.atendimentos = atendimentos;
    }
    
}