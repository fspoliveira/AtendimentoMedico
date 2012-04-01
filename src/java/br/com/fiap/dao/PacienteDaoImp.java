/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fiap.dao;

import br.com.fiap.model.Paciente;
import br.com.fiap.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author fsantiago
 */
public class PacienteDaoImp implements PacienteDao {
    
    @Override
    public void save(Paciente paciente) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = session.beginTransaction();
        session.save(paciente);
        t.commit();
    }
    
    @Override
    public Paciente getPaciente(long id) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        return (Paciente) session.load(Paciente.class, id);
    }
    
    @Override
    public List<Paciente> list() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = session.beginTransaction();
        List lista = session.createQuery("from Paciente").list();
        t.commit();
        return lista;
    }
    
    @Override
    public void remove(Paciente paciente) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = session.beginTransaction();
        session.delete(paciente);
        t.commit();
    }
    
    @Override
    public void update(Paciente paciente) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = session.beginTransaction();
        session.update(paciente);
        t.commit();
    }

    @Override
    public Paciente getPacienteId(Paciente paciente) {
       
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = session.beginTransaction();
        Paciente pac = (Paciente) session.createQuery("from Paciente where idPaciente = " + "'" + paciente.getId() + "'").uniqueResult();
        t.commit();
        return pac;
    }
}