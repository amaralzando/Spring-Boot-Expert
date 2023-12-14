package br.com.thegroupgasa.domain.entity;

public class Cliente {

    private Integer clienteId;

    private String nome;

    public Cliente() {
    }

    public Cliente(Integer id, String nome) {
        this.clienteId = id;
        this.nome = nome;
    }

    public Cliente(String nome) {
        this.nome = nome;
    }

    public Integer getClienteId() {
        return clienteId;
    }
    public void setClienteId(Integer id) {
        this.clienteId = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString(){
        return "Cliente {" +
                "id=" + clienteId +
                ", nome='" + nome + '\'' +
                '}';
    }

}
