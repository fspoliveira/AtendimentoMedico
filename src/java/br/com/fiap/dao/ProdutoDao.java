/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fiap.dao;

import br.com.fiap.model.Produto;
import java.util.List;

/**
 *
 * @author fsantiago
 */
public interface ProdutoDao {
    
    public void save(Produto produto);
    public Produto getProduto(long id);
    public List<Produto> list();
    public void remove(Produto produto);
    public void update(Produto produto);
    public Produto getProduto(Produto produto);
}