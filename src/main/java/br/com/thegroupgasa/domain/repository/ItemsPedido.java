package br.com.thegroupgasa.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.thegroupgasa.domain.entity.ItemPedido;

public interface ItemsPedido extends JpaRepository<ItemPedido, Integer> {
    
}
