package Controller;

import Model.Consumo;
import Model.Funcionario;
import Model.Hospedagem;
import Model.ItemConsumo;
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

public class ManterConsumoController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     * @throws java.io.IOException
     * @throws javax.servlet.ServletException
     * @throws java.text.ParseException
     *
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, IOException, ServletException, ParseException {
        String acao = request.getParameter("acao");
        if (acao.equals("prepararOperacao")) {
            prepararOperacao(request, response);
        } else if (acao.equals("confirmarOperacao")) {
            confirmarOperacao(request, response);
        }
    }

    public void prepararOperacao(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, IOException, ServletException {
        try {
            String operacao = request.getParameter("operacao");
            request.setAttribute("operacao", operacao);
            request.setAttribute("hospedagens", Hospedagem.obterHospedagensAtivas());
            request.setAttribute("itens", ItemConsumo.obterItensConsumo());
            request.setAttribute("funcionarioSolicitante", Funcionario.obterFuncionarios());
            if (!operacao.equals("Incluir")) {
                int idConsumo = Integer.parseInt(request.getParameter("id"));
                Consumo consumo = Consumo.obterConsumo(idConsumo);
                request.setAttribute("consumo", consumo);
            }
            RequestDispatcher view = request.getRequestDispatcher("/manterConsumo.jsp");
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
        int quantidade = Integer.parseInt(request.getParameter("quantidade"));

        int idHospedagem = 0;
        int codigoItem = 0;
        int idFuncionario = 0;

        if (!operacao.equals("Excluir")) {
            idHospedagem = Integer.parseInt(request.getParameter("hospedagem"));
            codigoItem = Integer.parseInt(request.getParameter("item"));
            idFuncionario = Integer.parseInt(request.getParameter("funcionarioSolicitante"));
        }
        try {
            Hospedagem hospedagem = null;
            if (idHospedagem != 0) {
                hospedagem = Hospedagem.obterHospedagem(idHospedagem);
            }
            ItemConsumo item = null;
            if (codigoItem != 0) {
                item = ItemConsumo.obterItemConsumo(codigoItem);
            }
            Funcionario funcionario = null;
            if (idFuncionario != 0) {
                funcionario = Funcionario.obterFuncionario(idFuncionario);
            }
            Consumo consumo = new Consumo(id, data, hora, quantidade, funcionario, hospedagem, item);
            if (operacao.equals("Incluir")) {
                consumo.gravar();
            } else if (operacao.equals("Excluir")) {
                consumo.excluir();
            } else if (operacao.equals("Editar")) {
                consumo.alterar();
            }
            RequestDispatcher view = request.getRequestDispatcher("PesquisaConsumoController");
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
            Logger.getLogger(ManterConsumoController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManterConsumoController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(ManterConsumoController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ManterConsumoController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManterConsumoController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(ManterConsumoController.class.getName()).log(Level.SEVERE, null, ex);
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
