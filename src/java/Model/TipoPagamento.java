package Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum TipoPagamento {
    CREDITO("Credito", 0),
    DEBITO("Debito", 1),
    DINHEIRO("Dinheiro", 2);

    private int id;
    private String nomeTipo;

    TipoPagamento(String tipo, int id) {
        this.nomeTipo = tipo;
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public String getNomeTipo() {
        return this.nomeTipo;
    }

    public static List<TipoPagamento> obterTiposPagamento() {
        ArrayList<TipoPagamento> tipos = new ArrayList<>();
        tipos.addAll(Arrays.asList(TipoPagamento.values()));
        return tipos;
    }

    public static TipoPagamento obterTipoPagamento(String valor) {
        return Enum.valueOf(TipoPagamento.class, valor.toUpperCase().replaceAll(" ", ""));
    }

}
