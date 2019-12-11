package Model;

import DAO.AtendimentoRestauranteDAO;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

public class AtendimentoRestaurante {

    private int id;
    private LocalDate data;
    private LocalTime hora;
    private int quantidade;
    private StatusAtendimentoRestaurante status;
    private Funcionario funcionarioSolicitante;
    private Hospedagem hospedagem;
    private OpcaoRestaurante opcao;
    private int idFuncionarioSolicitante;
    private int idHospedagem;
    private int idOpcao;

    public AtendimentoRestaurante(int id, LocalDate data, LocalTime hora, int quantidade, StatusAtendimentoRestaurante status, Funcionario funcionario, Hospedagem hospedagem, OpcaoRestaurante opcao) {
        this.id = id;
        this.data = data;
        this.hora = hora;
        this.quantidade = quantidade;
        this.status = status;
        this.funcionarioSolicitante = funcionario;
        this.hospedagem = hospedagem;
        this.opcao = opcao;
    }

    public static AtendimentoRestaurante obterAtendimentoRestaurante(int codSolicitacao) throws ClassNotFoundException, SQLException {
        return AtendimentoRestauranteDAO.obterAtendimentoRestaurante(codSolicitacao);
    }

    public static List<AtendimentoRestaurante> obterAtendimentosRestaurante() throws ClassNotFoundException, SQLException {
        return AtendimentoRestauranteDAO.obterAtendimentosRestaurante();
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

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public StatusAtendimentoRestaurante getStatus() {
        return status;
    }

    public void setStatus(StatusAtendimentoRestaurante status) {
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

    public OpcaoRestaurante getOpcao() throws ClassNotFoundException, SQLException {
        if ((this.idOpcao != 0) && (this.opcao == null)) {
            this.opcao = OpcaoRestaurante.obterOpcaoRestaurante(this.idOpcao);
        }

        return opcao;
    }

    public void setOpcao(OpcaoRestaurante opcao) {
        this.opcao = opcao;
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

    public int getIdOpcao() {
        return idOpcao;
    }

    public void setIdOpcao(int idOpcao) {
        this.idOpcao = idOpcao;
    }

    public float getPrecoAtendimento() throws ClassNotFoundException, SQLException {
        
        if(this.funcionarioSolicitante != null){
            return (this.getOpcao().getPreco()+this.getOpcao().getAcrescimo()) * this.getQuantidade();
        }
        
        return this.getOpcao().getPreco() * this.getQuantidade();  
    }

    public void gravar() throws SQLException, ClassNotFoundException {
        AtendimentoRestauranteDAO.gravar(this);
    }

    public void excluir() throws SQLException, ClassNotFoundException {
        AtendimentoRestauranteDAO.excluir(this);
    }

    public void alterar() throws SQLException, ClassNotFoundException {
        AtendimentoRestauranteDAO.alterar(this);
    }

}
