package Model;

public class vagaFuncionario {
    private String cpf;
    private int placa_veiculo;

    public vagaFuncionario(String cpf_funcionario, int placa_veiculo){
        this.cpf = cpf_funcionario;
        this.placa_veiculo = placa_veiculo;
    }

    public void setFuncionario(String cpf) {
        this.cpf = cpf;
    }

    public String getFuncionario() {
        return cpf;
    }

    public void setVaga(int placa_veiculo) {
         this.placa_veiculo = placa_veiculo;
    }

    public int getVaga() {
        return placa_veiculo;
    }
}
