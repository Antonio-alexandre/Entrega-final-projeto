package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VagaFuncionarioDAO extends ConnectionDAO {
    private boolean sucesso = false;

    // Método para inserir uma associação entre vaga e funcionário
    public boolean insertVagaFuncionario(int num_vaga, String cpf_funcionario) {
        connectToDB();
        String sql = "INSERT INTO VagaFuncionario (id_vaga, id_funcionario) VALUES (?, ?)";

        try {
            // Obter o id_vaga correspondente ao num_vaga
            int id_vaga = getIdVagaPorNumero(num_vaga);

            // Obter o id_funcionario correspondente ao cpf_funcionario
            int id_funcionario = getIdFuncionarioPorCPF(cpf_funcionario);

            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, id_vaga);
            pst.setInt(2, id_funcionario);
            pst.executeUpdate(); // Use executeUpdate para INSERT, UPDATE e DELETE
            sucesso = true;
        } catch (SQLException exc) {
            System.out.println("Erro ao inserir associação de vaga e funcionário: " + exc.getMessage());
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

    // Método para deletar uma associação entre vaga e funcionário
    public boolean deleteVagaFuncionario(int num_vaga, String cpf_funcionario) {
        connectToDB();
        String sql = "DELETE FROM VagaFuncionario WHERE id_vaga = ? AND id_funcionario = ?";

        try {
            // Obter o id_vaga correspondente ao num_vaga
            int id_vaga = getIdVagaPorNumero(num_vaga);

            // Obter o id_funcionario correspondente ao cpf_funcionario
            int id_funcionario = getIdFuncionarioPorCPF(cpf_funcionario);

            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, id_vaga);
            pst.setInt(2, id_funcionario);
            pst.executeUpdate(); // Use executeUpdate para INSERT, UPDATE e DELETE
            sucesso = true;
        } catch (SQLException exc) {
            System.out.println("Erro ao deletar associação de vaga e funcionário: " + exc.getMessage());
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

    // Método auxiliar para obter o id_vaga a partir do num_vaga
    private int getIdVagaPorNumero(int num_vaga) throws SQLException {
        connectToDB();
        String sql = "SELECT id_vaga FROM Vaga WHERE num_vaga = ?";
        int id_vaga = -1;

        try (PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setInt(1, num_vaga);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                id_vaga = rs.getInt("id_vaga");
            }
        }

        return id_vaga;
    }

    // Método auxiliar para obter o id_funcionario a partir do cpf_funcionario
    private int getIdFuncionarioPorCPF(String cpf_funcionario) throws SQLException {
        connectToDB();
        String sql = "SELECT id_funcionario FROM Funcionario WHERE cpf = ?";
        int id_funcionario = -1;

        try (PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, cpf_funcionario);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                id_funcionario = rs.getInt("id_funcionario");
            }
        }

        return id_funcionario;
    }
}
