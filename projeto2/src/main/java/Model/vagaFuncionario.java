package Model;

public class vagaFuncionario {
    private String cpf_funcionario;
    private int placa_veiculo;

    public vagaFuncionario(String cpf_funcionario, int placa_veiculo){
        this.cpf_funcionario = cpf_funcionario;
        this.placa_veiculo = placa_veiculo;
    }

    public void setFuncionario(String cpf_funcionario) {
        this.cpf_funcionario = cpf_funcionario;
    }

    public String getFuncionario() {
        return cpf_funcionario;
    }

    public void setVaga(int placa_veiculo) {
         this.placa_veiculo = placa_veiculo;
    }

    public int getVaga() {
        return placa_veiculo;
    }
}
