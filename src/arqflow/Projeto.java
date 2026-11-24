package arqflow;

import java.util.ArrayList;

public abstract class Projeto {
    private String codigo;
    private String nome;
    private Cliente cliente;
    private double area;
    private ComplexidadeProjeto complexidade;
    private StatusProjeto status;
    private ArrayList<EtapaProjeto> etapas;

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
        this.etapas = new ArrayList<>();
        this.etapas.add(new EtapaProjeto(TipoEtapa.BRIEFING));
        this.etapas.add(new EtapaProjeto(TipoEtapa.ESTUDO_PRELIMINAR));
        this.etapas.add(new EtapaProjeto(TipoEtapa.ANTEPROJETO));
        this.etapas.add(new EtapaProjeto(TipoEtapa.PROJETO_EXECUTIVO));
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

    public boolean contratar() {
        if (this.status == StatusProjeto.ORCAMENTO) {
            status = StatusProjeto.CONTRATADO;
            return true;
        }
        return false;
    }

    public boolean iniciar() {
        if (this.status == StatusProjeto.CONTRATADO) {
            status = StatusProjeto.EM_ANDAMENTO;
            return true;
        }
        return false;
    }

    public boolean cancelar() {
        if (this.status == StatusProjeto.ORCAMENTO || this.status == StatusProjeto.CONTRATADO || this.status == StatusProjeto.EM_ANDAMENTO) {
            status = StatusProjeto.CANCELADO;
            return true;
        }
        return false;
    }

    public void exibirEtapas() {
        System.out.println("========= ETAPAS DO PROJETO =========");
        int numero = 1;
        for (EtapaProjeto etapa : etapas) {
            String situacao;
            if (etapa.isConcluida()) {
                situacao = "CONCLUÍDA";
            } else {
                situacao = "PENDENTE";
            }
            System.out.println(numero + " - " + etapa.getTipo() + ": " + situacao);
            numero++;
        }
    }

    public boolean concluirEtapa(TipoEtapa tipo) {
        if (tipo == null || this.status != StatusProjeto.EM_ANDAMENTO) {
            return false;
        }
        for (EtapaProjeto etapa : etapas) {
            if (!etapa.isConcluida()) { // Se a estapa NÃO estier concluída
                // Aqui vamos verificar se é a etapa solicitada.
                if (etapa.getTipo() != tipo) {
                    return false;
                }
                return etapa.concluir();
            }
        }
        return false;
    }

    public boolean concluir () {
        if (this.status != StatusProjeto.EM_ANDAMENTO) {
            return false;
        }
        for (EtapaProjeto etapa : etapas) {
            if (!etapa.isConcluida()) {
                return false;
            }
        }
        this.status = StatusProjeto.CONCLUIDO;
        return true;
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
        System.out.println("STATUS DO PROJETO: " + this.status);
        System.out.println("====================================================");
    }
}