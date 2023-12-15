package model;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Confirmado implements EstadoVoo {
  @Override
  public void handle(Voo voo) {
    voo.atualizarHorarioPartidaChegada(voo.getPartida());

    Date dataPartida = voo.getPartida();
    SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    String partida = formatador.format(dataPartida);
    voo.notifyObservers("Voo " + voo.getCodigoVoo() + " confirmado para " + partida);
  }
}
