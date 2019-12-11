package Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum MomentoPagamento {
    CHECKIN("Check In", 0),
    CHECKOUT("Check Out", 1),
    RESERVA("Reserva", 2),
    OUTRO("Outro", 3);

    private int id;
    private String nomeMomento;

    MomentoPagamento(String momento, int id) {
        this.nomeMomento = momento;
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public String getNomeMomento() {
        return this.nomeMomento;
    }

    public static List<MomentoPagamento> obterMomentosPagamento() {
        ArrayList<MomentoPagamento> momentos = new ArrayList<>();
        momentos.addAll(Arrays.asList(MomentoPagamento.values()));
        return momentos;
    }

    public static MomentoPagamento obterMomentoPagamento(String valor) {
        return Enum.valueOf(MomentoPagamento.class, valor.toUpperCase().replaceAll(" ", ""));
    }

}
