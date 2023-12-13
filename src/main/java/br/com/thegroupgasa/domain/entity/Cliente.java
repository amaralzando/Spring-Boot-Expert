package br.com.thegroupgasa.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GenerationType;

@Entity
@Table(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "clienteId")
    private Integer clienteId;

    @Column(name = "nome", length = 255)
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
