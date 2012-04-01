/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fiap.model;


import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

/**
 *
 * @author fsantiago
 */

@Entity
@Table(name = "atendimento")
public class Atendimento implements Serializable {
    
    @Id
    @GeneratedValue
    @Column(name = "idAtendimento")
    private long id;
    
    @ManyToOne
    @JoinColumn(name="idMedico")
    private Medico idMedico; 
        
    @ManyToOne
    @JoinColumn(name="idEspecialidade" )
    private Especialidade idEspecialidade; 
    
    @ManyToOne
    @JoinColumn(name="idPaciente")
    private Paciente idPaciente; 
    
    @ManyToOne
    @JoinColumn(name="idConvenio" )
    private Convenio idConvenio; 
    
    @ManyToOne
    @JoinColumn(name="idTratamento" )
    private Tratamento idTratamento; 
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataAtendimento;
    
    private double valorTratamento;
    
    private String horaAtendimento;
    
    private String prontuario;
    
    @OneToMany(mappedBy = "atendimento", cascade=CascadeType.ALL)
    private Collection<Registro> registros;
    
    public Atendimento(){}

    public Atendimento(long id, Medico idMedico, Especialidade idEspecialidade, Paciente idPaciente, Convenio idConvenio, Tratamento idTratamento, Date dataAtendimento, String horaAtendimento) {
        this.id = id;
        this.idMedico = idMedico;
        this.idEspecialidade = idEspecialidade;
        this.idPaciente = idPaciente;
        this.idConvenio = idConvenio;
        this.idTratamento = idTratamento;
        this.dataAtendimento = dataAtendimento;
        this.horaAtendimento = horaAtendimento;
    }
    
    public Date getDataAtendimento() {
        return dataAtendimento;
    }

    public void setDataAtendimento(Date dataAtendimento) {
        this.dataAtendimento = dataAtendimento;
    }

    public String getHoraAtendimento() {
        return horaAtendimento;
    }

    public void setHoraAtendimento(String horaAtendimento) {
        this.horaAtendimento = horaAtendimento;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Convenio getIdConvenio() {
        return idConvenio;
    }

    public void setIdConvenio(Convenio idConvenio) {
        this.idConvenio = idConvenio;
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

    public Paciente getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Paciente idPaciente) {
        this.idPaciente = idPaciente;
    }

    public Tratamento getIdTratamento() {
        return idTratamento;
    }

    public void setIdTratamento(Tratamento idTratamento) {
        this.idTratamento = idTratamento;
    }

    public double getValorTratamento() {
        return valorTratamento;
    }

    public void setValorTratamento(double valorTratamento) {
        this.valorTratamento = valorTratamento;
    }

    public Collection<Registro> getRegistros() {
        return registros;
    }

    public void setRegistros(Collection<Registro> registros) {
        this.registros = registros;
    }

    public String getProntuario() {
        return prontuario;
    }

    public void setProntuario(String prontuario) {
        this.prontuario = prontuario;
    }
    
}