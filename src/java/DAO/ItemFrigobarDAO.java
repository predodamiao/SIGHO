/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import static DAO.DAO.fecharConexao;
import Model.ItemFrigobar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

public class ItemFrigobarDAO {

    public static List<ItemFrigobar> obterItensPadraoFrigobar() throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        List<ItemFrigobar> itensPadroesFrigobar = new ArrayList<>();
        ItemFrigobar itensPadraoFrigobar = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from itemFrigobar");
            while (rs.next()) {
                itensPadraoFrigobar = instanciarItemPadraoFrigobar(rs);
                itensPadroesFrigobar.add(itensPadraoFrigobar);
            }
        } finally {
            DAO.fecharConexao(conexao, comando);
        }
        return itensPadroesFrigobar;
    }

    public static ItemFrigobar obterItensPadraoFrigobar(int codItem) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        ItemFrigobar item = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from ItemFrigobar where id = " + codItem);
            rs.first();
            item = instanciarItemPadraoFrigobar(rs);
        } finally {
            DAO.fecharConexao(conexao, comando);
        }
        return item;
    }

    public static ItemFrigobar instanciarItemPadraoFrigobar(ResultSet rs) throws ClassNotFoundException, SQLException {
        ItemFrigobar item = new ItemFrigobar(rs.getInt("id"),
                rs.getInt("quantidade"),
                null);

        item.setIdItemConsumo(rs.getInt("idItemConsumo"));
        return item;
    }

    public static void gravar(ItemFrigobar item) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.prepareStatement("insert into itemFrigobar (id, quantidade, idItemConsumo) values (?,?,?)");
            comando.setInt(1, item.getId());
            comando.setInt(2, item.getQuantidade());

            if (item.getItem() == null) {
                comando.setNull(3, Types.INTEGER);
            } else {
                comando.setInt(3, item.getItem().getCodigo());
            }
            comando.executeUpdate();
        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public static void excluir(ItemFrigobar item) throws ClassNotFoundException, SQLException {

        Connection conexao = null;
        Statement comando = null;
        String stringSQL;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "delete from itemFrigobar where id = " + item.getId();
            comando.execute(stringSQL);
        } finally {
            fecharConexao(conexao, comando);
        }

    }

    public static void alterar(ItemFrigobar item) throws SQLException, ClassNotFoundException {

        Connection conexao = null;
        Statement comando = null;
        String stringSQL;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "update itemfrigobar set "
                    + "quantidade = " + item.getQuantidade() + ", "
                    + "idItemConsumo = ";
            if (item.getItem() == null) {
                stringSQL = stringSQL + null;
            } else {
                stringSQL = stringSQL + item.getItem().getCodigo();
            }

            stringSQL = stringSQL + " where id = " + item.getId();
            comando.execute(stringSQL);
        } finally {
            fecharConexao(conexao, comando);
        }

    }

}
