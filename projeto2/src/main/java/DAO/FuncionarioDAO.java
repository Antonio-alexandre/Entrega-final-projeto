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

        String sql = "INSERT INTO Funcionario (idf, cpf, nome, email) values(?,?,?,?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, funcionario.getIdf());
            pst.setLong(2, funcionario.getCpf());
            pst.setString(3, funcionario.getNome());
            pst.setString(4, funcionario.getEmail());
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

    public boolean deleteFuncionario(int idf) {
        connectToDB();
        String sql = "DELETE FROM Funcionario where idf=?";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, idf);
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

                Funcionario funcionarioAux = new Funcionario(rs.getInt("idf"), rs.getLong("cpf"), rs.getString("nome"), rs.getString("email"));

                System.out.println("idfuncionario = " + funcionarioAux.getIdf());
                System.out.println("cpf = " + funcionarioAux.getCpf());
                System.out.println("cpf = " + funcionarioAux.getNome());
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
}
