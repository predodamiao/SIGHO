package Model;

import DAO.OpcaoRestauranteDAO;
import java.sql.SQLException;
import java.util.List;

public class OpcaoRestaurante {

    private int codigo;
    private String nome;
    private String descricao;
    private float preco;
    private float acrescimo;
    private int tempoPreparo;

    public OpcaoRestaurante(int codigo, String nome, String descricao, float preco, float acrescimo, int tempoPreparo) {
        this.codigo = codigo;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.acrescimo = acrescimo;
        this.tempoPreparo = tempoPreparo;
    }

    public static OpcaoRestaurante obterOpcaoRestaurante(int codItem) throws ClassNotFoundException, SQLException {
        return OpcaoRestauranteDAO.obterOpcaoRestaurante(codItem);
    }

    public static List<OpcaoRestaurante> obterOpcoesRestaurante() throws ClassNotFoundException, SQLException {
        return OpcaoRestauranteDAO.obterOpcoesRestaurante();
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

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getAcrescimo() {
        return acrescimo;
    }

    public void setAcrescimo(float acrescimo) {
        this.acrescimo = acrescimo;
    }

    public int getTempoPreparo() {
        return tempoPreparo;
    }

    public void setTempoPreparo(int tempoPreparo) {
        this.tempoPreparo = tempoPreparo;
    }

    public void gravar() throws SQLException, ClassNotFoundException {
        OpcaoRestauranteDAO.gravar(this);
    }

    public void excluir() throws SQLException, ClassNotFoundException {
        OpcaoRestauranteDAO.excluir(this);
    }

    public void alterar() throws SQLException, ClassNotFoundException {
        OpcaoRestauranteDAO.alterar(this);
    }

}
