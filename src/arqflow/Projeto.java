package arqflow;

public abstract class Projeto {
    private String codigo;
    private String nome;
    private Cliente cliente;
    private double area;
    private ComplexidadeProjeto complexidade;
    private StatusProjeto status;

    public Projeto(String codigo, String nome, Cliente cliente, double area, ComplexidadeProjeto complexidade) {
        if (codigo == null || codigo.isBlank() || nome == null || nome.isBlank() ||
                area <= 0 || cliente == null || complexidade == null) {
            throw new IllegalArgumentException("Dados inválidos!"); // Isso impede que um projeto seja criado sem informações essenciais.
        }
        this.codigo = codigo;
        this.nome = nome;
        this.cliente = cliente;
        this.area = area;
        this.complexidade = complexidade;
        this.status = StatusProjeto.ORCAMENTO;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public double getArea() {
        return area;
    }

    public ComplexidadeProjeto getComplexidade() {
        return complexidade;
    }

    public StatusProjeto getStatus() {
        return status;
    }

    public abstract double calcularHonorarios();

    public abstract String getTipoProjeto();

    public void exibirResumo() {
        System.out.println("======================PROJETO=======================");
        System.out.println("CÓDIGO DO PROJETO: " + this.codigo);
        System.out.println("CÓDIGO DO CLIENTE: " + this.cliente.getCodigo());
        System.out.println("CLIENTE: " + this.cliente.getNome());
        System.out.println("NOME DO PROJETO: " + this.nome);
        System.out.println("AREA DO PROJETO: " + this.area);
        System.out.println("TIPO DE PROJETO: " + this.getTipoProjeto());
        System.out.println("COMPLEXIDADE: " + this.complexidade);
        System.out.printf("HONORÁRIOS: R$ %.2f%n" , this.calcularHonorarios());
        System.out.println("====================================================");
    }
}