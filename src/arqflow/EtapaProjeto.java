package arqflow;

import java.time.LocalDate;

public class EtapaProjeto {
    private String nome;
    private boolean concluida;
    private LocalDate dataConclusao;

    public EtapaProjeto(String nome) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome da etapa inválido!");
        }
        this.nome = nome;
        this.concluida = false;
        this.dataConclusao = null;
    }

    public String getNome() {
        return nome;
    }

    public boolean isConcluida() {
        return concluida;
    }

    public LocalDate getDataConclusao() {
        return dataConclusao;
    }

    public boolean concluir() {
        if (!concluida) {
            concluida = true;
            dataConclusao = LocalDate.now();
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "EtapaProjeto{" +
                "nome='" + nome + '\'' +
                ", concluida=" + concluida +
                ", dataConclusao=" + dataConclusao +
                '}';
    }
}
