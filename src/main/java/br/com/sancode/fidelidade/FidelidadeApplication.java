package br.com.sancode.fidelidade;

import br.com.sancode.fidelidade.model.Cliente;
import br.com.sancode.fidelidade.service.ClienteService;
import br.com.sancode.fidelidade.service.ClienteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class FidelidadeApplication {

    public static void main(String[] args) {

        BCryptPasswordEncoder bp = new BCryptPasswordEncoder();
        SpringApplication.run(FidelidadeApplication.class, args);
        //Cliente cliente = new Cliente("Alexsander Wilen", "Avenida dos Excombatens", "69", "Laurindo de Castro", "Uba", "MG", "alexsander@sancode.com.br", bp.encode("123"));
        System.out.println(bp.encode("123"));
    }

}
