package composite;

import java.util.ArrayList;
import java.util.List;

interface ComponenteArquivo {
    void exibir(String indentacao);
}

class Arquivo implements ComponenteArquivo {
    private String nome;

    public Arquivo(String nome) {
        this.nome = nome;
    }

    @Override
    public void exibir(String indentacao) {
        System.out.println(indentacao + "- " + nome);
    }
}

class Pasta implements ComponenteArquivo {
    private String nome;
    private List<ComponenteArquivo> componentes = new ArrayList<>();

    public Pasta(String nome) {
        this.nome = nome;
    }

    public void adicionar(ComponenteArquivo componente) {
        componentes.add(componente);
    }

    public void remover(ComponenteArquivo componente) {
        componentes.remove(componente);
    }

    @Override
    public void exibir(String indentacao) {
        System.out.println(indentacao + "+ " + nome);
        for (ComponenteArquivo componente : componentes) {
            componente.exibir(indentacao + "  ");
        }
    }
}