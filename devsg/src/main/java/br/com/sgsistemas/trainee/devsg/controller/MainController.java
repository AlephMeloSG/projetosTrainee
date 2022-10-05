package br.com.sgsistemas.trainee.devsg.controller;

import functions.Funcoes;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

    @ResponseBody
    @RequestMapping("/")
    public String Help(){
        String help = "TELA INICIAL \n\n" +
                "URLS: \n" +
                "/equipes \n" +
                "/pessoas \n" +
                "/linguagens \n" +
                "/produtos" +
                "Acoes:" +
                "/Nome -> Ver a informacao \n" +
                "/removeById={NUMERO} -> Deletar a informacao \n" +
                "__________\n" +
                "Para atualizar e criar é preciso fazer atualmente algo semelhante no postman \n" +
                "Usando o Modo Post para criar/Adicionar e Put para atualizar, citanto que tipo de formato é a informacao passada (Json/Xml)\n" +
                "__________\n";

        return Funcoes.breaklineToBr(help);
    }

}
