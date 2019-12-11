package DAO;

import static DAO.DAO.fecharConexao;
import Model.CategoriaFuncionario;
import Model.Funcionario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDAO {

    public static List<Funcionario> obterFuncionarios() throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        List<Funcionario> funcionarios = new ArrayList<>();
        Funcionario funcionario = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from funcionario");
            while (rs.next()) {
                funcionario = instanciarFuncionario(rs);
                funcionarios.add(funcionario);
            }
        } finally {
            DAO.fecharConexao(conexao, comando);
        }
        return funcionarios;
    }

    public static Funcionario obterFuncionario(int codFuncionario) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        Funcionario funcionario = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from funcionario where id = " + codFuncionario);
            rs.first();
            funcionario = instanciarFuncionario(rs);
        } finally {
            DAO.fecharConexao(conexao, comando);
        }
        return funcionario;
    }

    public static Funcionario instanciarFuncionario(ResultSet rs) throws ClassNotFoundException, SQLException {
        Funcionario funcionario = new Funcionario(rs.getInt("id"),
                rs.getString("nome"),
                rs.getString("telefone"),
                rs.getString("email"),
                rs.getString("rg"),
                rs.getString("cpf"),
                rs.getDate("dataNascimento"),
                rs.getDate("dataAdmissao"),
                Enum.valueOf(CategoriaFuncionario.class, rs.getString("categoria")));
        return funcionario;
    }

    public static void gravar(Funcionario funcionario) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.prepareStatement("insert into funcionario (id, nome, telefone, email, rg, cpf, dataNascimento, dataAdmissao, categoria) values (?,?,?,?,?,?,?,?,?)");
            comando.setInt(1, funcionario.getId());
            comando.setString(2, funcionario.getNome());
            comando.setString(3, funcionario.getTelefone());
            comando.setString(4, funcionario.getEmail());
            comando.setString(5, funcionario.getRg());
            comando.setString(6, funcionario.getCpf());
            comando.setDate(7, new java.sql.Date(funcionario.getDataNascimento().getTime()));
            comando.setDate(8, new java.sql.Date(funcionario.getDataAdmissao().getTime()));
            comando.setString(9, funcionario.getCategoria().toString());
            comando.executeUpdate();
        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public static void excluir(Funcionario funcionario) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "delete from funcionario where id = " + funcionario.getId();
            comando.execute(stringSQL);
        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public static void alterar(Funcionario funcionario) throws SQLException, ClassNotFoundException {

        Connection conexao = null;
        Statement comando = null;
        String stringSQL;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "update funcionario set "
                    + "nome = '" + funcionario.getNome() + "', "
                    + "telefone = '" + funcionario.getTelefone() + "', "
                    + "email = '" + funcionario.getEmail() + "', "
                    + "rg = '" + funcionario.getRg() + "', "
                    + "cpf = " + funcionario.getCpf() + ", "
                    + "dataNascimento = '" + new java.sql.Date(funcionario.getDataNascimento().getTime()) + "', "
                    + "dataAdmissao = '" + new java.sql.Date(funcionario.getDataAdmissao().getTime()) + "', "
                    + "categoria = '";
            if (funcionario.getCategoria() == null) {
                stringSQL = stringSQL + null;
            } else {
                stringSQL = stringSQL + funcionario.getCategoria().toString() + "'";
            }

            stringSQL = stringSQL + " where id = " + funcionario.getId();
            comando.execute(stringSQL);
        } finally {
            fecharConexao(conexao, comando);
        }

    }

}
