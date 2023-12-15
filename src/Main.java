import model.Aeronave;
import model.Passageiro;
import model.Voo;
import notifications.EmailContato;
import notifications.SMSContato;
import notifications.StatusVoo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> tiposNotificacoes = new ArrayList<>();
        tiposNotificacoes.add("email");
        tiposNotificacoes.add("sms");

        // Criar uma aeronave
        Aeronave boeing737 = new Aeronave(162, "Boeing 737 MAX 8");

        // Criar um voo
        Voo vooGLO2103 = new Voo("GLO2103", "JPA", "BSB", new Date(), new Date(), boeing737);

        // Criar passageiros
        Passageiro passageiro1 = new Passageiro("Paulo");

        while (passageiro1.getContatoPreferencial() == null) {
            System.out.println("Olá, " + passageiro1.getNome() + ", como você deseja ser contactado?");
            for (int i = 0; i < tiposNotificacoes.size(); i++) {
                System.out.println((i + 1) + " - " + tiposNotificacoes.get(i));
            }

            int opcao = scanner.nextInt();
    
            if (opcao == 1) {
                System.out.println("Digite seu e-mail:");
                String email = scanner.next();
                passageiro1.adicionarContato(new EmailContato(email));
            } else if (opcao == 2) {
                System.out.println("Digite seu número de telefone:");
                String telefone = scanner.next();
                passageiro1.adicionarContato(new SMSContato(telefone));
            } else {
                System.out.println("Opção inválida.");
            }
        }

        Passageiro passageiro2 = new Passageiro("Marcos");

        while (passageiro2.getContatoPreferencial() == null) {
            System.out.println("Olá, " + passageiro2.getNome() + ", como você deseja ser contactado?");
            for (int i = 0; i < tiposNotificacoes.size(); i++) {
                System.out.println((i + 1) + " - " + tiposNotificacoes.get(i));
            }
            int opcao = scanner.nextInt();

            if (opcao == 1) {
                System.out.println("Digite seu e-mail:");
                String email = scanner.next();
                passageiro2.adicionarContato(new EmailContato(email));
            } else if (opcao == 2) {
                System.out.println("Digite seu número de telefone:");
                String telefone = scanner.next();
                passageiro2.adicionarContato(new SMSContato(telefone));
            } else {
                System.out.println("Opção inválida.");
            }
        }


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

        //altera status do voo
        vooGLO2103.alterarStatus(StatusVoo.CONFIRMADO);

        String mensagem2 = "O voo está confirmado.";

        // Notificar passageiros
        vooGLO2103.notificarPassageiros(mensagem2);
    }
}
