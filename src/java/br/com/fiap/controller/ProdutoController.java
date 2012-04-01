/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fiap.controller;

/**
 *
 * @author fsantiago
 */

import br.com.fiap.dao.ProdutoDao;
import br.com.fiap.dao.ProdutoDaoImp;
import br.com.fiap.model.Produto;
import br.com.fiap.model.TipoProduto;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

@ManagedBean(name="produtoC")
@SessionScoped
public class ProdutoController extends TipoProdutoController {
    
    private Produto produto;
    private DataModel listaProdutos;    
    private TipoProduto tp;
    private SortedMap<String,String> produtos = new TreeMap<String,String>();
    
    public SortedMap<String, String> getProdutos(){
       
        List<Produto> tiposProdutos = new ProdutoDaoImp().list();
        for(Produto prod: tiposProdutos ){
            produtos.put( prod.getDescricao(),String.valueOf(new Long(prod.getId())));            
        }
        return produtos;
    }
        
    public void ProdutoController(){
         super.getTipos();
    }

    public TipoProduto getTp() {
        return tp;
    }

    public void setTp(TipoProduto tp) {
        this.tp = tp;
    }
    
    public Produto getProduto(){
        return produto;
    }
    
    public void setProduto(Produto produto){
        this.produto = produto;
    }
    
    public DataModel getListarProdutos(){
        List<Produto> lista = new ProdutoDaoImp().list();
        listaProdutos = new ListDataModel(lista);
        return listaProdutos;        
    }
    
    public void prepararAdicionarProduto(ActionEvent actionEvent){
        produto = new Produto();
        tp = new TipoProduto();
       
    }
    
    public void prepararAlterarProduto(ActionEvent actionEvent){
        produto = (Produto) (listaProdutos.getRowData());
        tp = new TipoProduto();
        tp.setIdTipoProduto(produto.getTipoProduto().getIdTipoProduto());        
    }
    
    public String excluirProduto(){
        Produto produtoTemp = (Produto) (listaProdutos.getRowData());
        ProdutoDao dao = new ProdutoDaoImp();
        dao.remove(produtoTemp);
        return "produto";
    }
     
    public void adicionarProduto(ActionEvent actionEvent){
        ProdutoDao dao = new ProdutoDaoImp();
        produto.setTipoProduto(tp);
        dao.save(produto);
    }
    
    public void alterarProduto(ActionEvent actionEvent){
        ProdutoDao dao = new ProdutoDaoImp();
        produto.setTipoProduto(tp);
        dao.update(produto);
    }
    
}