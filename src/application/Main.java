package application;
import java.util.List;

import model.Banco;
import model.Cliente;
import model.Conta;
import model.ContaCorrente;
import model.ContaPoupanca;
import model.ContaSalario;
import service.Relatorio;

public class Main {
    public static void main(String[] args) {
        //Criando o primeiro cliente
        Cliente cliente1 = new Cliente();
        cliente1.setNome("João");
        cliente1.setRg(1234567890);

        Conta cc1 = new ContaCorrente(cliente1);
        Conta cp1 = new ContaPoupanca(cliente1);
        Conta cs1 = new ContaSalario(cliente1, "Engenheiro");

        //Criando o segundo cliente
        Cliente cliente2 = new Cliente();
        cliente2.setNome("José");
        cliente2.setRg(345678901);

        Conta cc2 = new ContaCorrente(cliente2);
        Conta cp2 = new ContaPoupanca(cliente2);
        Conta cs2 = new ContaSalario(cliente2, "Professor");


        //Fazendo uma lista de contas 
        List<Conta> contas = List.of(cc1,cp1,cs1,cc2,cp2,cs2);

        //Criando o banco e passando as contas 
        Banco banco = new Banco("Zerbieti's Bank", contas);

        //Realizando movimentações nas contas do Cliente 
        cc1.depositar(200);
        cs1.depositar(500);
        cc1.transferir(50, cp1);

        cc2.depositar(600);
        cc2.transferir(300, cp2);
        cp2.sacar(100);

        Relatorio.imprimirExtratosPorCliente(banco);

        System.out.println("Total de clientes cadastrados: " + banco.totalClientes());
        
    } 
}