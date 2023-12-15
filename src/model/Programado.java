package model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Programado implements EstadoVoo {
  @Override
  public void handle(Voo voo) {

    Date dataPartida = voo.getPartida();
    SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    String partida = formatador.format(dataPartida);

    voo.atualizarHorarioPartidaChegada(voo.getPartida());
    voo.notificarPassageiros("Olá! Seu voo de código" + voo.getCodigoVoo() + "está programado para partir às" + partida);
  }
}
