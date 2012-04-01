/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fiap.model;


import java.io.Serializable;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;


/**
 *
 * @author fsantiago
 */

@Entity
@Table(name = "produto")
public class Produto implements Serializable {
    
    @Id
    @GeneratedValue
    @Column(name = "idProduto")
    private long id;
    
    @Column(name = "descricaoProduto")
    private String descricao;
    
    @ManyToOne
    @JoinColumn(name="idTipoProduto")
    private TipoProduto tipoProduto;
    
    @OneToMany(mappedBy = "produto", cascade=CascadeType.ALL)
    private Collection<Registro> registros;
    
    private double precoUnitario;
    
    
    public Produto(){}

    public Produto(long id, String descricao, TipoProduto tipoProduto) {
        this.id = id;
        this.descricao = descricao;
        this.tipoProduto = tipoProduto;
    }
    
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public TipoProduto getTipoProduto() {
        return tipoProduto;
    }

    public void setTipoProduto(TipoProduto tipoProduto) {
        this.tipoProduto = tipoProduto;
    }

    public Collection<Registro> getRegistros() {
        return registros;
    }

    public void setRegistros(Collection<Registro> registros) {
        this.registros = registros;
    }

    public double getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(double precoUnitario) {
        this.precoUnitario = precoUnitario;
    }
    
}