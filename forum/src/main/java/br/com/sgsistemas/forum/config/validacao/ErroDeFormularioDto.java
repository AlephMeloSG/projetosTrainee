package br.com.sgsistemas.forum.config.validacao;

public class ErroDeFormularioDto {
    private String campo;
    private String erro;
    public ErroDeFormularioDto(String field, String message) {
        campo = field;
        erro = message;
    }

    public String getCampo() {
        return campo;
    }
    public void setCampo(String campo) {
        this.campo = campo;
    }
    public String getErro() {
        return erro;
    }
    public void setErro(String erro) {
        this.erro = erro;
    }
}
