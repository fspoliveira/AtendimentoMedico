/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fiap.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;

/**
 *
 * @author fsantiago
 */

@Entity
@Table(name = "medicoEspecialidade")
public class MedicoEspecialidade implements Serializable{
     
    //utilização de chave primária composta (PK)
    @Id
    @ManyToOne
    @JoinColumn(name="idEspecialidade")
    private Especialidade idEspecialidade;
    
    @Id
    @ManyToOne
    @JoinColumn(name="idMedico")
    private Medico idMedico;
    
    public MedicoEspecialidade(){}

    public MedicoEspecialidade(Especialidade idEspecialidade, Medico idMedico) {
        this.idEspecialidade = idEspecialidade;
        this.idMedico = idMedico;
    }

    public Especialidade getIdEspecialidade() {
        return idEspecialidade;
    }

    public void setIdEspecialidade(Especialidade idEspecialidade) {
        this.idEspecialidade = idEspecialidade;
    }

    public Medico getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(Medico idMedico) {
        this.idMedico = idMedico;
    }
  
}