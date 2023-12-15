package notifications;

public class AppContato implements Contato{
  @Override
  public String getTipo(){
    return "App";
  }

  @Override
  public void enviarMensagem(String mensagem){
    System.out.println("Enviando mensagem para o app: " + mensagem);
  }
}
