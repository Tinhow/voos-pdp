package notifications;

public class EmailContato implements Contato {
    private String endereco;

    public EmailContato(String endereco) {
        this.endereco = endereco;
    }

    @Override
    public String getTipo() {
        return "Email";
    }

    @Override
    public void enviarMensagem(String mensagem) {
        System.out.println("Enviando email para " + endereco + ": " + mensagem);
    }

}
