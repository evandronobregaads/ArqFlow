package arqflow;

import java.util.ArrayList;

public class Escritorio {
    private ArrayList<Projeto> projetos;
    private ArrayList<Cliente> clientes;

    public Escritorio(ArrayList<Projeto> projetos, ArrayList<Cliente> clientes) {
        if (projetos == null || clientes == null) {
            throw new IllegalArgumentException("Listas inválidas!");
        }
        this.projetos = new ArrayList<>(projetos);
        this.clientes = new ArrayList<>(clientes);
    }

    public ArrayList<Projeto> getProjetos() {
        return projetos;
    }

    public void setProjetos(ArrayList<Projeto> projetos) {
        this.projetos = projetos;
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }

    public boolean cadastrarClientes(Cliente cliente){
        if (cliente == null){
            return false;
        }
        for (Cliente c : clientes){
            if (c.getCodigo().equals(cliente.getCodigo())){
                return false;
            }
        }
        clientes.add(cliente);
        return true;
    }

    public boolean cadastrarProjeto(Projeto projeto){
        if (projeto == null){
            return false;
        }
        boolean clientesCadastrados = false;
        for (Cliente c: clientes){
            if (c.getCodigo().equals(projeto.getCliente().getCodigo()) && c.isAtivo()){
                clientesCadastrados = true;
                break;
            }
        }
        if (!clientesCadastrados){
            return false;
        }
        for (Projeto p: projetos){
            if (p.getCodigo().equals(projeto.getCodigo())){
                return false;
            }
        }
        projetos.add(projeto);
        return true;
    }

    public void relatorioProjetos(){
        if (projetos.isEmpty()){
            System.out.println("Nenhum projeto cadastrado!");
            return;
        }
        for (Projeto p: projetos){
            p.exibirResumo();
        }
    }

    public void relatorioFinanceiro(){
      double totalHonorarios = 0;
      for (Projeto p: projetos){
          System.out.printf("%s (%s): R$ %.2f%n", p.getNome(), p.getTipoProjeto(), p.calcularHonorarios());
          totalHonorarios += p.calcularHonorarios();
      }
      System.out.printf("Total de honorários: R$ %.2f%n", totalHonorarios);
    }
}
