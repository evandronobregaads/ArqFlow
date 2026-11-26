import arqflow.*;

public class Main {
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente("CLI001", "Ana", "ana@email.com", "83 99999-8888");
        Cliente cliente2 = new Cliente("CLI002", "Evandro", "evandro@email.com", "83 98866-5544");
        EtapaProjeto etapa1 = new EtapaProjeto(TipoEtapa.BRIEFING);
        Projeto projetoCasa = new ProjetoResidencial("RES001", "Casa EMNJ", cliente1, 160, ComplexidadeProjeto.MEDIA);
        Projeto projetoLoja = new ProjetoComercial("COM001", "Crossfit", cliente2, 320, ComplexidadeProjeto.ALTA);

        System.out.println("======================ARQFLOW=======================");
        System.out.println("TESTES - CLIENTES:");
        System.out.println(cliente1);
        System.out.println(cliente2);
        System.out.println("TESTES - PROJETOS:");
        projetoCasa.exibirResumo();
        projetoLoja.exibirResumo();
        System.out.println("======================FIM DOS TESTES=======================");
    }
}
