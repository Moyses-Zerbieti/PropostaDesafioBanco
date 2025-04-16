package model;
public class ContaSalario  extends Conta{

    private String profissao;

    public ContaSalario(Cliente cliente, String profissão) {
        super(cliente);
        this.profissao = profissão;
    }

    public String getProfissao() {
        return profissao;
    }
    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("=== Extrato Conta Salário === ");
        super.imprimirInfosComuns();
        System.out.println(String.format("Profissão do titular: %s", this.profissao));
    }
}