package br.com.sgsistemas.spring.data;

import br.com.sgsistemas.spring.data.service.CargoService;
import br.com.sgsistemas.spring.data.service.FuncionarioService;
import br.com.sgsistemas.spring.data.service.UnidadeTrabalhoService;
import functions.Funcoes;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner {

	private final CargoService cargoService;
	private final FuncionarioService funcionarioService;
	private final UnidadeTrabalhoService unidadeTrabalhoService;

	private  boolean system = true;
	String logo = "\n" +
			"╔═══╗────╔╗─────╔╗────────╔╗────╔═╗\n" +
			"║╔═╗║────║║────╔╝╚╗───────║║────║╔╝\n" +
			"║║─╚╬══╦═╝╠══╦═╩╗╔╬═╦══╗╔═╝╠══╗╔╝╚╦╗╔╦═╗╔══╦╦══╦═╗╔══╦═╦╦══╗\n" +
			"║║─╔╣╔╗║╔╗║╔╗║══╣║║╔╣╔╗║║╔╗║║═╣╚╗╔╣║║║╔╗╣╔═╬╣╔╗║╔╗╣╔╗║╔╬╣╔╗║\n" +
			"║╚═╝║╔╗║╚╝║╔╗╠══║╚╣║║╚╝║║╚╝║║═╣─║║║╚╝║║║║╚═╣║╚╝║║║║╔╗║║║║╚╝║\n" +
			"╚═══╩╝╚╩══╩╝╚╩══╩═╩╝╚══╝╚══╩══╝─╚╝╚══╩╝╚╩══╩╩══╩╝╚╩╝╚╩╝╚╩══╝";


	public SpringDataApplication(CargoService cargoService, FuncionarioService funcionarioService, UnidadeTrabalhoService unidadeTrabalhoService) {
		this.cargoService = cargoService;
		this.funcionarioService = funcionarioService;
		this.unidadeTrabalhoService = unidadeTrabalhoService;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringDataApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		while(system){
			Funcoes.printTimes("\n",5);
			System.out.println(logo);
			System.out.println();
			System.out.println("Qual acao voce quer executar");
			System.out.println("1.Sair");
			System.out.println("2.Unidade de Trabalho");
			System.out.println("3.Cargo");
			System.out.println("4.Funcionario");
			System.out.println();

			int acao = Funcoes.inputInt("Digite o numero correspondente: ",1,4);
			System.out.println();
			switch (acao){
				case 1:{
					system = false;
					break;
				}
				case 2:{
					unidadeTrabalhoService.inicial();
				}
				case 3:{
					cargoService.inicial();
				}
				case 4:{
					funcionarioService.inicial();
				}
			}

		}
	}
}
