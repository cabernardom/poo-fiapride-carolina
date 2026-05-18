package br.com.fiapride.model;

public abstract class Veiculo {
    private String placa;
    private String modelo;
    private double nivelCombustivel;

    public Veiculo() {
        this("PLACA-PENDENTE", "Modelo nao informado");
    }

    public Veiculo(String placa, String modelo) {
        setPlaca(placa);
        setModelo(modelo);
        setNivelCombustivel(0);
        System.out.println("Registro inicial: um " + this.modelo + " nasceu com a placa " + this.placa + ".");
    }

    public String getPlaca() {
        return this.placa;
    }

    public String getModelo() {
        return this.modelo;
    }

    public void atualizarPlaca(String novaPlaca) {
        System.out.println("Solicitada atualizacao de placa no Detran para o veiculo " + this.modelo + ".");
        setPlaca(novaPlaca);
    }

    public abstract void exibirTipo();

    public abstract String calcularAutonomia();

    public void abastecer(double quantidade) {
        if (quantidade <= 0) {
            System.out.println("Erro: a quantidade de combustivel deve ser maior que zero.");
            return;
        }

        setNivelCombustivel(this.nivelCombustivel + quantidade);
    }

    public double getNivelCombustivel() {
        return this.nivelCombustivel;
    }

    private void setPlaca(String placa) {
        if (placa == null || placa.isBlank()) {
            System.out.println("Erro de validacao: a placa informada e invalida.");
            if (this.placa == null) {
                this.placa = "PLACA-PENDENTE";
            }
            return;
        }

        this.placa = placa;
        System.out.println("Sucesso: a placa agora e " + this.placa + ".");
    }

    private void setModelo(String modelo) {
        if (modelo == null || modelo.isBlank()) {
            System.out.println("Erro de validacao: o modelo informado e invalido.");
            this.modelo = "Modelo nao informado";
            return;
        }

        this.modelo = modelo;
    }

    private void setNivelCombustivel(double nivelCombustivel) {
        if (nivelCombustivel < 0) {
            System.out.println("Erro: o nivel de combustivel nao pode ser negativo.");
            return;
        }

        this.nivelCombustivel = nivelCombustivel;
    }
}
