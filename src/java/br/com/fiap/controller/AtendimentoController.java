/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fiap.controller;

import br.com.fiap.dao.AtendimentoDao;
import br.com.fiap.dao.AtendimentoDaoImp;
import br.com.fiap.dao.MedicoDaoImp;
import br.com.fiap.dao.PacienteDaoImp;
import br.com.fiap.dao.TratamentoDaoImp;
import br.com.fiap.model.Atendimento;
import br.com.fiap.model.Convenio;
import br.com.fiap.model.Especialidade;
import br.com.fiap.model.Medico;
import br.com.fiap.model.Paciente;
import br.com.fiap.model.Tratamento;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;
import javax.faces.event.ActionEvent;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author fsantiago
 */
@ManagedBean(name = "atendimentoC")
@SessionScoped
public class AtendimentoController {

    private Atendimento atendimento;
    private DataModel listaAtendimentos;
    private Especialidade especialidade;
    private Medico medico;
    private MedicoEspecialidadeController medicoC;
    private Paciente paciente;
    private PacienteController pacienteC;
    private PacienteDaoImp pacienteDao;
    private Tratamento tratamento;
    private TratamentoController tratamentoC;
    private Convenio convenio;
    private MedicoDaoImp medicoDao;
    private TratamentoDaoImp tratamentoDao;
    private SortedMap<String, String> atendimentos = new TreeMap<String, String>();

    public SortedMap<String, String> getAtendimentos() {
        atendimentos.clear();
        List<Atendimento> numerosAtendimentos = new AtendimentoDaoImp().list();
        for (Atendimento atend : numerosAtendimentos) {
            atendimentos.put(String.valueOf(new Long(atend.getId())), String.valueOf(new Long(atend.getId())));
        }
        return atendimentos;
    }

    public SortedMap<String, String> getTratPorConvEspCmbBox() {
       
            if ((especialidade != null) && (especialidade.getId() != 0)) {
                
                convenio.setId(pacienteDao.getPacienteId(paciente).getConvenio().getId());
                tratamentoC = new TratamentoController();
                return tratamentoC.getTratPorConvEspCmbBox(convenio, especialidade);
            }
        

        return null;
    }

    public SortedMap<String, String> getEspecialidadesMedicoCmbBox() {
        medicoC = new MedicoEspecialidadeController();
        Medico med = new MedicoDaoImp().getMedicoUserId(LoginController.getUser());
        return medicoC.getEspecialidadesMedicoCmbBox(med);
    }

    public DataModel getListarAtendimentos() {
        List<Atendimento> lista = new AtendimentoDaoImp().list();
        listaAtendimentos = new ListDataModel(lista);
        return listaAtendimentos;
    }

    public SortedMap<String, String> getpacientesCmbBox() {
        pacienteC = new PacienteController();
        return pacienteC.getPacientesCmbBox();

    }

    public Atendimento getAtendimento() {
        return atendimento;
    }

    public void setAtendimento(Atendimento atendimento) {
        this.atendimento = atendimento;
    }

    public void prepararAdicionarAtendimento(ActionEvent actionEvent) {
        atendimento = new Atendimento();
        convenio = new Convenio();
        especialidade = new Especialidade();
        medico = new Medico();
        paciente = new Paciente();
        tratamento = new Tratamento();
        medicoDao = new MedicoDaoImp();
        pacienteDao = new PacienteDaoImp();
        tratamentoDao = new TratamentoDaoImp();
    }

    public void prepararAlterarAtendimento(ActionEvent actionEvent) {
        atendimento = (Atendimento) (listaAtendimentos.getRowData());
    }

    public String excluirAtendimento() {
        Atendimento atendimentoTemp = (Atendimento) (listaAtendimentos.getRowData());
        AtendimentoDao dao = new AtendimentoDaoImp();
        dao.remove(atendimentoTemp);
        return "atendimento";
    }

    public void adicionarAtendimento(ActionEvent actionEvent) {
        AtendimentoDao dao = new AtendimentoDaoImp();
        atendimento.setIdEspecialidade(especialidade);
        atendimento.setIdPaciente(paciente);
        atendimento.setIdTratamento(tratamento);
        atendimento.setIdMedico(medicoDao.getMedicoUserId(LoginController.getUser()));
        atendimento.setIdConvenio(pacienteDao.getPacienteId(paciente).getConvenio());
        atendimento.setValorTratamento(tratamentoDao.getTratamento(tratamento).getValorTratamento());

        dao.save(atendimento);
    }

    public void alterarAtendimento(ActionEvent actionEvent) {
        AtendimentoDao dao = new AtendimentoDaoImp();
        dao.update(atendimento);
    }

    public DataModel getListaAtendimentos() {
        return listaAtendimentos;
    }

    public void setListaAtendimentos(DataModel listaAtendimentos) {
        this.listaAtendimentos = listaAtendimentos;
    }

    public Especialidade getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(Especialidade especialidade) {
        this.especialidade = especialidade;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Tratamento getTratamento() {
        return tratamento;
    }

    public void setTratamento(Tratamento tratamento) {
        this.tratamento = tratamento;
    }

    public MedicoEspecialidadeController getMedicoC() {
        return medicoC;
    }

    public void setMedicoC(MedicoEspecialidadeController medicoC) {
        this.medicoC = medicoC;
    }

    public Convenio getConvenio() {
        return convenio;
    }

    public void setConvenio(Convenio convenio) {
        this.convenio = convenio;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public MedicoDaoImp getMedicoDao() {
        return medicoDao;
    }

    public void setMedicoDao(MedicoDaoImp medicoDao) {
        this.medicoDao = medicoDao;
    }

    public PacienteController getPacienteC() {
        return pacienteC;
    }

    public void setPacienteC(PacienteController pacienteC) {
        this.pacienteC = pacienteC;
    }

    public PacienteDaoImp getPacienteDao() {
        return pacienteDao;
    }

    public void setPacienteDao(PacienteDaoImp pacienteDao) {
        this.pacienteDao = pacienteDao;
    }

    public TratamentoController getTratamentoC() {
        return tratamentoC;
    }

    public void setTratamentoC(TratamentoController tratamentoC) {
        this.tratamentoC = tratamentoC;
    }

    public TratamentoDaoImp getTratamentoDao() {
        return tratamentoDao;
    }

    public void setTratamentoDao(TratamentoDaoImp tratamentoDao) {
        this.tratamentoDao = tratamentoDao;
    }
}