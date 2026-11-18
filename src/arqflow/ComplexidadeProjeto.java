package arqflow;

public enum ComplexidadeProjeto {

    BAIXA(1.2),
    MEDIA(1.45),
    ALTA(1.6);

    private final double multiplicador;

    ComplexidadeProjeto(double multiplicador) {
        this.multiplicador = multiplicador;
    }

    public double getMultiplicador() {
        return multiplicador;
    }
}
