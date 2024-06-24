package Model;

public class Vagas {
    private int id_v;
    private int num;
    private boolean disponivel;
    private int id_ve;

    public Vagas(int num, boolean disponivel){
        this.num = num;
        this.disponivel = disponivel;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }

    public void setDisponivel(boolean disponivel){
        this.disponivel = disponivel;
    }

    public boolean getDisponivel(){
        return disponivel;
    }

    public void setId_ve(int id_ve){
        this.id_ve = id_ve;
    }

    public int getId_ve() {
        return id_ve;
    }
}
