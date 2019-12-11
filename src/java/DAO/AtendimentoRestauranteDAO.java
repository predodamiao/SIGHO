/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import static DAO.DAO.fecharConexao;
import Model.AtendimentoRestaurante;
import Model.StatusAtendimentoRestaurante;
import java.sql.Connection;
import java.sql.JDBCType;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class AtendimentoRestauranteDAO {

    public static List<AtendimentoRestaurante> obterAtendimentosRestaurante() throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        List<AtendimentoRestaurante> atendimentos = new ArrayList<>();
        AtendimentoRestaurante atendimento = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from atendimentoRestaurante");
            while (rs.next()) {
                atendimento = instanciarAtendimentoRestaurante(rs);
                atendimentos.add(atendimento);
            }
        } finally {
            DAO.fecharConexao(conexao, comando);
        }
        return atendimentos;
    }

    public static AtendimentoRestaurante obterAtendimentoRestaurante(int codAtendimento) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        AtendimentoRestaurante atendimento = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from atendimentoRestaurante where id = " + codAtendimento);
            rs.first();
            atendimento = instanciarAtendimentoRestaurante(rs);
        } finally {
            DAO.fecharConexao(conexao, comando);
        }
        return atendimento;
    }

    public static AtendimentoRestaurante instanciarAtendimentoRestaurante(ResultSet rs) throws ClassNotFoundException, SQLException {
        AtendimentoRestaurante solicitacao = new AtendimentoRestaurante(rs.getInt("id"),
                rs.getObject("data", LocalDate.class),
                rs.getObject("hora", LocalTime.class),
                rs.getInt("quantidade"),
                Enum.valueOf(StatusAtendimentoRestaurante.class, rs.getString("status")),
                null,
                null,
                null);
        solicitacao.setIdOpcao(rs.getInt("idOpcaoRestaurante"));
        solicitacao.setIdFuncionarioSolicitante(rs.getInt("idFuncionario"));
        solicitacao.setIdHospedagem(rs.getInt("idHospedagem"));
        return solicitacao;
    }

    public static void gravar(AtendimentoRestaurante atendimento) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.prepareStatement("insert into atendimentoRestaurante (id, data, hora, quantidade, status, idFuncionario, idHospedagem, idOpcaoRestaurante) values (?,?,?,?,?,?,?,?)");
            comando.setInt(1, atendimento.getId());
            comando.setObject(2, atendimento.getData());
            comando.setObject(3, atendimento.getHora(), JDBCType.TIME);
            comando.setInt(4, atendimento.getQuantidade());
            comando.setString(5, atendimento.getStatus().toString());
            if (atendimento.getFuncionarioSolicitante() == null) {
                comando.setNull(6, Types.INTEGER);
            } else {
                comando.setInt(6, atendimento.getFuncionarioSolicitante().getId());
            }
            if (atendimento.getHospedagem() == null) {
                comando.setNull(7, Types.INTEGER);
            } else {
                comando.setInt(7, atendimento.getHospedagem().getId());
            }
            if (atendimento.getOpcao() == null) {
                comando.setNull(8, Types.INTEGER);
            } else {
                comando.setInt(8, atendimento.getOpcao().getCodigo());
            }
            comando.executeUpdate();

        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public static void excluir(AtendimentoRestaurante atendimento) throws ClassNotFoundException, SQLException {

        Connection conexao = null;
        Statement comando = null;
        String stringSQL;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "delete from atendimentoRestaurante where id = " + atendimento.getId();
            comando.execute(stringSQL);
        } finally {
            fecharConexao(conexao, comando);
        }

    }

    public static void alterar(AtendimentoRestaurante atendimento) throws SQLException, ClassNotFoundException {

        Connection conexao = null;
        Statement comando = null;
        String stringSQL;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "update atendimentoRestaurante set "
                    + "data = '" + atendimento.getData() + "', "
                    + "hora = '" + atendimento.getHora() + "', "
                    + "quantidade = " + atendimento.getQuantidade() + ", "
                    + "status = '" + atendimento.getStatus().toString() + "' ";
            stringSQL = stringSQL + ", idFuncionario = ";
            if (atendimento.getFuncionarioSolicitante() == null) {
                stringSQL = stringSQL + null;
            } else {
                stringSQL = stringSQL + atendimento.getFuncionarioSolicitante().getId();
            }
            stringSQL = stringSQL + ", idHospedagem = ";
            if (atendimento.getHospedagem() == null) {
                stringSQL = stringSQL + null;
            } else {
                stringSQL = stringSQL + atendimento.getHospedagem().getId();
            }
            stringSQL = stringSQL + ", idOpcaoRestaurante = ";
            if (atendimento.getOpcao() == null) {
                stringSQL = stringSQL + null;
            } else {
                stringSQL = stringSQL + atendimento.getOpcao().getCodigo();
            }

            stringSQL = stringSQL + " where id = " + atendimento.getId();
            comando.execute(stringSQL);
        } finally {
            fecharConexao(conexao, comando);
        }

    }

    public static List<AtendimentoRestaurante> obterAtendimentosRestauranteHospede(int id) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        List<AtendimentoRestaurante> atendimentos = new ArrayList<>();
        AtendimentoRestaurante atendimento = null;
        try {

            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from atendimentoRestaurante where idHospedagem = " + id);
            while (rs.next()) {
                atendimento = instanciarAtendimentoRestaurante(rs);
                atendimentos.add(atendimento);
            }
        } finally {
            DAO.fecharConexao(conexao, comando);
        }
        return atendimentos;
    }

}
