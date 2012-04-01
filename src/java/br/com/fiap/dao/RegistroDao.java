/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fiap.dao;

import br.com.fiap.model.Registro;
import java.util.List;

/**
 *
 * @author fsantiago
 */
public interface RegistroDao {
    
    public void save(Registro registro);
    public Registro getRegistro(long id);
    public List<Registro> list();
    public void remove(Registro registro);
    public void update(Registro registro);
    
}
