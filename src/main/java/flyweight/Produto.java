package flyweight;

import java.util.HashMap;
import java.util.Map;

interface Produto {
    void exibirDetalhes();
}

class ProdutoConcreto implements Produto {
    private String nome;
    private String categoria;
    private double preco;

    public ProdutoConcreto(String nome, String categoria, double preco) {
        this.nome = nome;
        this.categoria = categoria;
        this.preco = preco;
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("Produto: " + nome + ", Categoria: " + categoria + ", Preço: R$" + preco);
    }
}

class FabricaDeProdutos {
    private Map<String, Produto> produtos = new HashMap<>();

    public Produto obterProduto(String nome, String categoria, double preco) {
        String chaveProduto = nome + categoria + preco;
        if (!produtos.containsKey(chaveProduto)) {
            produtos.put(chaveProduto, new ProdutoConcreto(nome, categoria, preco));
        }
        return produtos.get(chaveProduto);
    }
}

class Pedido {
    private Produto produto;
    private int quantidade;

    public Pedido(String nomeProduto, String categoriaProduto, double precoProduto, int quantidade) {
        FabricaDeProdutos fabrica = new FabricaDeProdutos();
        this.produto = fabrica.obterProduto(nomeProduto, categoriaProduto, precoProduto);
        this.quantidade = quantidade;
    }

    public void exibirDetalhesPedido() {
        produto.exibirDetalhes();
        System.out.println("Quantidade: " + quantidade);
    }
}
