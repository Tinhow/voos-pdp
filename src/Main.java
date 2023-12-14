import model.Aeronave;
import model.Passageiro;
import model.Voo;
import notifications.EmailContato;
import notifications.SMSContato;
import notifications.StatusVoo;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        // Criar uma aeronave
        Aeronave boeing737 = new Aeronave(162, "Boeing 737 MAX 8");

        // Criar um voo
        Voo vooGLO2103 = new Voo("GLO2103", "JPA", "BSB", new Date(), new Date(), boeing737);

        // Criar passageiros
        Passageiro passageiro1 = new Passageiro("Paulo");
        passageiro1.adicionarContato(new EmailContato("paulo@email.com"));

        Passageiro passageiro2 = new Passageiro("Marcos");
        passageiro2.adicionarContato(new SMSContato("123456789"));

        // Comprar bilhetes
        passageiro1.comprarBilhete(vooGLO2103);
        passageiro2.comprarBilhete(vooGLO2103);

        // Alterar status do voo
        vooGLO2103.alterarStatus(StatusVoo.ATRASADO);

        // Digitar mensagem relativa ao status do voo
        String mensagem = "O voo está atrasado devido a condições climáticas.";

        // Atualizar informações de partida e chegada no caso de atraso
        if (vooGLO2103.getStatus() == StatusVoo.ATRASADO) {
            vooGLO2103.atualizarHorarioPartidaChegada(new Date(System.currentTimeMillis() + 3600000)); // Adiciona 1 hora ao horário atual
        }

        // Notificar passageiros
        vooGLO2103.notificarPassageiros(mensagem);
    }
}
