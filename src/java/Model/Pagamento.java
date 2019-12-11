package Model;

import DAO.PagamentoDAO;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class Pagamento {

    private int id;
    private float valor;
    private LocalDate data;
    private LocalTime hora;
    private int quantidadeParcelas;
    private TipoPagamento tipo;
    private MomentoPagamento momento;
    private Hospedagem hospedagem;
    private int idHospedagem;

    public Pagamento(int id, float valor, LocalDate data, LocalTime hora, int parcelas, TipoPagamento tipo, MomentoPagamento momento, Hospedagem hospedagem) {
        this.id = id;
        this.valor = valor;
        this.data = data;
        this.hora = hora;
        this.quantidadeParcelas = parcelas;
        this.tipo = tipo;
        this.momento = momento;
        this.hospedagem = hospedagem;
    }

    public static Pagamento obterPagamento(int codPagamento) throws ClassNotFoundException, SQLException {
        return PagamentoDAO.obterPagamento(codPagamento);
    }

    public static List<Pagamento> obterPagamentos() throws ClassNotFoundException, SQLException {
        return PagamentoDAO.obterPagamentos();
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public int getQuantidadeParcelas() {
        return quantidadeParcelas;
    }

    public void setQuantidadeParcelas(int quantidadeParcelas) {
        this.quantidadeParcelas = quantidadeParcelas;
    }

    public TipoPagamento getTipo() {
        return tipo;
    }

    public void setTipo(TipoPagamento tipo) {
        this.tipo = tipo;
    }

    public MomentoPagamento getMomento() {
        return momento;
    }

    public void setMomento(MomentoPagamento momento) {
        this.momento = momento;
    }

    public Hospedagem getHospedagem() throws ClassNotFoundException, SQLException {
        if ((this.idHospedagem != 0) && (this.hospedagem == null)) {
            this.hospedagem = Hospedagem.obterHospedagem(this.idHospedagem);
        }

        return hospedagem;
    }

    public void setHospedagem(Hospedagem hospedagem) {
        this.hospedagem = hospedagem;
    }

    public int getIdHospedagem() {
        return idHospedagem;
    }

    public void setIdHospedagem(int idHospedagem) {
        this.idHospedagem = idHospedagem;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void gravar() throws SQLException, ClassNotFoundException {
        PagamentoDAO.gravar(this);
    }

    public void excluir() throws SQLException, ClassNotFoundException {
        PagamentoDAO.excluir(this);
    }

    public void alterar() throws SQLException, ClassNotFoundException {
        PagamentoDAO.alterar(this);
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

}
