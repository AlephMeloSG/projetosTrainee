public class ImpostoRenda {

    private Contribuinte contribuinte;
    double parcela = 0.0;
    double aliquotaAplicada = 0.0;
    double deducaoAplicada = 0.0;
    double baseCalculo = 0.0;
    double valorImpostoPagar = 0.0;

    public void calcular(){
        if (contribuinte.salario <= 1903.98) {
            parcela = 0.0;
            aliquotaAplicada = 0.0;
        } else if (contribuinte.salario <= 2826.65) {
            parcela = 142.8;
            aliquotaAplicada = 7.5;
        } else if (contribuinte.salario <= 3751.05) {
            parcela = 354.8;
            aliquotaAplicada = 15.0;
        } else if (contribuinte.salario <= 4664.68) {
            parcela = 636.13;
            aliquotaAplicada = 22.5;
        } else {
            parcela = 869.36;
            aliquotaAplicada = 27.5;
        }
        deducaoAplicada = parcela * 13;
        baseCalculo = (contribuinte.salario * 13) - deducaoAplicada;
        valorImpostoPagar = baseCalculo * (aliquotaAplicada / 100);
    }
    @Override
    public String toString() {
        String resultado = String.format(
                "Contribuinte: %s" +
                "\nCPF: %s " +
                "\nData De Nascimento: %s" +
                "\nSalario: %s R$" +
                "\nAliquota Aplicada: %.2f" +
                "\nDedução aplicada: %.2f R$" +
                "\nBase Calculo: %.2f R$" +
                "\nValor Imposto a pagar: %.2f R$",
                contribuinte.nome,
                contribuinte.cpf,
                contribuinte.dataNascimento,
                contribuinte.salario,
                aliquotaAplicada,
                deducaoAplicada,
                baseCalculo,
                valorImpostoPagar);

        return resultado;

    }

    public ImpostoRenda(Contribuinte contribuinte) {
        this.contribuinte = contribuinte;
    }
}
