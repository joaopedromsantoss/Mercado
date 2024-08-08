/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

/**
 *
 * @author user
 */
public class StatusPedidoClass {
    private String nome;
    private String telefone;
    private String status;
    private boolean whatsapp;

    public StatusPedidoClass(String nome, String telefone, String status, boolean whatsapp) {
        this.nome = nome;
        this.telefone = telefone;
        this.status = status;
        this.whatsapp = whatsapp;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getStatus() {
        return status;
    }

    public boolean isWhatsapp() {
        return whatsapp;
    }
    
     public String toString() {
        return "statusPedido{" + "nome=" + nome + ", telefone=" + telefone + ", status=" + status + ", whatsapp=" + whatsapp + '}';
    }
    
    
}
