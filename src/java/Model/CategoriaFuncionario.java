package Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum CategoriaFuncionario {
    GERENTE("Gerente", 0),
    LAVANDERIA("Lavanderia", 1),
    RECEPCAO("Recepcao", 2),
    CAMARARIA("Camararia", 3),
    RESTAURANTE("Restaurante", 4);

    private int id;
    private String nomeCategoria;

    CategoriaFuncionario(String funcao, int id) {
        this.nomeCategoria = funcao;
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public String getNomeCategoria() {
        return this.nomeCategoria;
    }

    public static List<CategoriaFuncionario> obterCategoriasFuncionario() {
        ArrayList<CategoriaFuncionario> categorias = new ArrayList<>();
        categorias.addAll(Arrays.asList(CategoriaFuncionario.values()));
        return categorias;
    }

    public static CategoriaFuncionario obterCategoriaFuncionario(String valor) {
        return Enum.valueOf(CategoriaFuncionario.class, valor.toUpperCase().replaceAll(" ", ""));
    }

}
