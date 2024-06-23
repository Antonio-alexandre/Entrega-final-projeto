package Model;

public class Historico {
    private int idh;
    private String horariosaida;
    private String horarioentrada;

    public Historico(int idh, String horariosaida, String horarioentrada) {
        this.horariosaida = horariosaida;
        this.horarioentrada = horarioentrada;
    }

    public int getIdh() {
        return idh;
    }

    public String getHorariosaida() {
        return horariosaida;
    }

    public void setHorariosaida(String horariosaida) {
        this.horariosaida = horariosaida;
    }

    public String getHorarioentrada() {
        return horarioentrada;
    }

    public void setHorarioentrada(String horarioentrada) {
        this.horarioentrada = horarioentrada;
    }
}
