package bridge;

interface Mensagem {
    void enviarMensagem(String mensagem);
}

// Implementação para envio por E-mail
class MensagemEmail implements Mensagem {
    @Override
    public void enviarMensagem(String mensagem) {
        System.out.println("[E-mail] " + mensagem);
    }
}

class MensagemSMS implements Mensagem {
    @Override
    public void enviarMensagem(String mensagem) {
        System.out.println("[SMS] " + mensagem);
    }
}

abstract class Notificacao {
    protected Mensagem mensagem;

    public Notificacao(Mensagem mensagem) {
        this.mensagem = mensagem;
    }

    public abstract void enviar(String mensagem);
}

class NotificacaoNormal extends Notificacao {
    public NotificacaoNormal(Mensagem mensagem) {
        super(mensagem);
    }

    @Override
    public void enviar(String mensagem) {
        System.out.println("Notificação Normal:");
        this.mensagem.enviarMensagem(mensagem);
    }
}

class NotificacaoUrgente extends Notificacao {
    public NotificacaoUrgente(Mensagem mensagem) {
        super(mensagem);
    }

    @Override
    public void enviar(String mensagem) {
        System.out.println("⚠️ Notificação Urgente ⚠️");
        this.mensagem.enviarMensagem(mensagem.toUpperCase());
    }
}