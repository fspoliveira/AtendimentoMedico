/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fiap.dao;

import br.com.fiap.model.Usuario;
import br.com.fiap.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author fsantiago
 */
public class UsuarioDaoImp implements UsuarioDao{

    @Override
    public void save(Usuario usuario) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.save(usuario);
        t.commit();
    }

    @Override
    public Usuario getUsuario(String user){

        // Consulta HQL (Hibernate Query Language)
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Usuario usuario = (Usuario) session.createQuery("from Usuario where login = '" + user + "'").uniqueResult();
        session.getTransaction().commit();
        return usuario;
    }

    @Override
    public Usuario getUsuario(long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        return (Usuario) session.load(Usuario.class, id);
    }

    @Override
    public List<Usuario> list() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        List lista = session.createQuery("from Usuario").list();
        t.commit();
        return lista;
    }

    @Override
    public void remove(Usuario usuario) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.delete(usuario);
        t.commit();
    }

    @Override
    public void update(Usuario usuario) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.update(usuario);
        t.commit();
    }
}