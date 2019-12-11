package Controller;

import Model.Hospede;
import Model.Hospedagem;
import Model.Quarto;
import Model.Reserva;
import Model.TipoQuarto;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RealizarCheckinController extends HttpServlet {

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
        if (acao.equals("prepararCheckin")) {
            prepararCheckin(request, response);
        } else if (acao.equals("checkinSemReserva")) {
            checkinSemReserva(request, response);
        } else if (acao.equals("checkinComReserva")) {
            checkinComReserva(request, response);
        }
    }

    public void prepararCheckin(HttpServletRequest request, HttpServletResponse response) throws ServletException, ClassNotFoundException, SQLException, IOException {
        try {
            request.setAttribute("tiposQuarto", TipoQuarto.obterTiposQuarto());
            RequestDispatcher view = request.getRequestDispatcher("/checkin.jsp");
            view.forward(request, response);
        } catch (ClassNotFoundException | SQLException e) {
            throw new ServletException(e);
        }
    }

    public void checkinSemReserva(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, ServletException, ParseException, IOException {
        int tipoQuarto = Integer.parseInt(request.getParameter("tipoQuarto"));

        request.setAttribute("operacao", "Incluir");

        request.setAttribute("quartos", Quarto.obterQuartosVagos(tipoQuarto));

        request.setAttribute("hospedes", Hospede.obterHospedes());

        RequestDispatcher view = request.getRequestDispatcher("/manterHospedagem.jsp");
        view.forward(request, response);

    }

    private void checkinComReserva(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, ServletException, IOException {
        int idReserva = Integer.parseInt(request.getParameter("id"));

        request.setAttribute("operacao", "Incluir");

        Reserva reserva = Reserva.obterReserva(idReserva);

        request.setAttribute("dataChegada", reserva.getDataEstimadaChegada());
        request.setAttribute("hospedes", Hospede.obterHospedes());
        request.setAttribute("quartos", Quarto.obterQuartosVagos(reserva.getIdTipoQuarto()));

        Hospedagem hospedagem = new Hospedagem(Hospede.obterHospede(reserva.getIdHospedeResponsavel()));

        request.setAttribute("hospedagem", hospedagem);

        RequestDispatcher view = request.getRequestDispatcher("/manterHospedagem.jsp");
        view.forward(request, response);

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
            Logger.getLogger(RealizarCheckinController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(RealizarCheckinController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(RealizarCheckinController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(RealizarCheckinController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(RealizarCheckinController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(RealizarCheckinController.class.getName()).log(Level.SEVERE, null, ex);
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
