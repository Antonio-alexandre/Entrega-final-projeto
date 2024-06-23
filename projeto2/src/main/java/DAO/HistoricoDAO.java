package DAO;
import java.sql.SQLException;
import java.util.ArrayList;
import Model.Historico;

public class HistoricoDAO extends ConnectionDAO{

    //DAO - Data Access Object
    boolean sucesso = false; //Para saber se funcionou

    //INSERT
    public boolean insertHistorico(Historico historico) {

        connectToDB();

        String sql = "INSERT INTO Historico (idh, horariosaida, horarioentrada) values(?,?,?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, historico.getIdh());
            pst.setString(2, historico.getHorariosaida());
            pst.setString(3, historico.getHorarioentrada());
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

    public boolean deleteHistorico(int idh) {
        connectToDB();
        String sql = "DELETE FROM Historico where idh=?";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, idh);
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

    public ArrayList<Historico> selectHistorico() {
        ArrayList<Historico> historico = new ArrayList<>();
        connectToDB();
        String sql = "SELECT * FROM Historico";

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);

            System.out.println("Lista de registros de histórico: ");

            while (rs.next()) {

                Historico historicoAux = new Historico(rs.getInt("idh"), rs.getString("horariosaida"), rs.getString("horarioentrada"));

                System.out.println("idhistorico = " + historicoAux.getIdh());
                System.out.println("horario de saída: = " + historicoAux.getHorariosaida());
                System.out.println("horário de entrada: = " + historicoAux.getHorarioentrada());
                System.out.println("--------------------------------");

                historico.add(historicoAux);
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
        return historico;
    }
}
