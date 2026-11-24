package arqflow;

import java.time.LocalDate;

public class EtapaProjeto {
    private TipoEtapa tipo;
    private boolean concluida;
    private LocalDate dataConclusao;

    public EtapaProjeto(TipoEtapa tipo) {
        if (tipo == null) {
            throw new IllegalArgumentException("Tipo de etapa inválido!");
        }
        this.tipo = tipo;
        this.concluida = false;
        this.dataConclusao = null;
    }

    public TipoEtapa getTipo() {
        return tipo;
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
                "Tipo='" + tipo + '\'' +
                ", concluida=" + concluida +
                ", dataConclusao=" + dataConclusao +
                '}';
    }
}
