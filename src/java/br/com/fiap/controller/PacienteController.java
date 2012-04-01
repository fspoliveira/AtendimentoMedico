/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fiap.controller;

import br.com.fiap.model.Paciente;
import br.com.fiap.dao.PacienteDao;
import br.com.fiap.dao.PacienteDaoImp;
import br.com.fiap.model.Convenio;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

/**
 *
 * @author fsantiago
 */

@ManagedBean(name="pacienteC")
@SessionScoped
public class PacienteController extends ConvenioController {
    
    private Paciente paciente;
    private DataModel listaPacientes;
    private Convenio convenio;
    
    private SortedMap<String,String> pacientes = new TreeMap<String,String>();    
    
    public SortedMap<String, String> getPacientesCmbBox(){
        List<Paciente> pac = new PacienteDaoImp().list();
        for(Paciente todosPacientes: pac ){
            pacientes.put( todosPacientes.getNome(), String.valueOf(new Long(todosPacientes.getId())));            
        }
        return pacientes;
    }
    
    public DataModel getListarPacientes(){
        List<Paciente> lista = new PacienteDaoImp().list();
        listaPacientes = new ListDataModel(lista);
        return listaPacientes;        
    }
    
    public Paciente getPaciente(){
        return paciente;
    }
    
    public void setPaciente(Paciente paciente){
        this.paciente = paciente;
    }
    
    public void prepararAdicionarPaciente(ActionEvent actionEvent){
        paciente = new Paciente();
        convenio = new Convenio();
    }
    
    public void prepararAlterarPaciente(ActionEvent actionEvent){
        paciente = (Paciente) (listaPacientes.getRowData());
        convenio = new Convenio();
        convenio.setId(paciente.getConvenio().getId());
    }
    
    public String excluirPaciente(){
        Paciente pacienteTemp = (Paciente) (listaPacientes.getRowData());
        PacienteDao dao = new PacienteDaoImp();
        dao.remove(pacienteTemp);
        return "paciente";
    }
     
    public void adicionarPaciente(ActionEvent actionEvent){
        PacienteDao dao = new PacienteDaoImp();
        paciente.setConvenio(convenio);
        dao.save(paciente);
    }
    
    public void alterarPaciente(ActionEvent actionEvent){
        PacienteDao dao = new PacienteDaoImp();
        paciente.setConvenio(convenio);
        dao.update(paciente);
    }

    @Override
    public Convenio getConvenio() {
        return convenio;
    }

    @Override
    public void setConvenio(Convenio convenio) {
        this.convenio = convenio;
    }

    public DataModel getListaPacientes() {
        return listaPacientes;
    }

    public void setListaPacientes(DataModel listaPacientes) {
        this.listaPacientes = listaPacientes;
    }
    
}