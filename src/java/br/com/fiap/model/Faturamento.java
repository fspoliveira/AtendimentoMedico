/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fiap.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author fsantiago
 */

@Entity
@Table(name = "faturamento")
public class Faturamento implements Serializable {
  
    
    @Id
    private long idConvenio;
    
    private String descricaoConvenio;
    private String nomeMedico;
    double valorTratamento;
    double precoTotalMateriais;

    public String getDescricaoConvenio() {
        return descricaoConvenio;
    }

    public void setDescricaoConvenio(String descricaoConvenio) {
        this.descricaoConvenio = descricaoConvenio;
    }

    public String getNomeMedico() {
        return nomeMedico;
    }

    public void setNomeMedico(String nomeMedico) {
        this.nomeMedico = nomeMedico;
    }

    public double getValorTratamento() {
        return valorTratamento;
    }

    public void setValorTratamento(double valorTratamento) {
        this.valorTratamento = valorTratamento;
    }

    public long getIdConvenio() {
        return idConvenio;
    }

    public void setIdConvenio(long idConvenio) {
        this.idConvenio = idConvenio;
    }

    public double getPrecoTotalMateriais() {
        return precoTotalMateriais;
    }

    public void setPrecoTotalMateriais(double precoTotalMateriais) {
        this.precoTotalMateriais = precoTotalMateriais;
    }
    
}
