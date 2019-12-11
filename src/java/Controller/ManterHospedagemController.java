package Controller;

import Model.Hospedagem;
import Model.Hospede;
import Model.Quarto;
import Model.TipoQuarto;
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

public class ManterHospedagemController extends HttpServlet {

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
            request.setAttribute("hospedes", Hospede.obterHospedes());
            request.setAttribute("quartos", Quarto.obterQuartos());
            request.setAttribute("tiposQuarto", TipoQuarto.obterTiposQuarto());
            if (!operacao.equals("Incluir")) {
                int idHospedagem = Integer.parseInt(request.getParameter("id"));
                Hospedagem hospedagem = Hospedagem.obterHospedagem(idHospedagem);
                request.setAttribute("hospedagem", hospedagem);
            }
            RequestDispatcher view = request.getRequestDispatcher("/manterHospedagem.jsp");
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
        LocalDate dataChegada = LocalDate.parse(request.getParameter("dataChegada"));
        LocalTime horaChegada = LocalTime.parse(request.getParameter("horaChegada"));

        int idHospede = 0;
        int idQuarto = 0;

        if (!operacao.equals("Excluir")) {
            idHospede = Integer.parseInt(request.getParameter("hospede"));
            idQuarto = Integer.parseInt(request.getParameter("quarto"));
        }
        try {
            Hospede hospede = null;
            if (idHospede != 0) {
                hospede = Hospede.obterHospede(idHospede);
            }
            Quarto quarto = null;
            if (idQuarto != 0) {
                quarto = Quarto.obterQuarto(idQuarto);
            }

            Hospedagem hospedagem = new Hospedagem(id, dataChegada, horaChegada, null, null, quarto, hospede);
            if (operacao.equals("Incluir")) {
                hospedagem.gravar();
            } else if (operacao.equals("Excluir")) {
                hospedagem.excluir();
            } else if (operacao.equals("Editar")) {
                hospedagem.alterar();
            }
            RequestDispatcher view = request.getRequestDispatcher("PesquisaHospedagemController");
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
            Logger.getLogger(ManterHospedagemController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManterHospedagemController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(ManterHospedagemController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ManterHospedagemController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManterHospedagemController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(ManterHospedagemController.class.getName()).log(Level.SEVERE, null, ex);
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
