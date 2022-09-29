package br.com.sgsistemas.trainee.buscaCep.view;

import br.com.sgsistemas.trainee.buscaCep.modelo.Dominio;
import br.com.sgsistemas.trainee.buscaCep.modelo.ListaDominios;
import com.thoughtworks.xstream.XStream;
import functions.Funcoes;
import org.apache.http.client.fluent.Request;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        Boolean auto = true;
        String cep = "";
        String resultadoBuscaJson = "";
        int minCep = 5;
        while (ListaDominios.getDominios().size() < minCep) {
            if (auto) {
                while (cep.length() < 8) {
                    int intCep = Funcoes.randomNumber(0, 9);
                    cep += Funcoes.intToString(intCep);
                }

            } else {
//                cep = Funcoes.inputStr("Digite um cep: ", 8, 8);
                cep = "01001000";
            }

            String typeFormat = "json";
            String url = "https://viacep.com.br/ws/" + cep + "/" + typeFormat + "/";

            resultadoBuscaJson = Request.Get(url).execute().returnContent().asString();

            if (Funcoes.contentSeparation(resultadoBuscaJson, ",").size() < 10) {
            } else {
                List<String> content = new ArrayList<>();
                ArrayList<String> linhas = Funcoes.contentSeparation(resultadoBuscaJson, "\n");
                for (String linha : linhas) {
                    if (Funcoes.contentSeparation(linha, "\"").size() > 3) {
                        content.add(Funcoes.contentSeparation(linha, "\"").get(3));
                    }
                }
                Dominio dominio = new Dominio(content.get(0), content.get(1), content.get(2),
                        content.get(3), content.get(4), content.get(5), content.get(6),
                        content.get(7), content.get(8), content.get(9));

                ListaDominios.adicionaDominio(dominio);
            }
            cep = "";
        }
        XStream xStream = new XStream();
        xStream.alias("dominio", Dominio.class);
        String xml = xStream.toXML(ListaDominios.getDominios());
        System.out.println(xml);
        System.out.println();
        System.out.println("Enexistentes: ");
        System.out.println(ListaDominios.getCepInvalidos());
    }
}