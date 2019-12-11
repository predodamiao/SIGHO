package Model;

import DAO.ItemConsumoDAO;
import java.sql.SQLException;
import java.util.List;

public class ItemConsumo {

    private int codigo;
    private String nome;
    private String descricao;
    private float precoVenda;

    public ItemConsumo(int codigo, String nome, String descricao, float precoVenda) {
        this.codigo = codigo;
        this.nome = nome;
        this.descricao = descricao;
        this.precoVenda = precoVenda;
    }

    public static ItemConsumo obterItemConsumo(int codItemConsumo) throws ClassNotFoundException, SQLException {
        return ItemConsumoDAO.obterItemConsumo(codItemConsumo);
    }

    public static List<ItemConsumo> obterItensConsumo() throws ClassNotFoundException, SQLException {
        return ItemConsumoDAO.obterItensConsumo();
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(float precoVenda) {
        this.precoVenda = precoVenda;
    }

    public void gravar() throws SQLException, ClassNotFoundException {
        ItemConsumoDAO.gravar(this);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void excluir() throws SQLException, ClassNotFoundException {
        ItemConsumoDAO.excluir(this);
    }

    public void alterar() throws SQLException, ClassNotFoundException {
        ItemConsumoDAO.alterar(this);
    }

}
