package locadoraDAO;

import conexao.ConexaoComBanco;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import locadoraMODELO.Genero;

public class GeneroDAO {

    /**
     *
     * @author taynara
     */
    public static void incluir(String m) throws Exception {

        ConexaoComBanco con = new ConexaoComBanco();
        PreparedStatement prepararPara = null;

        try {

            String consulta = "INSERT INTO genero (descricao)"
                    + "VALUES (?)";

            prepararPara = con.conectando().prepareStatement(consulta);
            prepararPara.setString(1, m);
            prepararPara.execute();

            JOptionPane.showMessageDialog(null, "Gênero criado com sucesso!");

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Erro ao criar gênero!\n" + e);
        } finally {

            prepararPara.close();
            con.fecharConexaoComBanco();

        }

    }

    public static List<Genero> getAll() throws SQLException, Exception {

        ConexaoComBanco con = new ConexaoComBanco();
        PreparedStatement prepararPara = null;
        String consulta = "SELECT * FROM genero;";

        List<Genero> lista = new ArrayList<Genero>();

        try {

            prepararPara = con.conectando().prepareStatement(consulta);
            ResultSet resultados = prepararPara.executeQuery();

            while (resultados.next()) {

                Genero atend = new Genero();

                atend.setIdGenero(resultados.getInt("ID_GENERO"));
                atend.setDescricao(resultados.getString("DESCRICAO"));

                lista.add(atend);

            }

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "Erro ao buscar todos os gêneros. \n" + e);

        } finally {
            prepararPara.close();
            con.fecharConexaoComBanco();

        }

        return lista;

    }
    
      public static String descricaoGenero(int id) throws Exception {

        String s = null;

        ConexaoComBanco con = new ConexaoComBanco();
        PreparedStatement verCod = null;

        String consulta = ("select g.descricao from genero g where g.id_genero = ?;");

        try {
            verCod = con.conectando().prepareStatement(consulta);

            verCod.setInt(1, id);

            ResultSet rs = verCod.executeQuery();
            while (rs.next()) {

                s = rs.getString("descricao");

            }

        } catch (Exception e) {

            System.out.println("Erro ao retornar a descrição do Gênero " + e);

        } finally {

            verCod.close();
            con.fecharConexaoComBanco();
        }

        return s;
    }

    public static String todasDescGenero() throws Exception {
        String s = null;

        ConexaoComBanco con = new ConexaoComBanco();
        PreparedStatement verCod = null;

        String consulta = ("select g.descricao from genero;");

        try {
            verCod = con.conectando().prepareStatement(consulta);

            ResultSet rs = verCod.executeQuery();
            while (rs.next()) {

                s = rs.getString("descricao");
            }

        } catch (Exception e) {

            System.out.println("Erro ao retornar todas descrições de Gênero " + e);

        } finally {

            verCod.close();
            con.fecharConexaoComBanco();
        }

        return s;
    }

    public static int retornaIdGenero(String descricao) throws Exception {

        int id = 0;

        ConexaoComBanco con = new ConexaoComBanco();
        PreparedStatement verCod = null;

        String consulta = ("select g.id_genero from genero g WHERE g.descricao = ?;");

        try {
            verCod = con.conectando().prepareStatement(consulta);

            verCod.setString(1, descricao);

            ResultSet rs = verCod.executeQuery();
            while (rs.next()) {

                id = rs.getInt("id_genero");

            }

        } catch (Exception e) {

            System.out.println("Erro ao buscar a ID do Gênero " + e);

        } finally {

            verCod.close();
            con.fecharConexaoComBanco();
        }

        return id;
    }

    public static Genero retTabGeneroPeloId(String id) throws Exception {

        ConexaoComBanco con = new ConexaoComBanco();
        PreparedStatement verCod = null;

        Genero atend = new Genero();

        try {

            String consulta = ("select * from genero where id_genero = ?;");

            verCod = con.conectando().prepareStatement(consulta);
            verCod.setString(1, id);

            ResultSet rs = verCod.executeQuery();
            while (rs.next()) {

                atend.setDescricao(rs.getString("descricao"));
                atend.setIdGenero(rs.getInt("id_genero"));

            }

        } catch (SQLException e) {
            System.out.println("Erro: " + e);
        } finally {
            verCod.close();
            con.fecharConexaoComBanco();

        }

        return atend;

    }

    public static void updateGenero(Genero atend) throws Exception {

        ConexaoComBanco con = new ConexaoComBanco();
        PreparedStatement preparador = null;

        String atualizar = ("UPDATE genero "
                + "SET descricao = ?  WHERE id_genero = ?");

        try {
            preparador = con.conectando().prepareStatement(atualizar);

            preparador.setString(1, atend.getDescricao());
            preparador.setInt(2, atend.getIdGenero());

            preparador.executeUpdate();

            JOptionPane.showMessageDialog(null, "Gênero alterado com sucesso!");

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Erro ao alterar gênero " + e);

        }

    }

    public static void excluirGenero(int id) throws SQLException, Exception {

        ConexaoComBanco con = new ConexaoComBanco();
        PreparedStatement verCod = null;

        try {

            String consulta = ("delete from genero where id_genero = ?;");

            verCod = con.conectando().prepareStatement(consulta);
            verCod.setInt(1, id);

            verCod.executeUpdate();

            JOptionPane.showMessageDialog(null, "Gênero excluído!");

        } catch (SQLException e) {

            System.out.println("Erro ao excluir gênero: " + e);

        } finally {
            verCod.close();
            con.fecharConexaoComBanco();

        }
    }

    public static String buscaPorDescricao(String descricao) throws SQLException {

        String resultado = null;

        ConexaoComBanco con = new ConexaoComBanco();
        String consulta = ("select * from genero where descricao like ?");

        PreparedStatement prepararPara;
        prepararPara = con.conectando().prepareStatement(consulta);
        ResultSet resultados = null;
        prepararPara.setString(1, '%' + descricao + '%');

        resultados = prepararPara.executeQuery();

        while (resultados.next()) {
            Genero gen = new Genero();

            gen.setIdGenero(resultados.getInt("id_genero"));
            gen.setDescricao(resultados.getString("descricao"));
            resultado = resultados.getString("descricao");

        }

        return resultado;
    }
}
