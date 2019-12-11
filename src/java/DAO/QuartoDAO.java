/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import static DAO.DAO.fecharConexao;
import Model.Quarto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

public class QuartoDAO {

    public static List<Quarto> obterQuartos() throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        List<Quarto> quartos = new ArrayList<>();
        Quarto quarto = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from quarto");
            while (rs.next()) {
                quarto = instanciarQuarto(rs);
                quartos.add(quarto);
            }
        } finally {
            DAO.fecharConexao(conexao, comando);
        }
        return quartos;
    }

    public static Quarto obterQuarto(int codQuarto) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        Quarto quarto = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from quarto where identificacao = " + codQuarto);
            rs.first();
            quarto = instanciarQuarto(rs);
        } finally {
            DAO.fecharConexao(conexao, comando);
        }
        return quarto;
    }

    public static Quarto instanciarQuarto(ResultSet rs) throws ClassNotFoundException, SQLException {
        Quarto quarto = new Quarto(rs.getInt("identificacao"),
                rs.getInt("quantidadeCamasCasal"),
                rs.getInt("quantidadeCamasSolteiro"),
                null);
        quarto.setIdTipoQuarto(rs.getInt("idtipoQuarto"));
        return quarto;
    }

    public static void gravar(Quarto quarto) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.prepareStatement("insert into quarto (identificacao, quantidadeCamasCasal, quantidadeCamasSolteiro, idtipoQuarto) values (?,?,?,?)");
            comando.setInt(1, quarto.getIdentificacao());
            comando.setInt(2, quarto.getQuantidadeCamasCasal());
            comando.setInt(3, quarto.getQuantidadeCamasSolteiro());
            if (quarto.getTipo() == null) {
                comando.setNull(4, Types.INTEGER);
            } else {
                comando.setInt(4, quarto.getTipo().getId());
            }
            comando.executeUpdate();
        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public static void excluir(Quarto quarto) throws ClassNotFoundException, SQLException {

        Connection conexao = null;
        Statement comando = null;
        String stringSQL;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "delete from Quarto where identificacao = " + quarto.getIdentificacao();
            comando.execute(stringSQL);
        } finally {
            fecharConexao(conexao, comando);
        }

    }

    public static void alterar(Quarto quarto) throws SQLException, ClassNotFoundException {

        Connection conexao = null;
        Statement comando = null;
        String stringSQL;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "update quarto set "
                    + "quantidadeCamasCasal = " + quarto.getQuantidadeCamasCasal() + ", "
                    + "quantidadeCamasSolteiro = " + quarto.getQuantidadeCamasSolteiro() + ", "
                    + "idtipoQuarto = ";
            if (quarto.getTipo() == null) {
                stringSQL = stringSQL + null;
            } else {
                stringSQL = stringSQL + quarto.getTipo().getId();
            }

            stringSQL = stringSQL + " where identificacao = " + quarto.getIdentificacao();
            comando.execute(stringSQL);
        } finally {
            fecharConexao(conexao, comando);
        }

    }

    public static List<Quarto> obterQuartosVagos(int tipoQuarto) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        List<Quarto> quartos = new ArrayList<>();
        Quarto quarto = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from quarto where idTipoQuarto = " + tipoQuarto);
            while (rs.next()) {
                quarto = instanciarQuarto(rs);
                quartos.add(quarto);
            }
        } finally {
            DAO.fecharConexao(conexao, comando);
        }
        return quartos;
    }
}
