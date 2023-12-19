package br.com.thegroupgasa.rest.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.thegroupgasa.domain.entity.Produto;
import br.com.thegroupgasa.domain.repository.Produtos;

import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    public Produtos produtoRepository;

    public ProdutoController(Produtos produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @GetMapping
    public List<Produto> findPorduto(Produto filter) {
        ExampleMatcher matcher = ExampleMatcher
                                .matching()
                                .withIgnoreCase()
                                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        Example example = Example.of(filter, matcher);
        return produtoRepository.findAll(example);
    }

    @GetMapping("/{id}")
    public Produto getProdutoById( @PathVariable("id") Integer id) {
       return produtoRepository
            .findById(id)
            .orElseThrow(() -> 
                    new ResponseStatusException(
                                                HttpStatus.NOT_FOUND,
                                                "Cliente não encontrado"
                                            ));
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public Produto postProduto(@RequestBody Produto produto) {
        Produto produtoNovo = produtoRepository.save(produto);
        return produtoNovo;

    }

    @DeleteMapping("/{id}")
    public void deleteProduto(@PathVariable Integer id) {
        produtoRepository.findById(id)
                .map(produtoExistente -> {
                    produtoRepository.delete(produtoExistente);
                    return new ResponseStatusException(
                                                HttpStatus.OK, 
                                                "Produto excluido com sucesso"
                                            );
                })
                .orElseThrow(() -> new ResponseStatusException(
                                                HttpStatus.NOT_FOUND, 
                                                "Cliente não encontrado"
                                            ));
    }

    @PutMapping("/{id}")
    public void putProduto(@PathVariable Integer id,
                                        @RequestBody Produto produto) {
        produtoRepository
            .findById(id)
            .map( produtoExistente -> {
                produto.setId(produtoExistente.getId());
                produtoRepository.save(produto);
                return ResponseEntity.ok(produto);
            }).orElseThrow(() -> new ResponseStatusException(
                                                HttpStatus.NOT_FOUND, 
                                                "Cliente não encontrado"
                                            ));
    }
    
    
}
