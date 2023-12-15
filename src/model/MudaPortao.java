package model;

public class MudaPortao implements EstadoVoo{
  @Override
  public void handle(Voo voo){
    voo.atualizarHorarioPartidaChegada(voo.getPartida());
    voo.notifyObservers("Voo " + voo.getCodigoVoo() + " mudou de portão");
  }
}
