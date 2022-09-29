package br.com.sgsistemas.java.trainee.modulo;

import functions.Funcoes;

import java.util.ArrayList;

public class NaturezaReceita {
    public NaturezaReceita(ArrayList<String> particao) {
        this.codigo = particao.get(0);
        this.descProd = particao.get(1);
        this.dtIni = particao.get(2);
        this.dtFim = particao.get(3);
        this.ncm = particao.get(4);
        this.ncmEx = particao.get(5);
        this.exIpi = particao.get(6);
        this.aliqPis = particao.get(7);
        this.aliqCofin = particao.get(8);

    }

    private String codigo;
    private String descProd;
    private String dtIni;
    private String dtFim;
    private String ncm;
    private String ncmEx;
    private String exIpi;
    private String aliqPis;
    private String aliqCofin;

    public String getCodigo() {
        return codigo;
    }

    public String getDescProd() {
        return descProd;
    }

    public String getDtIni() {
        return dtIni;
    }

    public String getDtFim() {
        return dtFim;
    }

    public String getNcm() {
        return ncm;
    }

    public String getNcmEx() {
        return ncmEx;
    }

    public String getExIpi() {
        return exIpi;
    }

    public String getAliqPis() {
        return aliqPis;
    }

    public String getAliqCofin() {
        return aliqCofin;
    }

    @Override
    public String toString() {
        return "codigo: " + this.getCodigo() + "\n" +
                "Descricao produto: " + this.getDescProd() + "\n" +
                "DT Inicial: " + Funcoes.stringDataFormat(this.getDtIni(), "dd/mm/yyyy") + "\n" +
                "DT Final: " + Funcoes.stringDataFormat(getDtFim(), "dd/mm/yyyy") + "\n" +
                "NCM: " + this.getNcm() + "\n" +
                "NCM EX: " + this.getNcmEx() + "\n" +
                "EX IPI: " + this.getExIpi() + "\n" +
                "Aliquota PIS: " + this.getAliqPis() + "\n" +
                "Aliquota Cofin: " + this.getAliqCofin() + "\n";

    }
}
