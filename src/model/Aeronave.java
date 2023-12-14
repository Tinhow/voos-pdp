package model;

public class Aeronave {
    private int assentosDisponiveis;
    private String modelo;

    public Aeronave(int assentosDisponiveis, String modelo) {
        this.assentosDisponiveis = assentosDisponiveis;
        this.modelo = modelo;
    }

    public int getAssentosDisponiveis() {
        return assentosDisponiveis;
    }
}
