package br.com.thegroupgasa;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

import br.com.thegroupgasa.domain.entity.Cliente;
import br.com.thegroupgasa.domain.entity.Pedido;
import br.com.thegroupgasa.domain.repository.Clientes;
import br.com.thegroupgasa.domain.repository.Pedidos;

@SpringBootApplication
@RestController
public class Main {

    @Bean
    public CommandLineRunner init(
            @Autowired Pedidos pedidos,
            @Autowired Clientes clientes){
        return args -> {

            System.out.println("Salvando clientes");
            Cliente fulano = new Cliente("fulano");
            clientes.save(fulano);

            Pedido pedido = new Pedido();
            pedido.setCliente(fulano);
            pedido.setDataPedido(LocalDate.now());
            pedido.setTotal(BigDecimal.valueOf(100));
            pedidos.save(pedido);

            // Cliente cliente = clientes.findClienteFetchPedidos(fulano.getId());
            // System.out.println(cliente);
            // System.out.println(cliente.getPedidos());

            pedidos.findByCliente(fulano).forEach(System.out::println);
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}