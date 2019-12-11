package Model;

import DAO.AtendimentoRestauranteDAO;
import DAO.ConsumoDAO;
import DAO.HospedagemDAO;
import DAO.PagamentoDAO;
import DAO.PrestacaoServicoDAO;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

public class Hospedagem {

    private int id;
    private LocalDate dataChegada;
    private LocalTime horaChegada;
    private LocalDate dataSaida;
    private LocalTime horaSaida;
    private Quarto quarto;
    private Hospede hospedeResponsavel;
    private int idQuarto;
    private int idHospedeResponsavel;

    public Hospedagem(int id, LocalDate dataChegada, LocalTime horaChegada, LocalDate dataSaida, LocalTime horaSaida, Quarto quarto, Hospede hospedeResponsavel) {
        this.id = id;
        this.dataChegada = dataChegada;
        this.horaChegada = horaChegada;
        this.dataSaida = dataSaida;
        this.horaSaida = horaSaida;
        this.quarto = quarto;
        this.hospedeResponsavel = hospedeResponsavel;
    }

    public Hospedagem(Hospede hospedeResponsavel) {
        this.hospedeResponsavel = hospedeResponsavel;
    }

    public Hospedagem(int id, LocalDate dataSaida, LocalTime horaSaida) {
        this.id = id;
        this.dataSaida = dataSaida;
        this.horaSaida = horaSaida;
    }

    public static Hospedagem obterHospedagem(int codHospedagem) throws ClassNotFoundException, SQLException {
        return HospedagemDAO.obterHospedagem(codHospedagem);
    }

    public static List<Hospedagem> obterHospedagens() throws ClassNotFoundException, SQLException {
        return HospedagemDAO.obterHospedagens();
    }

    public static List<Hospedagem> obterHospedagensAtivas() throws ClassNotFoundException, SQLException {
        return HospedagemDAO.obterHospedagensAtivas();
    }

    public void checkout() throws ClassNotFoundException, SQLException {
        HospedagemDAO.checkout(this);
    }

    public List<Pagamento> obterPagamentos() throws ClassNotFoundException, SQLException {
        return PagamentoDAO.obterPagamentosHospede(this.id);
    }

    public List<PrestacaoServico> obterPrestacoesServico() throws ClassNotFoundException, SQLException {
        return PrestacaoServicoDAO.obterPrestacoesServicoHospede(this.id);
    }

    public List<Consumo> obterConsumos() throws ClassNotFoundException, SQLException {
        return ConsumoDAO.obterConsumosHospede(this.id);
    }

    public List<AtendimentoRestaurante> obterAtendimentosRestaurante() throws ClassNotFoundException, SQLException {
        return AtendimentoRestauranteDAO.obterAtendimentosRestauranteHospede(this.id);
    }

    public Quarto getQuarto() throws ClassNotFoundException, SQLException {
        if ((this.idQuarto != 0) && (this.quarto == null)) {
            this.quarto = Quarto.obterQuarto(this.idQuarto);
        }

        return quarto;
    }

    public void setQuarto(Quarto quarto) {
        this.quarto = quarto;
    }

    public Hospede getHospedeResponsavel() throws ClassNotFoundException, SQLException {
        if ((this.idHospedeResponsavel != 0) && (this.hospedeResponsavel == null)) {
            this.hospedeResponsavel = Hospede.obterHospede(this.idHospedeResponsavel);
        }

        return hospedeResponsavel;
    }

    public void setHospedeResponsavel(Hospede hospedeResponsavel) {
        this.hospedeResponsavel = hospedeResponsavel;
    }

    public int getIdQuarto() {
        return idQuarto;
    }

    public void setIdQuarto(int idQuarto) {
        this.idQuarto = idQuarto;
    }

    public int getIdHospedeResponsavel() {
        return idHospedeResponsavel;
    }

    public void setIdHospedeResponsavel(int idHospedeResponsavel) {
        this.idHospedeResponsavel = idHospedeResponsavel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void gravar() throws SQLException, ClassNotFoundException {
        HospedagemDAO.gravar(this);
    }

    public void excluir() throws SQLException, ClassNotFoundException {
        HospedagemDAO.excluir(this);
    }

    public void alterar() throws SQLException, ClassNotFoundException {
        HospedagemDAO.alterar(this);
    }

    public LocalDate getDataChegada() {
        return dataChegada;
    }

    public void setDataChegada(LocalDate dataChegada) {
        this.dataChegada = dataChegada;
    }

    public LocalTime getHoraChegada() {
        return horaChegada;
    }

    public void setHoraChegada(LocalTime horaChegada) {
        this.horaChegada = horaChegada;
    }

    public LocalDate getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(LocalDate dataSaida) {
        this.dataSaida = dataSaida;
    }

    public LocalTime getHoraSaida() {
        return horaSaida;
    }

    public void setHoraSaida(LocalTime horaSaida) {
        this.horaSaida = horaSaida;
    }

}
