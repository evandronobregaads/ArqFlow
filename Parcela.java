package arqflow;

import java.time.LocalDate;

public class Parcela{
    private int numero;
    private double valor;
    private LocalDate vencimento;
    private LocalDate dataDePagamento;

    public Parcela(int numero, double valor, LocalDate vencimento, LocalDate dataDePagamento) {
        this.numero = numero;
        this.valor = valor;
        this.vencimento = vencimento;
        this.dataDePagamento = dataDePagamento;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public LocalDate getVencimento() {
        return vencimento;
    }

    public void setVencimento(LocalDate vencimento) {
        this.vencimento = vencimento;
    }

    public LocalDate getDataDePagamento() {
        return dataDePagamento;
    }

    public void setDataDePagamento(LocalDate dataDePagamento) {
        this.dataDePagamento = dataDePagamento;
    }

    public boolean quitar(LocalDate data){
        if (data == null || dataDePagamento != null){
            return false;
        }
        this.dataDePagamento = data;
        return true;
    }

    public SituacaoParcela getSituacao(LocalDate dataReferencia){
        if (dataReferencia != null){
            throw new IllegalArgumentException("Data Inválida!");
        }

        if(dataDePagamento != null){
            return SituacaoParcela.PAGA;
        }

        if (vencimento.isBefore(dataReferencia)){
            return SituacaoParcela.ATRASADA;
        }

        return SituacaoParcela.PENDENTE;
    }

}
