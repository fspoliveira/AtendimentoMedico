/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fiap.dao;

import br.com.fiap.model.Convenio;
import br.com.fiap.model.Especialidade;
import br.com.fiap.model.Tratamento;
import java.util.List;

/**
 *
 * @author fsantiago
 */
public interface TratamentoDao {
    
    public void save(Tratamento tratamento);
    public Tratamento getTratamento(long id);
    public List<Tratamento> list();
    public List<Tratamento> listTratamentos(Convenio conv, Especialidade esp);
    public void remove(Tratamento tratamento);
    public void update(Tratamento tratamento);
    public Tratamento getTratamento(Tratamento tratamento);
    
}
