package adapter;
interface Pagamento {
    void processarPagamento(double valor);
}

class PagamentoBanco implements Pagamento {
    @Override
    public void processarPagamento(double valor) {
        System.out.println("Pagamento de R$" + valor + " processado pelo banco.");
    }
}

class PagamentoPayPal {
    public void realizarTransacao(double quantia) {
        System.out.println("Pagamento de R$" + quantia + " realizado via PayPal.");
    }
}

class PagamentoPayPalAdapter implements Pagamento {
    private PagamentoPayPal pagamentoPayPal;

    public PagamentoPayPalAdapter(PagamentoPayPal pagamentoPayPal) {
        this.pagamentoPayPal = pagamentoPayPal;
    }

    @Override
    public void processarPagamento(double valor) {
        pagamentoPayPal.realizarTransacao(valor);
    }
}
