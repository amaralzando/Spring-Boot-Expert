package br.com.thegroupgasa.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.thegroupgasa.domain.entity.Produto;

public interface Produtos extends JpaRepository<Produto, Integer>{
    
}
