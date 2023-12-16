package br.com.thegroupgasa.domain.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id")
    private Integer Id;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "preco_unitario")
    private BigDecimal preco;

    public Integer getId() {
        return Id;
    }
    public void setId(Integer id) {
        this.Id = id;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String desccricao) {
        this.descricao = desccricao;
    }
    public BigDecimal getPreco() {
        return preco;
    }
    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }
}
