/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fiap.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.Temporal;

/**
 *
 * @author fsantiago
 */
@Entity
@Table(name = "agendamento")
public class Agendamento implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "idAgendamento")
    private long idAgendamento;
    
    @ManyToOne
    @JoinColumn(name = "idEspecialidade")
    private Especialidade idEspecialidade;
    
    @ManyToOne
    @JoinColumn(name = "idMedico")
    private Medico idMedico;
    
    @ManyToOne
    @JoinColumn(name = "idPaciente")
    private Paciente idPaciente;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataAgendamento;
    private String horaAtendimento;

    public Agendamento() {
    }

   public Agendamento(long idAgendamento, Especialidade idEspecialidade, Medico idMedico) {
        this.idAgendamento = idAgendamento;
        this.idEspecialidade = idEspecialidade;
        this.idMedico = idMedico;
    }

    public Especialidade getIdEspecialidade() {
        return idEspecialidade;
    }

    public void setIdEspecialidade(Especialidade idEspecialidade) {
        this.idEspecialidade = idEspecialidade;
    }

    public long getIdAgendamento() {
        return idAgendamento;
    }

    public void setIdAgendamento(long idAgendamento) {
        this.idAgendamento = idAgendamento;
    }

    public Medico getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(Medico idMedico) {
        this.idMedico = idMedico;
    }

    public Paciente getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Paciente idPaciente) {
        this.idPaciente = idPaciente;
    }

    public Date getDataAgendamento() {
        return dataAgendamento;
    }

    public void setDataAgendamento(Date dataAgendamento) {
        this.dataAgendamento = dataAgendamento;
    }

    public String getHoraAtendimento() {
        return horaAtendimento;
    }

    public void setHoraAtendimento(String horaAtendimento) {
        this.horaAtendimento = horaAtendimento;
    }
}