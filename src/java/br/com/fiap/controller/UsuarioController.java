/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fiap.controller;

import br.com.fiap.dao.UsuarioDao;
import br.com.fiap.dao.UsuarioDaoImp;
import br.com.fiap.model.Usuario;
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

@ManagedBean(name="usuarioC")
@SessionScoped
public class UsuarioController {
    
    private Usuario usuario;
    private DataModel listaUsuarios;    
    private SortedMap<String, String> listUsuariosCombo = new TreeMap<String, String>();

    public SortedMap<String, String> getUsuariosCmbBox() {
        List<Usuario> usuarios = new UsuarioDaoImp().list();
        for (Usuario usuarioList : usuarios) {
            listUsuariosCombo.put(usuarioList.getLogin(), usuarioList.getLogin());
        }
        return listUsuariosCombo;
    }
       
    public DataModel getListarUsuarios(){
        List<Usuario> lista = new UsuarioDaoImp().list();
        listaUsuarios = new ListDataModel(lista);
        return listaUsuarios;        
    }
    
    public Usuario getUsuario(){
        return usuario;
    }
    
    public void setUsuario(Usuario usuario){
        this.usuario = usuario;
    }
    
    public void prepararAdicionarUsuario(ActionEvent actionEvent){
        usuario = new Usuario();
    }
    
    public void prepararAlterarUsuario(ActionEvent actionEvent){
        usuario = (Usuario) (listaUsuarios.getRowData());
    }
    
    public String excluirUsuario(){
        Usuario convenioTemp = (Usuario) (listaUsuarios.getRowData());
        UsuarioDao dao = new UsuarioDaoImp();
        dao.remove(convenioTemp);
        return "usuario";
    }
     
    public void adicionarUsuario(ActionEvent actionEvent){
        UsuarioDao dao = new UsuarioDaoImp();
        dao.save(usuario);
    }
    
    public void alterarUsuario(ActionEvent actionEvent){
        UsuarioDao dao = new UsuarioDaoImp();
        dao.update(usuario);
    }

    public DataModel getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(DataModel listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

}
