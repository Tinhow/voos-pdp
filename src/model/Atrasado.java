package model;


import java.text.SimpleDateFormat;
import java.util.Date;

public class Atrasado implements EstadoVoo {
  @Override
  public void handle(Voo voo) {
    voo.atualizarHorarioPartidaChegada(new Date(System.currentTimeMillis() + 3600000));
    
    Date dataPartida = voo.getPartida();
    SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    String partida = formatador.format(dataPartida);

    voo.notificarPassageiros("Voo " + voo.getCodigoVoo() + " atrasado para " + partida);
  }
}
