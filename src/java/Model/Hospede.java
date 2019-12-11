package Model;

import DAO.HospedeDAO;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class Hospede extends Pessoa {

    private String passaporte;

    public Hospede(int id, String nome, String telefone, String email, String rg, String cpf, Date dataNascimento, String passaporte) {
        super(id, nome, telefone, email, rg, cpf, dataNascimento);
        this.passaporte = passaporte;
    }

    public static Hospede obterHospede(int codHospede) throws ClassNotFoundException, SQLException {
        return HospedeDAO.obterHospede(codHospede);
    }

    public static List<Hospede> obterHospedes() throws ClassNotFoundException, SQLException {
        return HospedeDAO.obterHospedes();
    }

    public String getPassaporte() {
        return passaporte;
    }

    public void setPassaporte(String passaporte) {
        this.passaporte = passaporte;
    }

    public void gravar() throws SQLException, ClassNotFoundException {
        HospedeDAO.gravar(this);
    }

    public void excluir() throws SQLException, ClassNotFoundException {
        HospedeDAO.excluir(this);
    }

    public void alterar() throws SQLException, ClassNotFoundException {
        HospedeDAO.alterar(this);
    }

}
