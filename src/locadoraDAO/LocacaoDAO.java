/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locadoraDAO;

import locadoraMODELO.Locacoes;
import conexao.ConexaoComBanco;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Taynara Kris
 */
public class LocacaoDAO {

    public static void incluir(Locacoes locacao) throws Exception {

        //System.out.println("dentro da funcao icluir");
        ConexaoComBanco con = new ConexaoComBanco();
        PreparedStatement prepararPara = null;

        try {

            String consulta = "INSERT INTO locacoes (id_locacao, nome_cliente, telefone, data_locacao, "
                    + "data_devolucao, valor_item, id_game)"
                    + "VALUES (?,?,?,?,?,?,?)";

            prepararPara = con.conectando().prepareStatement(consulta);

            prepararPara.setInt(1, locacao.getIdLocacao());
            prepararPara.setString(2, locacao.getNomeCliente());
            prepararPara.setString(3, locacao.getTelefone());
            prepararPara.setString(4, locacao.getDtLocacao());
            prepararPara.setString(5, locacao.getDtDevolucao());
            prepararPara.setFloat(6, locacao.getValor());
            prepararPara.setInt(7, locacao.getIdGame());

            prepararPara.executeUpdate();

            JOptionPane.showMessageDialog(null, "Locação realizada com sucesso!");

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Erro ao realizar locacao\n" + e);
        } finally {

            prepararPara.close();
            con.fecharConexaoComBanco();

        }

    }

    public static List<Locacoes> getAll() throws SQLException, Exception {

        ConexaoComBanco con = new ConexaoComBanco();
        PreparedStatement prepararPara = null;
        String consulta = "SELECT * FROM locacoes group by id_locacao";

        List<Locacoes> lista = new ArrayList<Locacoes>();

        try {

            prepararPara = con.conectando().prepareStatement(consulta);
            ResultSet resultados = prepararPara.executeQuery();

            while (resultados.next()) {

                Locacoes atend = new Locacoes();

                atend.setIdLocacao(resultados.getInt("id_locacao"));
                atend.setNomeCliente(resultados.getString("nome_cliente"));
                atend.setTelefone(resultados.getString("telefone"));
                atend.setDtLocacao(resultados.getString("data_locacao"));
                atend.setDtDevolucao(resultados.getString("data_devolucao"));
                atend.setValor(resultados.getInt("valor_item"));
                atend.setIdGame(resultados.getInt("id_game"));

                lista.add(atend);

            }

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "Locação não encontrada. \n" + e);
        } finally {
            prepararPara.close();
            con.fecharConexaoComBanco();

        }

        return lista;

    }

    public static List<Locacoes> getAllComGames(int idLocacao) throws SQLException, Exception {

        ConexaoComBanco con = new ConexaoComBanco();
        PreparedStatement prepararPara = null;
        List<Locacoes> lista = new ArrayList<Locacoes>();
        Locacoes pac = new Locacoes();

        try {

            String consulta = "SELECT * FROM locacoes where id_locacao = ?";

            prepararPara = con.conectando().prepareStatement(consulta);
            prepararPara.setInt(1, idLocacao);

            ResultSet rs = prepararPara.executeQuery();
            while (rs.next()) {

                pac.setIdGame(rs.getInt("id_game"));
                pac.setDtDevolucao(rs.getString("data_devolucao"));
                pac.setDtLocacao(rs.getString("data_locacao"));
                pac.setNomeCliente(rs.getString("nome_cliente"));
                pac.setValor(rs.getFloat("valor_item"));
                pac.setTelefone(rs.getString("telefone"));
                pac.setId(rs.getInt("id_locacao"));

                lista.add(pac);

            }

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "Locação não encontrada. \n" + e);
        } finally {
            prepararPara.close();
            con.fecharConexaoComBanco();

        }

        return lista;

    }

    public static Locacoes buscarGamePorIdRecLocacao(int id) throws Exception {

        ConexaoComBanco con = new ConexaoComBanco();
        PreparedStatement verCod = null;

        Locacoes pac = new Locacoes();

        try {

            String consulta = ("SELECT * from game where id_game = ?;");

            verCod = con.conectando().prepareStatement(consulta);
            verCod.setInt(1, id);

            ResultSet rs = verCod.executeQuery();
            while (rs.next()) {

                pac.setIdGame(rs.getInt("id_game"));
                pac.setDtDevolucao(rs.getString("data_devolucao"));
                pac.setDtLocacao(rs.getString("data_locacao"));
                pac.setNomeCliente(rs.getString("nome_cliente"));
                pac.setValor(rs.getFloat("valor_item"));
                pac.setTelefone(rs.getString("telefone"));
                pac.setId(rs.getInt("id_locacao"));

            }

        } catch (SQLException e) {
            System.out.println("Erro ao buscar game por ID GAME: " + e);
        } finally {
            verCod.close();
            con.fecharConexaoComBanco();

        }

        return pac;

    }

    public static Locacoes buscarLocacoesPorId(String id) throws Exception {

        ConexaoComBanco con = new ConexaoComBanco();
        PreparedStatement verCod = null;

        Locacoes locacoes = new Locacoes();

        try {

            String consulta = ("SELECT * from locacoes where id_locacoes = ?;");

            verCod = con.conectando().prepareStatement(consulta);
            verCod.setString(1, id);

            ResultSet resultados = verCod.executeQuery();

            while (resultados.next()) {

                locacoes.setIdLocacao(resultados.getInt("idLocacoes"));
                locacoes.setNomeCliente(resultados.getString("nomeCliente"));
                locacoes.setTelefone(resultados.getString("telefone"));
                locacoes.setDtLocacao(resultados.getString("dtLocacao"));
                locacoes.setDtDevolucao(resultados.getString("dtDevolucao"));
                locacoes.setValor(resultados.getInt("valor"));
                locacoes.setIdGame(resultados.getInt("game"));

            }

        } catch (SQLException e) {
            System.out.println("Erro ao buscar locacoes por ID: " + e);
        } finally {
            verCod.close();
            con.fecharConexaoComBanco();

        }

        return locacoes;

    }

    public static void alterarAtendimento(Locacoes atend) throws Exception {

        ConexaoComBanco con = new ConexaoComBanco();
        PreparedStatement preparador = null;

        String atualizar = ("UPDATE locacoes "
                + "SET nome_cliente = ?, telefone = ?, data_locacao = ?,"
                + "data_devolucao = ?, valor_item = ?, id_game = ?  WHERE id_locacao = ?");

        try {
            preparador = con.conectando().prepareStatement(atualizar);

            preparador.setString(1, atend.getNomeCliente());
            preparador.setString(2, atend.getTelefone());
            preparador.setString(3, atend.getDtLocacao());
            preparador.setString(4, atend.getDtDevolucao());
            preparador.setFloat(5, atend.getValor());
            preparador.setInt(6, atend.getIdGame());
            preparador.setInt(7, atend.getIdLocacao());

            preparador.executeUpdate();

            JOptionPane.showMessageDialog(null, "Locacao alterada com sucesso!");

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Erro ao alterar Locacao " + e);

        }

    }

    public static List<Locacoes> buscaLocacoesporId(String atendimento) {

        ConexaoComBanco con = new ConexaoComBanco();

        String consulta = ("select * from locacoes where id_locacoes like ?");

        List<Locacoes> list = new ArrayList<Locacoes>();

        try {
            PreparedStatement prepararPara;
            prepararPara = con.conectando().prepareStatement(consulta);
            ResultSet resultados = null;
            prepararPara.setString(1, '%' + atendimento + '%');

            resultados = prepararPara.executeQuery();

            while (resultados.next()) {
                Locacoes atend = new Locacoes();

                atend.setIdLocacao(resultados.getInt("id_locacoes"));
                atend.setNomeCliente(resultados.getString("nome_cliente"));
                atend.setTelefone(resultados.getString("telefone"));
                atend.setDtLocacao(resultados.getString("data_locacao"));
                atend.setDtDevolucao(resultados.getString("data_devolucao"));
                atend.setValor(resultados.getInt("valor_item"));
                atend.setIdGame(resultados.getInt("id_gamegame"));

                list.add(atend);

                System.out.println("buscou no banco");
            }

        } catch (Exception e) {
            System.out.println("Erro - " + e.getMessage());
        }

        return list;
    }

    public static void excluirLocacao(int id) throws SQLException, Exception {

        ConexaoComBanco con = new ConexaoComBanco();
        PreparedStatement verCod = null;

        try {

            String consulta = ("delete from locacoes where id_locacao = ?;");

            verCod = con.conectando().prepareStatement(consulta);
            verCod.setInt(1, id);

            verCod.executeUpdate();

            JOptionPane.showMessageDialog(null, "Locacao " + id + " excluída!");

        } catch (SQLException e) {

            System.out.println("Erro ao excluir locacao: " + e);

        } finally {
            verCod.close();
            con.fecharConexaoComBanco();

        }
    }
}
