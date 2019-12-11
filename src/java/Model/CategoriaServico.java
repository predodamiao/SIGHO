package Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum CategoriaServico {
    CAMARARIA("Camararia", 0),
    LAVANDERIA("Lavanderia", 1),
    RECEPCAO("Recepcao", 2),
    OUTROS("Outros", 3);

    private int id;
    private String nomeCategoria;

    CategoriaServico(String funcao, int id) {
        this.nomeCategoria = funcao;
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public String getNomeCategoria() {
        return this.nomeCategoria;
    }

    public static List<CategoriaServico> obterCategoriasServico() {
        ArrayList<CategoriaServico> categorias = new ArrayList<>();
        categorias.addAll(Arrays.asList(CategoriaServico.values()));
        return categorias;
    }

    public static CategoriaServico obterCategoriaServico(String valor) {
        return Enum.valueOf(CategoriaServico.class, valor.toUpperCase().replaceAll(" ", ""));
    }

}
