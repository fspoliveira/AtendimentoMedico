/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fiap.controller;

import br.com.fiap.dao.ConvenioDao;
import br.com.fiap.dao.ConvenioDaoImp;
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

@ManagedBean(name="convenioC")
@SessionScoped
public class ConvenioController {
    
    private Convenio convenio;
    private DataModel listaConvenios;
    private SortedMap<String,String> tipos = new TreeMap<String,String>();
    
    public SortedMap<String, String> getTipos(){
        List<Convenio> tiposConvenios = new ConvenioDaoImp().list();
        for(Convenio tiposConvenio: tiposConvenios ){
            tipos.put( tiposConvenio.getDescricao(), String.valueOf(new Long(tiposConvenio.getId())));            
        }
        return tipos;
    }
    
    public void setTipos(SortedMap<String, String> tipos) {
        this.tipos = tipos;
    }
    
    public DataModel getListarConvenios(){
        List<Convenio> lista = new ConvenioDaoImp().list();
        listaConvenios = new ListDataModel(lista);
        return listaConvenios;        
    }
    
    public Convenio getConvenio(){
        return convenio;
    }
    
    public void setConvenio(Convenio convenio){
        this.convenio = convenio;
    }
    
    public void prepararAdicionarConvenio(ActionEvent actionEvent){
        convenio = new Convenio();
    }
    
    public void prepararAlterarConvenio(ActionEvent actionEvent){
        convenio = (Convenio) (listaConvenios.getRowData());
    }
    
    public String excluirConvenio(){
        Convenio convenioTemp = (Convenio) (listaConvenios.getRowData());
        ConvenioDao dao = new ConvenioDaoImp();
        dao.remove(convenioTemp);
        return "convenio";
    }
     
    public void adicionarConvenio(ActionEvent actionEvent){
        ConvenioDao dao = new ConvenioDaoImp();
        dao.save(convenio);
    }
    
    public void alterarConvenio(ActionEvent actionEvent){
        ConvenioDao dao = new ConvenioDaoImp();
        dao.update(convenio);
    }

    public DataModel getListaConvenios() {
        return listaConvenios;
    }

    public void setListaConvenios(DataModel listaConvenios) {
        this.listaConvenios = listaConvenios;
    }
   
}