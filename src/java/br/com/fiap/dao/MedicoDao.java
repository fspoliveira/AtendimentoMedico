/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fiap.dao;

import br.com.fiap.model.Medico;
import br.com.fiap.model.Usuario;
import java.util.List;

/**
 *
 * @author fsantiago
 */
public interface MedicoDao {
    
    public void save(Medico medico);
    public Medico getMedico(long id);
    public List<Medico> list();
    public void remove(Medico medico);
    public void update(Medico medico);
    public Medico getMedicoUserId(Usuario user);
}
