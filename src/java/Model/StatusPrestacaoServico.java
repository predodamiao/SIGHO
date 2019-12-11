package Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum StatusPrestacaoServico {
    SOLICITADO("Solicitado", 0),
    EMANDAMENTO("Em Andamento", 1),
    PRONTO("Pronto", 2),
    ENTREGUE("Entregue", 3);

    private int id;
    private String nomeStatus;

    StatusPrestacaoServico(String status, int id) {
        this.nomeStatus = status;
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public String getNomeStatus() {
        return this.nomeStatus;
    }

    public static List<StatusPrestacaoServico> obterStatusSolicitacoes() {
        ArrayList<StatusPrestacaoServico> status = new ArrayList<>();
        status.addAll(Arrays.asList(StatusPrestacaoServico.values()));
        return status;
    }

    public static StatusPrestacaoServico obterStatusSolicitacao(String valor) {
        return Enum.valueOf(StatusPrestacaoServico.class, valor.toUpperCase().replaceAll(" ", ""));
    }

}
