package arqflow;
import java.time.LocalDate;
import java.util.ArrayList;

public class CobrancaParcelada implements PlanoCobranca {
    private int numParcelas;

    public CobrancaParcelada(int numParcelas) {
        this.numParcelas = numParcelas;
    }

    public int getNumParcelas() {
        return numParcelas;
    }

    public void setNumParcelas(int numParcelas) {
        if (numParcelas < 1){
            throw new IllegalArgumentException("quantidade de parcelas inválidas!");
        }
        this.numParcelas = numParcelas;
    }

    @Override
    public ArrayList<Parcela> gerarParcelas(double valor, LocalDate vencimento) {
        if (valor <= 0 || vencimento == null){
            throw new IllegalArgumentException("Dados inválidos");
        }
        ArrayList<Parcela> parcelas = new ArrayList<>();
        double valorParcela = Math.round((valor / numParcelas) * 100.0)/ 100.0;
        double somaAnteriores = 0;
        for (int i = 0; i < numParcelas; i++){
            double valorAtual;
            if (i == numParcelas){
                valorAtual = Math.round((valor / numParcelas) * 100.0)/ 100.0;
            }else{
                valorAtual = valorParcela;
                somaAnteriores += valorParcela;
            }
            LocalDate vencimentoParcela = vencimento.plusMonths(i - 1);
            parcelas.add(new Parcela(i , valorAtual, vencimentoParcela, null));
        }
        return parcelas;
    }
}
