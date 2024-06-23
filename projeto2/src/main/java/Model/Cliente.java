package Model;

public class Cliente {
    private int idc;
    private long cpf;
    private String nome;
    private String email;

    public Cliente(int idc, long cpf, String nome, String email) {
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.idc = idc;
    }

    public void setIdc(int idc) {
        this.idc = idc;
    }

    public int getIdc() {
        return idc;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getCpf() {
        return cpf;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }
}
