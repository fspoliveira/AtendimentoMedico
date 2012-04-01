/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fiap.controller;

import br.com.fiap.dao.TipoProdutoDao;
import br.com.fiap.dao.TipoProdutoDaoImp;
import br.com.fiap.model.TipoProduto;
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

@ManagedBean(name="tipoProdutoC")
@SessionScoped
public class TipoProdutoController{
    
    private TipoProduto tipoProduto;
    private DataModel listaTipoProdutos;    
    private SortedMap<String,String> tipos = new TreeMap<String,String>();

    public SortedMap<String, String> getTipos(){
        List<TipoProduto> tiposProdutos = new TipoProdutoDaoImp().list();
        for(TipoProduto tiposProduto: tiposProdutos ){
            tipos.put( tiposProduto.getDescricao(),String.valueOf(new Long(tiposProduto.getIdTipoProduto())));            
        }
        return tipos;
    }
    
    public DataModel getListarTipoProdutos(){
        List<TipoProduto> lista = new TipoProdutoDaoImp().list();
        listaTipoProdutos = new ListDataModel(lista);
        return listaTipoProdutos;        
    }
    
    public TipoProduto getTipoProduto(){
        return tipoProduto;
    }
    
    public void setTipoProduto(TipoProduto tipoProduto){
        this.tipoProduto = tipoProduto;
    }
    
    public void prepararAdicionarTipoProduto(ActionEvent actionEvent){
        tipoProduto = new TipoProduto();
    }
    
    public void prepararAlterarTipoProduto(ActionEvent actionEvent){
        tipoProduto = (TipoProduto) (listaTipoProdutos.getRowData());
    }
    
    public String excluirTipoProduto(){
        TipoProduto tipoProdutoTemp = (TipoProduto) (listaTipoProdutos.getRowData());
        TipoProdutoDao dao = new TipoProdutoDaoImp();
        dao.remove(tipoProdutoTemp);
        return "tipoProduto";
    }
     
    public void adicionarTipoProduto(ActionEvent actionEvent){
        TipoProdutoDao dao = new TipoProdutoDaoImp();
        dao.save(tipoProduto);
    }
    
    public void alterarTipoProduto(ActionEvent actionEvent){
        TipoProdutoDao dao = new TipoProdutoDaoImp();
        dao.update(tipoProduto);
    }
    
}