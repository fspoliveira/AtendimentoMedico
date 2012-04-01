/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fiap.controller;

import br.com.fiap.dao.EspecialidadeDao;
import br.com.fiap.dao.EspecialidadeDaoImp;
import br.com.fiap.model.Especialidade;
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

@ManagedBean(name="especialidadeC")
@SessionScoped
public class EspecialidadeController {
    
    private Especialidade especialidade;    
    private DataModel listaEspecialidades;
    private SortedMap<String, String> listEspecialidade = new TreeMap<String, String>();
    
    public SortedMap<String, String> getEspecialidadesCmbBox() {
        List<Especialidade> especialidades = new EspecialidadeDaoImp().list();
        for (Especialidade listEspecialidades : especialidades) {
            listEspecialidade.put(listEspecialidades.getEspecialidade(), String.valueOf(new Long(listEspecialidades.getId())));
        }
        return listEspecialidade;
    }
    
    public DataModel getListarEspecialidades(){
        List<Especialidade> lista = new EspecialidadeDaoImp().list();
        listaEspecialidades = new ListDataModel(lista);
        return listaEspecialidades;        
    }
    
    public Especialidade getEspecialidade(){
        return especialidade;
    }
    
    public void setEspecialidade(Especialidade especialidade){
        this.especialidade = especialidade;
    }
    
    public void prepararAdicionarEspecialidade(ActionEvent actionEvent){
        especialidade = new Especialidade();
    }
    
    public void prepararAlterarEspecialidade(ActionEvent actionEvent){
        especialidade = (Especialidade) (listaEspecialidades.getRowData());
    }
    
    public String excluirEspecialidade(){
        Especialidade especialidadeTemp = (Especialidade) (listaEspecialidades.getRowData());
        EspecialidadeDao dao = new EspecialidadeDaoImp();
        dao.remove(especialidadeTemp);
        return "especialidade";
    }
     
    public void adicionarEspecialidade(ActionEvent actionEvent){
        EspecialidadeDao dao = new EspecialidadeDaoImp();
        dao.save(especialidade);
    }
    
    public void alterarEspecialidade(ActionEvent actionEvent){
        EspecialidadeDao dao = new EspecialidadeDaoImp();
        dao.update(especialidade);
    }
    
}