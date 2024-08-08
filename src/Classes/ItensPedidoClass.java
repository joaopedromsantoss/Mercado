package Classes;

public class ItensPedidoClass {
    
    private String produto;
    private String valor;
    private String quantidade;
    private String total;

    public ItensPedidoClass(String produto, String valor, String quantidade, String total) {
        this.produto = produto;
        this.valor = valor;
        this.quantidade = quantidade;
        this.total = total;
    }

    public String getProduto() {
        return produto;
    }

    public String getValor() {
        return valor;
    }

    public String getQuantidade() {
        return quantidade;
    }

    public String getTotal() {
        return total;
    }

   
    

    
    public String toString() {
        return "itensPedido{" + "produto=" + produto + ", valor=" + valor + ", quantidade=" + quantidade + ", total=" + total + '}';
    }
    
    
    public boolean finalizarPedido(){
        return true;
    }
    public void removerItens(){
    }
}
