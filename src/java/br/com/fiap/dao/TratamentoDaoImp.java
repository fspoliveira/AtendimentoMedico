/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fiap.dao;

import br.com.fiap.model.Convenio;
import br.com.fiap.model.Especialidade;
import br.com.fiap.model.Tratamento;
import br.com.fiap.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;


/**
 *
 * @author fsantiago
 */

public class TratamentoDaoImp implements TratamentoDao {
     @Override
    public void save(Tratamento tratamento) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = session.beginTransaction();
        session.save(tratamento);
        t.commit();
    }
    
    @Override
    public Tratamento getTratamento(long id) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        return (Tratamento) session.load(Tratamento.class, id);
    }
    
    @Override
    public List<Tratamento> list() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = session.beginTransaction();
        List lista = session.createQuery("from Tratamento").list();
        t.commit();
        return lista;
    }
    
     @Override
    public List<Tratamento> listTratamentos(Convenio conv, Especialidade esp) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = session.beginTransaction();
        List lista = session.createQuery("from Tratamento where idEspecialidade= "  + conv.getId() + 
                 " and idConvenio= " + esp.getId() ).list(); 
        t.commit();
        return lista;
    }
    
    @Override
    public void remove(Tratamento tratamento) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = session.beginTransaction();
        session.delete(tratamento);
        t.commit();
    }
    
    @Override
    public void update(Tratamento tratamento) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = session.beginTransaction();
        session.update(tratamento);
        t.commit();
    }

    @Override
    public Tratamento getTratamento(Tratamento tratamento) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = session.beginTransaction();
        Tratamento trat = (Tratamento) session.createQuery("from Tratamento where idTratamento = " + "'" + tratamento.getIdTratamento() + "'").uniqueResult();
        t.commit();
        return trat;
    }

}