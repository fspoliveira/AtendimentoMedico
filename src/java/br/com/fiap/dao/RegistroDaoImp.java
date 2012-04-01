/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fiap.dao;


import br.com.fiap.model.Registro;
import br.com.fiap.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;


/**
 *
 * @author fsantiago
 */

public class RegistroDaoImp implements RegistroDao{
    
    @Override
    public void save(Registro registro) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.save(registro);
        t.commit();
    }
    
    @Override
    public Registro getRegistro(long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        return (Registro) session.load(Registro.class, id);
    }
    
    @Override
    public List<Registro> list() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        List lista = session.createQuery("from Registro").list();
        t.commit();
        return lista;
    }
    
    @Override
    public void remove(Registro registro) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.delete(registro);
        t.commit();
    }
    
    @Override
    public void update(Registro registro) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.update(registro);
        t.commit();
    }

    
}
