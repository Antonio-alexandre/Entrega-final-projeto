package DAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import Model.Vagas;

public class VagasDAO extends ConnectionDAO{
    Scanner entrada = new Scanner(System.in);
    //DAO - Data Access Object
    boolean sucesso = false; //Para saber se funcionou
    VeiculosDAO veiculosDAO;

    //INSERT
    public boolean insertVaga(Vagas vaga) {

        connectToDB();

        String sql = "INSERT INTO Vagas (num, disponivel) values(?,?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, vaga.getNum());
            pst.setBoolean(2, vaga.getDisponivel());
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

    public boolean updateVaga(boolean disponivel, int id_ve, int num) {
        connectToDB();
        String sql = "UPDATE Vagas SET disponivel = ? , id_ve = ? WHERE num = ?";
        String sql1 = "SELECT * FROM Veiculos WHERE placa =?";
        try {
            pst = con.prepareStatement(sql);
            System.out.println("Digite o número da vaga: ");
            pst.setInt(3, num);
            System.out.println();
            System.out.println("Digite a disponibilidade da vaga: ");
            disponivel = entrada.nextBoolean();
            if(disponivel)
                pst.setBoolean(1, disponivel);
            else{
                pst.setBoolean(1, disponivel);
                System.out.println("Veículos cadastrados no sistema: ");
                veiculosDAO.selectVeiculo();
                System.out.println("Digite o id do veículo a ser alocado para a vaga: ");
                pst.setInt(2, id_ve);
            }
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

    public ArrayList<Vagas> selectVaga() {
        ArrayList<Vagas> vagas = new ArrayList<>();
        connectToDB();
        String sql = "SELECT * FROM Vagas";

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);

            System.out.println("Lista de vagas disponíveis: ");

            while (rs.next()) {

                Vagas vagasAux = new Vagas(rs.getInt("num"), rs.getBoolean("disponivel"));
                System.out.println("Número da vaga: " + vagasAux.getNum());
                System.out.println("Disponibilidade da vaga: = " + vagasAux.getDisponivel());
                System.out.println("--------------------------------");

                if(vagasAux.getDisponivel())
                    vagas.add(vagasAux);
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
        return vagas;
    }
}
