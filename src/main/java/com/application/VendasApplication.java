package com.application;

import com.application.domain.dao.ClienteDao;
import com.application.domain.entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
public class VendasApplication {

    @Autowired
    private ClienteDao clienteDao;

    @Bean
    public CommandLineRunner init() {
        return args -> {
            clienteDao.salvar(new Cliente("Jefferson"));
            clienteDao.salvar(new Cliente("Outro Jefferson"));

            List<Cliente> clientes = clienteDao.obterTodos();

            clientes.forEach(System.out::println);
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(VendasApplication.class, args);
    }
}
