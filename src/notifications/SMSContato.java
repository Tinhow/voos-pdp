package notifications;

public class SMSContato implements Contato {
    private String numeroTelefone;

    public SMSContato(String numeroTelefone) {
        this.numeroTelefone = numeroTelefone;
    }

    @Override
    public void enviarMensagem(String mensagem) {
        System.out.println("Enviando SMS para " + numeroTelefone + ": " + mensagem);
    }

    @Override
    public String getTipo() {
        return "SMS";
    }
}
