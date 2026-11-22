package arqflow;
import java.util.ArrayList;
import java.time.LocalDate;

public class CobrancaAVista implements PlanoCobranca{

    public CobrancaAVista() {}


    @Override
    public ArrayList<Parcela> gerarParcelas(double valor, LocalDate vencimento) {
        if (valor <= 0 || vencimento == null){
            throw new IllegalArgumentException("Dados inválidos");
        }

        ArrayList<Parcela> parcelas = new ArrayList<Parcela>();
        parcelas.add(new Parcela(1, valor, vencimento, null));
        return parcelas;
    }
}
