/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import static DAO.DAO.fecharConexao;
import Model.CategoriaServico;
import Model.Servico;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ServicoDAO {

    public static List<Servico> obterServicos() throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        List<Servico> servicos = new ArrayList<>();
        Servico servico = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from servico");
            while (rs.next()) {
                servico = instanciarServico(rs);
                servicos.add(servico);
            }
        } finally {
            DAO.fecharConexao(conexao, comando);
        }
        return servicos;
    }

    public static Servico obterServico(int codServico) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        Servico servico = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from servico where id = '" + codServico + "'");
            rs.first();
            servico = instanciarServico(rs);
        } finally {
            DAO.fecharConexao(conexao, comando);
        }
        return servico;
    }

    public static Servico instanciarServico(ResultSet rs) throws ClassNotFoundException, SQLException {
        Servico servico = new Servico(rs.getInt("id"),
                rs.getString("nome"),
                rs.getString("descricao"),
                rs.getFloat("preco"),
                Enum.valueOf(CategoriaServico.class, rs.getString("categoria")));
        return servico;
    }

    public static void gravar(Servico servico) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.prepareStatement("insert into servico (id, nome, descricao, preco, categoria) values (?,?,?,?,?)");
            comando.setInt(1, servico.getCodigo());
            comando.setString(2, servico.getNome());
            comando.setString(3, servico.getDescricao());
            comando.setFloat(4, servico.getPreco());
            comando.setString(5, servico.getCategoria().toString());
            comando.executeUpdate();
        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public static void excluir(Servico servico) throws ClassNotFoundException, SQLException {

        Connection conexao = null;
        Statement comando = null;
        String stringSQL;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "delete from Servico where id = " + servico.getCodigo();
            comando.execute(stringSQL);
        } finally {
            fecharConexao(conexao, comando);
        }

    }

    public static void alterar(Servico servico) throws SQLException, ClassNotFoundException {

        Connection conexao = null;
        Statement comando = null;
        String stringSQL;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "update servico set "
                    + "nome = '" + servico.getNome() + "', "
                    + "descricao = '" + servico.getDescricao() + "', "
                    + "preco = " + servico.getPreco() + ","
                    + "categoria = '" + servico.getCategoria().toString() + "'";

            stringSQL = stringSQL + " where id = " + servico.getCodigo();
            comando.execute(stringSQL);
        } finally {
            fecharConexao(conexao, comando);
        }

    }

}
