package Model;

import DAO.PrestacaoServicoDAO;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

public class PrestacaoServico {

    private int id;
    private LocalDate data;
    private LocalTime hora;
    private StatusPrestacaoServico status;
    private Funcionario funcionarioSolicitante;
    private Hospedagem hospedagem;
    private Servico servico;
    private int idFuncionarioSolicitante;
    private int idHospedagem;
    private int idServico;

    public PrestacaoServico(int id, LocalDate data, LocalTime hora, StatusPrestacaoServico status, Funcionario funcionario, Hospedagem hospedagem, Servico servico) {
        this.id = id;
        this.data = data;
        this.hora = hora;
        this.status = status;
        this.funcionarioSolicitante = funcionario;
        this.hospedagem = hospedagem;
        this.servico = servico;
    }

    public static PrestacaoServico obterPrestacaoServico(int codSolicitacao) throws ClassNotFoundException, SQLException {
        return PrestacaoServicoDAO.obterPrestacaoServico(codSolicitacao);
    }

    public static List<PrestacaoServico> obterPrestacoesServico() throws ClassNotFoundException, SQLException {
        return PrestacaoServicoDAO.obterPrestacoesServico();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public StatusPrestacaoServico getStatus() {
        return status;
    }

    public void setStatus(StatusPrestacaoServico status) {
        this.status = status;
    }

    public Funcionario getFuncionarioSolicitante() throws ClassNotFoundException, SQLException {
        if ((this.idFuncionarioSolicitante != 0) && (this.funcionarioSolicitante == null)) {
            this.funcionarioSolicitante = Funcionario.obterFuncionario(this.idFuncionarioSolicitante);
        }
        return funcionarioSolicitante;
    }

    public void setFuncionarioSolicitante(Funcionario funcionarioSolicitante) {
        this.funcionarioSolicitante = funcionarioSolicitante;
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

    public Servico getServico() throws ClassNotFoundException, SQLException {
        if ((this.idServico != 0) && (this.servico == null)) {
            this.servico = Servico.obterServico(this.idServico);
        }

        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    public int getIdFuncionarioSolicitante() {
        return idFuncionarioSolicitante;
    }

    public void setIdFuncionarioSolicitante(int idFuncionarioSolicitante) {
        this.idFuncionarioSolicitante = idFuncionarioSolicitante;
    }

    public int getIdHospedagem() {
        return idHospedagem;
    }

    public void setIdHospedagem(int idHospedagem) {
        this.idHospedagem = idHospedagem;
    }

    public int getIdServico() {
        return idServico;
    }

    public void setIdServico(int idServico) {
        this.idServico = idServico;
    }

    public void gravar() throws SQLException, ClassNotFoundException {
        PrestacaoServicoDAO.gravar(this);
    }

    public void excluir() throws SQLException, ClassNotFoundException {
        PrestacaoServicoDAO.excluir(this);
    }

    public void alterar() throws SQLException, ClassNotFoundException {
        PrestacaoServicoDAO.alterar(this);
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

}
