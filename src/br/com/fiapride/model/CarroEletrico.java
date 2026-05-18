package br.com.fiapride.model;

public class CarroEletrico extends Veiculo implements Recarregavel {
    private int nivelBateria;

    public CarroEletrico(String placa, String modelo) {
        super(placa, modelo);
        setNivelBateria(CARGA_MINIMA);
    }

    public int getNivelBateria() {
        return this.nivelBateria;
    }

    @Override
    public void recarregar(int percentual) {
        if (percentual < Recarregavel.CARGA_MINIMA || percentual > Recarregavel.CARGA_MAXIMA) {
            System.out.println("Erro: percentual de bateria invalido para o carro eletrico.");
            return;
        }

        setNivelBateria(percentual);
        System.out.println("Carro " + getModelo() + " recarregado para " + this.nivelBateria + "%.");
    }

    @Override
    public void exibirTipo() {
        System.out.println("Sou um Carro Eletrico.");
    }

    @Override
    public String calcularAutonomia() {
        double kmRestante = this.nivelBateria * 5.0;
        return "Autonomia: " + kmRestante + " km (5 km por ponto de bateria).";
    }

    private void setNivelBateria(int nivelBateria) {
        if (nivelBateria < CARGA_MINIMA || nivelBateria > CARGA_MAXIMA) {
            System.out.println("Erro: nivel de bateria fora do intervalo permitido.");
            return;
        }

        this.nivelBateria = nivelBateria;
    }
}
