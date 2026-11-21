package arqflow;

import java.time.LocalDate;
import java.util.ArrayList;

public class Contrato {
    private double valorContratado;
    private int numero;
    private LocalDate dataAssinatura;
    private ArrayList<Parcela> parcelas;

    public Contrato(double valorContratado, int numero, LocalDate dataAssinatura, ArrayList<Parcela> parcelas) {
        this.valorContratado = valorContratado;
        this.numero = numero;
        this.dataAssinatura = dataAssinatura;
        this.parcelas = new ArrayList<>();
    }

    public double getValorCobrado() {
        return valorContratado;
    }

    public void setValorCobrado(double valorContratado) {
        this.valorContratado = valorContratado;
    }

    public ArrayList<Parcela> getParcela() {
        return parcelas;
    }

    public void setParcela(ArrayList<Parcela> parcelas) {
        this.parcelas = parcelas;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public LocalDate getDataAssinatura() {
        return dataAssinatura;
    }

    public void setDataAssinatura(LocalDate dataAssinatura) {
        this.dataAssinatura = dataAssinatura;
    }

    public boolean registrarPagamento(int numParcela, LocalDate data){
        for (Parcela p: parcelas){
            if (p.getNumero() == numParcela){
                return p.quitar(data);
            }
        }
        return false;
    }

    public double totalRecebido(){
        double parcelasPagas = 0;
        for (Parcela p: parcelas){
            if (p.getDataDePagamento() != null){
                parcelasPagas += p.getValor();
            }
        }
        return parcelasPagas;
    }
    // Revisa essas duas classes, pois os resultados podem sair por uma classe só!!
    public double saldoPendente(){
        double parcelasEmAberto = 0;
        for (Parcela p: parcelas){
            if (p.getDataDePagamento() == null){
                parcelasEmAberto += p.getValor();
            }
        }
        return parcelasEmAberto;
    }
}
