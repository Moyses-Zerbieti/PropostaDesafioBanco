package service;
import java.util.List;
import java.util.Map;

import model.Banco;
import model.Cliente;
import model.Conta;

public class Relatorio {
    public static void imprimirExtratosPorCliente(Banco banco) {
        System.out.println("---------- ZERBIETI'S BANK ----------\n");
        for (Map.Entry<Cliente, List<Conta>> entry : banco.getContasPorCliente().entrySet()) {
            for (Conta conta : entry.getValue()) {
                conta.imprimirExtrato();
                System.out.println();
            }
            System.out.println("------------------------------\n");
        }
    }
}

