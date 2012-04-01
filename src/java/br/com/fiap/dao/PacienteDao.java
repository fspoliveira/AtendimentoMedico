/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fiap.dao;

import br.com.fiap.model.Paciente;
import java.util.List;

/**
 *
 * @author fsantiago
 */
public interface PacienteDao {
    
    public void save(Paciente paciente);
    public Paciente getPaciente(long id);
    public List<Paciente> list();
    public void remove(Paciente paciente);
    public void update(Paciente paciente);
    public Paciente getPacienteId(Paciente paciente);
    
}
