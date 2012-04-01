/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fiap.dao;


import br.com.fiap.model.TipoProduto;
import br.com.fiap.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author fsantiago
 */
public class TipoProdutoDaoImp implements TipoProdutoDao {
    @Override
    public void save(TipoProduto tipoProduto) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = session.beginTransaction();
        session.save(tipoProduto);
        t.commit();
    }
    
    @Override
    public TipoProduto getTipoProduto(long id) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        return (TipoProduto) session.load(TipoProduto.class, id);
    }
    
    @Override
    public List<TipoProduto> list() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = session.beginTransaction();
        List lista = session.createQuery("from TipoProduto").list();
        t.commit();
        return lista;
    }
    
    @Override
    public void remove(TipoProduto tipoProduto) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = session.beginTransaction();
        session.delete(tipoProduto);
        t.commit();
    }
    
    @Override
    public void update(TipoProduto tipoProduto) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = session.beginTransaction();
        session.update(tipoProduto);
        t.commit();
    }
    
}
