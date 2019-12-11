/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import static DAO.DAO.fecharConexao;
import Model.Hospede;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class HospedeDAO {

    public static List<Hospede> obterHospedes() throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        List<Hospede> hospedes = new ArrayList<>();
        Hospede hospede = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from hospede");
            while (rs.next()) {
                hospede = instanciarHospede(rs);
                hospedes.add(hospede);
            }
        } finally {
            DAO.fecharConexao(conexao, comando);
        }
        return hospedes;
    }

    public static Hospede obterHospede(int codHospede) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        Hospede hospede = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from hospede where id = " + codHospede);
            rs.first();
            hospede = instanciarHospede(rs);
        } finally {
            DAO.fecharConexao(conexao, comando);
        }
        return hospede;
    }

    public static Hospede instanciarHospede(ResultSet rs) throws ClassNotFoundException, SQLException {
        Hospede hospede = new Hospede(rs.getInt("id"),
                rs.getString("nome"),
                rs.getString("telefone"),
                rs.getString("email"),
                rs.getString("rg"),
                rs.getString("cpf"),
                rs.getDate("dataNascimento"),
                rs.getString("passaporte"));
        return hospede;
    }

    public static void gravar(Hospede hospede) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.prepareStatement("insert into hospede (id, nome, telefone, email, rg, cpf, dataNascimento, passaporte) values (?,?,?,?,?,?,?,?)");
            comando.setInt(1, hospede.getId());
            comando.setString(2, hospede.getNome());
            comando.setString(3, hospede.getTelefone());
            comando.setString(4, hospede.getEmail());
            comando.setString(5, hospede.getRg());
            comando.setString(6, hospede.getCpf());
            comando.setDate(7, new java.sql.Date(hospede.getDataNascimento().getTime()));
            comando.setString(8, hospede.getPassaporte());
            comando.executeUpdate();
        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public static void excluir(Hospede hospede) throws ClassNotFoundException, SQLException {

        Connection conexao = null;
        Statement comando = null;
        String stringSQL;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "delete from Hospede where id = " + hospede.getId();
            comando.execute(stringSQL);
        } finally {
            fecharConexao(conexao, comando);
        }

    }

    public static void alterar(Hospede hospede) throws SQLException, ClassNotFoundException {

        Connection conexao = null;
        Statement comando = null;
        String stringSQL;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "update hospede set "
                    + "nome = '" + hospede.getNome() + "', "
                    + "telefone = '" + hospede.getTelefone() + "', "
                    + "email = '" + hospede.getEmail() + "', "
                    + "rg = '" + hospede.getRg() + "', "
                    + "cpf = " + hospede.getCpf() + ", "
                    + "dataNascimento = '" + new java.sql.Date(hospede.getDataNascimento().getTime()) + "', "
                    + "passaporte = '" + hospede.getPassaporte() + "'";

            stringSQL = stringSQL + " where id = " + hospede.getId();
            comando.execute(stringSQL);
        } finally {
            fecharConexao(conexao, comando);
        }

    }

}
