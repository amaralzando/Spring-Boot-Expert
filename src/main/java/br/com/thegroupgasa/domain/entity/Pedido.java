package br.com.thegroupgasa.domain.entity;

import java.math.BigDecimal;

public class Pedido {
    
    private Integer pedidoId;
    private Cliente cliente;
    private Produto produto;
    private BigDecimal total;

    public Integer getPedidoId() {
        return pedidoId;
    }
    public void setPedidoId(Integer id) {
        this.pedidoId = id;
    }
    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public Produto getProduto() {
        return produto;
    }
    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    public BigDecimal getTotal() {
        return total;
    }
    public void setTotal(BigDecimal total) {
        this.total = total;
    }

}
