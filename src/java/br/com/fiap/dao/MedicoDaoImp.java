/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fiap.dao;

import br.com.fiap.model.Medico;
import br.com.fiap.model.Usuario;
import br.com.fiap.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author fsantiago
 */
public class MedicoDaoImp implements MedicoDao {
    
    @Override
    public void save(Medico medico) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = session.beginTransaction();
        session.save(medico);
        t.commit();
    }
    
    @Override
    public Medico getMedico(long id) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        return (Medico) session.load(Medico.class, id);
    }
    
    @Override
    public Medico getMedicoUserId(Usuario user) {
       Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = session.beginTransaction();
        Medico medico = (Medico) session.createQuery("from Medico where usuario= " + "'" + user.getLogin() + "'").uniqueResult();
        t.commit();
        return medico;
    }
    
    @Override
    public List<Medico> list() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = session.beginTransaction();
        List lista = session.createQuery("from Medico").list();
        t.commit();
        return lista;
    }
    
    @Override
    public void remove(Medico medico) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = session.beginTransaction();
        session.delete(medico);
        t.commit();
    }
    
    @Override
    public void update(Medico medico) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = session.beginTransaction();
        session.update(medico);
        t.commit();
    }
}