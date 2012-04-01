/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fiap.dao;

import br.com.fiap.model.Agendamento;
import java.util.List;

/**
 *
 * @author fsantiago
 */
public interface AgendamentoDao {
    
    public void save(Agendamento agendamento);
    public Agendamento getAgendamento(long id);
    public List<Agendamento> list();
    public void remove(Agendamento agendamento);
    public void update(Agendamento agendamento);
    
}
