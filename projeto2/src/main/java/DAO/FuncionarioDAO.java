package DAO;
import java.sql.SQLException;
import java.util.ArrayList;
import Model.Funcionario;

public class FuncionarioDAO extends ConnectionDAO{

    //DAO - Data Access Object
    boolean sucesso = false; //Para saber se funcionou

    //INSERT
    public boolean insertFuncionario(Funcionario funcionario) {

        connectToDB();

        String sql = "INSERT INTO Funcionario (cpf, nome, email) values(?,?,?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, funcionario.getCpf());
            pst.setString(2, funcionario.getNome());
            pst.setString(3, funcionario.getEmail());
            pst.execute();
            sucesso = true;
        } catch (SQLException exc) {
            System.out.println("Erro: " + exc.getMessage());
            sucesso = false;
        } finally {
            try {
                con.close();
                pst.close();
            } catch (SQLException exc) {
                System.out.println("Erro: " + exc.getMessage());
            }
        }
        return sucesso;
    }

    public boolean deleteFuncionario(String cpf) {
        connectToDB();
        String sql = "DELETE FROM Funcionario where cpf=?";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, cpf);
            pst.execute();
            sucesso = true;
        } catch (SQLException ex) {
            System.out.println("Erro = " + ex.getMessage());
            sucesso = false;
        } finally {
            try {
                con.close();
                pst.close();
            } catch (SQLException exc) {
                System.out.println("Erro: " + exc.getMessage());
            }
        }
        return sucesso;
    }

    public ArrayList<Funcionario> selectFuncionario() {
        ArrayList<Funcionario> funcionarios = new ArrayList<>();
        connectToDB();
        String sql = "SELECT * FROM Funcionario";

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);

            System.out.println("Lista de funcionários: ");

            while (rs.next()) {

                Funcionario funcionarioAux = new Funcionario(rs.getString("cpf"), rs.getString("nome"), rs.getString("email"));

                System.out.println("cpf = " + funcionarioAux.getCpf());
                System.out.println("nome = " + funcionarioAux.getNome());
                System.out.println("email = " + funcionarioAux.getEmail());
                System.out.println("--------------------------------");

                funcionarios.add(funcionarioAux);
            }
            sucesso = true;
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
            sucesso = false;
        } finally {
            try {
                con.close();
                st.close();
            } catch (SQLException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
        return funcionarios;
    }

    public boolean editFuncionario(String cpf, int opcao, String novoValor) {
        connectToDB();

        String campo = opcao == 1 ? "nome" : "email";
        String sql = "UPDATE Funcionario SET " + campo + " = ? WHERE cpf = ?";

        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, novoValor);
            pst.setString(2, cpf);
            pst.executeUpdate();
            sucesso = true;
        } catch (SQLException exc) {
            System.out.println("Erro: " + exc.getMessage());
            sucesso = false;
        } finally {
            try {
                con.close();
                pst.close();
            } catch (SQLException exc) {
                System.out.println("Erro: " + exc.getMessage());
            }
        }
        return sucesso;
    }
}

