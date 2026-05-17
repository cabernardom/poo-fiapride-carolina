package br.com.fiapride.main;

import br.com.fiapride.model.Passageiro;
import br.com.fiapride.model.Veiculo;

public class SistemaPrincipal {

    public static void main(String[] args) {
        System.out.println("--- Iniciando o Sistema FiapRide ---");

        Passageiro passageiro1 = new Passageiro("Ana Silva", "222.222.222-22");
        Passageiro passageiro2 = new Passageiro("Carlos Souza", "333.333.333-33");

        System.out.println("--- Recargas ---");
        passageiro1.adicionarSaldo(50.0);
        passageiro2.adicionarSaldo(12.50);
        passageiro2.adicionarSaldo(-10.0);

        System.out.println("--- Sistema FiapRide ---");
        System.out.println("Passageiro: " + passageiro1.getNome() + " | Saldo: R$" + passageiro1.getSaldo()
                + " | CPF: " + passageiro1.getCpf());
        System.out.println("Passageiro: " + passageiro2.getNome() + " | Saldo: R$" + passageiro2.getSaldo()
                + " | CPF: " + passageiro2.getCpf());

        System.out.println("--- Pagamentos de Viagem ---");
        passageiro1.pagarViagem(20.0);
        passageiro2.pagarViagem(20.0);
        passageiro1.pagarViagem(0.0);

        // A linha abaixo nao compila porque saldo agora e private.
        // passageiro1.saldo = 999999.0;

        System.out.println("--- Cadastro de Veiculos ---");
        Veiculo meuCarro = new Veiculo("ABC-1234", "Toyota Corolla");
        Veiculo veiculoPendente = new Veiculo();

        System.out.println("Veiculo: " + meuCarro.getModelo() + " | Placa: " + meuCarro.getPlaca());
        meuCarro.atualizarPlaca("XYZ-9876");
        meuCarro.atualizarPlaca("");

        System.out.println("Veiculo pendente: " + veiculoPendente.getModelo() + " | Placa: "
                + veiculoPendente.getPlaca());
    }
}
