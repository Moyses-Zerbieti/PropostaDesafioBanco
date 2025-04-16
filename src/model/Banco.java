package model;
 
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Banco {

    private List <Conta> contas;
    private String nome;
    private Set <Cliente> clientes = new HashSet<>(); 

    public Banco(String nome, List<Conta> contas){
        this.nome = nome;
        this.contas = contas;
    }

    public void adicionarCliente(Cliente cliente){
        clientes.add(cliente);
    }

    public int totalClientes(){
        Set <Cliente> clientesUnicos = new HashSet<>();
        for (Conta conta : contas){
        clientesUnicos.add(conta.cliente);
    }
        return clientesUnicos.size();
    }

    public Map<Cliente, List<Conta>> getContasPorCliente(){
        Map<Cliente, List<Conta>> contasPorCliente = new HashMap<>();
            for (Conta conta : contas){
                contasPorCliente.computeIfAbsent(conta.getCliente(),k -> new ArrayList<>()).add(conta);
            }
        return contasPorCliente;
    }
        
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(Set<Cliente> clientes) {
        this.clientes = clientes;
    }

    public List<Conta> getContas() {
        return contas;
    }

    public void setContas(List<Conta> contas) {
        this.contas = contas;
    }

    
}
