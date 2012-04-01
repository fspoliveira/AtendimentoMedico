/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fiap.dao;

import br.com.fiap.model.Atendimento;
import java.util.List;

/**
 *
 * @author fsantiago
 */

public interface AtendimentoDao {
    public void save(Atendimento atendimento);
    public Atendimento getAtendimento(long id);
    public List<Atendimento> list();
    public void remove(Atendimento atendimento);
    public void update(Atendimento atendimento);
}
