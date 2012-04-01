/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fiap.util;

import br.com.fiap.dao.FaturamentoDaoImp;
import br.com.fiap.model.Atendimento;
import java.util.Collection;

/**
 *
 * @author fsantiago
 */
public class Teste {
    
    private static Collection<Atendimento> teste;
    public static void main(String args[]){
        
        FaturamentoDaoImp f = new FaturamentoDaoImp();
        teste = f.list();
        
    }
}
