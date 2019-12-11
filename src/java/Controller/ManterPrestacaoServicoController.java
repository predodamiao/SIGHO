package Controller;

import Model.Funcionario;
import Model.Hospedagem;
import Model.Servico;
import Model.PrestacaoServico;
import Model.StatusPrestacaoServico;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ManterPrestacaoServicoController extends HttpServlet {

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
            request.setAttribute("hospedagens", Hospedagem.obterHospedagensAtivas());
            request.setAttribute("funcionarios", Funcionario.obterFuncionarios());
            request.setAttribute("servicos", Servico.obterServicos());
            request.setAttribute("status", StatusPrestacaoServico.obterStatusSolicitacoes());

            if (!operacao.equals("Incluir")) {
                int idPrestacao = Integer.parseInt(request.getParameter("id"));
                PrestacaoServico prestacao = PrestacaoServico.obterPrestacaoServico(idPrestacao);
                request.setAttribute("prestacao", prestacao);
            }

            RequestDispatcher view = request.getRequestDispatcher("/manterPrestacaoServico.jsp");
            view.forward(request, response);
        } catch (ServletException e) {
            throw e;
        } catch (IOException e) {
            throw new ServletException(e);
        }
    }

    public void confirmarOperacao(HttpServletRequest request, HttpServletResponse response) throws ParseException, ClassNotFoundException, SQLException, ServletException {
        String operacao = request.getParameter("operacao");
        int id = Integer.parseInt(request.getParameter("id"));
        LocalDate data = LocalDate.parse(request.getParameter("data"));
        LocalTime hora = LocalTime.parse(request.getParameter("hora"));

        int idHospedagem = 0;
        int idFuncionario = 0;
        String idStatus = null;
        int codigoServico = 0;

        if (!operacao.equals("Excluir")) {
            idHospedagem = Integer.parseInt(request.getParameter("hospedagem"));
            idFuncionario = Integer.parseInt(request.getParameter("funcionarioSolicitante"));
            idStatus = request.getParameter("status");
            codigoServico = Integer.parseInt(request.getParameter("servico"));
        }
        try {
            Hospedagem hospedagem = null;
            if (idHospedagem != 0) {
                hospedagem = Hospedagem.obterHospedagem(idHospedagem);
            }
            Funcionario funcionario = null;
            if (idFuncionario != 0) {
                funcionario = Funcionario.obterFuncionario(idFuncionario);
            }
            StatusPrestacaoServico status = null;
            if (idStatus != null) {
                status = StatusPrestacaoServico.obterStatusSolicitacao(idStatus);
            }
            Servico servico = null;
            if (codigoServico != 0) {
                servico = Servico.obterServico(codigoServico);
            }

            PrestacaoServico prestacao = new PrestacaoServico(id, data, hora, status, funcionario, hospedagem, servico);
            if (operacao.equals("Incluir")) {
                prestacao.gravar();
            } else if (operacao.equals("Excluir")) {
                prestacao.excluir();
            } else if (operacao.equals("Editar")) {
                prestacao.alterar();
            }
            RequestDispatcher view = request.getRequestDispatcher("PesquisaPrestacaoServicoController");
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
            Logger.getLogger(ManterPrestacaoServicoController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManterPrestacaoServicoController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(ManterPrestacaoServicoController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ManterPrestacaoServicoController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManterPrestacaoServicoController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(ManterPrestacaoServicoController.class.getName()).log(Level.SEVERE, null, ex);
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
