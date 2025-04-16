package model;
import interfaces.IConta;


public abstract class Conta implements IConta{

    private static int AGENCIA_SEQUENCIAL = 0;

    private static int CONTA_SEQUENCIAL = 1;

    protected int agencia;
    protected int numConta;
    protected double saldo;
    protected Cliente cliente;


    public Conta(Cliente cliente){
    this.agencia = AGENCIA_SEQUENCIAL ++;
       this.numConta= CONTA_SEQUENCIAL++;
       this.cliente = cliente;
    }

    @Override
    public void sacar(double valor) {
        this.saldo = saldo - valor;
    }
    @Override
    public void depositar(double valor) {
        this.saldo = saldo + valor;
    }
    @Override
    public void transferir(double valor, Conta contaDestino) {
        this.sacar(valor);
        contaDestino.depositar(valor);
    }

    public int getAgencia() {
        return agencia;
    }
    public int getNumConta() {
        return numConta;
    }
    public double getSaldo() {
        return saldo;
    }

    public Cliente getCliente(){
        return cliente;
    }

    protected void imprimirInfosComuns() {
        System.out.println(String.format("Titular da conta: %s ", cliente.getNome()));
        System.out.println(String.format("RG do titular: %s ", cliente.getRg()));
        System.out.println(String.format("Agencia: %d" ,agencia));
        System.out.println(String.format("Conta: %d" , numConta));
        System.out.println(String.format("Saldo: %1f" , saldo));
    }
}
