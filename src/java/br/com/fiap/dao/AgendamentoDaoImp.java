/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fiap.dao;

import br.com.fiap.model.Agendamento;
import br.com.fiap.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author fsantiago
 */
public class AgendamentoDaoImp implements AgendamentoDao {
    
    @Override
    public void save(Agendamento agendamento) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = session.beginTransaction();
        session.save(agendamento);
        t.commit();
    }
    
    @Override
    public Agendamento getAgendamento(long id) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        return (Agendamento) session.load(Agendamento.class, id);
    }
    
    @Override
    public List<Agendamento> list() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = session.beginTransaction();
        List lista = session.createQuery("from Agendamento").list();
        t.commit();
        return lista;
    }
    
    @Override
    public void remove(Agendamento agendamento) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = session.beginTransaction();
        session.delete(agendamento);
        t.commit();
    }
    
    @Override
    public void update(Agendamento agendamento) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = session.beginTransaction();
        session.update(agendamento);
        t.commit();
    }
}
