package br.com.thegroupgasa.domain.entity;

public class ItemPedido {
    
    private Integer itemPedidoId;
    private Pedido pedido;
    private Produto produto;
    private Integer quantidade;

    public Integer getItemPedidoId() {
        return itemPedidoId;
    }
    public void setItemPedidoId(Integer id) {
        this.itemPedidoId = id;
    }
    public Pedido getPedido() {
        return pedido;
    }
    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
    public Produto getProduto() {
        return produto;
    }
    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    public Integer getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
    
}
