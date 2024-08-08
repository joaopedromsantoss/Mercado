package Classes;

import java.util.Date;

public class CadastrarPedidoClass {
    private String itensPedido;
    private String numeroPedido;
    private String dataPedido;
    private String valorPedido;
    private String formaPagamento;

    public CadastrarPedidoClass(String itensPedido, String numeroPedido, String dataPedido, String valorPedido, String formaPagamento) {
        this.itensPedido = itensPedido;
        this.numeroPedido = numeroPedido;
        this.dataPedido = dataPedido;
        this.valorPedido = valorPedido;
        this.formaPagamento = formaPagamento;
    }

    public String getItensPedido() {
        return itensPedido;
    }

    public String getNumeroPedido() {
        return numeroPedido;
    }

    public String getDataPedido() {
        return dataPedido;
    }

    public String getValorPedido() {
        return valorPedido;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    

    
    
  
    
    
    
    
    
    


    
    
    
     public String toString() {
        return "cadastrarPedido{" + "itensPedido=" + itensPedido+ ", numeroPedido=" + numeroPedido + ", dataPedido=" + dataPedido + ", valorPedido=" + valorPedido + ", formaPagamento=" + formaPagamento + '}';
    }

  

    public boolean cadastrarPedido(){
        return true;
    }
    public boolean cancelarPedido(){
        return false;
    }
}
