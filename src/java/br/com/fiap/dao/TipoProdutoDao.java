/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fiap.dao;

import br.com.fiap.model.TipoProduto;
import java.util.List;

/**
 *
 * @author fsantiago
 */
public interface TipoProdutoDao {
    
    public void save(TipoProduto tipoProduto);
    public TipoProduto getTipoProduto(long id);
    public List<TipoProduto> list();
    public void remove(TipoProduto tipoProduto);
    public void update(TipoProduto tipoProduto);
    
}
