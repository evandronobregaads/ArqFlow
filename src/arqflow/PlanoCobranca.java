package arqflow;

import java.time.LocalDate;
import java.util.ArrayList;

public interface PlanoCobranca {
    ArrayList<Parcela> gerarParcelas(double valor, LocalDate vencimento);
}
