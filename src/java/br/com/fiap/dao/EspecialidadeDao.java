/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fiap.dao;

import br.com.fiap.model.Especialidade;
import java.util.List;

/**
 *
 * @author fsantiago
 */
public interface EspecialidadeDao {
    public void save(Especialidade especialidade);
    public Especialidade getEspecialidade(long id);
    public List<Especialidade> list();
    public void remove(Especialidade especialidade);
    public void update(Especialidade especialidade);
    
}
