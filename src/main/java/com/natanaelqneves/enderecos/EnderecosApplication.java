package com.natanaelqneves.enderecos;

import com.natanaelqneves.enderecos.conexao.RetornaEndereco;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class EnderecosApplication {

	public static void main(String[] args) throws IOException, InterruptedException {
		SpringApplication.run(EnderecosApplication.class, args);
	}

}
