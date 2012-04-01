/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.fiap.dao;

import br.com.fiap.model.Usuario;
import java.util.List;
/**
 *
 * @author fsantiago
 */
public interface UsuarioDao {
    public void save(Usuario usuario);
    public Usuario getUsuario(String user);
    public Usuario getUsuario(long id);
    public List<Usuario> list();
    public void remove(Usuario livro);
    public void update(Usuario livro);
}
