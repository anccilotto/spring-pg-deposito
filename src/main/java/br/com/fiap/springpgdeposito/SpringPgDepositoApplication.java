package br.com.fiap.springpgdeposito;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
public class SpringPgDepositoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringPgDepositoApplication.class, args);
    }
    @GetMapping(value = "/")
    public String index() {
        String hello = """
                Sitema de Deposito 
                """;
        return hello;
    }

}
