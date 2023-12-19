package br.com.thegroupgasa.rest.controller;

import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.thegroupgasa.domain.entity.Cliente;
import br.com.thegroupgasa.domain.repository.Clientes;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
    
    private Clientes clienteRepository;

    public ClienteController(Clientes clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @GetMapping
    public List<Cliente> findCliente(Cliente filter) {
        ExampleMatcher matcher = ExampleMatcher
                                .matching()
                                .withIgnoreCase()
                                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        Example example = Example.of(filter, matcher);
        return clienteRepository.findAll(example);
    }
    

    @GetMapping("/{id}")
    public Cliente getClienteById( @PathVariable("id") Integer id) {
       return clienteRepository
            .findById(id)
            .orElseThrow(() -> 
                    new ResponseStatusException(
                                                HttpStatus.NOT_FOUND,
                                                "Cliente não encontrado"
                                            ));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente postCliente(@RequestBody Cliente cliente) {
        Cliente clienteNovo = clienteRepository.save(cliente);
        return clienteNovo;
    }

    @DeleteMapping("/{id}")
    public void deleteCliente(@PathVariable Integer id) {
        clienteRepository.findById(id)
                .map(clienteExistente -> {
                    clienteRepository.delete(clienteExistente);
                    return new ResponseStatusException(
                                                HttpStatus.OK, 
                                                "Cliente excluido com sucesso"
                                            );
                })
                .orElseThrow(() -> new ResponseStatusException(
                                                HttpStatus.NOT_FOUND, 
                                                "Cliente não encontrado"
                                            ));
    }

    @PutMapping("/{id}")
    public void putCliente(@PathVariable Integer id,
                                        @RequestBody Cliente cliente) {
        clienteRepository.findById(id)
            .map( clienteExistente -> {
                cliente.setId(clienteExistente.getId());
                clienteRepository.save(cliente);
                return ResponseEntity.ok(cliente);
            }).orElseThrow(() -> new ResponseStatusException(
                                                HttpStatus.NOT_FOUND, 
                                                "Cliente não encontrado"
                                            ));
    }
}

