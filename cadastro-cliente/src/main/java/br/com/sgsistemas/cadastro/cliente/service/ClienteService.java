package br.com.sgsistemas.cadastro.cliente.service;

import br.com.sgsistemas.cadastro.cliente.modelo.Cliente;
import br.com.sgsistemas.cadastro.cliente.modelo.Endereco;
import br.com.sgsistemas.cadastro.cliente.projection.ClienteProjection;
import br.com.sgsistemas.cadastro.cliente.repository.ClienteRepository;
import br.com.sgsistemas.cadastro.cliente.repository.EnderecoRepository;
import functions.Funcoes;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    private final ClienteRepository clienteRepository;
    private final EnderecoRepository enderecoRepository;
    private Cliente cliente;

    public ClienteService(ClienteRepository clienteRepository, EnderecoRepository enderecoRepository) {
        this.clienteRepository = clienteRepository;
        this.enderecoRepository = enderecoRepository;
    }

    public void salvar(){
        String nome = Funcoes.inputStr("Nome: ");
        LocalDate dataNascimento = Funcoes.inputLocalDate("Data de Nascimento: ");
        int limite = Funcoes.inputInt("limite: ",0);
        List<Endereco> enderecos = enderecos();
        cliente = new Cliente(nome,dataNascimento,limite, enderecos);
        clienteRepository.save(cliente);
    }
    public void atualizar(){
        int id = Funcoes.inputInt("digite o id do cliente para atualizar: ");
        String nome = Funcoes.inputStr("Nome:");
        LocalDate dataNascimento = Funcoes.inputLocalDate("Data de Nascimento");
        int limite = Funcoes.inputInt("limite: ",0);
        List<Endereco> enderecos = enderecos();
        cliente = new Cliente(nome, dataNascimento, limite, enderecos);
        cliente.setId(id);
        clienteRepository.save(cliente);
    }
    public void deletar(){
        int id = Funcoes.inputInt("Digite o id do cliente para deletar: ");
        clienteRepository.deleteById(id);
    }
    public void deletarTodos(){
        String confirma = Funcoes.inputStr("Tem Certeza ao deletar todos? ");
        if (confirma.substring(0,1).toLowerCase().equals("s")) {
            clienteRepository.deleteAll();
        }
    }
    public void visualizar(){
        Pageable pageable = PageRequest.of(0,100, Sort.unsorted());
        Page<ClienteProjection> clientes = clienteRepository.findNomeDataNascimento(pageable);
        System.out.println("Clientes Total Pags: " + clientes.getTotalPages());
        System.out.println("digite 0 para sair!");
        int pagina = Funcoes.inputInt("Digite o numero da pagina desejada: ", 0, clientes.getTotalPages()) - 1;
        if(pagina != -1) {
            pageable = PageRequest.of(pagina, 100, Sort.unsorted());
            clientes = clienteRepository.findNomeDataNascimento(pageable);
            System.out.println();
            for (ClienteProjection cliente1 : clientes) {
                System.out.println("Nome: " + cliente1.getNome() + " Data de Nascimento: " + cliente1.getDataNascimento());
            }
        }

    }
    private List<Endereco> enderecos(){
        List<Endereco> enderecos = new ArrayList<>();
        EnderecoService enderecoService = new EnderecoService(enderecoRepository);
        boolean system = true;
        while (system) {
            System.out.println();
            System.out.println("Enderecos:");
            System.out.println("1.Adicionar");
            System.out.println("2.Remover");
            System.out.println("3.Lista Adicionados");
            System.out.println("4.Sair");
            int acao = Funcoes.inputInt("Acao/Numero: ",1,5);
            System.out.println();
            switch (acao){
                case 1:
                    String logradouro = Funcoes.inputStr("Logradouro: ");
                    String numero = Funcoes.inputStr("numero: ");
                    String bairro = Funcoes.inputStr("Bairro: ");
                    String cep = Funcoes.inputStr("cep: ",8, 9);
                    String cidade = Funcoes.inputStr("Cidade: ");
                    Endereco endereco1 = new Endereco(logradouro,numero,bairro,cep,cidade);
                    enderecos.add(endereco1);
                    break;
                case 2:
                    endereco1 = enderecos.get(Funcoes.inputInt("Digite a posicao do endereco: ",1,enderecos.size()) - 1);
                    enderecos.remove(endereco1);
                    break;
                case 3:
                    System.out.println("Enderecos Adicionados: ");
                    int count = 1;
                    for (Endereco endereco : enderecos) {
                        System.out.println(count + "." + endereco);
                        count += 1;
                    }
                    break;
                case 4:
                    system = false;
                    break;
            }
        }
        for (Endereco endereco : enderecos) {
            enderecoService.salvar(endereco);
        }
        return enderecos;
    }
}
