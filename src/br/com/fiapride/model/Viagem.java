package br.com.fiapride.model;

public class Viagem {
    private String destino;
    private double valor;
    private Passageiro solicitante;
    private Veiculo veiculoUtilizado;

    public Viagem(String destino, Passageiro solicitante, Veiculo veiculoUtilizado) {
        setDestino(destino);
        setSolicitante(solicitante);
        setVeiculoUtilizado(veiculoUtilizado);
        this.valor = 0.0;

        System.out.println("Nova viagem solicitada para: " + this.destino);
    }

    public String getDestino() {
        return this.destino;
    }

    public double getValor() {
        return this.valor;
    }

    public Passageiro getSolicitante() {
        return this.solicitante;
    }

    public Veiculo getVeiculoUtilizado() {
        return this.veiculoUtilizado;
    }

    public void definirValor(double valor) {
        if (valor <= 0) {
            System.out.println("Erro: o valor da viagem deve ser maior que zero.");
            return;
        }

        this.valor = valor;
    }

    public void exibirResumo() {
        System.out.println("--- Resumo da Viagem ---");
        System.out.println("Destino: " + this.destino);
        System.out.println("Valor: R$" + this.valor);
        System.out.println("Passageiro: " + this.solicitante.getNome());
        System.out.println("Veiculo: " + this.veiculoUtilizado.getModelo() + " | Placa: "
                + this.veiculoUtilizado.getPlaca());
    }

    private void setDestino(String destino) {
        if (destino == null || destino.isBlank()) {
            System.out.println("Erro: o destino da viagem deve ser informado.");
            this.destino = "Destino nao informado";
            return;
        }

        this.destino = destino;
    }

    private void setSolicitante(Passageiro solicitante) {
        if (solicitante == null) {
            System.out.println("Erro: a viagem precisa de um passageiro solicitante.");
            return;
        }

        this.solicitante = solicitante;
    }

    private void setVeiculoUtilizado(Veiculo veiculoUtilizado) {
        if (veiculoUtilizado == null) {
            System.out.println("Erro: a viagem precisa de um veiculo.");
            return;
        }

        this.veiculoUtilizado = veiculoUtilizado;
    }
}
