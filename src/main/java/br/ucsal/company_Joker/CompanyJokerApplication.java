package br.ucsal.company_Joker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class CompanyJokerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CompanyJokerApplication.class, args);
	}
	
	@GetMapping("/")
	public String index() {
		return "Vamos começar não é meus coleguinhas???";
	}
}
