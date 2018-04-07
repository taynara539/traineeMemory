/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locadoraDAO;

import conexao.ConexaoComBanco;
import java.awt.HeadlessException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import locadoraMODELO.Game;

/**
 *
 * @author Taynara Kris
 */
public class GameDAO {

    public static Game descricaoRecGameParam(Game idGame) throws Exception {

        ConexaoComBanco con = new ConexaoComBanco();
        PreparedStatement verCod = null;

        int a = idGame.getIdGenero();

        // String b = null;
        Game game = new Game();

        try {

            String consulta = ("SELECT g.descricao from genero g where g.id_genero = ?;");

            verCod = con.conectando().prepareStatement(consulta);
            verCod.setInt(1, a);

            ResultSet rs = verCod.executeQuery();
            while (rs.next()) {

                game.setIdGenero(rs.getInt("descricao"));

            }

        } catch (SQLException e) {

            System.out.println("Erro ao retornar descrição" + e);

        } finally {

            verCod.close();
            con.fecharConexaoComBanco();

        }

        return game;

    }

    public static Game retTabGamePeloId(String id) throws Exception {

        ConexaoComBanco con = new ConexaoComBanco();
        PreparedStatement verCod = null;

        Game pac = new Game();

        try {

            String consulta = ("SELECT * from game where id_game = ?;");

            verCod = con.conectando().prepareStatement(consulta);
            verCod.setString(1, id);

            ResultSet rs = verCod.executeQuery();
            while (rs.next()) {

                pac.setIdGame(rs.getInt("id_game"));
                pac.setTitulo(rs.getString("titulo"));
                pac.setSinopse(rs.getString("sinopse"));
                pac.setQtdeJogador(rs.getInt("qtde_jogador"));
                pac.setIdGenero(rs.getInt("id_genero"));
                pac.setSituacao(rs.getString("situacao"));

            }

        } catch (SQLException e) {
            System.out.println("Erro no select*from por ID do Game" + e);
        } finally {
            verCod.close();
            con.fecharConexaoComBanco();

        }

        return pac;

    }

    public static void updateGamePorIdGame(Game game) throws SQLException {
        ConexaoComBanco con = new ConexaoComBanco();
        PreparedStatement preparador = null;

        String atualizar = ("UPDATE game "
                + "SET titulo = ?, sinopse = ?,"
                + "qtde_jogador = ?, id_genero = ?, situacao = ? WHERE id_game = ?");

        try {

            preparador = con.conectando().prepareStatement(atualizar);

            preparador.setString(1, game.getTitulo());
            preparador.setString(2, game.getSinopse());
            preparador.setInt(3, game.getQtdeJogador());
            preparador.setInt(4, game.getIdGenero());
            preparador.setString(5, game.getSituacao());
            preparador.setInt(6, game.getIdGame());

            preparador.executeUpdate();

            JOptionPane.showMessageDialog(null, "Game alterado com sucesso!");

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Erro ao alterar Game " + e);

        }

    }

    public static List<Game> getAll() throws SQLException, Exception {

        ConexaoComBanco con = new ConexaoComBanco();
        PreparedStatement prepararPara = null;
        String consulta = "SELECT * FROM game";

        List<Game> lista = new ArrayList<Game>();

        try {

            prepararPara = con.conectando().prepareStatement(consulta);
            ResultSet resultados = prepararPara.executeQuery();

            while (resultados.next()) {

                Game game = new Game();

                game.setIdGame(resultados.getInt("id_game"));
                game.setTitulo(resultados.getString("titulo"));
                game.setQtdeJogador(resultados.getInt("qtde_jogador"));
                game.setIdGenero(resultados.getInt("id_genero"));
                game.setSinopse(resultados.getString("sinopse"));
                game.setSituacao(resultados.getString("situacao"));

                lista.add(game);

            }

        } catch (SQLException e) {

            System.out.println("Game nao encontrado.");
            JOptionPane.showMessageDialog(null, "Game nao encontrado. \n" + e);
        } finally {
            prepararPara.close();
            con.fecharConexaoComBanco();

        }

        return lista;

    }

    public static void incluirGame(Game game) throws SQLException, Exception {

        ConexaoComBanco con = new ConexaoComBanco();
        PreparedStatement prepararPara = null;

        try {

            Game novoGame = game;

            String inserir = ("INSERT INTO game (titulo, sinopse, qtde_jogador, id_genero, situacao) VALUES (?,?,?,?,?);");

            prepararPara = con.conectando().prepareStatement(inserir);

            prepararPara.setString(1, novoGame.getTitulo());
            prepararPara.setString(2, novoGame.getSinopse());
            prepararPara.setInt(3, novoGame.getQtdeJogador());
            prepararPara.setInt(4, novoGame.getIdGenero());
            prepararPara.setString(5, novoGame.getSituacao());
       
            prepararPara.executeUpdate();

            JOptionPane.showMessageDialog(null, "Game " + novoGame.getTitulo() + " criado com sucesso");

        } catch (HeadlessException | SQLException e) {

            JOptionPane.showInputDialog("Erro ao criar game: " + e.getMessage());

        } finally {

            prepararPara.close();
            con.fecharConexaoComBanco();

        }

    }

    public static List<Game> buscarGameporNome(String nome) {

        ConexaoComBanco con = new ConexaoComBanco();

        String consulta = ("select * from game where titulo like ?");

        List<Game> list = new ArrayList<Game>();

        try {
            PreparedStatement prepararPara;
            prepararPara = con.conectando().prepareStatement(consulta);
            ResultSet rs = null;

            prepararPara.setString(1, '%' + nome + '%');
            rs = prepararPara.executeQuery();

            while (rs.next()) {

                Game pac = new Game();

                pac.setIdGame(rs.getInt("id_game"));
                pac.setTitulo(rs.getString("titulo"));
                pac.setSinopse(rs.getString("sinopse"));
                pac.setQtdeJogador(rs.getInt("qtde_jogador"));
                pac.setIdGenero(rs.getInt("id_genero"));
                pac.setSituacao(rs.getString("situacao"));

                list.add(pac);

            }

        } catch (Exception e) {
            System.out.println("Erro ao buscar game por nome! " + e.getMessage());
        }

        return list;
    }

    public static int idGame(String id) throws Exception {
        String s = null;
        int x = 0;

        ConexaoComBanco con = new ConexaoComBanco();
        PreparedStatement verCod = null;

        String consulta = ("select g.id_game from game g where g.titulo = ?;");

        try {
            verCod = con.conectando().prepareStatement(consulta);

            verCod.setString(1, id);

            ResultSet rs = verCod.executeQuery();
            while (rs.next()) {

                x = rs.getInt("id_game");

            }

        } catch (Exception e) {

        } finally {

            verCod.close();
            con.fecharConexaoComBanco();
        }

        return x;
    }

    public static void excluirGame(int id) throws SQLException, Exception {

        ConexaoComBanco con = new ConexaoComBanco();
        PreparedStatement verCod = null;

        try {

            String consulta = ("delete from game where id_game = ?;");

            verCod = con.conectando().prepareStatement(consulta);
            verCod.setInt(1, id);

            verCod.executeUpdate();

            JOptionPane.showMessageDialog(null, "Game excluído!");

        } catch (SQLException e) {

            System.out.println("Erro ao excluir locacao: " + e);

        } finally {
            verCod.close();
            con.fecharConexaoComBanco();

        }
    }

}
