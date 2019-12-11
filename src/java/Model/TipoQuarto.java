package Model;

import DAO.TipoQuartoDAO;
import java.sql.SQLException;
import java.util.List;

public class TipoQuarto {

    private int id;
    private String nome;
    private String descricao;
    private float diaria;

    public TipoQuarto(int id, String nome, String descricao, float diaria) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.diaria = diaria;
    }

    public static TipoQuarto obterTipoQuarto(int codTipoQuarto) throws ClassNotFoundException, SQLException {
        return TipoQuartoDAO.obterTipoQuarto(codTipoQuarto);
    }

    public static List<TipoQuarto> obterTiposQuarto() throws ClassNotFoundException, SQLException {
        return TipoQuartoDAO.obterTiposQuarto();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getDiaria() {
        return diaria;
    }

    public void setDiaria(float diaria) {
        this.diaria = diaria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void gravar() throws SQLException, ClassNotFoundException {
        TipoQuartoDAO.gravar(this);
    }

    public void excluir() throws SQLException, ClassNotFoundException {
        TipoQuartoDAO.excluir(this);
    }

    public void alterar() throws SQLException, ClassNotFoundException {
        TipoQuartoDAO.alterar(this);
    }

}
