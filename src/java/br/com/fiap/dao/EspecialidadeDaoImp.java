/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fiap.dao;

import br.com.fiap.model.Especialidade;
import br.com.fiap.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author fsantiago
 */
public class EspecialidadeDaoImp implements EspecialidadeDao {
    
    @Override
    public void save(Especialidade especialidade) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = session.beginTransaction();
        session.save(especialidade);
        t.commit();
    }
    
    @Override
    public Especialidade getEspecialidade(long id) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        return (Especialidade) session.load(Especialidade.class, id);
    }
    
    @Override
    public List<Especialidade> list() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = session.beginTransaction();
        List lista = session.createQuery("from Especialidade").list();
        t.commit();
        return lista;
    }
    
    @Override
    public void remove(Especialidade especialidade) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = session.beginTransaction();
        session.delete(especialidade);
        t.commit();
    }
    
    @Override
    public void update(Especialidade especialidade) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = session.beginTransaction();
        session.update(especialidade);
        t.commit();
    }
    
}