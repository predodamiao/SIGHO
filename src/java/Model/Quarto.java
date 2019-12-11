package Model;

import DAO.QuartoDAO;
import java.sql.SQLException;
import java.util.List;

public class Quarto {

    private int identificacao;
    private int quantidadeCamasCasal;
    private int quantidadeCamasSolteiro;
    private TipoQuarto tipo;
    private int idTipoQuarto;

    public Quarto(int identificacao, int quantidadeCamasCasal, int quantidadeCamasSolteiro, TipoQuarto tipo) {
        this.identificacao = identificacao;
        this.quantidadeCamasCasal = quantidadeCamasCasal;
        this.quantidadeCamasSolteiro = quantidadeCamasSolteiro;
        this.tipo = tipo;
    }

    public static Quarto obterQuarto(int codQuarto) throws ClassNotFoundException, SQLException {
        return QuartoDAO.obterQuarto(codQuarto);
    }

    public static List<Quarto> obterQuartos() throws ClassNotFoundException, SQLException {
        return QuartoDAO.obterQuartos();
    }

    public static List<Quarto> obterQuartosVagos(int tipoQuarto) throws ClassNotFoundException, SQLException {
        return QuartoDAO.obterQuartosVagos(tipoQuarto);
    }

    public int getIdentificacao() {
        return identificacao;
    }

    public void setIdentificacao(int identificacao) {
        this.identificacao = identificacao;
    }

    public int getQuantidadeCamasCasal() {
        return quantidadeCamasCasal;
    }

    public void setQuantidadeCamasCasal(int quantidadeCamasCasal) {
        this.quantidadeCamasCasal = quantidadeCamasCasal;
    }

    public int getQuantidadeCamasSolteiro() {
        return quantidadeCamasSolteiro;
    }

    public void setQuantidadeCamasSolteiro(int quantidadeCamasSolteiro) {
        this.quantidadeCamasSolteiro = quantidadeCamasSolteiro;
    }

    public TipoQuarto getTipo() throws ClassNotFoundException, SQLException {
        if ((this.idTipoQuarto != 0) && (this.tipo == null)) {
            this.tipo = TipoQuarto.obterTipoQuarto(this.idTipoQuarto);
        }

        return tipo;
    }

    public void setTipo(TipoQuarto tipo) {
        this.tipo = tipo;
    }

    public int getIdTipoQuarto() {
        return idTipoQuarto;
    }

    public void setIdTipoQuarto(int idTipoQuarto) {
        this.idTipoQuarto = idTipoQuarto;
    }

    public void gravar() throws SQLException, ClassNotFoundException {
        QuartoDAO.gravar(this);
    }

    public void excluir() throws SQLException, ClassNotFoundException {
        QuartoDAO.excluir(this);
    }

    public void alterar() throws SQLException, ClassNotFoundException {
        QuartoDAO.alterar(this);
    }

}
