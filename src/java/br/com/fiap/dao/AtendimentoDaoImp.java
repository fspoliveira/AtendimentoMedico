/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fiap.dao;

import br.com.fiap.model.Atendimento;
import br.com.fiap.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author fsantiago
 */
public class AtendimentoDaoImp implements AtendimentoDao {
    
    @Override
    public void save(Atendimento atendimento) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = session.beginTransaction();
        session.save(atendimento);
        t.commit();
    }
    
    @Override
    public Atendimento getAtendimento(long id) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        return (Atendimento) session.load(Atendimento.class, id);
    }
    
    @Override
    public List<Atendimento> list() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = session.beginTransaction();
        List lista = session.createQuery("from Atendimento").list();
        t.commit();
        return lista;
    }
    
    @Override
    public void remove(Atendimento atendimento) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = session.beginTransaction();
        session.delete(atendimento);
        t.commit();
    }
    
    @Override
    public void update(Atendimento atendimento) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = session.beginTransaction();
        session.update(atendimento);
        t.commit();
    }
}
