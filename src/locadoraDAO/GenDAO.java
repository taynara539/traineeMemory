/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locadoraDAO;

import conexao.ConexaoComBanco;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import locadoraMODELO.Gen;

/**
 *
 * @author Taynara Kris
 */
public class GenDAO {

    public static List<Gen> gameDaLocacaoJoin(int idLocacao) throws SQLException, Exception {

        ConexaoComBanco con = new ConexaoComBanco();
        PreparedStatement prepararPara = null;
        List<Gen> lista = new ArrayList<Gen>();

        try {

            String consulta = "SELECT L.ID_GAME, GA.TITULO, GE.DESCRICAO FROM LOCACOES L JOIN GAME GA "
                    + "ON (L.ID_GAME = GA.ID_GAME) JOIN GENERO GE ON (GA.ID_GENERO = GE.ID_GENERO) WHERE L.ID_LOCACAO = ?";

            prepararPara = con.conectando().prepareStatement(consulta);
            prepararPara.setInt(1, idLocacao);

            ResultSet rs = prepararPara.executeQuery();
            while (rs.next()) {

                Gen loc = new Gen();

                loc.setId_game(rs.getInt("id_game"));
                loc.setTitulo(rs.getString("titulo"));
                loc.setDescricao(rs.getString("descricao"));

                lista.add(loc);

            }

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "Locação não encontrada. \n" + e);
        } finally {
            prepararPara.close();
            con.fecharConexaoComBanco();

        }

        return lista;

    }

    public static List<Gen> gamesDisponiveis() throws SQLException, Exception {

        ConexaoComBanco con = new ConexaoComBanco();
        PreparedStatement prepararPara = null;
        List<Gen> lista = new ArrayList<Gen>();

        try {

            String consulta = "SELECT GA.ID_GAME, GA.TITULO, GE.DESCRICAO "
                    + "FROM GAME GA JOIN GENERO GE ON (GA.ID_GENERO = GE.ID_GENERO)"
                    + "WHERE GA.SITUACAO LIKE '%DISPONÍVEL%';";
            prepararPara = con.conectando().prepareStatement(consulta);
  
            ResultSet rs = prepararPara.executeQuery();
            while (rs.next()) {

                Gen loc = new Gen();

                loc.setId_game(rs.getInt("id_game"));
                loc.setTitulo(rs.getString("titulo"));
                loc.setDescricao(rs.getString("descricao"));

                lista.add(loc);

            }

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "Locação não encontrada. \n" + e);
        } finally {
            prepararPara.close();
            con.fecharConexaoComBanco();

        }

        return lista;

    }

}
