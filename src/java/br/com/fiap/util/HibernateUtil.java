/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fiap.util;

import br.com.fiap.model.Agendamento;
import br.com.fiap.model.Atendimento;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;
import br.com.fiap.model.Convenio;
import br.com.fiap.model.Especialidade;
import br.com.fiap.model.Faturamento;
import br.com.fiap.model.Medico;
import br.com.fiap.model.MedicoEspecialidade;
import br.com.fiap.model.Paciente;
import br.com.fiap.model.Produto;
import br.com.fiap.model.Registro;
import br.com.fiap.model.TipoProduto;
import br.com.fiap.model.Tratamento;
import br.com.fiap.model.Usuario;


/**
 *
 * @author fsantiago
 */
public class HibernateUtil {
    
    private static SessionFactory sessionFactory;

    private HibernateUtil() {
        
    }

    public static SessionFactory getSessionFactory() {

        if (sessionFactory == null) {
            try {
                
                AnnotationConfiguration ac = new AnnotationConfiguration();
                
                ac.addAnnotatedClass(Usuario.class);
                ac.addAnnotatedClass(Convenio.class);
                ac.addAnnotatedClass(Medico.class);
                ac.addAnnotatedClass(Especialidade.class);
                ac.addAnnotatedClass(Produto.class);
                ac.addAnnotatedClass(TipoProduto.class);
                ac.addAnnotatedClass(MedicoEspecialidade.class);
                ac.addAnnotatedClass(Paciente.class);
                ac.addAnnotatedClass(Tratamento.class);
                ac.addAnnotatedClass(Agendamento.class);
                ac.addAnnotatedClass(Atendimento.class);
                ac.addAnnotatedClass(Registro.class);
                ac.addAnnotatedClass(Faturamento.class);
                
                
                sessionFactory = ac.configure().buildSessionFactory();
                
            } catch (Throwable ex) {
                
                System.err.println("Initial SessionFactory creation failed." + ex);
                throw new ExceptionInInitializerError(ex);
            }

            return sessionFactory;

        } else {
            return sessionFactory;
        }
        
    }
}
