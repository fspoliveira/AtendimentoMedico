/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fiap.dao;

import br.com.fiap.model.Especialidade;
import br.com.fiap.model.Medico;
import br.com.fiap.model.MedicoEspecialidade;
import br.com.fiap.util.HibernateUtil;
import java.util.List;
import org.hibernate.Transaction;
import org.hibernate.criterion.Expression;
import org.hibernate.Session;

/**
 *
 * @author fsantiago
 */
public class MedicoEspecialidadeDaoImp implements MedicoEspecialidadeDao {

    @Override
    public void save(MedicoEspecialidade medicoEspecialidade) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.save(medicoEspecialidade);
        t.commit();
    }

    @Override
    public MedicoEspecialidade getMedicoEspecialidade(long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        return (MedicoEspecialidade) session.load(MedicoEspecialidade.class, id);
    }

    @Override
    public List<MedicoEspecialidade> list() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        List lista = session.createQuery("from MedicoEspecialidade").list();
        t.commit();
        return lista;
    }

    //API Criteria
    @Override    
    public List<MedicoEspecialidade> findMedicos(long idEspecialidade) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        MedicoEspecialidade medicoEsp = new MedicoEspecialidade();
        Especialidade esp = new Especialidade();
        
        esp.setId(idEspecialidade);
        medicoEsp.setIdEspecialidade(esp);        
      
        List results = session.createCriteria(MedicoEspecialidade.class)
                .add(Expression.eq("idEspecialidade", medicoEsp.getIdEspecialidade())).list();
        session.getTransaction().commit();
        
        return results;

    }
    
    //API Criteria
    @Override    
    public List<MedicoEspecialidade> findEspecialidades(long idMedico) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        MedicoEspecialidade medicoEsp = new MedicoEspecialidade();
        Medico med = new Medico();
        
        med.setId(idMedico);
        medicoEsp.setIdMedico(med);       
      
        List results = session.createCriteria(MedicoEspecialidade.class)
                .add(Expression.eq("idMedico", medicoEsp.getIdMedico())).list();
        session.getTransaction().commit();
        
        return results;

    }

    @Override
    public void remove(MedicoEspecialidade medicoEspecialidade) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.delete(medicoEspecialidade);
        t.commit();
    }

    @Override
    public void update(MedicoEspecialidade medicoEspecialidade) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.update(medicoEspecialidade);
        t.commit();
    }
}