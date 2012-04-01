/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fiap.dao;

import br.com.fiap.model.Convenio;
import java.util.List;

/**
 *
 * @author fsantiago
 */
public interface ConvenioDao {
    
    public void save(Convenio convenio);
    public Convenio getConvenio(long id);
    public List<Convenio> list();
    public void remove(Convenio convenio);
    public void update(Convenio convenio);
    
}
