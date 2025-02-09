package decorator;

interface Cafe {
    String servir();
    double custo();
}

class CafeSimples implements Cafe {
    @Override
    public String servir() {
        return "Café simples";
    }

    @Override
    public double custo() {
        return 5.00;
    }
}

abstract class CafeDecorator implements Cafe {
    protected Cafe cafe;

    public CafeDecorator(Cafe cafe) {
        this.cafe = cafe;
    }

    @Override
    public String servir() {
        return cafe.servir();
    }

    @Override
    public double custo() {
        return cafe.custo();
    }
}

class CafeComLeite extends CafeDecorator {
    public CafeComLeite(Cafe cafe) {
        super(cafe);
    }

    @Override
    public String servir() {
        return cafe.servir() + " com leite";
    }

    @Override
    public double custo() {
        return cafe.custo() + 2.00;
    }
}

class CafeComAcucar extends CafeDecorator {
    public CafeComAcucar(Cafe cafe) {
        super(cafe);
    }

    @Override
    public String servir() {
        return cafe.servir() + " com açúcar";
    }

    @Override
    public double custo() {
        return cafe.custo() + 1.00;
    }
}