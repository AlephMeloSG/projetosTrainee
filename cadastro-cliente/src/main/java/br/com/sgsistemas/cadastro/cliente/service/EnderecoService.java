package br.com.sgsistemas.cadastro.cliente.service;

import br.com.sgsistemas.cadastro.cliente.modelo.Endereco;
import br.com.sgsistemas.cadastro.cliente.projection.EnderecoProjection;
import br.com.sgsistemas.cadastro.cliente.repository.EnderecoRepository;
import functions.Funcoes;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class EnderecoService {
    private final EnderecoRepository enderecoRepository;
    private Endereco endereco;

    public EnderecoService(EnderecoRepository enderecoRepository) {
        this.enderecoRepository = enderecoRepository;
    }

    public Endereco salvar(){
        String logradouro = Funcoes.inputStr("Logradouro: ");
        String numero = Funcoes.inputStr("numero: ");
        String bairro = Funcoes.inputStr("Bairro: ");
        String cep = Funcoes.inputStr("cep: ",8, 9);
        String cidade = Funcoes.inputStr("Cidade: ");
        endereco = new Endereco(logradouro,numero,bairro,cep,cidade);
        enderecoRepository.save(endereco);
        return endereco;
    }
    public Endereco salvar(Endereco endereco){
        enderecoRepository.save(endereco);
        return endereco;
    }
    public Endereco atualizar(){
        int id = Funcoes.inputInt("Digite o id do endereco: ");
        String logradouro = Funcoes.inputStr("Logradouro: ");
        String numero = Funcoes.inputStr("numero: ");
        String bairro = Funcoes.inputStr("Bairro: ");
        String cep = Funcoes.inputStr("cep: ",8, 9);
        String cidade = Funcoes.inputStr("Cidade: ");
        endereco = new Endereco(logradouro,numero,bairro,cep,cidade);
        endereco.setId(id);
        enderecoRepository.save(endereco);
        return endereco;
    }
    public void deletar(Endereco endereco){
        int id = endereco.getId();
        enderecoRepository.deleteById(id);
    }
    public void deletar(){
        int id = Funcoes.inputInt("Id do endereco:");
        enderecoRepository.deleteById(id);
    }
    public void deletarTodos(){
        String confirma = Funcoes.inputStr("Tem Certeza ao deletar todos? ");
        if (confirma.substring(0,1).toLowerCase().equals("s")) {
            enderecoRepository.deleteAll();
        }
    }
    public void visualizar(){
        Pageable pageable = PageRequest.of(0,100, Sort.unsorted());
        Page<EnderecoProjection> enderecos = enderecoRepository.findEnderecos(pageable);
        int pagina = Funcoes.inputInt("Digite o numero da pagina desejada: ", 0, enderecos.getTotalPages()) - 1;
        if(pagina != -1) {
            pageable = PageRequest.of(pagina, 100, Sort.unsorted());
            enderecos = enderecoRepository.findEnderecos(pageable);
            System.out.println();
            for (EnderecoProjection endereco1 : enderecos) {
                System.out.println("Logradouro: " + endereco1.getLogradouro() + " cep: " + endereco1.getCep() + " Cidade: " + endereco1.getCidade());
            }
        }

    }
}
