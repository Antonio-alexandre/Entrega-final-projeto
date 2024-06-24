package DAO;

import Model.vagaFuncionario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VagaFuncionarioDAO extends ConnectionDAO {
    private boolean sucesso = false;

    // Método para inserir uma associação entre vaga e funcionário
    public boolean insertVagaFuncionario(vagaFuncionario vaga_has_funcionario) {
        connectToDB();
        String sql = "INSERT INTO Vagas_has_Funcionario (num_vaga, cpf_funcionario) VALUES (?, ?)";

        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, vaga_has_funcionario.getVaga());
            pst.setString(2, vaga_has_funcionario.getFuncionario());
            pst.executeUpdate(); // Use executeUpdate para INSERT, UPDATE e DELETE
            sucesso = true;
        } catch (SQLException exc) {
            System.out.println("Erro ao inserir associação de vaga e funcionário: " + exc.getMessage());
            sucesso = false;
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException exc) {
                System.out.println("Erro: " + exc.getMessage());
            }
        }
        return sucesso;
    }

    // Método para deletar uma associação entre vaga e funcionário
    public boolean deleteVagaFuncionario(vagaFuncionario vaga_has_funcionario) {
        connectToDB();
        String sql = "DELETE FROM Vagas_has_funcionario WHERE id_vaga = ? AND id_funcionario = ?";

        try {
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, vaga_has_funcionario.getFuncionario());
            pst.setInt(2, vaga_has_funcionario.getVaga());
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


}
