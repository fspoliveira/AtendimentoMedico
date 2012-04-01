/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fiap.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.OneToMany;

/**
 *
 * @author fsantiago
 */

@Entity
@Table(name = "tipoProduto")
public class TipoProduto implements Serializable {
    
    @Id
    @GeneratedValue
    @Column(name = "idTipoProduto")
    private long idTipoProduto;
    
    @Column(name = "descricaoTipoProduto")
    private String descricao;
    
    @OneToMany(mappedBy = "tipoProduto", cascade=CascadeType.ALL)
    private Collection<Produto> produtos;
    
    public TipoProduto(){}

    public TipoProduto(long idTipoProduto, String descricao, Collection<Produto> produtos) {
        this.idTipoProduto = idTipoProduto;
        this.descricao = descricao;
        this.produtos = produtos;
    }

    public long getIdTipoProduto() {
        return idTipoProduto;
    }

    public void setIdTipoProduto(long idTipoProduto) {
        this.idTipoProduto = idTipoProduto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Collection<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(Collection<Produto> produtos) {
        this.produtos = produtos;
    }

}