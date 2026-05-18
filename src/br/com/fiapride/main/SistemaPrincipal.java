package br.com.fiapride.main;

import java.util.ArrayList;
import java.util.List;

import br.com.fiapride.model.Carro;
import br.com.fiapride.model.Moto;
import br.com.fiapride.model.Passageiro;
import br.com.fiapride.model.Veiculo;
import br.com.fiapride.model.Viagem;

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

        System.out.println("--- Teste de Heranca na Frota ---");
        Carro meuCarro = new Carro("ABC-1234", "Toyota Corolla", 4);
        Moto motoEletrica = new Moto("MOT-2026", "Voltz EVS", true);

        System.out.println("Carro: " + meuCarro.getModelo() + " | Placa: " + meuCarro.getPlaca()
                + " | Capacidade: " + meuCarro.getCapacidadePassageiros() + " passageiros");
        System.out.println("Moto: " + motoEletrica.getModelo() + " | Placa: " + motoEletrica.getPlaca());

        if (motoEletrica.isEletrica()) {
            System.out.println("A moto eletrica esta disponivel para viagens sustentaveis.");
        }

        meuCarro.atualizarPlaca("XYZ-9876");
        meuCarro.atualizarPlaca("");

        System.out.println("--- Relatorio de Autonomia da Frota ---");
        List<Veiculo> frota = new ArrayList<>();
        frota.add(meuCarro);
        frota.add(motoEletrica);

        for (Veiculo veiculo : frota) {
            veiculo.abastecer(50);
            veiculo.exibirTipo();
            System.out.println("Veiculo: " + veiculo.getModelo());
            System.out.println(veiculo.calcularAutonomia());
        }

        // A linha abaixo nao compila porque Veiculo agora e uma classe abstrata.
        // Veiculo veiculoGenerico = new Veiculo("GEN-0000", "Generico");

        System.out.println("--- Associacao entre Objetos ---");
        Viagem viagemDaAna = new Viagem("Avenida Paulista, 1000", passageiro1, meuCarro);
        viagemDaAna.definirValor(25.0);
        viagemDaAna.exibirResumo();

        System.out.println("Saldo consultado pela viagem antes da nova recarga: R$"
                + viagemDaAna.getSolicitante().getSaldo());
        passageiro1.adicionarSaldo(15.0);
        System.out.println("Saldo consultado pela viagem depois da nova recarga: R$"
                + viagemDaAna.getSolicitante().getSaldo());
    }
}
