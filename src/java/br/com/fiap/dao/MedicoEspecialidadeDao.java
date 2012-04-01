/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fiap.dao;

import br.com.fiap.model.MedicoEspecialidade;
import java.util.List;

/**
 *
 * @author fsantiago
 */
public interface MedicoEspecialidadeDao {
    
    public void save(MedicoEspecialidade medicoEspecialidade);
    public MedicoEspecialidade getMedicoEspecialidade(long id);
    public List<MedicoEspecialidade> list();
    public List<MedicoEspecialidade> findMedicos(long idEspecialidade);
    public void remove(MedicoEspecialidade medicoEspecialidade);
    public void update(MedicoEspecialidade medicoEspecialidade);
    public List<MedicoEspecialidade> findEspecialidades(long idMedico);
    
}
