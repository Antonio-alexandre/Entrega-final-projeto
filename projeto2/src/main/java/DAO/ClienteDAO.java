package DAO;
import java.sql.SQLException;
import java.util.ArrayList;
import Model.Cliente;

public class ClienteDAO extends ConnectionDAO{

    //DAO - Data Access Object
    boolean sucesso = false; //Para saber se funcionou

    //INSERT
    public boolean insertCliente(Cliente cliente) {

        connectToDB();

        String sql = "INSERT INTO Clientes (cpf, nome, email) values(?,?,?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, cliente.getCpf());
            pst.setString(2, cliente.getNome());
            pst.setString(3, cliente.getEmail());
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

    public boolean deleteCliente(int idc) {
        connectToDB();
        String sql = "DELETE FROM Cliente where idc=?";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, idc);
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

    public ArrayList<Cliente> selectCliente() {
        ArrayList<Cliente> clientes = new ArrayList<>();
        connectToDB();
        String sql = "SELECT * FROM Clientes";

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);

            System.out.println("Lista de clientes: ");

            while (rs.next()) {

                Cliente clienteAux = new Cliente(rs.getString("cpf"), rs.getString("nome"), rs.getString("email"));

                System.out.println("cpf = " +clienteAux.getCpf());
                System.out.println("nome = " + clienteAux.getNome());
                System.out.println("email = " + clienteAux.getEmail());
                System.out.println("--------------------------------");

                clientes.add(clienteAux);
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
        return clientes;
    }

    public boolean editCliente(int id_ve, String cpf) {
        connectToDB();

        String sql = "UPDATE Cliente SET id_ve = ? WHERE cpf = ?";

        try {
            pst = con.prepareStatement(sql);
            pst.setString(2, cpf);
            pst.setString(1, id_ve);
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
