/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fiap.controller;

import br.com.fiap.dao.ProdutoDaoImp;
import br.com.fiap.dao.RegistroDao;
import br.com.fiap.dao.RegistroDaoImp;
import br.com.fiap.model.Atendimento;
import br.com.fiap.model.Produto;
import br.com.fiap.model.Registro;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

/**
 *
 * @author fsantiago
 */

@ManagedBean(name="registroC")
@SessionScoped
public class RegistroController extends ProdutoController {
    
    private Registro registro;
    private DataModel listaRegistros; 
    private Atendimento atendimento;
    private Produto produto;
    private ProdutoDaoImp produtoDao;
    private AtendimentoController atendimentoC;
    
    //No construtor alimenta a ComboBox
    public RegistroController(){
         super.getProdutos();
    }

    public DataModel getListarRegistros(){
        List<Registro> lista = new RegistroDaoImp().list();
        listaRegistros = new ListDataModel(lista);
        return listaRegistros;        
    }
    
    public void prepararAdicionarRegistro(ActionEvent actionEvent){
        registro = new Registro();
        produto = new Produto();
        atendimento = new Atendimento();
        produtoDao = new ProdutoDaoImp();        
    }
    
    public void prepararAlterarRegistro(ActionEvent actionEvent){
        registro = (Registro) (listaRegistros.getRowData());
    }
    
    public String excluirRegistro(){
        Registro produtoTemp = (Registro) (listaRegistros.getRowData());
        RegistroDao dao = new RegistroDaoImp();
        dao.remove(produtoTemp);
        return "registro";
    }
     
    public void adicionarRegistro(ActionEvent actionEvent){
        RegistroDao dao = new RegistroDaoImp();    
        registro.setProduto(produto);
        registro.setAtendimento(atendimento);
        registro.setPrecoUnitario(produtoDao.getProduto(produto).getPrecoUnitario());
        registro.setPrecoTotal(registro.getPrecoUnitario() * registro.getQuantidade());
        dao.save(registro);
    }
    
    public void alterarRegistro(ActionEvent actionEvent){
        RegistroDao dao = new RegistroDaoImp();        
        dao.update(registro);
    }

    public Atendimento getAtendimento() {
        return atendimento;
    }

    public void setAtendimento(Atendimento atendimento) {
        this.atendimento = atendimento;
    }

    public DataModel getListaRegistros() {
        return listaRegistros;
    }

    public void setListaRegistros(DataModel listaRegistros) {
        this.listaRegistros = listaRegistros;
    }

    public Registro getRegistro() {
        return registro;
    }

    public void setRegistro(Registro registro) {
        this.registro = registro;
    }

    @Override
    public Produto getProduto() {
        return produto;
    }

    @Override
    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public AtendimentoController getAtendimentoC() {
        return atendimentoC;
    }

    public void setAtendimentoC(AtendimentoController atendimentoC) {
        this.atendimentoC = atendimentoC;
    }

    public ProdutoDaoImp getProdutoDao() {
        return produtoDao;
    }

    public void setProdutoDao(ProdutoDaoImp produtoDao) {
        this.produtoDao = produtoDao;
    }
    
}