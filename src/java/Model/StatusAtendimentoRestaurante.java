package Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum StatusAtendimentoRestaurante {
    SOLICITADO("Solicitado", 0),
    EMPREPARO("Em Preparo", 1),
    PRONTO("Pronto", 2),
    ENTREGUE("Entregue", 3);

    private int id;
    private String nomeStatus;

    StatusAtendimentoRestaurante(String status, int id) {
        this.nomeStatus = status;
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public String getNomeStatus() {
        return this.nomeStatus;
    }

    public static List<StatusAtendimentoRestaurante> obterStatusAtendimentosRestaurante() {
        ArrayList<StatusAtendimentoRestaurante> status = new ArrayList<>();
        status.addAll(Arrays.asList(StatusAtendimentoRestaurante.values()));
        return status;
    }

    public static StatusAtendimentoRestaurante obterStatusAtendimentoRestaurante(String valor) {
        return Enum.valueOf(StatusAtendimentoRestaurante.class, valor.toUpperCase().replaceAll(" ", ""));
    }

}
