package br.com.fiapride.model;

public class Carro extends Veiculo {
    private int capacidadePassageiros;

    public Carro(String placa, String modelo, int capacidadePassageiros) {
        super(placa, modelo);
        setCapacidadePassageiros(capacidadePassageiros);
    }

    public int getCapacidadePassageiros() {
        return this.capacidadePassageiros;
    }

    private void setCapacidadePassageiros(int capacidadePassageiros) {
        if (capacidadePassageiros <= 0) {
            System.out.println("Erro: a capacidade de passageiros deve ser maior que zero.");
            this.capacidadePassageiros = 1;
            return;
        }

        this.capacidadePassageiros = capacidadePassageiros;
    }

    @Override
    public void exibirTipo() {
        System.out.println("Sou um Carro.");
    }

    @Override
    public String calcularAutonomia() {
        double kmRestante = getNivelCombustivel() * 10.0;
        return "Autonomia: " + kmRestante + " km (consumo de 10 km/l).";
    }
}
