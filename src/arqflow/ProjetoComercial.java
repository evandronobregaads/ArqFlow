package arqflow;

public class ProjetoComercial extends Projeto {

    public ProjetoComercial(String codigo, String nome, Cliente cliente, double area, ComplexidadeProjeto complexidade) {
        super(codigo, nome, cliente, area, complexidade);
    }

    @Override
    public double calcularHonorarios() {
        return (super.getArea() * 80 * super.getComplexidade().getMultiplicador()) + 500;
    }

    @Override
    public String getTipoProjeto() {
        return "Comercial";
    }
}
