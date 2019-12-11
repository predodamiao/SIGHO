package Controller;

import Model.CategoriaFuncionario;
import Model.Funcionario;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ManterFuncionarioController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     * @throws java.text.ParseException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException, ParseException {
        String acao = request.getParameter("acao");
        if (acao.equals("prepararOperacao")) {
            prepararOperacao(request, response);
        } else if (acao.equals("confirmarOperacao")) {
            confirmarOperacao(request, response);
        }
    }

    public void prepararOperacao(HttpServletRequest request, HttpServletResponse response) throws ServletException, ClassNotFoundException, SQLException {
        try {
            String operacao = request.getParameter("operacao");
            request.setAttribute("operacao", operacao);
            request.setAttribute("categorias", CategoriaFuncionario.obterCategoriasFuncionario());
            if (!operacao.equals("Incluir")) {
                int idFuncionario = Integer.parseInt(request.getParameter("id"));
                Funcionario funcionario = Funcionario.obterFuncionario(idFuncionario);
                request.setAttribute("funcionario", funcionario);
            }
            RequestDispatcher view = request.getRequestDispatcher("/manterFuncionario.jsp");
            view.forward(request, response);
        } catch (ServletException e) {
            throw e;
        } catch (IOException e) {
            throw new ServletException(e);
        }
    }

    public void confirmarOperacao(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, ServletException, ParseException, IOException {
        String operacao = request.getParameter("operacao");
        int id = Integer.parseInt(request.getParameter("id"));
        String nome = request.getParameter("nome");
        String telefone = request.getParameter("telefone");
        String email = request.getParameter("email");
        String rg = request.getParameter("rg");
        String cpf = request.getParameter("cpf");
        Date dataNascimento = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("dataNascimento"));
        Date dataAdmissao = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("dataAdmissao"));
        String idCategoria = null;
        idCategoria = request.getParameter("categoriaFuncionario");
        try {
            CategoriaFuncionario categoria = null;
            if (idCategoria != null) {
                categoria = CategoriaFuncionario.obterCategoriaFuncionario(idCategoria);
            }

            Funcionario funcionario = new Funcionario(id, nome, telefone, email, rg, cpf, dataNascimento, dataAdmissao, categoria);
            if (operacao.equals("Incluir")) {
                funcionario.gravar();
            } else if (operacao.equals("Excluir")) {
                funcionario.excluir();
            } else if (operacao.equals("Editar")) {
                funcionario.alterar();
            }

            RequestDispatcher view = request.getRequestDispatcher("PesquisaFuncionarioController");
            view.forward(request, response);
        } catch (IOException e) {
            throw new ServletException(e);
        }
    }

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManterFuncionarioController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManterFuncionarioController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(ManterFuncionarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManterFuncionarioController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManterFuncionarioController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(ManterFuncionarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
