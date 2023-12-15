package model;

import notifications.Contato;

import java.util.ArrayList;
import java.util.List;

public class Passageiro implements Observer {
    private String nome;
    private List<Contato> contatos = new ArrayList<>();

    public Passageiro(String nome) {
        this.nome = nome;
    }

    public void adicionarContato(Contato contato) {
        contatos.add(contato);
    }

    public void comprarBilhete(Voo voo) {
        voo.adicionarPassageiro(this);
    }

    @Override
    public void update(String mensagem) {
        notificar(mensagem);
    }

    public void notificar(String mensagem) {
        contatos.forEach(contato -> contato.enviarMensagem(mensagem));
    }

    public Contato getContatoPreferencial() {
        return contatos.isEmpty() ? null : contatos.get(0);
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return nome;
    }
}