/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fiap.controller;

import br.com.fiap.dao.TratamentoDao;
import br.com.fiap.dao.TratamentoDaoImp;
import br.com.fiap.model.Convenio;
import br.com.fiap.model.Especialidade;
import br.com.fiap.model.Tratamento;
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

@ManagedBean(name="tratamentoC")
@SessionScoped
public class TratamentoController {
    
    private Tratamento tratamento;
    private DataModel listaTratamentos;
    private EspecialidadeController especialidadeC;
    private Especialidade especialidade;
    private ConvenioController convenioC;
    private Convenio convenio;
    private SortedMap<String,String> tratamentos = new TreeMap<String,String>();
    
    public SortedMap<String, String> getEspecialidadesCmbBox() {
        especialidadeC = new EspecialidadeController();
        return especialidadeC.getEspecialidadesCmbBox();
    }
    
    public SortedMap<String, String> getConveniosCmbBox() {
        convenioC = new ConvenioController();
        return convenioC.getTipos();
    }
    
    public DataModel getListarTratamentos(){
        List<Tratamento> lista = new TratamentoDaoImp().list();
        listaTratamentos = new ListDataModel(lista);
        return listaTratamentos;        
    }
        
    public SortedMap<String, String> getTratPorConvEspCmbBox(Convenio conv, Especialidade esp){
       
        List<Tratamento> tiposTratamentos =  new TratamentoDaoImp().listTratamentos(conv, esp); 
       // List<Tratamento> tiposTratamentos =  new TratamentoDaoImp().list(); 
        for(Tratamento tiposTratamento: tiposTratamentos ){
            tratamentos.put( tiposTratamento.getDescricao(), String.valueOf(new Long(tiposTratamento.getIdTratamento())));            
        }
        return tratamentos;
        
    }
    
    public Tratamento getTratamento(){
        return tratamento;
    }
    
    public void setTratamento(Tratamento tratamento){
        this.tratamento = tratamento;
    }
    
    public void prepararAdicionarTratamento(ActionEvent actionEvent){
        tratamento = new Tratamento();
        especialidade = new Especialidade();
        convenio = new Convenio();
    }
    
    public void prepararAlterarTratamento(ActionEvent actionEvent){
        tratamento = (Tratamento) (listaTratamentos.getRowData());
        especialidade = new Especialidade();
        especialidade.setId(tratamento.getIdEspecialidade().getId());
        convenio = new Convenio();
        convenio.setId(tratamento.getConvenio().getId());
    }
    
    public String excluirTratamento(){
        Tratamento tratamentoTemp = (Tratamento) (listaTratamentos.getRowData());
        TratamentoDao dao = new TratamentoDaoImp();
        dao.remove(tratamentoTemp);
        return "tratamento";
    }
     
    public void adicionarTratamento(ActionEvent actionEvent){
        TratamentoDao dao = new TratamentoDaoImp();
        tratamento.setIdEspecialidade(especialidade);
        tratamento.setConvenio(convenio);
        dao.save(tratamento);
    }
    
    public void alterarTratamento(ActionEvent actionEvent){
        TratamentoDao dao = new TratamentoDaoImp();
        tratamento.setIdEspecialidade(especialidade);
        tratamento.setConvenio(convenio);
        dao.update(tratamento);
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

    public DataModel getListaTratamentos() {
        return listaTratamentos;
    }

    public void setListaTratamentos(DataModel listaTratamentos) {
        this.listaTratamentos = listaTratamentos;
    }

    public Convenio getConvenio() {
        return convenio;
    }

    public void setConvenio(Convenio convenio) {
        this.convenio = convenio;
    }

    public ConvenioController getConvenioC() {
        return convenioC;
    }

    public void setConvenioC(ConvenioController convenioC) {
        this.convenioC = convenioC;
    }
}