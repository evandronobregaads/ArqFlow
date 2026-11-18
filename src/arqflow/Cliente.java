package arqflow;

public class Cliente {
    private String codigo;
    private String nome;
    private String email;
    private String telefone;
    private boolean ativo;

    public Cliente(String codigo, String nome, String email, String telefone) {
        if (codigo == null || codigo.isBlank() ||
                nome == null || nome.isBlank() ||
                email == null || email.isBlank() ||
                telefone == null || telefone.isBlank()) {
            throw new IllegalArgumentException("Dados inválidos!");
        }
        this.codigo = codigo;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.ativo = true;
    }

    public String getCodigo() { return codigo; }

    public String getNome() { return nome; }

    public String getEmail() { return email; }

    public String getTelefone() { return telefone; }

    public boolean isAtivo() { return ativo; }

    public boolean atualizarContato (String email, String telefone) {
        if (email != null && !email.isBlank() && telefone != null && !telefone.isBlank()) {
                this.email = email;
                this.telefone = telefone;
                return true;
            } return false;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "codigo=" + codigo +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", telefone='" + telefone + '\'' +
                ", ativo=" + ativo +
                '}';
    }
}
