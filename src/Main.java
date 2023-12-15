import model.Aeronave;
import model.Atrasado;
import model.Confirmado;
import model.Passageiro;
import model.Programado;
import model.Voo;
import notifications.EmailContato;
import notifications.SMSContato;

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
        Aeronave boeing737 = new Aeronave(1, "Boeing 737 MAX 8");

        // Criar um voo
        Voo vooGLO2103 = new Voo("GLO2103", "JPA", "BSB", new Date(), new Date(), boeing737, new Programado());

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

        vooGLO2103.notificarPassageiro(passageiro1, "Olá " + passageiro1.getNome() + ", seu voo está programado para partir às " + vooGLO2103.getPartida() + ".");

        // Alterar status do voo
        vooGLO2103.alterarStatus(new Atrasado());

        // Digitar mensagem relativa ao status do voo
        String mensagem = "O voo está atrasado devido a condições climáticas.";

        // Notificar passageiros
        vooGLO2103.notifyObservers(mensagem);

        //altera status do voo
        vooGLO2103.alterarStatus(new Confirmado());

        String mensagem2 = "O voo está confirmado.";

        // Notificar passageiros
        vooGLO2103.notifyObservers(mensagem2);

        scanner.close();
    }
}
