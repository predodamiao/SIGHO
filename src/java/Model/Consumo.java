package Model;

import DAO.ConsumoDAO;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class Consumo {

    private int id;
    private LocalDate data;
    private LocalTime hora;
    private int quantidade;
    private Funcionario funcionarioSolicitante;
    private Hospedagem hospedagem;
    private ItemConsumo itemConsumido;

    private int idFuncionario;
    private int idHospedagem;
    private int idItemConsumido;

    public Consumo(int id, LocalDate data, LocalTime hora, int quantidade, Funcionario funcionarioSolicitante, Hospedagem hospedagem, ItemConsumo itemConsumido) {
        this.id = id;
        this.data = data;
        this.hora = hora;
        this.quantidade = quantidade;
        this.funcionarioSolicitante = funcionarioSolicitante;
        this.hospedagem = hospedagem;
        this.itemConsumido = itemConsumido;
    }

    public static Consumo obterConsumo(int codConsumo) throws ClassNotFoundException, SQLException {
        return ConsumoDAO.obterConsumo(codConsumo);
    }

    public static List<Consumo> obterConsumos() throws ClassNotFoundException, SQLException {
        return ConsumoDAO.obterConsumos();
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

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Funcionario getFuncionarioSolicitante() throws ClassNotFoundException, SQLException {
        if ((this.idFuncionario != 0) && (this.funcionarioSolicitante == null)) {
            this.funcionarioSolicitante = Funcionario.obterFuncionario(this.idFuncionario);
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

    public ItemConsumo getItemConsumido() throws ClassNotFoundException, SQLException {
        if ((this.idItemConsumido != 0) && (this.itemConsumido == null)) {
            this.itemConsumido = ItemConsumo.obterItemConsumo(this.idItemConsumido);
        }

        return itemConsumido;
    }

    public void setItemConsumido(ItemConsumo itemConsumido) {
        this.itemConsumido = itemConsumido;
    }

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public int getIdHospedagem() {
        return idHospedagem;
    }

    public void setIdHospedagem(int idHospedagem) {
        this.idHospedagem = idHospedagem;
    }

    public int getIdItemConsumido() {
        return idItemConsumido;
    }

    public void setIdItemConsumido(int idItemConsumido) {
        this.idItemConsumido = idItemConsumido;
    }

    public float getPrecoConsumo() throws ClassNotFoundException, SQLException {
        return ((this.getItemConsumido().getPrecoVenda()) * (this.getQuantidade()));
    }

    public void gravar() throws SQLException, ClassNotFoundException {
        ConsumoDAO.gravar(this);
    }

    public void excluir() throws SQLException, ClassNotFoundException {
        ConsumoDAO.excluir(this);
    }

    public void alterar() throws SQLException, ClassNotFoundException {
        ConsumoDAO.alterar(this);
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }
}
