package notifications;

public class EmailContato implements Contato {
    @Override
    public String getTipo() {
        return "Email";
    }

    private String endereco;

    public EmailContato(String endereco) {
        this.endereco = endereco;
    }

    @Override
    public void enviarMensagem(String mensagem) {
        System.out.println("Enviando email para " + endereco + ": " + mensagem);
    }

}
