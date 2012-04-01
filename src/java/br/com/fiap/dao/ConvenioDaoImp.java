/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fiap.dao;

import br.com.fiap.model.Convenio;
import br.com.fiap.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author fsantiago
 */
public class ConvenioDaoImp implements ConvenioDao {
    
    @Override
    public void save(Convenio convenio) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = session.beginTransaction();
        session.save(convenio);
        t.commit();
    }
    
    @Override
    public Convenio getConvenio(long id) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        return (Convenio) session.load(Convenio.class, id);
    }
    
    @Override
    public List<Convenio> list() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = session.beginTransaction();
        List lista = session.createQuery("from Convenio").list();
        t.commit();
        return lista;
    }
    
    @Override
    public void remove(Convenio convenio) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = session.beginTransaction();
        session.delete(convenio);
        t.commit();
    }
    
    @Override
    public void update(Convenio convenio) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = session.beginTransaction();
        session.update(convenio);
        t.commit();
    }

   }