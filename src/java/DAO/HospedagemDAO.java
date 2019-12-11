/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import static DAO.DAO.fecharConexao;
import Model.Hospedagem;
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

public class HospedagemDAO {

    public static List<Hospedagem> obterHospedagens() throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        List<Hospedagem> hospedagens = new ArrayList<>();
        Hospedagem hospedagem = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from hospedagem");
            while (rs.next()) {
                hospedagem = instanciarHospedagem(rs);
                hospedagens.add(hospedagem);
            }
        } finally {
            DAO.fecharConexao(conexao, comando);
        }
        return hospedagens;
    }

    public static Hospedagem obterHospedagem(int codHospedagem) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        Hospedagem hospedagem = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from hospedagem where id = " + codHospedagem);
            rs.first();
            hospedagem = instanciarHospedagem(rs);
        } finally {
            DAO.fecharConexao(conexao, comando);
        }
        return hospedagem;
    }

    public static Hospedagem instanciarHospedagem(ResultSet rs) throws ClassNotFoundException, SQLException {
        Hospedagem hospedagem = new Hospedagem(rs.getInt("id"),
                rs.getObject("dataChegada", LocalDate.class),
                rs.getObject("horaChegada", LocalTime.class),
                rs.getObject("dataSaida", LocalDate.class),
                rs.getObject("horaSaida", LocalTime.class),
                null,
                null);
        hospedagem.setIdQuarto(rs.getInt("idquarto"));
        hospedagem.setIdHospedeResponsavel(rs.getInt("idhospedeResponsavel"));
        return hospedagem;
    }

    public static void gravar(Hospedagem hospedagem) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.prepareStatement("insert into hospedagem (id, dataChegada, horaChegada, idquarto, idhospedeResponsavel) values (?,?,?,?,?)");
            comando.setInt(1, hospedagem.getId());
            comando.setObject(2, hospedagem.getDataChegada());
            comando.setObject(3, hospedagem.getHoraChegada(), JDBCType.TIME);
            if (hospedagem.getQuarto() == null) {
                comando.setNull(4, Types.INTEGER);
            } else {
                comando.setInt(4, hospedagem.getQuarto().getIdentificacao());
            }
            if (hospedagem.getHospedeResponsavel() == null) {
                comando.setNull(5, Types.INTEGER);
            } else {
                comando.setInt(5, hospedagem.getHospedeResponsavel().getId());
            }
            comando.executeUpdate();
        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public static void excluir(Hospedagem hospedagem) throws ClassNotFoundException, SQLException {

        Connection conexao = null;
        Statement comando = null;
        String stringSQL;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "delete from Hospedagem where id = " + hospedagem.getId();
            comando.execute(stringSQL);
        } finally {
            fecharConexao(conexao, comando);
        }

    }

    public static void alterar(Hospedagem hospedagem) throws SQLException, ClassNotFoundException {

        Connection conexao = null;
        Statement comando = null;
        String stringSQL;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "update hospedagem set "
                    + "dataChegada = '" + hospedagem.getDataChegada() + "', "
                    + "horaChegada = '" + hospedagem.getHoraChegada() + "', "
                    + "dataSaida = '" + hospedagem.getDataSaida() + "', "
                    + "horaSaida = '" + hospedagem.getHoraSaida() + "', "
                    + "idhospedeResponsavel = ";
            if (hospedagem.getHospedeResponsavel() == null) {
                stringSQL = stringSQL + null;
            } else {
                stringSQL = stringSQL + hospedagem.getHospedeResponsavel().getId();
            }
            stringSQL = stringSQL + ", idquarto = ";
            if (hospedagem.getQuarto() == null) {
                stringSQL = stringSQL + null;
            } else {
                stringSQL = stringSQL + hospedagem.getQuarto().getIdentificacao();
            }

            stringSQL = stringSQL + " where id = " + hospedagem.getId();
            comando.execute(stringSQL);
        } finally {
            fecharConexao(conexao, comando);
        }

    }

    public static List<Hospedagem> obterHospedagensAtivas() throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        List<Hospedagem> hospedagens = new ArrayList<>();
        Hospedagem hospedagem = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from hospedagem where dataSaida is " + null);
            while (rs.next()) {
                hospedagem = instanciarHospedagem(rs);
                hospedagens.add(hospedagem);
            }
        } finally {
            DAO.fecharConexao(conexao, comando);
        }
        return hospedagens;
    }

    public static void checkout(Hospedagem hospedagem) throws ClassNotFoundException, SQLException {

        Connection conexao = null;
        Statement comando = null;
        String stringSQL;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "update hospedagem set "
                    + "dataSaida = '" + hospedagem.getDataChegada() + "', "
                    + "horaSaida = '" + hospedagem.getHoraChegada() + "' ";

            stringSQL = stringSQL + " where id = " + hospedagem.getId();
            comando.execute(stringSQL);
        } finally {
            fecharConexao(conexao, comando);
        }

    }

}
