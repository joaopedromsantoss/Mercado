package Classes;

public class CadastrarCliente {

    private String nome;
    private String email;
    private String telefone;
    private String cpf;

    public CadastrarCliente(String nome, String email, String telefone, String cpf) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCpf() {
        return cpf;
    }

    

    
    
    

  
    
    public String toString() {
        return "cadastar{" + "nome=" + nome + ", email=" + email + ", telefone=" + telefone + ", cpf=" + cpf + '}';
    }
    
    public boolean cadastrarCliente(){
        return true;
    }
    public boolean cancelarCadastro(){
        return false;
    }
    
}
