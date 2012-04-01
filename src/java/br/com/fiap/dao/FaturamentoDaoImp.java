/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fiap.dao;

import br.com.fiap.model.Atendimento;
import br.com.fiap.model.Faturamento;

import br.com.fiap.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author fsantiago
 */
public class FaturamentoDaoImp {

    public List<Atendimento> list() {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        t.commit();

        List atendimentos = session.createSQLQuery(
                "  SELECT a.idConvenio, c.descricaoConvenio, m.nomeMedico , sum(a.valorTratamento) as 'valorTratamento', "
                + "(SELECT IFNULL(sum(registro.precoTotal), 0) "
                + "  FROM registro , atendimento"
                + " WHERE registro.idAtendimento = atendimento.idAtendimento and atendimento.idConvenio = a.idConvenio"
                + " and atendimento.idMedico = m.idMedico"
                +"  ) AS 'precoTotalMateriais'"
                + " FROM atendimento a, medico m, convenio c"
                + " where a.idMedico = m.idMedico and a.idConvenio = c.idConvenio"
                + " group by  a.idConvenio, c.descricaoConvenio, m.nomeMedico ").addEntity(Faturamento.class).list();

        return atendimentos;
    }
}
