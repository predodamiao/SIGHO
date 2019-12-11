package Controller;

import Model.AtendimentoRestaurante;
import Model.Consumo;
import Model.Hospedagem;
import Model.Pagamento;
import Model.PrestacaoServico;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RealizarCheckoutController extends HttpServlet {

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

            int idHospedagem = Integer.parseInt(request.getParameter("idHospedagem"));
            Hospedagem hospedagem = Hospedagem.obterHospedagem(idHospedagem);
            request.setAttribute("hospedagem", hospedagem);

            Period periodo = Period.between(hospedagem.getDataChegada(), LocalDate.now());

            int quantidadeDiarias = periodo.getDays();
            
            if(quantidadeDiarias == 0){
                quantidadeDiarias = 1;
            }

            request.setAttribute("quantidadeDiarias", quantidadeDiarias);

            float totalDiarias = quantidadeDiarias * hospedagem.getQuarto().getTipo().getDiaria();

            request.setAttribute("totalDiarias", totalDiarias);

            List<Pagamento> pagamentos = hospedagem.obterPagamentos();
            List<Consumo> consumos = hospedagem.obterConsumos();
            List<PrestacaoServico> prestacoes = hospedagem.obterPrestacoesServico();
            List<AtendimentoRestaurante> atendimentos = hospedagem.obterAtendimentosRestaurante();

            request.setAttribute("pagamentos", pagamentos);
            request.setAttribute("solicitacoes", prestacoes);
            request.setAttribute("consumos", consumos);
            request.setAttribute("atendimentos", atendimentos);

            float totalPagamentos = 0;
            float totalPrestacoes = 0;
            float totalConsumos = 0;
            float totalAtendimentos = 0;

            for (Pagamento pagamento : pagamentos) {
                totalPagamentos += pagamento.getValor();
            }

            for (PrestacaoServico prestacao : prestacoes) {
                totalPrestacoes += prestacao.getServico().getPreco();
            }

            for (Consumo consumo : consumos) {
                totalConsumos += consumo.getPrecoConsumo();
            }

            for (AtendimentoRestaurante atendimento : atendimentos) {
                totalAtendimentos += atendimento.getPrecoAtendimento();
            }

            request.setAttribute("totalPagamentos", totalPagamentos);
            request.setAttribute("totalSolicitacoes", totalPrestacoes);
            request.setAttribute("totalConsumos", totalConsumos);
            request.setAttribute("totalAtendimentos", totalAtendimentos);

            RequestDispatcher view = request.getRequestDispatcher("/checkout.jsp");
            view.forward(request, response);
        } catch (ServletException e) {
            throw e;
        } catch (IOException e) {
            throw new ServletException(e);
        }
    }

    public void confirmarOperacao(HttpServletRequest request, HttpServletResponse response) throws ParseException, ClassNotFoundException, SQLException, ServletException, IOException {

        int idHospedagem = Integer.parseInt(request.getParameter("idHospedagem"));

        Hospedagem hospedagem = Hospedagem.obterHospedagem(idHospedagem);

        hospedagem.setDataSaida(LocalDate.now());
        hospedagem.setHoraSaida(LocalTime.now());

        hospedagem.checkout();

        RequestDispatcher view = request.getRequestDispatcher("/PesquisaHospedagensAtivasController");
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
            Logger.getLogger(RealizarCheckoutController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(RealizarCheckoutController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(RealizarCheckoutController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(RealizarCheckoutController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(RealizarCheckoutController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(RealizarCheckoutController.class.getName()).log(Level.SEVERE, null, ex);
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
