package br.com.fiapride.model;

public class Passageiro {
    public String nome;
    public double saldo;

    public boolean adicionarSaldo(double valor) {
        if (valor <= 0) {
            System.out.println("Erro: o valor da recarga deve ser maior que zero.");
            return false;
        }

        saldo += valor;
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

        saldo -= custo;
        System.out.println("Viagem paga por " + nome + ". Saldo restante: R$" + saldo);
        return true;
    }
}
