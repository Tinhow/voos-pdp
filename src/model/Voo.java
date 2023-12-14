package model;

import notifications.Contato;
import notifications.StatusVoo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Voo {
    private String codigoVoo;
    private StatusVoo status;
    private String origem;
    private String destino;
    private Date partida;
    private Date chegada;
    private Aeronave aeronave;

    private List<Passageiro> passageiros = new ArrayList<>();

    public Voo(String codigoVoo, String origem, String destino, Date partida, Date chegada, Aeronave aeronave) {
        this.codigoVoo = codigoVoo;
        this.origem = origem;
        this.destino = destino;
        this.partida = partida;
        this.chegada = chegada;
        this.aeronave = aeronave;
        this.status = StatusVoo.PROGRAMADO;
    }

    public void adicionarPassageiro(Passageiro passageiro) {
        if (passageiros.size() < aeronave.getAssentosDisponiveis()) {
            passageiros.add(passageiro);
            System.out.println("Passageiro " + passageiro + " adicionado ao voo " + codigoVoo);
        } else {
            System.out.println("Não há assentos disponíveis para o passageiro " + passageiro);
        }
    }

    public void alterarStatus(StatusVoo novoStatus) {
        this.status = novoStatus;
        notificarPassageiros("Status do voo alterado para: " + novoStatus);
    }

    public void notificarPassageiros(String mensagem) {
        passageiros.forEach(passageiro -> passageiro.notificar(mensagem));
    }

    public StatusVoo getStatus() {
        return status;
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

}

