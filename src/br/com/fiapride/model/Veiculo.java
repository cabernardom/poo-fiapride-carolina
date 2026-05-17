package br.com.fiapride.model;

public class Veiculo {
    private String placa;
    private String modelo;

    public Veiculo() {
        this("PLACA-PENDENTE", "Modelo nao informado");
    }

    public Veiculo(String placa, String modelo) {
        setPlaca(placa);
        setModelo(modelo);
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

    private void setPlaca(String placa) {
        if (placa == null || placa.isBlank()) {
            System.out.println("Erro de validacao: a placa informada e invalida.");
            this.placa = "PLACA-PENDENTE";
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
}
