/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import static DAO.DAO.fecharConexao;
import Model.PrestacaoServico;
import Model.StatusPrestacaoServico;
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

public class PrestacaoServicoDAO {

    public static List<PrestacaoServico> obterPrestacoesServico() throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        List<PrestacaoServico> prestacoes = new ArrayList<>();
        PrestacaoServico prestacao = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from prestacaoServico");
            while (rs.next()) {
                prestacao = instanciarPrestacaoServico(rs);
                prestacoes.add(prestacao);
            }
        } finally {
            DAO.fecharConexao(conexao, comando);
        }
        return prestacoes;
    }

    public static PrestacaoServico obterPrestacaoServico(int codPrestacao) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        PrestacaoServico solicitacao = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from prestacaoServico where id = " + codPrestacao);
            rs.first();
            solicitacao = instanciarPrestacaoServico(rs);
        } finally {
            DAO.fecharConexao(conexao, comando);
        }
        return solicitacao;
    }

    public static PrestacaoServico instanciarPrestacaoServico(ResultSet rs) throws ClassNotFoundException, SQLException {
        PrestacaoServico solicitacao = new PrestacaoServico(rs.getInt("id"),
                rs.getObject("data", LocalDate.class),
                rs.getObject("hora", LocalTime.class),
                Enum.valueOf(StatusPrestacaoServico.class, rs.getString("status")),
                null,
                null,
                null);
        solicitacao.setIdFuncionarioSolicitante(rs.getInt("idFuncionario"));
        solicitacao.setIdHospedagem(rs.getInt("idHospedagem"));
        solicitacao.setIdServico(rs.getInt("idServico"));
        return solicitacao;
    }

    public static void gravar(PrestacaoServico prestacao) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.prepareStatement("insert into prestacaoServico (id, data, hora, status, idFuncionario, idHospedagem, idServico) values (?,?,?,?,?,?,?)");
            comando.setInt(1, prestacao.getId());
            comando.setObject(2, prestacao.getData());
            comando.setObject(3, prestacao.getHora(), JDBCType.TIME);
            comando.setString(4, prestacao.getStatus().toString());
            if (prestacao.getFuncionarioSolicitante() == null) {
                comando.setNull(5, Types.INTEGER);
            } else {
                comando.setInt(5, prestacao.getFuncionarioSolicitante().getId());
            }
            if (prestacao.getHospedagem() == null) {
                comando.setNull(6, Types.INTEGER);
            } else {
                comando.setInt(6, prestacao.getHospedagem().getId());
            }
            if (prestacao.getServico() == null) {
                comando.setNull(7, Types.INTEGER);
            } else {
                comando.setInt(7, prestacao.getServico().getCodigo());
            }
            comando.executeUpdate();

        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public static void excluir(PrestacaoServico prestacao) throws ClassNotFoundException, SQLException {

        Connection conexao = null;
        Statement comando = null;
        String stringSQL;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "delete from prestacaoServico where id = " + prestacao.getId();
            comando.execute(stringSQL);
        } finally {
            fecharConexao(conexao, comando);
        }

    }

    public static void alterar(PrestacaoServico prestacao) throws SQLException, ClassNotFoundException {

        Connection conexao = null;
        Statement comando = null;
        String stringSQL;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "update prestacaoServico set "
                    + "data = '" + prestacao.getData() + "', "
                    + "hora = '" + prestacao.getHora() + "', "
                    + "status = '" + prestacao.getStatus().toString() + "' ";
            stringSQL = stringSQL + ", idFuncionario = ";
            if (prestacao.getFuncionarioSolicitante() == null) {
                stringSQL = stringSQL + null;
            } else {
                stringSQL = stringSQL + prestacao.getFuncionarioSolicitante().getId();
            }
            stringSQL = stringSQL + ", idHospedagem = ";
            if (prestacao.getHospedagem() == null) {
                stringSQL = stringSQL + null;
            } else {
                stringSQL = stringSQL + prestacao.getHospedagem().getId();
            }
            stringSQL = stringSQL + ", idServico = ";
            if (prestacao.getServico() == null) {
                stringSQL = stringSQL + null;
            } else {
                stringSQL = stringSQL + prestacao.getServico().getCodigo();
            }

            stringSQL = stringSQL + " where id = " + prestacao.getId();
            comando.execute(stringSQL);
        } finally {
            fecharConexao(conexao, comando);
        }

    }

    public static List<PrestacaoServico> obterPrestacoesServicoHospede(int id) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        List<PrestacaoServico> prestacoes = new ArrayList<>();
        PrestacaoServico prestacao = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from prestacaoServico where idHospedagem = " + id);
            while (rs.next()) {
                prestacao = instanciarPrestacaoServico(rs);
                prestacoes.add(prestacao);
            }
        } finally {
            DAO.fecharConexao(conexao, comando);
        }
        return prestacoes;
    }

}
