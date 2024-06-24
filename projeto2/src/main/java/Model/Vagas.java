package Model;

public class Vagas {
    private int num;
    private boolean disponivel;
    private int placa_veiculo;

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

    public void setPlaca_veiculo(int placa_veiculo){
        this.placa_veiculo = placa_veiculo;
    }

    public int getPlaca_veiculo() {
        return placa_veiculo;
    }
}
