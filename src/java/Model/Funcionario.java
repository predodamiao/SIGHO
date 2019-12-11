package Model;

import DAO.FuncionarioDAO;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class Funcionario extends Pessoa {

    private Date dataAdmissao;
    private CategoriaFuncionario categoria;

    public Funcionario(int id, String nome, String telefone, String email, String rg, String cpf, Date dataNascimento, Date dataAdmissao, CategoriaFuncionario categoria) {
        super(id, nome, telefone, email, rg, cpf, dataNascimento);
        this.dataAdmissao = dataAdmissao;
        this.categoria = categoria;
    }

    public static Funcionario obterFuncionario(int codFuncionario) throws ClassNotFoundException, SQLException {
        return FuncionarioDAO.obterFuncionario(codFuncionario);
    }

    public static List<Funcionario> obterFuncionarios() throws ClassNotFoundException, SQLException {
        return FuncionarioDAO.obterFuncionarios();
    }

    public Date getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(Date dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    public CategoriaFuncionario getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaFuncionario categoria) {
        this.categoria = categoria;
    }

    public void gravar() throws SQLException, ClassNotFoundException {
        FuncionarioDAO.gravar(this);
    }

    public void excluir() throws SQLException, ClassNotFoundException {
        FuncionarioDAO.excluir(this);
    }

    public void alterar() throws SQLException, ClassNotFoundException {
        FuncionarioDAO.alterar(this);
    }

}
