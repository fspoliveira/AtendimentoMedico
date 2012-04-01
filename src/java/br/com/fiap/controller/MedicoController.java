/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fiap.controller;

import br.com.fiap.dao.MedicoDao;
import br.com.fiap.dao.MedicoDaoImp;
import br.com.fiap.model.Medico;
import br.com.fiap.model.Usuario;
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
@ManagedBean(name = "medicoC")
@SessionScoped
public class MedicoController {

    private Medico medico;
    private DataModel listaMedicos;
    private SortedMap<String, String> listMedicos = new TreeMap<String, String>();
    private UsuarioController usuarioC;
    private Usuario usuario;

    public SortedMap<String, String> getMedicosCmbBox() {
        List<Medico> medicos = new MedicoDaoImp().list();
        for (Medico medicoList : medicos) {
            listMedicos.put(medicoList.getNome(), String.valueOf(new Long(medicoList.getId())));
        }
        return listMedicos;
    }
    
    public SortedMap<String, String> getUsuariosCmbBox() {
        usuarioC = new UsuarioController();
        return usuarioC.getUsuariosCmbBox();
    }

    public DataModel getListarMedicos() {
        List<Medico> lista = new MedicoDaoImp().list();
        listaMedicos = new ListDataModel(lista);
        return listaMedicos;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public void prepararAdicionarMedico(ActionEvent actionEvent) {
        medico = new Medico();
        usuario = new Usuario();
    }

    public void prepararAlterarMedico(ActionEvent actionEvent) {
        medico = (Medico) (listaMedicos.getRowData());
        usuario = new Usuario();
        usuario.setLogin(medico.getUsuario().getLogin());
    }

    public String excluirMedico() {
        Medico medicoTemp = (Medico) (listaMedicos.getRowData());
        MedicoDao dao = new MedicoDaoImp();
        dao.remove(medicoTemp);
        return "medico";
    }

    public void adicionarMedico(ActionEvent actionEvent) {
        MedicoDao dao = new MedicoDaoImp();
        medico.setUsuario(usuario);        
        dao.save(medico);
    }

    public void alterarMedico(ActionEvent actionEvent) {
        MedicoDao dao = new MedicoDaoImp();
        medico.setUsuario(usuario);
        dao.update(medico);
    }

    public SortedMap<String, String> getListMedicos() {
        return listMedicos;
    }

    public void setListMedicos(SortedMap<String, String> listMedicos) {
        this.listMedicos = listMedicos;
    }

    public DataModel getListaMedicos() {
        return listaMedicos;
    }

    public void setListaMedicos(DataModel listaMedicos) {
        this.listaMedicos = listaMedicos;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public UsuarioController getUsuarioC() {
        return usuarioC;
    }

    public void setUsuarioC(UsuarioController usuarioC) {
        this.usuarioC = usuarioC;
    }
    
}