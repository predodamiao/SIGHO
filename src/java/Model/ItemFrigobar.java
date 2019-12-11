package Model;

import DAO.ItemFrigobarDAO;
import java.sql.SQLException;
import java.util.List;

public class ItemFrigobar {

    private int id;
    private int quantidade;
    private ItemConsumo item;
    private int idItemConsumo;

    public ItemFrigobar(int id, int quantidade, ItemConsumo item) {
        this.id = id;
        this.quantidade = quantidade;
        this.item = item;
    }

    public static ItemFrigobar obterItemFrigobar(int codItem) throws ClassNotFoundException, SQLException {
        return ItemFrigobarDAO.obterItensPadraoFrigobar(codItem);
    }

    public static List<ItemFrigobar> obterItensFrigobar() throws ClassNotFoundException, SQLException {
        return ItemFrigobarDAO.obterItensPadraoFrigobar();
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public ItemConsumo getItem() throws ClassNotFoundException, SQLException {
        if ((this.idItemConsumo != 0) && (this.item == null)) {
            this.item = ItemConsumo.obterItemConsumo(this.idItemConsumo);
        }

        return item;
    }

    public void setItem(ItemConsumo item) {
        this.item = item;
    }

    public int getIdItemConsumo() {
        return idItemConsumo;
    }

    public void setIdItemConsumo(int idItemConsumo) {
        this.idItemConsumo = idItemConsumo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void gravar() throws SQLException, ClassNotFoundException {
        ItemFrigobarDAO.gravar(this);
    }

    public void excluir() throws SQLException, ClassNotFoundException {
        ItemFrigobarDAO.excluir(this);
    }

    public void alterar() throws SQLException, ClassNotFoundException {
        ItemFrigobarDAO.alterar(this);
    }

}
