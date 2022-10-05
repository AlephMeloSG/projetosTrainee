package br.com.sgsistemas.cadastro.cliente;

import br.com.sgsistemas.cadastro.cliente.service.ClienteService;
import br.com.sgsistemas.cadastro.cliente.service.EnderecoService;
import functions.Funcoes;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CadastroClienteApplication implements CommandLineRunner {
	private final EnderecoService enderecoService;
	private final ClienteService clienteService;

	public CadastroClienteApplication(EnderecoService enderecoService, ClienteService clienteService) {
		this.enderecoService = enderecoService;
		this.clienteService = clienteService;
	}

	public static void main(String[] args) {
		SpringApplication.run(CadastroClienteApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		boolean system = true;
		while (system) {
			System.out.println();
			System.out.println("CadastroCliente");
			System.out.println();
			System.out.println("1.Clientes");
			System.out.println("2.Enderecos");
			System.out.println("3.Sair");
			int acao = Funcoes.inputInt("Numero: ", 1, 3);
			System.out.println();
			switch (acao) {
				case 1: {
					System.out.println("Cliente");
					System.out.println();
					System.out.println("1.salvar");
					System.out.println("2.atualizar");
					System.out.println("3.deletar");
					System.out.println("4.deletar Todos");
					System.out.println("5.visualizar");
					System.out.println("6.Voltar");
					acao = Funcoes.inputInt("Numero: ", 1, 6);
					switch (acao) {
						case 1: {
							clienteService.salvar();
							break;
						}
						case 2: {
							clienteService.atualizar();
							break;
						}
						case 3: {
							clienteService.deletar();
							break;
						}
						case 4: {
							clienteService.deletarTodos();
							break;
						}
						case 5: {
							clienteService.visualizar();
							break;
						}
					}
					break;
				} case 2: {
					System.out.println("Endereco");
					System.out.println();
					System.out.println("1.salvar");
					System.out.println("2.atualizar");
					System.out.println("3.deletar");
					System.out.println("4.deletar Todos");
					System.out.println("5.visualizar");
					System.out.println("6.Voltar");
					acao = Funcoes.inputInt("Numero: ", 1, 6);
					switch (acao) {
						case 1: {
							enderecoService.salvar();
							break;
						}
						case 2: {
							enderecoService.atualizar();
							break;
						}
						case 3: {
							enderecoService.deletar();
							break;
						}
						case 4: {
							enderecoService.deletarTodos();
							break;
						}
						case 5: {
							enderecoService.visualizar();
							break;
						}
					}
					break;
				}
				case 3:{
					system = false;
					break;
				}
			}
		}
	}
}
