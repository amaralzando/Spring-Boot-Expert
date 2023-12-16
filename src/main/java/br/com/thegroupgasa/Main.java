package br.com.thegroupgasa;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

import br.com.thegroupgasa.domain.entity.Cliente;
import br.com.thegroupgasa.domain.repository.Clientes;

@SpringBootApplication
@RestController
public class Main {

    @Bean
    public CommandLineRunner init(@Autowired Clientes clientes){
        return args -> {

            System.out.println("Salvando clientes");
            clientes.save(new Cliente("Gabriel Amaral"));
            clientes.save(new Cliente("Jeferson"));

            boolean existNome = clientes.existsByNome("Gabriel Amaral");
            System.out.println("Existe um cliente com o nome Gabriel Amaral? " + existNome);

            List<Cliente> result = clientes.encontrarPorNome("Gabriel Amaral");
            result.forEach(System.out::println);
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}