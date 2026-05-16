package br.com.fiapride.model;

public class Passageiro {
    private String nome;
    private String cpf;
    private double saldo;

    public Passageiro(String nome, String cpf) {
        setNome(nome);
        setCpf(cpf);
        setSaldo(0);
    }

    public String getNome() {
        return nome;
    }

    private void setNome(String nome) {
        if (nome == null || nome.isBlank()) {
            System.out.println("Erro: o nome do passageiro deve ser informado.");
            this.nome = "Nome nao informado";
            return;
        }

        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    private void setCpf(String cpf) {
        if (cpf == null || cpf.isBlank()) {
            System.out.println("Erro: o CPF do passageiro deve ser informado.");
            this.cpf = "CPF nao informado";
            return;
        }

        this.cpf = cpf;
    }

    public double getSaldo() {
        return saldo;
    }

    private void setSaldo(double valor) {
        if (valor < 0) {
            System.out.println("Erro de seguranca: tentativa de definir saldo negativo bloqueada.");
            return;
        }

        saldo = valor;
    }

    public boolean adicionarSaldo(double valor) {
        if (valor <= 0) {
            System.out.println("Erro: o valor da recarga deve ser maior que zero.");
            return false;
        }

        setSaldo(saldo + valor);
        System.out.println("Recarga realizada para " + nome + ". Novo saldo: R$" + saldo);
        return true;
    }

    public boolean pagarViagem(double custo) {
        if (custo <= 0) {
            System.out.println("Erro: o custo da viagem deve ser maior que zero.");
            return false;
        }

        if (saldo < custo) {
            System.out.println("Erro: saldo insuficiente para " + nome + " realizar a viagem.");
            return false;
        }

        setSaldo(saldo - custo);
        System.out.println("Viagem paga por " + nome + ". Saldo restante: R$" + saldo);
        return true;
    }
}
