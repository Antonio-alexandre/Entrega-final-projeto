package Model;

public class Funcionario {
    private int idf;
    private long cpf;
    private String nome;
    private String email;

    public Funcionario(int idf, long cpf, String nome, String email) {
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.idf = idf;
    }

    public void setIdf(int idf) {
        this.idf = idf;
    }

    public int getIdf() {
        return idf;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }

    public long getCpf() {
        return cpf;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
}
