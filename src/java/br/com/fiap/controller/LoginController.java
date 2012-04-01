/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fiap.controller;

import br.com.fiap.dao.MedicoDaoImp;
import br.com.fiap.dao.UsuarioDaoImp;

import br.com.fiap.model.Medico;
import br.com.fiap.model.Usuario;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author fsantiago
 */
@ManagedBean (name="loginC")
@SessionScoped
public class LoginController implements Serializable{

    private UsuarioDaoImp userDao = new UsuarioDaoImp();
    private Usuario usuario = new Usuario();
    
    private String username;
    private String password;

    public LoginController(){
        
    }

    public LoginController(String username, String password) {
        this.username = username;
        this.password = password;
    }
    

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String login() {
        
        FacesMessage msg = null;
        
        this.setPassword(Usuario.encrypt(this.username, this.password));

        this.usuario = this.userDao.getUsuario(username);
       
        if(this.usuario != null && this.username.equals(usuario.getLogin()) && this.password.equals(usuario.getSenha())){
           
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", usuario);
           return "home";
            
        }else{
          
            msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Login Error", "Invalid credentials");
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(username, msg);
            
            return "login";
        }

    }
    
    public static Usuario getUser(){
        Usuario user = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
        return user;
    }
    
     public String getNomeUserLogado() {
        
        Medico medico = new MedicoDaoImp().getMedicoUserId(LoginController.getUser()); 
        if (medico == null){
            return "medico nao cadastrado";
        }
        else{
        
        return medico.getNome();
        }
        
    }
}
