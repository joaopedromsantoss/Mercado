/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Formularios;

import Classes.ItensPedidoClass;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Aluno
 */
public class ItensPedido extends javax.swing.JInternalFrame {

    private List<ItensPedidoClass> itensPedidos = new ArrayList<>();
    private DefaultTableModel tabelaDeItensPedido;
    private JSONArray clientesBancoDeDados = new JSONArray();
    private String caminhoDoArquivo = System.getProperty("user.dir") +  "/src/Arquivos/itensPedido.json";

    /**
     * Creates new form ItensPedido
     */
    public ItensPedido() {
        initComponents();
        
        this.tabelaDeItensPedido = (DefaultTableModel) jTableItensPedido.getModel();
        jTableItensPedido.setRowHeight(30);
        
        lerArquivoDeClientes();
        
    }
    
    public void lerArquivoDeClientes() {
        // verificar se o arquivo existe
        File file = new File(this.caminhoDoArquivo);

        if (file.exists()) {
            // ler o arquivo
            JSONParser conversor = new JSONParser();
            FileReader leitor = null;

            try {
                leitor = new FileReader(this.caminhoDoArquivo);
                JSONArray conteudo = (JSONArray) conversor.parse(leitor);

                for (int i = 0; i < conteudo.size(); i++) {
                    JSONObject itemArray = (JSONObject) conteudo.get(i);
                    
                    String produto = (String) itemArray.get("produto");
                    String valor = (String) itemArray.get("valor");
                    String quantidade = (String) itemArray.get("quantidade");
                    String total = (String) itemArray.get("total");

                    ItensPedidoClass itensPedido2 = new ItensPedidoClass(produto, valor, quantidade, total);
                    JSONObject item = this.criarObjeto(itensPedido2);

                    // adicionar as informações na variavel JSON Array
                    this.clientesBancoDeDados.add(item);

                    // adicionar as informações na tabela
                    Object[] itensPedidoVetor = {
                        itensPedido2.getProduto(), itensPedido2.getValor(), itensPedido2.getQuantidade(), itensPedido2.getTotal()
                    };

                    this.tabelaDeItensPedido.addRow(itensPedidoVetor);
                }
            } catch (IOException | ParseException e) {
            } finally {
                try {
                    if (leitor != null) {
                        leitor.close();
                    }
                } catch (Exception e) {
                }
            }
        } else {
            System.out.println("ARQUIVO NAO EXISTE");
        }
    }

    public JSONObject criarObjeto(ItensPedidoClass itensPedido2) {
        JSONObject item = new JSONObject();
        item.put("produto", itensPedido2.getProduto());
        item.put("valor", itensPedido2.getValor());
        item.put("quantidade", itensPedido2.getQuantidade());
        item.put("total", itensPedido2.getTotal());
        return item;
    }

    private void adicinarItensPedidoNaTabela() {
        limparTabela();
        mostrarItensPedidoNaTabela(itensPedidos);

    }

    private void limparTabela() {
        while (tabelaDeItensPedido.getRowCount() > 0) {
            tabelaDeItensPedido.removeRow(0);
        }
    }

    private void mostrarItensPedidoNaTabela(List<ItensPedidoClass> itenPedidos) {
        for (int i = 0; i < itensPedidos.size(); i++) {

            ItensPedidoClass itenspedidoLinha = itensPedidos.get(i);

            Object[] itensPedidoVetor = {
                itenspedidoLinha.getProduto(),
                itenspedidoLinha.getValor(),
                itenspedidoLinha.getQuantidade(),
                itenspedidoLinha.getTotal()
            };

            tabelaDeItensPedido.addRow(itensPedidoVetor);
        }

    }
    private void pesquisarPedido(String ItenPedido) {

        List<ItensPedidoClass> pedidosFiltrados = new ArrayList<>();

        for (int i = 0; i < itensPedidos.size(); i++) {

            ItensPedidoClass itenspedidoLinha = itensPedidos.get(i);

            if (itenspedidoLinha.getProduto().toLowerCase().contains(ItenPedido)) {
                pedidosFiltrados.add(itenspedidoLinha);
            }
        }
        limparTabela();
         System.out.println("Filtro: " + pedidosFiltrados);
        mostrarItensPedidoNaTabela(pedidosFiltrados);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jTextField6 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jProgressBar1 = new javax.swing.JProgressBar();
        jToggleButton1 = new javax.swing.JToggleButton();
        button1 = new java.awt.Button();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButtonConfirmar = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jTextFieldValor = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jTextFieldQuantidade = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableItensPedido = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldTotal = new javax.swing.JTextField();
        jComboBoxProduto = new javax.swing.JComboBox<>();
        jButtonCalcular = new javax.swing.JButton();
        jButtonFechar = new javax.swing.JButton();
        jTextFieldIdPesquisar = new javax.swing.JTextField();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jTextField6.setBackground(new java.awt.Color(204, 204, 204));
        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });

        jLabel4.setBackground(new java.awt.Color(51, 51, 51));
        jLabel4.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel4.setText("Nome:");

        jTextField3.setBackground(new java.awt.Color(204, 204, 204));
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        jLabel6.setBackground(new java.awt.Color(51, 51, 51));
        jLabel6.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel6.setText("E-mail:");

        jRadioButton1.setText("jRadioButton1");

        jRadioButton2.setText("jRadioButton2");

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane3.setViewportView(jTextArea2);

        jToggleButton1.setText("jToggleButton1");

        button1.setLabel("button1");

        setClosable(true);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(48, 202, 180));

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ITENS DO PEDIDO");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(145, 145, 145))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel5.setBackground(new java.awt.Color(51, 51, 51));
        jLabel5.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel5.setText("Produto:");

        jButtonConfirmar.setBackground(new java.awt.Color(48, 202, 180));
        jButtonConfirmar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonConfirmar.setText("Confirmar");
        jButtonConfirmar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonConfirmarMouseClicked(evt);
            }
        });
        jButtonConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConfirmarActionPerformed(evt);
            }
        });
        jButtonConfirmar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButtonConfirmarKeyPressed(evt);
            }
        });

        jLabel10.setBackground(new java.awt.Color(51, 51, 51));
        jLabel10.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel10.setText("Valor:");

        jTextFieldValor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldValorActionPerformed(evt);
            }
        });

        jLabel11.setBackground(new java.awt.Color(51, 51, 51));
        jLabel11.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel11.setText("Quantidade:");

        jTextFieldQuantidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldQuantidadeActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(48, 202, 180));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Adicionar Itens");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTableItensPedido.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Produto", "Valor", "Quantidade", "Total"
            }
        ));
        jScrollPane2.setViewportView(jTableItensPedido);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Total:");

        jTextFieldTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldTotalActionPerformed(evt);
            }
        });

        jComboBoxProduto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "Coca Cola 2L", "Suco de Laranja", "Suco de Abacaxi", "Suco de Limão", "Suco de Manga", "Coxinha", "Esfiha de Carne", "Pão de Queijo", "Pizza de Frango", "Pizza de Mussarela", "Pizza de Calabresa", "Pizza de Quatro Queijos", "Pizza de Brócolis", "Pizza de Rúcula", "Pizzza de Picanha" }));
        jComboBoxProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxProdutoActionPerformed(evt);
            }
        });

        jButtonCalcular.setText("Calcular");
        jButtonCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCalcularActionPerformed(evt);
            }
        });

        jButtonFechar.setForeground(new java.awt.Color(48, 202, 180));
        jButtonFechar.setText("Salvar");
        jButtonFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFecharActionPerformed(evt);
            }
        });

        jTextFieldIdPesquisar.setText("Pesquisar...");
        jTextFieldIdPesquisar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextFieldIdPesquisarMouseClicked(evt);
            }
        });
        jTextFieldIdPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldIdPesquisarActionPerformed(evt);
            }
        });
        jTextFieldIdPesquisar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldIdPesquisarKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(53, 53, 53)
                                .addComponent(jTextFieldValor, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(29, 29, 29)
                                .addComponent(jTextFieldTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButtonCalcular)
                                    .addComponent(jTextFieldQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jButton2)
                                .addGap(60, 60, 60)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonFechar)
                        .addGap(123, 123, 123))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonConfirmar))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 466, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldIdPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 466, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jComboBoxProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(jTextFieldValor))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(jTextFieldQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(141, 141, 141)))
                .addGap(18, 18, 18)
                .addComponent(jButtonCalcular)
                .addGap(24, 24, 24)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(20, 20, 20)
                .addComponent(jTextFieldIdPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButtonFechar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonConfirmar)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jDesktopPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jDesktopPane1)
                .addGap(499, 499, 499))
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jButtonConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConfirmarActionPerformed
    CodigoBarras2 TelaCodigoBarras2 = new CodigoBarras2();
    getParent().add(TelaCodigoBarras2);
    TelaCodigoBarras2.setVisible(true);
    }//GEN-LAST:event_jButtonConfirmarActionPerformed

    private void jTextFieldQuantidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldQuantidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldQuantidadeActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String produto = jComboBoxProduto.getSelectedItem().toString();
        String valor = jTextFieldValor.getText();
        String quantidade = jTextFieldQuantidade.getText();
        String total = jTextFieldTotal.getText();

        ItensPedidoClass itensPedido2 = new ItensPedidoClass(produto, valor, quantidade, total);
        itensPedidos.add(itensPedido2);
        adicinarItensPedidoNaTabela();

        JSONObject item = this.criarObjeto(itensPedido2);

        this.clientesBancoDeDados.add(item);


    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextFieldValorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldValorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldValorActionPerformed

    private void jButtonCalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCalcularActionPerformed
        double valor = Double.parseDouble(jTextFieldValor.getText());
        int quantidade = Integer.parseInt(jTextFieldQuantidade.getText());
        double total = valor * quantidade;
        jTextFieldTotal.setText(String.valueOf(total));


    }//GEN-LAST:event_jButtonCalcularActionPerformed

    private void jComboBoxProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxProdutoActionPerformed
        String produto = jComboBoxProduto.getModel().getSelectedItem().toString();
        System.out.println("Produto " + produto);
        if (produto == "Coca Cola 2L") {
            jTextFieldValor.setText("15.99");
        }
        if (produto == "Suco de Laranja") {
            jTextFieldValor.setText("8.99");
        }
        if (produto == "Suco de Abacaxi") {
            jTextFieldValor.setText("8.99");
        }
        if (produto == "Suco de Limão") {
            jTextFieldValor.setText("6.99");
        }
        if (produto == "Suco de Manga") {
            jTextFieldValor.setText("7.99");
        }
        if (produto == "Coxinha") {
            jTextFieldValor.setText("7.99");
        }
        if (produto == "Esfiha de carne") {
            jTextFieldValor.setText("7.99");
        }
        if (produto == "Pão de Queijo") {
            jTextFieldValor.setText("5.99");
        }
        if (produto == "Pizza de Frango") {
            jTextFieldValor.setText("25.99");
        }
        if (produto == "Pizza de Mussarela") {
            jTextFieldValor.setText("26.99");
        }
        if (produto == "Pizza de Calabresa") {
            jTextFieldValor.setText("27.99");
        }
        if (produto == "Pizza de Quatro Queijos") {
            jTextFieldValor.setText("32.99");
        }
        if (produto == "Pizza de Brócolis") {
            jTextFieldValor.setText("28.99");
        }
        if (produto == "Pizza de Rúcula") {
            jTextFieldValor.setText("24.99");
        }
        if (produto == "Pizza de Picanha") {
            jTextFieldValor.setText("45.99");
        }
    }//GEN-LAST:event_jComboBoxProdutoActionPerformed

    private void jTextFieldTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldTotalActionPerformed

    }//GEN-LAST:event_jTextFieldTotalActionPerformed

    private void jButtonFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFecharActionPerformed
        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter(this.caminhoDoArquivo);
            String conteudoSalvar = clientesBancoDeDados.toJSONString();
            fileWriter.write(conteudoSalvar);
        } catch (IOException e) {
            System.out.println("Erro ao escrever arquivo");
            System.err.println(e.getMessage());
        } finally {
            try {
                if (fileWriter != null) {
                    fileWriter.close();
                }
            } catch (Exception e) {
            }
        }

        // Fecha o formulário
        dispose();
    }//GEN-LAST:event_jButtonFecharActionPerformed

    private void jTextFieldIdPesquisarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextFieldIdPesquisarMouseClicked
        jTextFieldIdPesquisar.setText("");
    }//GEN-LAST:event_jTextFieldIdPesquisarMouseClicked

    private void jTextFieldIdPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldIdPesquisarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldIdPesquisarActionPerformed

    private void jTextFieldIdPesquisarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldIdPesquisarKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            String cliente = jTextFieldIdPesquisar.getText().toLowerCase();

            if (cliente.isEmpty()) {
                limparTabela();
                mostrarItensPedidoNaTabela(itensPedidos);
            } else {
                pesquisarPedido(cliente);
            }
        }
    }//GEN-LAST:event_jTextFieldIdPesquisarKeyPressed

    private void jButtonConfirmarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButtonConfirmarKeyPressed

    }//GEN-LAST:event_jButtonConfirmarKeyPressed

    private void jButtonConfirmarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonConfirmarMouseClicked
      
    }//GEN-LAST:event_jButtonConfirmarMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button button1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButtonCalcular;
    private javax.swing.JButton jButtonConfirmar;
    private javax.swing.JButton jButtonFechar;
    private javax.swing.JComboBox<String> jComboBoxProduto;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTableItensPedido;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextFieldIdPesquisar;
    private javax.swing.JTextField jTextFieldQuantidade;
    private javax.swing.JTextField jTextFieldTotal;
    private javax.swing.JTextField jTextFieldValor;
    private javax.swing.JToggleButton jToggleButton1;
    // End of variables declaration//GEN-END:variables

}
