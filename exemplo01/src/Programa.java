public class Programa {
    public static void main(String[] args) {
        Pessoa Pessoa1 = new Pessoa();

        Pessoa1.nome            = "Aleph";
        Pessoa1.endereco        = "Rua encarnação castilho";
        Pessoa1.complemento     = "Casa";
        Pessoa1.numero          = "18";
        Pessoa1.telefone        = "998616594";
        Pessoa1.idade           = 18;
        Pessoa1.idade2          = Pessoa1.idade;
        Pessoa1.Peso            = 97.5;
        Pessoa1.dataNascimento  = "11/08/2004";

        Pessoa Pessoa2 = new Pessoa();
        Pessoa2.nome            = "Jose";
        Pessoa2.endereco        = "Rua camargo";
        Pessoa2.complemento     = "Casa Jose";
        Pessoa2.numero          = "Jose09";
        Pessoa2.telefone        = "887232898";
        Pessoa2.idade           = 22;
        Pessoa2.Peso            = 75;
        Pessoa2.dataNascimento  = "20/04/1996";

        Pessoa Pessoa3 = new Pessoa();
        Pessoa3.nome            = "Maria";
        Pessoa3.endereco        = "Bairro Morangueira";
        Pessoa3.complemento     = "Casa";
        Pessoa3.numero          = "109";
        Pessoa3.telefone        = "456332898";
        Pessoa3.idade           = 10;
        Pessoa3.Peso            = 50;
        Pessoa3.dataNascimento  = "20/04/2016";

        Pessoa Pessoa4 = new Pessoa();
        Pessoa4.nome            = "Fernando";
        Pessoa4.endereco        = "Bairro Diamante";
        Pessoa4.complemento     = "Hotel";
        Pessoa4.numero          = "N109";
        Pessoa4.telefone        = "453423234";
        Pessoa4.idade           = 20;
        Pessoa4.Peso            = 67;
        Pessoa4.dataNascimento  = "20/04/2002";

        Pessoa Pessoa5 = new Pessoa();
        Pessoa5.nome            = "Lucas Pereira";
        Pessoa5.endereco        = "Rua Lavender Town";
        Pessoa5.complemento     = "Casa";
        Pessoa5.numero          = "2011";
        Pessoa5.telefone        = "4443534566";
        Pessoa5.idade           = 37;
        Pessoa5.Peso            = 50;
        Pessoa5.dataNascimento  = "20/04/1990";

        System.out.println(Pessoa1.FullInfo() + "\n" + Pessoa2.FullInfo() + "\n" + Pessoa3.FullInfo() + "\n" + Pessoa4.FullInfo() + "\n" + Pessoa5.FullInfo());
        System.out.println(Pessoa1.toString());
    }
}
