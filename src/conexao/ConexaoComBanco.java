package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoComBanco {

    private String STRING_CONEXAO = "jdbc:mysql://localhost:3306/locadora?user=root"; 
    //private String STRING_CONEXAO = "jdbc:mysql://localhost:3306/locadora?useSSL=false";
    private String USUARIO_CONEXAO = "root";
    private String SENHA_CONEXAO = "123456";

    private Connection conectar;

    public ConexaoComBanco() {
        try {
            conectar = DriverManager.getConnection(STRING_CONEXAO, USUARIO_CONEXAO, SENHA_CONEXAO);
        } catch (SQLException e) {
            System.out.println("Erro ao conectar com o banco... Verifique " + e + " e tente novamente!");
        }
    }

    public void fecharConexaoComBanco() throws Exception {
        try {
            conectar.close();
        } catch (SQLException e) {
            System.out.println("Erro ao fechar o banco... Verififique " + e + " e tente novamente!");
        }
    }

    public Connection conectando() {
        return conectar;
    }

}
