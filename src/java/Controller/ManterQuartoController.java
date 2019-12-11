package Controller;

import Model.Quarto;
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

public class ManterQuartoController extends HttpServlet {

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
            request.setAttribute("tiposQuarto", TipoQuarto.obterTiposQuarto());

            if (!operacao.equals("Incluir")) {
                int idQuarto = Integer.parseInt(request.getParameter("id"));
                Quarto quarto = Quarto.obterQuarto(idQuarto);
                request.setAttribute("quarto", quarto);
            }

            RequestDispatcher view = request.getRequestDispatcher("/manterQuarto.jsp");
            view.forward(request, response);
        } catch (ServletException e) {
            throw e;
        } catch (IOException e) {
            throw new ServletException(e);
        }
    }

    public void confirmarOperacao(HttpServletRequest request, HttpServletResponse response) throws ParseException, ClassNotFoundException, SQLException, ServletException, IOException {
        String operacao = request.getParameter("operacao");
        int identificacao = Integer.parseInt(request.getParameter("identificacao"));
        int quantidadeCamasCasal = Integer.parseInt(request.getParameter("quantidadeCamasCasal"));
        int quantidadeCamasSolteiro = Integer.parseInt(request.getParameter("quantidadeCamasSolteiro"));
        int idTipoQuarto = 0;

        if (!operacao.equals("Excluir")) {
            idTipoQuarto = Integer.parseInt(request.getParameter("tipoQuarto"));
        }
        try {
            TipoQuarto tipoQuarto = null;
            if (idTipoQuarto != 0) {
                tipoQuarto = TipoQuarto.obterTipoQuarto(idTipoQuarto);
            }
            Quarto quarto = new Quarto(identificacao, quantidadeCamasCasal, quantidadeCamasSolteiro, tipoQuarto);
            if (operacao.equals("Incluir")) {
                quarto.gravar();
            } else if (operacao.equals("Excluir")) {
                quarto.excluir();
            } else if (operacao.equals("Editar")) {
                quarto.alterar();
            }
            RequestDispatcher view = request.getRequestDispatcher("PesquisaQuartoController");
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
            Logger.getLogger(ManterQuartoController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManterQuartoController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(ManterQuartoController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ManterQuartoController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManterQuartoController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(ManterQuartoController.class.getName()).log(Level.SEVERE, null, ex);
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
