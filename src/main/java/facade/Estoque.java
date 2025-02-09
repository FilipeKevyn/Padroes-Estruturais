package facade;

class Estoque {
    public void verificarDisponibilidade(String produto) {
        System.out.println("Verificando disponibilidade do produto: " + produto);
    }
}

class Pagamento {
    public void processarPagamento(double valor) {
        System.out.println("Pagamento de R$" + valor + " processado com sucesso.");
    }
}

class Entrega {
    public void despacharPedido(String produto) {
        System.out.println("Produto " + produto + " despachado para entrega.");
    }
}

class PedidoFacade {
    private Estoque estoque;
    private Pagamento pagamento;
    private Entrega entrega;

    public PedidoFacade() {
        this.estoque = new Estoque();
        this.pagamento = new Pagamento();
        this.entrega = new Entrega();
    }

    public void realizarPedido(String produto, double valor) {
        System.out.println("Iniciando processamento do pedido...");
        estoque.verificarDisponibilidade(produto);
        pagamento.processarPagamento(valor);
        entrega.despacharPedido(produto);
        System.out.println("Pedido concluído com sucesso!\n");
    }
}