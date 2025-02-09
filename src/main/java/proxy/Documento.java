package proxy;

interface Documento {
    void exibir();
}

class DocumentoConfidencial implements Documento {
    private String conteudo;

    public DocumentoConfidencial(String conteudo) {
        this.conteudo = conteudo;
        carregarDoDisco();
    }

    private void carregarDoDisco() {
        System.out.println("Carregando documento do disco...");
    }

    @Override
    public void exibir() {
        System.out.println("Exibindo documento: " + conteudo);
    }
}

class ProxyDocumento implements Documento {
    private DocumentoConfidencial documentoConfidencial;
    private String conteudo;
    private boolean acessoPermitido;

    public ProxyDocumento(String conteudo, boolean acessoPermitido) {
        this.conteudo = conteudo;
        this.acessoPermitido = acessoPermitido;
    }

    @Override
    public void exibir() {
        if (acessoPermitido) {
            if (documentoConfidencial == null) {
                documentoConfidencial = new DocumentoConfidencial(conteudo);
            }
            documentoConfidencial.exibir();
        } else {
            System.out.println("Acesso negado ao documento.");
        }
    }
}