/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fiap.controller;

import br.com.fiap.dao.AgendamentoDao;
import br.com.fiap.dao.AgendamentoDaoImp;
import br.com.fiap.model.Agendamento;
import br.com.fiap.model.Especialidade;
import br.com.fiap.model.Medico;
import br.com.fiap.model.Paciente;
import java.util.List;
import java.util.SortedMap;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

/**
 *
 * @author fsantiago
 */

@ManagedBean(name = "agendamentoC")
@SessionScoped
public class AgendamentoController  {

    private Agendamento agendamento;
    private DataModel listaAgendamentos;
    private Medico medico;
    private Especialidade especialidade;
    private MedicoController medicoC;
    private EspecialidadeController especialidadeC;
    private MedicoEspecialidadeController medicoEspecialidadeC;
    private PacienteController pacienteC;
    private Paciente paciente;
   
    public SortedMap<String, String> getEspecialidadesCmbBox() {
        especialidadeC = new EspecialidadeController();
        return especialidadeC.getEspecialidadesCmbBox();
    }

    public SortedMap<String, String> getMedicosCmbBox() {
        medicoC = new MedicoController();
        return medicoC.getMedicosCmbBox();
    }
    
          
    public SortedMap<String, String> getpacientesCmbBox() {
        pacienteC = new PacienteController();
        return pacienteC.getPacientesCmbBox();
       
    }

    public SortedMap<String, String> getMedicosEspecialidadesCmbBox() {
        if((especialidade != null) && (especialidade.getId() != 0)){
             medicoEspecialidadeC = new MedicoEspecialidadeController();
        return medicoEspecialidadeC.getMedicosEspecialidadesCmbBox(especialidade);
        }
        
       return null;
        
    }
    
    public DataModel getListarAgendamentos() {
        List<Agendamento> lista = new AgendamentoDaoImp().list();
        listaAgendamentos = new ListDataModel(lista);
        return listaAgendamentos;
    }

    public Agendamento getAgendamento() {
        return agendamento;
    }

    public void setAgendamento(Agendamento agendamento) {
        this.agendamento = agendamento;
    }

    public void prepararAdicionarAgendamento(ActionEvent actionEvent) {
        agendamento = new Agendamento();
        medico = new Medico();
        especialidade = new Especialidade();
        paciente = new Paciente();
    }

    public void prepararAlterarAgendamento(ActionEvent actionEvent) {
        agendamento = (Agendamento) (listaAgendamentos.getRowData());
        medico = new Medico();
        medico.setId(agendamento.getIdMedico().getId());
        especialidade = new Especialidade();        
        especialidade.setId(agendamento.getIdEspecialidade().getId());
        paciente = new Paciente();
        paciente.setId(agendamento.getIdPaciente().getId());
        
    }

    public String excluirAgendamento() {
        Agendamento agendamentoTemp = (Agendamento) (listaAgendamentos.getRowData());
        AgendamentoDao dao = new AgendamentoDaoImp();
        dao.remove(agendamentoTemp);
        return "agendamento";
    }

    public void adicionarAgendamento(ActionEvent actionEvent) {
        AgendamentoDao dao = new AgendamentoDaoImp();
        agendamento.setIdEspecialidade(especialidade);
        agendamento.setIdMedico(medico);
        agendamento.setIdPaciente(paciente);
       
        dao.save(agendamento);
    }

    public void alterarAgendamento(ActionEvent actionEvent) {
        AgendamentoDao dao = new AgendamentoDaoImp();
        agendamento.setIdEspecialidade(especialidade);
        agendamento.setIdMedico(medico);
        agendamento.setIdPaciente(paciente);
        dao.update(agendamento);
    }

    public DataModel getListaAgendamentos() {
        return listaAgendamentos;
    }

    public void setListaAgendamentos(DataModel listaAgendamentos) {
        this.listaAgendamentos = listaAgendamentos;
    }

    public Especialidade getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(Especialidade especialidade) {
        this.especialidade = especialidade;
    }

    public EspecialidadeController getEspecialidadeC() {
        return especialidadeC;
    }

    public void setEspecialidadeC(EspecialidadeController especialidadeC) {
        this.especialidadeC = especialidadeC;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public MedicoController getMedicoC() {
        return medicoC;
    }

    public void setMedicoC(MedicoController medicoC) {
        this.medicoC = medicoC;
    }

    public MedicoEspecialidadeController getMedicoEspecialidadeC() {
        return medicoEspecialidadeC;
    }

    public void setMedicoEspecialidadeC(MedicoEspecialidadeController medicoEspecialidadeC) {
        this.medicoEspecialidadeC = medicoEspecialidadeC;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public PacienteController getPacienteC() {
        return pacienteC;
    }

    public void setPacienteC(PacienteController pacienteC) {
        this.pacienteC = pacienteC;
    }
    
}