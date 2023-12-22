package br.com.thegroupgasa.domain.repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.thegroupgasa.domain.entity.Cliente;
import br.com.thegroupgasa.domain.entity.Pedido;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface Pedidos extends JpaRepository<Pedido, Integer>{
    List<Pedido> findByCliente(Cliente cliente);

    @Query("select p from Pedido p left join fetch p.itens where p.id = :id")
    Optional<Pedido> findByIdFetchItens(@Param("id") Integer id);
}
