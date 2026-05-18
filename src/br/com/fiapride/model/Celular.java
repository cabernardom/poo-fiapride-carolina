package br.com.fiapride.model;

public class Celular implements Recarregavel {
    private String marca;
    private int nivelBateria;

    public Celular(String marca) {
        setMarca(marca);
        this.nivelBateria = Recarregavel.CARGA_MINIMA;
    }

    public String getMarca() {
        return this.marca;
    }

    public int getNivelBateria() {
        return this.nivelBateria;
    }

    @Override
    public void recarregar(int percentual) {
        if (percentual < Recarregavel.CARGA_MINIMA || percentual > Recarregavel.CARGA_MAXIMA) {
            System.out.println("Erro: percentual de bateria invalido para o celular.");
            return;
        }

        this.nivelBateria = percentual;
        System.out.println("Celular " + this.marca + " carregado para " + this.nivelBateria + "%.");
    }

    private void setMarca(String marca) {
        if (marca == null || marca.isBlank()) {
            this.marca = "Marca nao informada";
            return;
        }

        this.marca = marca;
    }
}
