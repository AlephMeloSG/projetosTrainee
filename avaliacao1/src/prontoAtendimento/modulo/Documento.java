package prontoAtendimento.modulo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Documento {
    private int id;
    private Date dataNascimento;
    private String cpf;

    public Documento(Date dataNascimento, String cpf) {
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
