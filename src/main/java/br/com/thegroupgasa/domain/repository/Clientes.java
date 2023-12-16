package br.com.thegroupgasa.domain.repository;

import br.com.thegroupgasa.domain.entity.Cliente;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface Clientes extends JpaRepository<Cliente, Integer> {

    //@Query(value = " select * from cliente where nome like '%:nome%' ", nativeQuery = true)
    @Query(value = " select c from Cliente c where c.nome like :nome ")
    List<Cliente> encontrarPorNome( @Param("nome") String nome);
    // OU
    //List<Cliente> findByNomeLike(String nome);

    @Query(" delete from Cliente c where c.nome =:nome ")
    @Modifying // Colocar quando vai fazer um delete ou atualização no banco de dados.
    void deleteByNome(String nome);

    boolean existsByNome(String nome);

    @Query(" select c from Cliente c left join fetch c.pedidos where c.id = :id ")
    Cliente findClienteFetchPedidos( @Param("id") Integer id);

}
