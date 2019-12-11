package Controller;

import Model.Hospede;
import Model.Reserva;
import Model.TipoQuarto;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ManterReservaController extends HttpServlet {

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
            request.setAttribute("tiposQuarto", TipoQuarto.obterTiposQuarto());
            if (!operacao.equals("Incluir")) {
                int idReserva = Integer.parseInt(request.getParameter("id"));
                Reserva reserva = Reserva.obterReserva(idReserva);
                request.setAttribute("reserva", reserva);
            }
            RequestDispatcher view = request.getRequestDispatcher("/manterReserva.jsp");
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
        LocalDate dataEstimadaChegada = LocalDate.parse(request.getParameter("dataEstimadaChegada"));
        LocalDate dataEstimadaSaida = LocalDate.parse(request.getParameter("dataEstimadaSaida"));

        int idHospede = 0;
        int idTipoQuarto = 0;

        if (!operacao.equals("Excluir")) {
            idHospede = Integer.parseInt(request.getParameter("hospede"));
            idTipoQuarto = Integer.parseInt(request.getParameter("tipoQuarto"));
        }
        try {
            Hospede hospede = null;
            if (idHospede != 0) {
                hospede = Hospede.obterHospede(idHospede);
            }
            TipoQuarto tipoQuarto = null;
            if (idTipoQuarto != 0) {
                tipoQuarto = TipoQuarto.obterTipoQuarto(idTipoQuarto);
            }

            Reserva reserva = new Reserva(id, dataEstimadaChegada, dataEstimadaSaida, tipoQuarto, hospede);
            if (operacao.equals("Incluir")) {
                reserva.gravar();
            } else if (operacao.equals("Excluir")) {
                reserva.excluir();
            } else if (operacao.equals("Editar")) {
                reserva.alterar();
            }
            RequestDispatcher view = request.getRequestDispatcher("PesquisaReservaController");
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
            Logger.getLogger(ManterReservaController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManterReservaController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(ManterReservaController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ManterReservaController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManterReservaController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(ManterReservaController.class.getName()).log(Level.SEVERE, null, ex);
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
