/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fiap.controller;

import br.com.fiap.dao.FaturamentoDaoImp;
import br.com.fiap.model.Atendimento;
import br.com.fiap.model.Faturamento;
import java.util.Collection;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

/**
 *
 * @author fsantiago
 */


@ManagedBean(name="faturamentoC")
@SessionScoped
public class FaturamentoController {
      
   
    private Collection<Atendimento>  atendimento;
     private DataModel listaFaturamento;
     private Faturamento faturamento;
    
     public DataModel getListarFaturamentos(){
        
        List<Atendimento> lista = new FaturamentoDaoImp().list();
        listaFaturamento = new ListDataModel(lista);
        return listaFaturamento;  
    }

    public Collection<Atendimento> getAtendimento() {
        return atendimento;
    }

    public void setAtendimento(Collection<Atendimento> atendimento) {
        this.atendimento = atendimento;
    }

    public DataModel getListaFaturamento() {
        return listaFaturamento;
    }

    public void setListaFaturamento(DataModel listaFaturamento) {
        this.listaFaturamento = listaFaturamento;
    }

    public Faturamento getFaturamento() {
        return faturamento;
    }

    public void setFaturamento(Faturamento faturamento) {
        this.faturamento = faturamento;
    }
    
}
