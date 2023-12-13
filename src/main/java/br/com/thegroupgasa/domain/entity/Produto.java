package br.com.thegroupgasa.domain.entity;

import java.math.BigDecimal;

public class Produto {
    private Integer produtoId;
    private String desccricao;
    private BigDecimal preco;

    public Integer getProdutoId() {
        return produtoId;
    }
    public void setProdutoId(Integer id) {
        this.produtoId = id;
    }
    public String getDesccricao() {
        return desccricao;
    }
    public void setDesccricao(String desccricao) {
        this.desccricao = desccricao;
    }
    public BigDecimal getPreco() {
        return preco;
    }
    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }
}
