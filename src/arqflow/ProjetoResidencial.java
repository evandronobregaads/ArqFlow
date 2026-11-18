package arqflow;

public class ProjetoResidencial extends Projeto {

    public ProjetoResidencial(String codigo, String nome, Cliente cliente, double area, ComplexidadeProjeto complexidade) {
        super(codigo, nome, cliente, area, complexidade);
    }

    @Override
    public double calcularHonorarios() {
        return super.getArea() * 60 * super.getComplexidade().getMultiplicador();
    }

    @Override
    public String getTipoProjeto() {
        return "Residencial";
    }
}
