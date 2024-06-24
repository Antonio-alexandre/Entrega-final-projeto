package DAO;
import java.sql.SQLException;
import java.util.ArrayList;
import Model.Veiculos;


public class VeiculosDAO extends ConnectionDAO {

    //DAO - Data Access Object
    boolean sucesso = false; //Para saber se funcionou

    //INSERT
    public boolean insertVeiculos(Veiculos veiculo) {

        connectToDB();

        String sql = "INSERT INTO Veiculos (placa, cor, modelo) values(?,?,?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, veiculo.getPlaca());
            pst.setString(2, veiculo.getCor());
            pst.setString(3, veiculo.getModelo());
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

    public boolean deleteVeiculo(String placa) {
        connectToDB();
        String sql = "DELETE FROM Veiculos where placa=?";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, placa);
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

    public ArrayList<Veiculos> selectVeiculo() {
        ArrayList<Veiculos> veiculos = new ArrayList<>();
        connectToDB();
        String sql = "SELECT * FROM Veiculo";

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);

            System.out.println("Lista de veículos: ");

            while (rs.next()) {

                Veiculos veiculoAux = new Veiculos(rs.getString("placa"), rs.getString("cor"), rs.getString("modelo"));

                System.out.println("placa = " + veiculoAux.getPlaca());
                System.out.println("cor = " + veiculoAux.getCor());
                System.out.println("modelo = " + veiculoAux.getModelo());
                System.out.println("--------------------------------");

                veiculos.add(veiculoAux);
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
        return veiculos;
    }
}
