package br.com.fiapride.main;

import br.com.fiapride.model.Passageiro;

public class SistemaPrincipal {

    public static void main(String[] args) {
        Passageiro passageiro1 = new Passageiro();
        passageiro1.nome = "Ana Silva";

        Passageiro passageiro2 = new Passageiro();
        passageiro2.nome = "Carlos Souza";

        System.out.println("--- Recargas ---");
        passageiro1.adicionarSaldo(50.0);
        passageiro2.adicionarSaldo(12.50);
        passageiro2.adicionarSaldo(-10.0);

        System.out.println("--- Sistema FiapRide ---");
        System.out.println("Passageiro: " + passageiro1.nome + " | Saldo: R$" + passageiro1.saldo);
        System.out.println("Passageiro: " + passageiro2.nome + " | Saldo: R$" + passageiro2.saldo);

        System.out.println("--- Pagamentos de Viagem ---");
        passageiro1.pagarViagem(20.0);
        passageiro2.pagarViagem(20.0);
        passageiro1.pagarViagem(0.0);
    }
}
