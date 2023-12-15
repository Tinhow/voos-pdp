package model;

import notifications.Contato;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Voo {
    private String codigoVoo;
    private EstadoVoo estado;
    private String origem;
    private String destino;
    private Date partida;
    private Date chegada;
    private Aeronave aeronave;

    private List<Passageiro> passageiros = new ArrayList<>();

    public Voo(String codigoVoo, String origem, String destino, Date partida, Date chegada, Aeronave aeronave, EstadoVoo estado) {
        this.codigoVoo = codigoVoo;
        this.origem = origem;
        this.destino = destino;
        this.partida = partida;
        this.chegada = chegada;
        this.aeronave = aeronave;
        this.estado = new Programado();
    }

    public void adicionarPassageiro(Passageiro passageiro) {
        if (passageiros.size() < aeronave.getAssentosDisponiveis()) {
            passageiros.add(passageiro);
            System.out.println("Passageiro " + passageiro + " adicionado ao voo " + codigoVoo + ", ainda há " + (aeronave.getAssentosDisponiveis() - passageiros.size()) + " assentos disponíveis.");
        } else {
            System.out.println("Não há assentos disponíveis para o passageiro " + passageiro);
        }
    }

    public void alterarStatus(EstadoVoo novoEstado) {
        this.estado = novoEstado;
        estado.handle(this);
    }

    public void notificarPassageiros(String mensagem) {
        passageiros.forEach(passageiro -> passageiro.notificar(mensagem));
    }

    public EstadoVoo getEstadoVoo() {
        return estado;
    }

    public Passageiro[] getPassageiros() {
        return passageiros.toArray(new Passageiro[0]);
    }

    public void atualizarHorarioPartidaChegada(Date novaData) {
        this.partida = novaData;
    }

    public void notificarPassageiro(Passageiro passageiro, String mensagem) {
        passageiro.notificar(mensagem);
    }

    public String getCodigoVoo() {
        return codigoVoo;
    }

    public Date getPartida() {
        return partida;
    }
}

